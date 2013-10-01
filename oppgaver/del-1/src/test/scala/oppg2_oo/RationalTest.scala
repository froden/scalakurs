package oppg2_oo

import org.scalatest.FunSuite

class RationalTest extends FunSuite {
  test("Rational skal ha to public accessors 'numer' og 'denom'") {
    val r = Rational(1, 2)
    assert(r.numer === 1)
    assert(r.denom === 2)
  }

  test("Rational skal ikke godta denom = 0") {
    intercept[IllegalArgumentException] {
      Rational(1, 0)
    }
  }

  test("Rational skal ha en fornuftig toString") {
    assert(Rational(1, 2).toString === "1/2")
  }

  test("Rational skal ha en constructor med kun ett parameter for heltall") {
    val r = Rational(2)
    assert(r.numer === 2)
    assert(r.denom === 1)
  }

  test("Det skal gå an å legge sammen to rationelle tall") {
    val r = Rational(1, 2).add(Rational(1, 2))
    assert(r.numer === r.denom)
    val r2 = Rational(11, 13).add(Rational(2, 45))
    assert(r2.numer === r2.denom)
  }
}
