package com.hawu.scala.playground.persistence

import akka.actor.{Actor, ActorLogging, ActorRef}
import akka.persistence.{PersistentActor, SaveSnapshotFailure, SaveSnapshotSuccess, SnapshotOffer}
import com.hawu.scala.playground.commands.SetPlaygroundInput
import com.hawu.scala.playground.events.InputChanged


case class PlaygroundStateContent (input: String = "")

case object GetActualState
case class ActualState(state: PlaygroundStateContent)
class PlaygroundState(val persistenceId: String) extends PersistentActor  with ActorLogging {
  var content = PlaygroundStateContent()

  override def receive = receiveCommand

  override def receiveCommand = {
    case chi: InputChanged =>
      log.info("Received message {}", chi)
      persist(chi) {e => {}}
      content = content.copy(input = chi.newInput)

    case GetActualState =>
      sender() ! ActualState(content)

    case SaveSnapshotSuccess(metadata)         =>
     log.debug("Successfully saved snapshot")

    case SaveSnapshotFailure(metadata, reason) =>
      log.error("Can't save snapshot because {}", reason)
  }

  override def receiveRecover = {
    case SnapshotOffer(_, snapshot: PlaygroundStateContent) => {
      log.debug("Offered snapshot {}", snapshot)
      content = snapshot
    }

    case other =>
      self ! other
  }

  override def postStop(): Unit = {
    log.debug("Stopping actor and storing snapshot")
    saveSnapshot(content)
  }
}
