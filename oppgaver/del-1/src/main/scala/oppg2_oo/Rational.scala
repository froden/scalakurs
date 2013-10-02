package oppg2_oo

class Rational {

  val numer: Int = ???
  val denom: Int = ???

  /**
   * Hint: 1   2   3   4
   *       - + - = - + -
   *       2   3   6   6
   * Du trenger ikke finne minste fellesnevner i denne oppgaven
   */
  def add(that: Rational): Rational = ???
}

object Rational {
  /**
   * Hint: Lag og bruk constructor på Ration-klassen
   */
  def apply(n: Int, d: Int): Rational = ???

  /**
   * Hint: Ikke kall den andre apply-metoden.
   * Lag egen constructor med ett parameter på Rational klassen.
   */
  def apply(n: Int): Rational = ???
}
