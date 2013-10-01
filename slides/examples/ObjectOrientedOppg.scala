object ObjectOrientedOppg1 extends App {


  class Rational(n: Int, d: Int) extends Ordered[Rational] {
    //oppgave validere at d ikke er 0
    require(d != 0)

    //predef for å få oppgaven til å kompilere?
    val numer: Int = n
    val denom: Int = d

    //oppgave lag ekstra constructor
    def this(n: Int) = this(n, n)

    //oppg lag add
    def add(that: Rational): Rational =
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    //oppg lag + metode
    def +(that: Rational) = add(that)

    //oppg lag tostring
    override def toString = numer + "/" + denom

    //oppg mix inn ordered og implementer metode
    def compare(that: Rational): Int = (numer * that.denom) - (that.numer * denom)
  }

  //oppgave lag factorymetode
  object Rational {
    def apply(n: Int, d: Int) = new Rational(n, d)
  }


  val r1 = new Rational(1, 2)
  val r2 = new Rational(3, 4)
  val r3 = Rational(2, 3)

  println(r1)
  println(r1.add(r2))
  println(r1 + r2)
  println(List(r1, r2, r3).max)
}

//Vanskelig: normalisering av brøk
object ObjectOrientedOppg2 extends App {


  class Rational(n: Int, val d: Int) {
    //oppgave validere at d ikke er 0
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    //oppgave lag ekstra constructor
    def this(n: Int) = this(n, n)

    //oppg lag add
    def add(that: Rational): Rational =
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    //oppg lag tostring
    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }


  val r1 = new Rational(1, 2)
  val r2 = new Rational(1, 2)

  println(r1)
  println(r1.add(r2))
}

object OppgTrait {
  trait Ord {
    def < (that: Any): Boolean
    def <=(that: Any): Boolean =  (this < that) || (this == that)
    def > (that: Any): Boolean = !(this <= that)
    def >=(that: Any): Boolean = !(this < that)
  }
}
