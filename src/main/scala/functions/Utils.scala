package functions

import monads.{Debuggable, MyWrapper, GenericDebuggable}

case class Utils()

object Utils {

  def duplicate(a: Int)= MyWrapper(a * 2)

  def triplicate(a: Int) = MyWrapper(a * 3)

  def quadruple(a: Int) = MyWrapper(a * 4)

  def duplicateDebuggable(a: Int) = {
    val result = a * 2
    Debuggable(result, s"f($a): $a * 2 = $result")
  }

  def triplicateDebuggable(a: Int) = {
    val result = a * 3
    Debuggable(result, s"f($a): $a * 3 = $result")
  }

  def quadrupleDebuggable(a: Int) = {
    val result = a * 4
    Debuggable(result, s"f($a): $a * 4 = $result")
  }

  def duplicateDebuggableGenerics(a: Int) = {
    val result = a * 2
    GenericDebuggable(result, s"f($a): $a * 2 = $result")
  }

  def triplicateDebuggableGenerics(a: Int) = {
    val result = a * 3
    GenericDebuggable(result, s"f($a): $a * 3 = $result")
  }

  def quadrupleDebuggableGenerics(a: Int) = {
    val result = a * 4
    GenericDebuggable(result, s"f($a): $a * 4 = $result")
  }

  def duplicateFloat(a: Float) = {
    val result = a * 2
    GenericDebuggable(result, s"f($a): $a * 2 = $result")
  }

  def triplicateFloat(a: Float) = {
    val result = a * 3
    GenericDebuggable(result, s"f($a): $a * 3 = $result")
  }

  def quadrupleFloat(a: Float) = {
    val result = a * 4
    GenericDebuggable(result, s"f($a): $a * 4 = $result")
  }

}
