package com.hawu.scala.playground.events

sealed trait PlaygroundStateChangeEvent

case class InputChanged(newInput: String) extends PlaygroundStateChangeEvent
