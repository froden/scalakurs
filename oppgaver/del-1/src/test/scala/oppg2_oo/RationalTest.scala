package oppg2_oo

import org.scalatest.FunSuite
import Support.rationalEq

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
    assert(r === new Rational(2, 1))
  }

  test("Det skal gå an å legge sammen to rasjonale tall") {
    val r = Rational(1, 2).add(Rational(1, 2))
    assert(r === Rational(1, 1))
    val r2 = Rational(11, 13).add(Rational(1, 13))
    assert(r2 === Rational(12, 13))
  }

  test("Det skal gå an å legge sammen to rasjonale tall med syntaksen r1 + r2 (operator)") {
//    throw new Exception("Remove this line. Uncommend the following lines and make them compile. Do not alter the test")
    val r1: Rational = Rational(1, 2)
    val r2: Rational = Rational(3, 4)
    assert((r1 + r2) === Rational(5, 4))
  }
}
