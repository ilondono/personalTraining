package recursion

case class Recursion()

object Recursion {

  /**
    * sums all the elements of a List[Int]
    *
    * @param numbersList list of elements to be added
    * @return the sum of all Int elements of a list
    */
  def sum(numbersList: List[Int]): Int = {

    numbersList match {
      case Nil => 0
      case x :: xs => x + sum(xs)
    }
  }

  /**
    * Multiplies all the elements of a List[Int] between them
    * @param testList list of elements to be multiplied
    * @return the product of multiplying all Int values in the List between them.
    */
  def prod(testList: List[Int]): Int = {
    testList match {
      case Nil => 1
      case x :: xs => x * (prod(xs))
    }
  }

  /**
    *
    * @param list
    * @param name
    * @return
    */
  def has(list: List[String], name: String):Boolean = {
    list match {
      case Nil => false
      case x :: xs => if (x.equals(name)) {
                        true
                      } else {
                        has(xs, name)
                      }
    }
  }
}
