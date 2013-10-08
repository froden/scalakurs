package oppg2_oo

class Rational(n: Int, d: Int) {

  def this(n: Int) = this(n, 1)

  require(d != 0)

  /**
   * Remember that the body of the class is the body of the primary constructor. Assignments goes here.
   *
   * ??? Throws a NotImplementedException and returns the type Nothing
   * which is a subtype of every other type in Scala
   */
  val numer: Int = n
  val denom: Int = d

  /**
   * Hint: 1   2   3   4
   *       - + - = - + -
   *       2   3   6   6
   * You don't need to find the greatest common divisor
   */
  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(that: Rational) = add(that)

  override def toString = numer + "/" + denom
}

object Rational {
  /**
   * Hint: Create and invoke a constructor on class Rational
   */
  def apply(n: Int, d: Int): Rational = new Rational(n, d)

  /**
   * Hint: Don't call the other apply method
   * Create a separate constructor using 'this'
   */
  def apply(n: Int): Rational = new Rational(n)
}
