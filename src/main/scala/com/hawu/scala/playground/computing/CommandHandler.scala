package com.hawu.scala.playground.computing

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.hawu.scala.playground.commands.PlaygroundCommand
import com.hawu.scala.playground.persistence.{ActualState, GetActualState}

class CommandHandler(stateActor: ActorRef) extends Actor with ActorLogging{
  def receive = {
    case cmd: PlaygroundCommand => //Got command
      stateActor.tell(GetActualState, context.actorOf(Props(classOf[WaitForStateActor], self, cmd))) //ask for current state and pass ref for wait actor
  }
}

class WaitForStateActor(parent: ActorRef, command: PlaygroundCommand) extends Actor with ActorLogging {
  def receive = {
    case as: ActualState =>
      command.command(as.state).foreach(event => sender() ! event) //Send event to state actor
      context.stop(self)
  }
}
