package recursion

import org.scalatest.FunSuite


class RecursionTest extends FunSuite {

  test("adding the Int values of a List[Int] using regular and tail recursion") {
    val testList = List(2, 4, 6, 8, 10)
    assert(Recursion.sum(testList) == 30)
    assert(Recursion.sumTailRecursive(testList) == 30)

    val testList2 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    assert(Recursion.sum(testList2) == 15)
    assert(Recursion.sumTailRecursive(testList2) == 15)
  }

  test("multiplying all the  Int values of a List[Int] using recursion") {

    val testList = List(1, 2, 3, 4, 5, 6)
    assert(Recursion.prod(testList) == 720)

    val otherList = List(0, 1, 2, 3, 4, 5, 6)

    assert(Recursion.prod(otherList) == 0)
  }

  test("Telling if a List[String] contains a String given as a parameter using recursion") {

    val saiyans = List("Goku", "Vegetta", "Gohan", "Goten", "Trunks", "Pan")

    assert(!Recursion.has(saiyans, "Bulma"))
    assert(Recursion.has(saiyans, "Goku"))
    assert(Recursion.has(saiyans, "Gohan"))
    assert(Recursion.has(saiyans, "Pan"))
    assert(!Recursion.has(saiyans, "Roshi"))
  }

}
