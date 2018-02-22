package com.hawu.scala.playground.persistence

import akka.actor.{Actor, ActorLogging, ActorRef}
import akka.persistence._
import com.hawu.scala.playground.commands.SetPlaygroundInput
import com.hawu.scala.playground.events.{InputChanged, PlaygroundStateChangeEvent}


case class PlaygroundStateContent (input: String = "")

case object GetActualState
case class ActualState(state: PlaygroundStateContent)

case object ClearJournal
case object JournalCleared
case object CannotClearJournal

case object ClearSnapshot
case object SnapshotCleared
case object CannotClearSnapshot

case object GetSequenceNumberForMessages
case class SequenceNumberForMessages(number: Int)

case object RegisterPersistListener
case object DeRegisterPersistListener

case class EventPersisted(event: PlaygroundStateChangeEvent)

class PlaygroundState(val persistenceId: String) extends PersistentActor  with ActorLogging {
  var content = PlaygroundStateContent()
  var messagesSequenceNO = 0
  var snapshotsSequenceNO = 0

  var clearingSnapshotQueue: List[ActorRef] = List()
  var clearingJournalQueue: List[ActorRef] = List()

  var persistListener: List[ActorRef] = List()

  override def receive = receiveCommand

  override def receiveCommand = {
    case RegisterPersistListener =>
      persistListener = sender :: persistListener.filterNot(l => l == sender)

    case DeRegisterPersistListener =>
      persistListener = persistListener.filterNot(l => l == sender)

    case GetSequenceNumberForMessages =>
      sender ! SequenceNumberForMessages(messagesSequenceNO)

    case chi: InputChanged =>
      messagesSequenceNO += 1
      log.info("Received message {}", chi)
      persist(chi) {e => {
        persistListener.foreach(l => l ! EventPersisted(e))
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
      clearingJournalQueue.foreach(s => s ! JournalCleared)
      clearingJournalQueue = List()

    case DeleteMessagesFailure =>
      log.debug("Got DeleteMessagesFailure")
      clearingJournalQueue.foreach(s => s ! CannotClearJournal)
      clearingJournalQueue = List()

    case ClearSnapshot =>
      clearingSnapshotQueue = sender :: clearingSnapshotQueue
      deleteSnapshot(snapshotsSequenceNO)

    case DeleteSnapshotSuccess =>
      log.debug("Got DeleteSnapshotSuccess")
      clearingSnapshotQueue.foreach(s => s ! SnapshotCleared)
      clearingSnapshotQueue = List()

    case DeleteSnapshotFailure =>
      log.debug("Got DeleteSnapshotFailure")
      clearingSnapshotQueue.foreach(s => s ! CannotClearSnapshot)
      clearingSnapshotQueue = List()
  }

  override def receiveRecover = {
    case SnapshotOffer(_, snapshot: PlaygroundStateContent) => {
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
