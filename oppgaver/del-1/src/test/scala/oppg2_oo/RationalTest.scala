package oppg2_oo

import org.scalatest.FunSuite
import Support.rationalEq

class RationalTest extends FunSuite {
  test("Rational should have two pulic accessors: 'numer' and 'denom'") {
    val r = Rational(1, 2)
    assert(r.numer === 1)
    assert(r.denom === 2)
  }

  test("Rational should prevent divide by zero by not accepting denom = 0") {
    intercept[IllegalArgumentException] {
      Rational(1, 0)
    }
  }

  test("Rational should yield a meaningful output from toString()") {
    assert(Rational(1, 2).toString === "1/2")
  }

  test("Rational should have a dedicated constructor for constructing integers") {
    val r = Rational(2)
    assert(r === Rational(2, 1))
  }

  test("One should be able to add two rational numbers together") {
    val r = Rational(1, 2).add(Rational(1, 2))
    assert(r === Rational(1, 1))
    val r2 = Rational(11, 13).add(Rational(1, 13))
    assert(r2 === Rational(12, 13))
  }

  /**
   * Hint: method names can consist of special characters (operators)
   * example: def /\/\/\(str: String) is valid
   * If the method take only one parameter you can omit the . and () in the method call.
   * example: this /\/\/\ "hei" is equivalent to this./\/\/\("hei")
   */
  test("Adding two rational numbers should be possible using the syntax r1 + r2 (operators)") {
    val r1: Rational = Rational(1, 2)
    val r2: Rational = Rational(3, 4)
    assert((r1 + r2) === Rational(5, 4))
  }
}
