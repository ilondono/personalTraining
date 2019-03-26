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
    ???
  }
}



