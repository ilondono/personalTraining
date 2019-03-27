package hackerrank

import org.scalatest.FunSuite

class HackerRankExercisesTest extends FunSuite {


  test("Sum of all elements of an Array[Int] using var") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArray(values.toArray)

    println("The result with unpure functions was: " + result)

    assert(result == 21)

  }

  test("Sum of all elements of an Array[Int] using common recursion") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArrayV2(values.toArray)

    println("The result using recursion was: " + result)

    assert(result == 21)

  }

  test("Sum of all elements of an Array[Int] using tailrecursion") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArrayV3(values.toArray)

    println("The result using tailrec was: " + result)

    assert(result == 21)
  }

  test("Comparing triplets: ") {

    val tripA = Array(5, 6, 7)
    val tripB = Array(3, 6, 10)

    val result = HackerRankExercises.compareTripletsV1(tripA, tripB)

    result.foreach {
      println(_)
    }

    assert(result.toList.toString() == Array(1, 1).toList.toString)

  }

  test ("Sum of an Array[Int] with really long values:") {

    val array = Array(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L)

    val result: Long = HackerRankExercises.aVeryBigSum(array)

    println("The result was: " + result + ", and the type is: " + result.getClass)

    assert(result == 5000000015L)

  }

  test ("Diagonal difference") {

    val array = Array(Array(11, 2, 4), Array(4, 5, 6), Array(10, 8, -12))

    val result: Int = HackerRankExercises.diagonalDifference(array)

    println("The result was: " + result)

    assert(result == 15)
  }


}
