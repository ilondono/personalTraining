package coursera.practice

import scala.annotation.tailrec

object SquareRoot extends App {

  println(squareRoot(1.0e60))

  def squareRoot(x: Double) = {
    println("La raíz cuadrada de " + x + " es: ")
    BigDecimal(calculateSquareRoot(1, x)).setScale(11, BigDecimal.RoundingMode.HALF_EVEN).toDouble
  }

  @tailrec
  private def calculateSquareRoot(guess: Double, base: Double): Double = {
    if (isGoodEnoughGuess(guess, base)) guess
    else calculateSquareRoot(improve(guess, base), base)
  }

  private def abs(x: Double) : Double = if (x < 0) -x else x

  private def improve(guess: Double, base: Double) = (guess + (base/guess)) / 2

  private def isGoodEnoughGuess(guess: Double, base: Double) = {

    abs((guess * guess) - base) / base < 0.00000000001

  }
}
