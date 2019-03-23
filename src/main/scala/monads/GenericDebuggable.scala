package monads

case class GenericDebuggable[A](value: A, message: String) {

  def map[B](f: A => B): GenericDebuggable[B] = {

    val newValue: B = f(this.value)
    GenericDebuggable(newValue, this.message)
  }

  def flatMap[B](f: A => GenericDebuggable[B]): GenericDebuggable[B] = {

    val nextValue = f(this.value)
    GenericDebuggable(nextValue.value, this.message + "\n" + nextValue.message)
  }
}
