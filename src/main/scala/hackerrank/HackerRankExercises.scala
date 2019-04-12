package hackerrank

import scala.annotation.tailrec

case class HackerRankExercises()

object HackerRankExercises {

  def sumArray(arr: Array[Int]): Int = {

    var result = 0
    arr.foreach(result += _)
    result
  }

  def sumArrayV2 (ar: Array[Int]): Int = {

    val list = ar.toList

    list match {
      case head :: tail => head + sumArray(tail.toArray)
      case Nil => 0
    }

  }

  def sumArrayV3(ar: Array[Int]): Int = {

    @tailrec
    def sumList(values: List[Int], total: Int): Int = {

      values match {
        case head :: tail => sumList(tail, total + head)
        case Nil => total
      }
    }

    sumList(ar.toList, 0)
  }

  def compareTriplets(arrayA: Array[Int], arrayB: Array[Int]): Array[Int] = {

    def compareTrip(listA: List[Int], listB: List[Int], totalA: Int, totalB: Int): Array[Int] = {

      listA match {
        case Nil => Array(totalA, totalB)
        case _ => {
          for {
            a <- listA
            b <- listB
          } yield println(a + ", " + b)
          Array(1,1)
        }
      }
    }
    compareTrip(arrayA.toList, arrayB.toList, 0, 0)
  }

  def compareTripletsV1(a: Array[Int], b: Array[Int]): Array[Int] = {

    @tailrec
    def compareTrip(listA: List[Int], listB: List[Int], totalA: Int, totalB: Int): Array[Int] = {

      listA match {
       case headA :: tailA => {
         if (headA > listB.head) compareTrip(tailA, listB.tail, totalA + 1, totalB)
         else if (headA < listB.head) compareTrip(tailA, listB.tail, totalA, totalB + 1)
         else compareTrip(tailA, listB.tail, totalA, totalB)
       }
       case Nil => Array(totalA, totalB)
     }
    }
    compareTrip(a.toList, b.toList, 0, 0)
  }


  def aVeryBigSum(array: Array[Long]): Long = {

    @tailrec
    def longSum(list: List[Long], total: Long): Long = {

      list match {
        case head :: tail => longSum(tail, total + head)
        case Nil => total
      }
    }

    longSum(array.toList, 0)
  }


  def diagonalDifference(array: Array[Array[Int]]): Int = {

    @tailrec
    def calculateDiagonals(list: List[Array[Int]], index: Int, totalA: Int, totalB: Int): Array[Array[Int]] = {

      list match {
        case head :: tail => {
          val diagonalLeft = head.slice(index, list.length + index).head
          val diagonalRight = head.reverse.slice(index, list.length + index).head
          calculateDiagonals(tail, index + 1, totalA + diagonalLeft, totalB + diagonalRight)
        }
        case Nil => Array(Array(totalA), Array(totalB))
      }
    }

    val arrayDiagonals = calculateDiagonals(array.toList, 0, 0, 0)

    (arrayDiagonals.head.head - arrayDiagonals.tail.head.head).abs
  }

  def plusMinus(input: Array[Int]): Array[Double] = {


    // create a class to save state
    @tailrec
    def lookSign(values: List[Int], state: Array[Double]): Array[Double] = {

      values match {
        case head :: tail => {

          head match {
            case 0 => lookSign(tail, Array(state(0), state(1), state(2) + 1))
            case _ => {

              if (head > 0){
                lookSign(tail, Array(state(0) + 1, state(1), state(2)))
              } else {
                lookSign(tail, Array(state(0), state(1) + 1, state(2)))
              }
            }
          }
        }
        case Nil => state
      }
    }

    val result = lookSign(input.toList, Array(0, 0, 0))

    val percentage = for {
      a <- result
    } yield BigDecimal(a / input.length).setScale(6, BigDecimal.RoundingMode.HALF_EVEN).toDouble

    percentage.foreach(println(_))
    percentage
  }


  def staircase(n: Int): Unit = {

    @tailrec
    def printFloor(floors: Int, currentFloor: Int): Unit = {

      (floors > currentFloor) match {
        case true => {
          print(" " * (floors - currentFloor))
          print(("#" * currentFloor) + "\n")
          printFloor(floors, currentFloor + 1)
        }
        case false => print("#" * (currentFloor))
      }
    }

    printFloor(n, 1)
  }
}



