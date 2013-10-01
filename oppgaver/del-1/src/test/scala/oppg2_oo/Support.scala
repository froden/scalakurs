package oppg2_oo

import org.scalautils.Equality

object Support {
  implicit val rationalEq = new Equality[Rational] {
    def areEqual(a: Rational, ba: Any): Boolean = ba match {
      case b: Rational =>
        val r1 = n(a)
        val r2 = n(b)
        r1.numer == r2.numer && r1.denom == r2.denom
      case _ => false
    }
    private def n(r: Rational) = {
      val g = gcd(r.numer, r.denom)
      Rational(r.numer/g, r.denom/g)
    }
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }
}
