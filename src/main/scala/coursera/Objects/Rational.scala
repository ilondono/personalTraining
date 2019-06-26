package coursera.Objects

object Rational extends App {

  class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y

    def add(param: Rational): Rational = {
      new Rational(numer * param.denom + param.numer * denom, denom * param.denom)
    }

    def neg(): Rational = {
      new Rational(-numer, denom)
    }

    def subtract(x: Rational) = {
      new Rational(numer * x.denom - x.numer * denom, denom * x.denom)
    }

    override def toString() = {
      numer + "/" + denom
    }

  }

  println(new Rational(1, 2).toString())

  val x = new Rational(1,3)
  val y = new Rational(5, 7)
  val z = new Rational(3,2)

  println("Neg -->\t\t\t\t\t\t" + x.neg())
  println("subtract -->\t\t\t\t" + x.subtract(y))
  println("subtract another way--> \t" + x.add(y.neg()))
  println("x - y - z --> \t\t\t\t" + x.subtract(y).subtract(z))

}
