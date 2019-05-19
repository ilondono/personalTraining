package coursera.practice

import scala.annotation.tailrec

object Factorial extends App {


  def factorial(x: Int): Long = {

    @tailrec
    def recursiveFactorial(base: Int, accumulate: Long): Long = {

      base match {
        case 0 => accumulate
        case _ => recursiveFactorial(base - 1, accumulate * base)
      }
    }

    val result = recursiveFactorial(x, 1)
    println("Factorial de " + x + " = " + result)
    result
  }

  factorial(0)
  factorial(1)
  factorial(5)
  factorial(9)
  factorial(20)

}
