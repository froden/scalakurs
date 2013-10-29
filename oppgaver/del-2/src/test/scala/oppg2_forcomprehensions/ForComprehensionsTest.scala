package oppg2_forcomprehensions

import org.scalatest.FunSuite
import support.ScalakursSupport

class ForComprehensionsTest extends FunSuite with ScalakursSupport {

  test("increment numbers in a list") {
    assert(ForComprehensions.incrementAllNumbers(List(1,2,3)) === List(2,3,4))
  }

  test("keep even numbers in a list") {
    assert(ForComprehensions.keepAllEvenNumbersInAList(List(1,2,3,4,5,6,7,8,9,10)) === List(2,4,6,8,10))
  }

  test("find all pairs in two lists as a list of pairs (list of tuples)") {
    assert(ForComprehensions.findAllPairs(List("a", "b"), List("x","y")) === List(("a","x"),("a","y"),("b","x"),("b","y")))
  }

  test("find all pairs in two lists of int as a list of pairs (list of tuples) where first element is even") {
    assert(ForComprehensions.findAllPairsWhereFirstElementIsEven(List(1,2), List(1,2)) === List((2,1),(2,2)))
  }

  test("find all primes in a list of numbers") {
    assert(ForComprehensions.findAllPrimes(List(3L)) === List(3L))
    assert(ForComprehensions.findAllPrimes(List(4L)) === List())
    assert(ForComprehensions.findAllPrimes(List(1L, 4L, 13L, 21L, 23L)) === List(1L, 13L, 23L))
  }

}
