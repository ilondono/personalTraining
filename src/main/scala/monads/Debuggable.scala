package monads

class Debuggable private (val value: Int, val message: String) {

  def map(f: Int => Int): Debuggable = {

    val nextValue = f(this.value)
    Debuggable(nextValue, this.message)
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val nextVal = f(value)
    Debuggable(nextVal.value, this.message + "\n" + nextVal.message)
  }
}

object Debuggable {
  def apply (value: Int, message: String): Debuggable = new Debuggable(value, message)
}
