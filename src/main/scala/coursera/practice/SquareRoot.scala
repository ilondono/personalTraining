package coursera.practice

import scala.annotation.tailrec

object SquareRoot extends App {

  def sqrt(base: Double): Double = {

    @tailrec
    def calculateSquareRoot(guess: Double): Double = {
      if (isGoodEnoughGuess(guess)) guess
      else calculateSquareRoot(improve(guess))
    }

    def abs(x: Double): Double = if (x < 0) -x else x

    def improve(guess: Double) = (guess + (base / guess)) / 2

    def isGoodEnoughGuess(guess: Double) = {
      abs((guess * guess) - base) / base < 0.00000000001
    }

    println("La raíz cuadrada de " + base + " es: ")
    BigDecimal(calculateSquareRoot(1)).setScale(10, BigDecimal.RoundingMode.HALF_EVEN).toDouble
  }

  println(sqrt(1.0e60))
  println(sqrt(9))
  println(sqrt(81))
  println(sqrt(121))

}
