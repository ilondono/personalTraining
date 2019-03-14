package monads

import functions.Utils
import org.scalatest.FunSuite

class DebuggableTest extends FunSuite {

  test("Using Debuggable monad in a for expression as an extension of MyWrapper monad's functionality") {

    val result = for {
      a <- Utils.duplicateDebuggable(1)
      b <- Utils.triplicateDebuggable(a)
      c <- Utils.quadrupleDebuggable(b)
    } yield a + b + c

    println(result.value + " =>\n" + result.message)
  }
}
