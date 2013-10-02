package oppg2_oo

class Rational(n: Int, d: Int) {
  require(d != 0)

  def this(n: Int) = this(n, 1)

  val numer: Int = n
  val denom: Int = d

  /**
   * Hint: 1   2   3   4
   *       - + - = - + -
   *       2   3   6   6
   * Du trenger ikke finne minste fellesnevner i denne oppgaven
   */
  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  /**
   * Hint: metodenavn kan også bestå av spesialtegn
   * f.eks: /\/\/\(str: String) er gyldig
   * Når man bare har ett parameter kan man utelate . og () i metodekallet.
   * f.eks: this /\/\/\ "hei" == this./\/\/\("hei")
   */
  def +(that: Rational) = add(that)

  override def toString = numer + "/" + denom
}

object Rational {
  /**
   * Hint: Lag og bruk constructor på Ration-klassen
   */
  def apply(n: Int, d: Int): Rational = new Rational(n, d)

  /**
   * Hint: Ikke kall den andre apply-metoden. Lag egen constructor på Rational klassen.
   */
  def apply(n: Int): Rational = new Rational(n)
}
