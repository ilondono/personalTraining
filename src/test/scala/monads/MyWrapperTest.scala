package monads

import functions.Utils
import org.scalatest.FunSuite

class MyWrapperTest extends FunSuite{

  test("Using MyWrapper monad in userInput for expression") {

    val result = for {
      a <- Utils.duplicate(1)
      b <- Utils.triplicate(a)
      c <- Utils.quadruple(b)
    } yield a + b + c

    assert(result.getClass === MyWrapper(32).getClass)
    assert(result.toString.equals(MyWrapper(32).toString))

  }
}
