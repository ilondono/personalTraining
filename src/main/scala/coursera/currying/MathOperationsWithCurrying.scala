package coursera.currying

object MathOperationsWithCurrying extends App {

  /**
    * (0) THIS IS THE BASE sum() FUNCTION WITHOUT CURRYING.
    * the f() function is sent as a parameter inside sum() function.
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param a lower limit from the range of ints to be added.
    * @param b upper limit from the range of ints to be added.
    * @return the sum of the function f applied to all digits between lower and upper limit (including both).
    */
  def sum(f: Int => Int, a: Int, b: Int): Int = {

    (a > b) match {
      case true => 0
      case false => f(a) + sum(f, a + 1, b)
    }
  }

  /**
    * (1) This is the first version of the function sum() using Currying
    * sumCurrying is a function that receives a function as a parameter and returns another function.
    * @param f function which receives an Int and returns an Int
    * @return function which receives two Int as parameters and returns an Int.
    */
  def sumCurrying(f: Int => Int): (Int, Int) => Int = {

    def sumCurryingF(a: Int, b: Int): Int = {

      (a > b) match {
        case true => 0
        case false => f(a) + sumCurryingF(a + 1, b)
      }
    }

    sumCurryingF
  }

  def sumInts = sumCurrying(x => x)
  def sumCubes = sumCurrying(x => x * x * x)

  println(sumInts(1, 5))
  println(sumCurrying(x => x)(1, 5))

  println(sumCubes(1, 5))

  /**
    * (2) This function is the same as (1) ---> sumCurrying, just written with some "Syntactic Sugar".
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param a lower limit from the range of ints to be added.
    * @param b upper limit from the range of ints to be added.
    * @return the sum of the function f applied to all digits between lower and upper limit (including both).
    */
  def sumCurrying2(f: Int => Int)(a: Int, b: Int): Int = {
    (a > b) match {
      case true => 0
      case false => f(a) + sumCurrying2(f)(a + 1, b)
    }
  }

  println(sumCurrying2(x => x)(1, 5))

  /**
    * (3) This function is the same as (2) but for product operation instead of sum.
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param a lower limit from the range of ints to be processed.
    * @param b upper limit from the range of ints to be processed.
    * @return the product of the function f applied to all digits between lower and upper limit (including both).
    */
  def productCurrying(f: Int => Int)(a: Int, b: Int): Int = {

    (a > b) match {
      case true => 1
      case false => f(a) * productCurrying(f)( a + 1, b)
    }
  }

  println(productCurrying(x => x)(1, 5))

  /**
    * (4)This function represents factorial operation in terms of (3) ---> Product
    * @param base the factorial base number
    * @return the factorial result for the base number
    */
  def factorial(base: Int): Int = productCurrying(x => x)(1, base)

  println("Factorial " + factorial(5))

  /**
    * (5) This function generalizes both (2) and (3) functions
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param combine function which combines the result of f applied to each value within the limits
    * @param zero the module value of math operations sum and product
    * @param a lower limit from the range of ints to be processed.
    * @param b upper limit from the range of ints to be processed.
    * @return the sum or product of the function f applied to all digits between lower and upper limit (including both).
    */
  def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int):Int = {
    (a > b) match {
      case true => zero
      case false => combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    }
  }

  println("MapReduce sum => " + mapReduce(x => x, (x, y) => x + y, 0)(1, 5))
  println("MapReduce product => " + mapReduce(x => x, (x, y) => x * y, 1)(1, 5))

  /**
    * (6) This is (2) written in terms of (5)
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param a lower limit from the range of ints to be added.
    * @param b upper limit from the range of ints to be added.
    * @return the sum of the function f applied to all digits between lower and upper limit (including both).
    */
  def sumMapReduce(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)

  println("sumMapReduce() => " + sumMapReduce(x => x)(1, 5))

  /**
    * (7) This is (3) written in terms of (5)
    * @param f function received as a parameter in the function. f receives an Int and returns an Int as well.
    * @param a lower limit from the range of ints to be processed.
    * @param b upper limit from the range of ints to be processed.
    * @return the product of the function f applied to all digits between lower and upper limit (including both).
    */
  def productMapReduce(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  println("productMapReduce() => " + productMapReduce(x => x)(1, 5))


  /*********** FIND THE FIXED POINT OF A FUNCTION: ************/
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = {
    (((x - y) / x)  * (-1)) / x < tolerance
  }

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {

    def iterate(x: Double): Double = {
      val nextGuess = f(x)
      if (isCloseEnough(x, nextGuess)) nextGuess //BigDecimal(nextGuess).setScale(3, BigDecimal.RoundingMode.HALF_EVEN).toDouble
      else iterate(nextGuess)
    }

    iterate(firstGuess)
  }

  println("Fixed point for f(x) = 1 + x/2 :" + fixedPoint(x => 1 + x/2)(0))

  /*********** FIND THE SQUARE ROOT OF X: ************/
  // TODO: Does not work with all values.
  def sqrt(x: Double) = {
    fixedPoint(y => (y + x / y) / 2)(1.0)
  }

  println("Square root of 16: " + sqrt(2))

  /********* ANOTHER EXAMPLE *************/

  def averageDamp(f: Double => Double)(x: Double) = {
    (x + f(x)) / 2
  }

  def sqrtTwo(x: Double) = {
    fixedPoint(averageDamp(y => x / y))(1)
  }

  println("sqrtTwo 16: " + sqrtTwo(2))


}
