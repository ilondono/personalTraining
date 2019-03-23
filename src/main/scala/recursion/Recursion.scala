package recursion

import scala.annotation.tailrec

case class Recursion()

object Recursion {

  /**
    * sums all the elements of userInput List[Int] using normal recursion.
    *
    * @param numbersList list of elements to be added
    * @return the sum of all Int elements of userInput list
    */
  def sum(numbersList: List[Int]): Int = {

    numbersList match {
      /*case Nil => {
        val stackTraceAsArray = Thread.currentThread.getStackTrace
        stackTraceAsArray.foreach(println)
        0
      }*/
      case Nil => 0
      case x :: xs => x + sum(xs)
    }
  }

  /**
    * sums all the elements of userInput List[Int] using tail recursion.
    *
    * @param numbersList list of elements to be added
    * @return the sum of all Int elements of userInput list
    */
  def sumTailRecursive(numbersList: List[Int]): Int = {

    // the function is inside the main function in order to limit the scope of the recursive function
    // That implies not to declare it as private.
    @tailrec
    def partialSum(numbersList: List[Int], accumulator: Int): Int = {

      numbersList match {
        case Nil => accumulator
        case x :: xs => partialSum(xs, accumulator + x)
      }
    }

    partialSum(numbersList, 0)
  }

  /**
    * Multiplies all the elements of userInput List[Int] between them
    * @param testList list of elements to be multiplied
    * @return the product of multiplying all Int values in the List between them.
    */
  def prod(testList: List[Int]): Int = {
    testList match {
      case Nil => 1
      case x :: xs => x * (prod(xs))
    }
  }

  /**
    *
    * @param list
    * @param name
    * @return
    */
  @tailrec
  def has(list: List[String], name: String):Boolean = {
    list match {
      case Nil => false
      case x :: xs => {
        x.equals(name) match {
          case true => true
          case false => has(xs, name)
        }
      }
    }
  }
}
