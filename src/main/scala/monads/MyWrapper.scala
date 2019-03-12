package monads

class MyWrapper[A] private (value: A) {

  def map[B](f: A => B): MyWrapper[B] = {

    val newValue = f(value)
    MyWrapper(newValue)
  }

  def flatMap[B](f: A => MyWrapper[B]): MyWrapper[B] = {
    f(value)
  }

  override def toString = value.toString

}

object MyWrapper {

  def apply[A] (value: A): MyWrapper[A] = new MyWrapper(value)
}
