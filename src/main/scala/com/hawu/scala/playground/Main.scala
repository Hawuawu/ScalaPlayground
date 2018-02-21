package com.hawu.scala.playground

import akka.actor.{ActorRef, ActorSystem, Props}
import com.hawu.scala.playground.commands.SetPlaygroundInput
import com.hawu.scala.playground.computing.CommandHandler
import com.hawu.scala.playground.persistence.PlaygroundState


object ActorServicesNamingConvention {
  val commandHandler = "commandHandler"
  val playgroundState = "playgroundState"
}

object Main extends App {
  var actorSystem: Option[ActorSystem] = None
  var state: Option[ActorRef] = None
  var handler: Option[ActorRef] = None

  try {
    actorSystem = Some(ActorSystem("Hawus_space"))

    state = actorSystem.map(as => as.actorOf(Props(classOf[PlaygroundState], "persistence-state-1"), ActorServicesNamingConvention.playgroundState))
    handler = actorSystem.map(as => as.actorOf(Props(classOf[CommandHandler], state.get), ActorServicesNamingConvention.commandHandler))


    handler.map(h => h ! SetPlaygroundInput("ahoj3"))
  } catch {
    case t: Throwable =>
      actorSystem.map(as => as.log.error("Exception while starting entrypoint {}", t))
  }

  actorSystem.map(as => as.log.debug("Press enter to quit!"))
  scala.io.StdIn.readLine
  actorSystem.map(as => as.terminate)
}
