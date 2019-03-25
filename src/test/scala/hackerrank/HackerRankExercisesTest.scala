package hackerrank

import org.scalatest.FunSuite

class HackerRankExercisesTest extends FunSuite {


  test("La suma") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArray(values.toArray)

    println(result)

    assert(result == 21)

  }

  test("La suma v2") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArrayV2(values.toArray)

    println("El resultado fue: " + result)

    assert(result == 21)

  }

  test("La suma V3") {

    val values = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    val result = HackerRankExercises.sumArrayV3(values.toArray)

    println("El resultado fue con tailrec: " + result)

    assert(result == 21)
  }

  test("Comparar tripletas: ") {

    val tripA = Array(5, 6, 7)
    val tripB = Array(3, 6, 10)

    val result = HackerRankExercises.compareTripletsV1(tripA, tripB)

    result.foreach {
      println(_)
    }

    assert(result.toList.toString() == Array(1, 1).toList.toString)

  }

}
