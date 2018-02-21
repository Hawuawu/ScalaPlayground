package com.hawu.scala.playground.events

trait PlaygroundStateChangeEvent
case class InputChanged(newInput: String) extends PlaygroundStateChangeEvent