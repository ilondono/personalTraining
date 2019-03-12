package functions

import monads.MyWrapper

case class Utils()

object Utils {

  def duplicate(a: Int)= MyWrapper(a * 2)

  def triplicate(a: Int) = MyWrapper(a * 3)

  def quadruple(a: Int) = MyWrapper(a * 4)

}
