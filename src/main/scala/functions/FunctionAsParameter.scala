package functions

import scala.annotation.tailrec

case class FunctionAsParameter()

object FunctionAsParameter {

  /**
    * Basic example of userInput list filter function which receives userInput function as userInput parameter.
    * First version without using recursion and using for loops.
    *
    * @param f  Function to be applied to each value of the list
    * @param list elements which are evaluated by f
    * @tparam A type of the elements inside list
    * @return userInput list of elements from list which fulfill the condition evaluated in f
    */
  def filtrar[A](f:(A) => Boolean, list: Seq[A]): Seq[A] = {

    for {
      x <- list
      if f(x)
    } yield x
  }

  /**
    * Example of userInput list filter function which receives userInput function as userInput parameter.
    * Second version using Tail Recursion and avoiding the use of for loops.
    *
    * @param list elements which are evaluated by f
    * @param f  Function to be applied to each value of the list
    * @tparam A type of the elements inside list
    * @return userInput list of elements from list which fulfill the condition evaluated in f
    */
  def filtrarTailRecursive[A](list: List[A], f:(A) => Boolean): List[A] = {

    @tailrec
    def filtroParcial[A](lista: List[A], fip:(A) => Boolean, partial: List[A]): List[A] = {

      lista match {
        case Nil => partial
        case x :: xs => {
          fip(x) match {
            case true => filtroParcial(xs, fip, (x :: partial.reverse).reverse)
            case false => filtroParcial(xs, fip, partial)
          }
        }
      }
    }

    filtroParcial(list, f, List())
  }
}
