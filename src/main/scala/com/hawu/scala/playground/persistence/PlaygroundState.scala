package com.hawu.scala.playground.persistence

import akka.actor.{Actor, ActorLogging, ActorRef}
import akka.persistence._
import com.hawu.scala.playground.commands.SetPlaygroundInput
import com.hawu.scala.playground.events.{InputChanged, PlaygroundStateChangeEvent}

case object GetActualState

case class ActualState(state: PlaygroundState.Content)

case object GetSequenceNumberForMessages

case object RegisterPersistListener
case object DeRegisterPersistListener

case class SequenceNumberForMessages(number: Int)

case class EventPersisted(event: PlaygroundStateChangeEvent)

case object ClearJournal
case object JournalCleared
case object CannotClearJournal

case object ClearSnapshot
case object SnapshotCleared
case object CannotClearSnapshot

object PlaygroundState {
  case class Content(input: String = "")
}

class PlaygroundState(val persistenceId: String) extends PersistentActor  with ActorLogging {
  import PlaygroundState._

  var content = Content()
  var messagesSequenceNO = 0
  var snapshotsSequenceNO = 0

  var clearingSnapshotQueue: List[ActorRef] = List()
  var clearingJournalQueue: List[ActorRef] = List()

  var persistListener: List[ActorRef] = List()

  override def receive = receiveCommand

  override def receiveCommand = {
    case RegisterPersistListener =>
      persistListener = sender :: persistListener.filterNot(_ == sender)

    case DeRegisterPersistListener =>
      persistListener = persistListener.filterNot(_ == sender)

    case GetSequenceNumberForMessages =>
      sender ! SequenceNumberForMessages(messagesSequenceNO)

    case chi: InputChanged =>
      messagesSequenceNO += 1
      log.info("Received message {}", chi)
      persist(chi) { e => {
        persistListener.foreach(_ ! EventPersisted(e))
      }}
      content = content.copy(input = chi.newInput)

    case GetActualState =>
      sender() ! ActualState(content)

    case SaveSnapshotSuccess(metadata)         =>
     log.debug("Successfully saved snapshot")

    case SaveSnapshotFailure(metadata, reason) =>
      log.error("Can't save snapshot because {}", reason)

    case ClearJournal =>
      clearingJournalQueue = sender :: clearingJournalQueue
      deleteMessages(messagesSequenceNO)

    case DeleteMessagesSuccess =>
      log.debug("Got DeleteMessagesSuccess")
      clearingJournalQueue.foreach(_ ! JournalCleared)
      clearingJournalQueue = Nil

    case DeleteMessagesFailure =>
      log.debug("Got DeleteMessagesFailure")
      clearingJournalQueue.foreach(_ ! CannotClearJournal)
      clearingJournalQueue = Nil

    case ClearSnapshot =>
      clearingSnapshotQueue = sender :: clearingSnapshotQueue
      deleteSnapshot(snapshotsSequenceNO)

    case DeleteSnapshotSuccess =>
      log.debug("Got DeleteSnapshotSuccess")
      clearingSnapshotQueue.foreach(_ ! SnapshotCleared)
      clearingSnapshotQueue = Nil

    case DeleteSnapshotFailure =>
      log.debug("Got DeleteSnapshotFailure")
      clearingSnapshotQueue.foreach(_ ! CannotClearSnapshot)
      clearingSnapshotQueue = Nil
  }

  override def receiveRecover = {
    case SnapshotOffer(_, snapshot: Content) => {
      log.debug("Offered snapshot {}", snapshot)
      content = snapshot
      snapshotsSequenceNO += 1
    }

    case other =>
      self ! other
  }

  override def postStop(): Unit = {
    log.debug("Stopping actor and storing snapshot")
    saveSnapshot(content)
    snapshotsSequenceNO += 1
  }
}
