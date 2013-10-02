package lister_intro

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class ListerTest extends FlatSpec with ShouldMatchers {

  val lister: Lister = new Lister

  "Lister" should "reverse a list of Ints" in {
    assert(lister.reverser(List(1, 2, 3)) === List(3, 2, 1))
  }

  it should "reverse a list of Strings" in {
    assert(lister.reverser(List("a", "b", "c")) === List("c", "b", "a"))
  }

  it should "remove Int duplicates" in {
    assert(lister.fjernDuplikater(List(1, 1, 1, 1, 1, 2, 3, 1, 2, 1, 2, 1)) === List(1, 2, 3))
  }

  it should "remove String duplicates" in {
    assert(lister.fjernDuplikater(List("a", "a", "a", "a", "a", "b", "c", "a", "b", "a", "b", "a")) === List("a", "b", "c"))
  }

  it should "find first Int element" in {
    assert(lister.finneForsteElement(List(1, 2, 3, 4)) === 1)
  }

  it should "find first String element" in {
    assert(lister.finneForsteElement(List("a", "b", "c", "d")) === "a")
  }

  it should "find last Int element" in {
    assert(lister.finneSisteElement(List(1, 2, 4)) === 4)
  }

  it should "find last String element" in {
    assert(lister.finneSisteElement(List("a", "b")) === "b")
  }

  it should "find two first Int elements" in {
    assert(lister.finnToForsteElementer(List(1, 2, 3)) === List(1, 2))
  }

  it should "find two first String elements" in {
    assert(lister.finnToForsteElementer(List("a", "b", "c")) === List("a", "b"))
  }

  it should "find all but the first Int element" in {
    assert(lister.finnBortsettFraForsteElement(List(1, 2, 3)) === List(2, 3))
  }

  it should "find all but the first String element" in {
    assert(lister.finnBortsettFraForsteElement(List("a", "b", "c")) === List("b", "c"))
  }

  it should "find all but the first two Int elements" in {
    assert(lister.finnBortsettFraToForsteElementer(List(1, 2, 3)) === List(3))
  }

  it should "find all but the first to String elements" in {
    assert(lister.finnBortsettFraToForsteElementer(List("a", "b", "d")) === List("d"))
  }

  it should "find all but the first two String elements" in {
    assert(lister.finnBortsettFraToForsteElementer(List("a", "b", "c", "d")) === List("c", "d"))
  }

  it should "find even numbers" in {
    assert(lister.finnPartall(List(1, 2, 3, 4, 5, 6, 7, 33, 44, 66, 200)) === List(2, 4, 6, 44, 66, 200))
  }

  it should "calculate the cubes of a list of numbers" in {
    assert(lister.kalkulerKubene(List(1, 2, 3)) === List(1, 8, 27))
  }

  it should "find sublist from can-be-divided-by-3 predicate" in {
    assert(lister.finnSublisteFraPredikat(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i % 3 == 0) === List(3, 6, 9))
  }

  it should "find sublist from must-be-greater-than-5 predicate" in {
    assert(lister.finnSublisteFraPredikat(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i > 5) === List(6, 7, 8, 9, 10))
  }

  it should "wind up two lists" in {
    assert(lister.tvinneToLister(List(1,2,3), List("a", "b", "c")) === List((1,"a"),("b",2),(3,"c")))
  }

  it should "wind up another two lists" in {
    assert(lister.tvinneToLister(List(1,2,3), List(4,5,6)) === List((1,4),(5,2),(3,6)))
  }

  it should "chop a list from both ends" in {
    assert(lister.plukkeFraKanteneAvListen(List(1,2,3,4,5,6,7,8)) === List(1,8,2,7,3,6,4,5))
  }

  it should "find the sum of a short list of Ints" in {
    assert(lister.summereAlleIntsIEnListe((1 to 10).toList) === 55)
  }

  it should "find the sum of a long list of Ints" in {
    assert(lister.summereAlleIntsIEnListe((1 to 100).toList) === 5050)
  }

  it should "encode runlength of a sorted list of Strings" in {
    assert(lister.encodeSekvensLengdeIEnSortertListe(List("a", "a", "b", "b", "c", "d", "d", "d", "d")) === List((2,"a"),(2,"b"),(1,"c"),(4,"d")))
  }

}
