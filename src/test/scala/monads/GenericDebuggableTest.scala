package monads

import functions.Utils
import org.scalatest.FunSuite

class GenericDebuggableTest extends FunSuite {

  test("Using GenericDebuggable (with generics - Int) in userInput for expression as an extension of MyWrapper monad's functionality") {

    val result = for {
      a <- Utils.duplicateDebuggableGenerics(100)
      b <- Utils.triplicateDebuggableGenerics(a)
      c <- Utils.quadrupleDebuggableGenerics(b)

    } yield a + b + c

    println(result.value + " => \n" + result.message)

    assert(result.value == 3200)

  }

  test("Using GenericDebuggable (with generics - Float) in userInput for expression as an extension of MyWrapper monad's functionality") {

    val result = for {
      a <- Utils.duplicateFloat(1.5f)
      b <- Utils.triplicateFloat(a)
      c <- Utils.quadrupleFloat(b)

    } yield a + b + c

    println(result.value + " => \n" + result.message)

    assert(result.value == 48.0f)

  }

}
