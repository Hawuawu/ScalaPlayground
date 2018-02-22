package com.hawu.scala.playground.tests

import java.io.File

import akka.actor.{ActorRef, ActorSystem, Props}
import com.hawu.scala.playground.ActorServicesNamingConvention
import com.hawu.scala.playground.commands.SetPlaygroundInput
import com.hawu.scala.playground.computing.CommandHandler
import com.hawu.scala.playground.persistence._
import org.scalatest.FlatSpec

import scala.concurrent._
import scala.concurrent.Await
import akka.pattern.ask
import akka.util.Timeout
import java.util.UUID.randomUUID

import com.hawu.scala.playground.tests.dummy.{Count, GetCount, ListenerCounter}
import org.apache.commons.io._

import scala.concurrent.duration._

class PlaygroundFixture(val uuid: Option[String] = None) {
  val actorSystem = Some(ActorSystem(uuid.getOrElse(randomUUID().toString)))
  var restartNO = 0

  val storageLocations: List[File] = List(
    new File(actorSystem.get.settings.config.getString("akka.persistence.journal.leveldb.dir")),
    new File(actorSystem.get.settings.config.getString("akka.persistence.snapshot-store.local.dir"))
  )

  var state: Option[ActorRef] = None
  var handler: Option[ActorRef] = None

  def prepare = {
    restartState
    handler = actorSystem.map(_.actorOf(Props(classOf[CommandHandler], state.get), ActorServicesNamingConvention.commandHandler))
  }

  def restartState: Unit = {
    state.map(st => actorSystem.map(_.stop(st)))
    state = actorSystem.map(_.actorOf(Props(classOf[PlaygroundState], "persistence-test"), ActorServicesNamingConvention.playgroundState))
    restartNO += 1
  }

  def reset = {
    actorSystem.map(as => {
      as.terminate()
      // FIXME do not fork main thread
      Await.ready(as.whenTerminated, 365.days)
    })
  }

  def forceCleanStorages = {
    storageLocations.foreach(loc => {
      FileUtils.cleanDirectory(loc)
    })
  }

  def giveSomeTime = {
    blocking { // FIXME do not fork main thread
      Thread.sleep(1000)
    }
  }

  def getNumberOfSequences: Option[Int] = {
    state.map(s => {
      implicit val timeout = Timeout(5 seconds)
      val future = s ? GetSequenceNumberForMessages
      // FIXME do not fork main thread
      val result = Await.result(future, timeout.duration).asInstanceOf[SequenceNumberForMessages]
      result.number
    })

  }
}

class CoreTests extends FlatSpec {

  "Playground state" should "increase sequenceNO after receiving InputChanged" in {
    val fixture = new PlaygroundFixture

    try {
      fixture.prepare
      fixture.handler.map(handler => {
        for (i <- 0 to 9) {
         handler ! SetPlaygroundInput("Some test input")
        }
      })
      fixture.giveSomeTime //Giving time for processing messages

      val sequenceNumber = fixture.getNumberOfSequences
      assert(sequenceNumber.isDefined)
      assert(sequenceNumber.get == 10)

    } catch {
      case t: Throwable =>
        fail("Got exception " + t)
    } finally {
      fixture.reset
      fixture.forceCleanStorages
    }

  }

  "Playground " should "persist after restarting ActorSystem" in {
    val fixture = new PlaygroundFixture

    try {
      fixture.prepare
      fixture.handler.map(handler => for (i <- 0 to 9) {
        //handler ! SetPlaygroundInput("Some test input")
      })
      fixture.giveSomeTime //Giving time for processing messages
    } catch {
      case t: Throwable =>
        fail("Got exception " + t)
    } finally {
      fixture.reset
      fixture.forceCleanStorages
    }

    pending
  }

  "Events " should "be sent to listeners" in {
    var fixture = new PlaygroundFixture

    try {
      fixture.prepare
      fixture.handler.map(handler => {
        val listener = fixture.actorSystem.get.actorOf(Props(classOf[ListenerCounter], 10))
        val listener2 = fixture.actorSystem.get.actorOf(Props(classOf[ListenerCounter], 10))

        fixture.state.map(state => {
          state.tell(RegisterPersistListener, listener)
          state.tell(RegisterPersistListener, listener2)
        })

        for (i <- 0 to 9) handler ! SetPlaygroundInput("Some test input")

        implicit val timeout = Timeout(5 seconds)

        val future = listener ? GetCount
        // FIXME do not fork main thread
        val result = Await.result(future, timeout.duration).asInstanceOf[Count]

        val future2 = listener2 ? GetCount
        // FIXME do not fork main thread
        val result2 = Await.result(future2, timeout.duration).asInstanceOf[Count]

        assert(result.count == 10)
        assert(result2.count == 10)
      })
    } catch {
      case t: Throwable =>
        fail("Got exception " + t)
    } finally {
      fixture.reset
      fixture.forceCleanStorages
    }

  }

  "Events " should "persist in journal" in {
    //todo: new ActorSystem doesn't count like  restart, i will have to try to create supervision strategy for restarting
    var fixture = new PlaygroundFixture(Some("test"))

    try {
      fixture.prepare
      fixture.giveSomeTime

      val listener = fixture.actorSystem.get.actorOf(Props(classOf[ListenerCounter], 10))

      fixture.state.map(state => {
        state.tell(RegisterPersistListener, listener)
      })

      fixture.handler.map(handler => {
        for (i <- 0 to 9) handler ! SetPlaygroundInput("Some test input")
      })
      implicit val timeout = Timeout(5 seconds)

      val future = listener ? GetCount
      // FIXME do not fork main thread
      val result = Await.result(future, timeout.duration).asInstanceOf[Count]

      /*
            fixture.restartState

            val sequenceNumber = fixture.getNumberOfSequences
            assert(sequenceNumber.isDefined)
            assert(sequenceNumber.get == 10)*/
    } catch {
      case t: Throwable =>
        fail("Got exception " + t)

    } finally {
      fixture.reset
      fixture.forceCleanStorages
    }
    pending
  }

  "ClearJournal " should "clear journal" in {
    pending
  }

  "ClearSnapshot " should "delete snapshot" in {
    pending
  }
}
