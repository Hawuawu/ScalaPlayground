package com.hawu.scala.playground.tests.dummy

import akka.actor.{Actor, ActorRef}
import com.hawu.scala.playground.events.PlaygroundStateChangeEvent
import com.hawu.scala.playground.persistence.EventPersisted

case object GetCount
case class Count(count: Int)

class ListenerCounter(val expectedCount: Int) extends Actor {

 var counter = 0
 var receiver: Option[ActorRef] = None

 def receive = {
   case GetCount =>
     receiver = Some(sender)
     test

   case e: EventPersisted =>
     counter += 1
     test
  }

  def test = {
    if (counter == expectedCount) {
      receiver.map(_ ! Count(expectedCount))
    }
  }
}
