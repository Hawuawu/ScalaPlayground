package com.hawu.scala.playground.commands

import com.hawu.scala.playground.events.{InputChanged, PlaygroundStateChangeEvent}
import com.hawu.scala.playground.persistence.PlaygroundStateContent

trait PlaygroundCommand {
  def command(state:PlaygroundStateContent): List[PlaygroundStateChangeEvent]
}

case class SetPlaygroundInput(input: String) extends PlaygroundCommand {
  override def command(state: PlaygroundStateContent): List[PlaygroundStateChangeEvent] = {
    InputChanged(input) :: Nil
  }
}
