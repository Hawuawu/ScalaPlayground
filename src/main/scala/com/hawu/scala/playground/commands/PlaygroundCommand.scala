package com.hawu.scala.playground.commands

import com.hawu.scala.playground.events.{InputChanged, PlaygroundStateChangeEvent}
import com.hawu.scala.playground.persistence.PlaygroundState

trait PlaygroundCommand {
  def command(state: PlaygroundState.Content): List[PlaygroundStateChangeEvent]
}

case class SetPlaygroundInput(input: String) extends PlaygroundCommand {
  override def command(state: PlaygroundState.Content): List[PlaygroundStateChangeEvent] = {
    InputChanged(input) :: Nil
  }
}
