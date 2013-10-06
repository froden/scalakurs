package oppg3_lister_intro

import org.scalatest._

class ListerTest extends FunSuite {

  val lister: Lister = new Lister

  test ("Lister should reverse a list of Ints") {
    assert(lister.reverse(List(1, 2, 3)) === List(3, 2, 1))
  }

  test ("it should reverse a list of Strings") {
    assert(lister.reverse(List("a", "b", "c")) === List("c", "b", "a"))
  }

  test ("it should remove Int duplicates") {
    assert(lister.removeDuplicates(List(1, 1, 1, 1, 1, 2, 3, 1, 2, 1, 2, 1)) === List(1, 2, 3))
  }

  test ("it should remove String duplicates") {
    assert(lister.removeDuplicates(List("a", "a", "a", "a", "a", "b", "c", "a", "b", "a", "b", "a")) === List("a", "b", "c"))
  }

  test ("it should find first Int element") {
    assert(lister.findFirstElement(List(1, 2, 3, 4)) === 1)
  }

  test ("it should find first String element") {
    assert(lister.findFirstElement(List("a", "b", "c", "d")) === "a")
  }

  test ("it should find last Int element") {
    assert(lister.findLastElement(List(1, 2, 4)) === 4)
  }

  test ("it should find last String element") {
    assert(lister.findLastElement(List("a", "b")) === "b")
  }

  test("it should find two first Int elements") {
    assert(lister.findTwoFirstElements(List(1, 2, 3)) === List(1, 2))
  }

  test("it should find two first String elements") {
    assert(lister.findTwoFirstElements(List("a", "b", "c")) === List("a", "b"))
  }

  test("it should find all but the first Int element") {
    assert(lister.findAllButFirstElement(List(1, 2, 3)) === List(2, 3))
  }

  test("it should find all but the first String element") {
    assert(lister.findAllButFirstElement(List("a", "b", "c")) === List("b", "c"))
  }

  test("it should find all but the first two Int elements") {
    assert(lister.findAllButTwoFirstElements(List(1, 2, 3)) === List(3))
  }

  test("it should find all but the first to String elements") {
    assert(lister.findAllButTwoFirstElements(List("a", "b", "d")) === List("d"))
  }

  test("it should find all but the first two String elements") {
    assert(lister.findAllButTwoFirstElements(List("a", "b", "c", "d")) === List("c", "d"))
  }

  test("it should find even numbers") {
    assert(lister.findEvenNumbers(List(1, 2, 3, 4, 5, 6, 7, 33, 44, 66, 200)) === List(2, 4, 6, 44, 66, 200))
  }

  test("it should calculate the cubes of a list of numbers") {
    assert(lister.calculateCubes(List(1, 2, 3)) === List(1, 8, 27))
  }

  test("it should find sublist from can-be-divided-by-3 predicate") {
    assert(lister.findSublistFromPredicate(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i % 3 == 0) === List(3, 6, 9))
  }

  test("it should find sublist from must-be-greater-than-5 predicate") {
    assert(lister.findSublistFromPredicate(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i > 5) === List(6, 7, 8, 9, 10))
  }

  test("it should wind up two lists") {
    assert(lister.windUpTwoLists(List(1,2,3), List("a", "b", "c")) === List((1,"a"),("b",2),(3,"c")))
  }

  test("it should wind up another two lists") {
    assert(lister.windUpTwoLists(List(1,2,3), List(4,5,6)) === List((1,4),(5,2),(3,6)))
  }

  test("it should chop a list from both ends") {
    assert(lister.chopFromBothsEndsAtAList(List(1,2,3,4,5,6,7,8)) === List(1,8,2,7,3,6,4,5))
  }

  test("it should find the sum of a short list of Ints") {
    assert(lister.sumAllNumbersInList((1 to 10).toList) === 55)
  }

  test("it should find the sum of a long list of Ints") {
    assert(lister.sumAllNumbersInList((1 to 100).toList) === 5050)
  }

  test("it should encode runlength of a sorted list of Strings") {
    assert(lister.encodeSequenceLengthInSortedList(List("a", "a", "b", "b", "c", "d", "d", "d", "d")) === List((2,"a"),(2,"b"),(1,"c"),(4,"d")))
  }

}
