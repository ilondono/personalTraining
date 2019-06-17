package coursera.hof

import scala.annotation.tailrec

object MathOperations extends App {

  // the f() function is sent as a parameter inside sum() function.
  def sum(f: Int => Int, a: Int, b: Int): Int = {

    (a > b) match {
      case true => 0
      case false => f(a) + sum(f, a + 1, b)
    }
  }

  def id(x: Int): Int = x
  def square(x: Int): Int = x * x
  def cube(x:Int): Int = x * x * x

  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumSquares(a: Int, b: Int) : Int = sum(square, a, b)
  def sumCubes(a:Int, b: Int) : Int = sum(cube, a, b)

  println(sumInts(1, 5))  // 15
  println(sumSquares(1,5))  // 55
  println(sumCubes(1,3))  // 36

  println("-------- Since this spot, we will use Anonymous Functions--------")

  println(sum((x: Int) => x, 1, 5))

  // If the compiler can infer the type of the parameter, it can be omitted
  println(sum((x) => x * x, 1, 5))
  println(sum((x) => x * x * x, 1, 3))


  // Now let's try with tail recursion:
  def sum2(f: Int => Int, a: Int, b: Int): Int = {

    @tailrec
    def recursiveSum(f: Int => Int, a: Int, b: Int, currentValue: Int): Int = {
      (a > b) match {
        case true => currentValue
        case false => recursiveSum(f, a + 1, b, currentValue + f(a))
      }
    }

    recursiveSum(f, a, b, 0)
  }

  println("-------- Here with tail recursion --------")

  println(sum2((x: Int) => x, 1, 5))

  // If the compiler can infer the type of the parameter, it can be omitted
  println(sum2((x) => x * x, 1, 5))
  println(sum2((x) => x * x * x, 1, 3))

  // a third version using tail recursion:
  def sum3(f: Int => Int, a: Int, b: Int): Int = {

    @tailrec
    def loop(a: Int, acc: Int): Int = {
      (a > b) match {
        case true => acc
        case false => loop(a + 1, acc + f(a))
      }
    }

    loop(a, 0)
  }

  println("-------- Here with tail recursion. Second version --------")

  println(sum2((x) => x, 1, 5))
  println(sum2((x) => x * x, 1, 5))
  println(sum2((x) => x * x * x, 1, 3))

}
