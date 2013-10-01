package oppg2_oo

class Rational {

  val numer: Int = ???
  val denom: Int = ???

  /**
   * Hint: Du trenger ikke finne den _minste_ fellesnevneren i denne utgaven.
   * En fellesnevner holder.
   */
  def add(rational: Rational): Rational = ???
}

object Rational {
  /**
   * Hint: Lag og bruk constructor på Ration-klassen
   */
  def apply(n: Int, d: Int): Rational = ???

  /**
   * Hint: Ikke kall den andre apply-metoden. Lag egen constructor på Rational klassen.
   */
  def apply(n: Int): Rational = ???
}
