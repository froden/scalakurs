package oppg3_lister_intro

import org.scalatest._

class ListerTest extends FunSuite {

  val lister: Lister = new Lister

  test ("it should reverse a list of Strings") {
    pending //TODO: remove
    assert(lister.reverse(List("a", "b", "c")) === List("c", "b", "a"))
  }

  test ("it should remove Int duplicates") {
    pending //TODO: remove
    assert(lister.removeDuplicates(List(1, 1, 1, 1, 1, 2, 3, 1, 2, 1, 2, 1)) === List(1, 2, 3))
  }

  test ("it should find first String element") {
    pending //TODO: remove
    assert(lister.findFirstElement(List("a", "b", "c", "d")) === "a")
  }

  test ("it should find last Int element") {
    pending //TODO: remove
    assert(lister.findLastElement(List(1, 2, 4)) === 4)
  }

  test("it should find two first String elements") {
    pending //TODO: remove
    assert(lister.findTwoFirstElements(List("a", "b", "c")) === List("a", "b"))
  }

  test("it should find all but the first Int element") {
    pending //TODO: remove
    assert(lister.findAllButFirstElement(List(1, 2, 3)) === List(2, 3))
  }

  test("it should find all but the first two String elements") {
    pending //TODO: remove
    assert(lister.findAllButTwoFirstElements(List("a", "b", "d")) === List("d"))
    assert(lister.findAllButTwoFirstElements(List("a", "b", "c", "d")) === List("c", "d"))
  }

  test("it should find even numbers") {
    pending //TODO: remove
    assert(lister.findEvenNumbers(List(1, 2, 3, 4, 5, 6, 7, 33, 44, 66, 200)) === List(2, 4, 6, 44, 66, 200))
  }

  test("it should calculate the cubes of a list of numbers") {
    pending //TODO: remove
    assert(lister.calculateCubes(List(1, 2, 3)) === List(1, 8, 27))
  }

  test("it should find sublist from predicate") {
    pending //TODO: remove
    assert(lister.findSublistFromPredicate(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i % 3 == 0) === List(3, 6, 9))
    assert(lister.findSublistFromPredicate(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (i: Int) => i > 5) === List(6, 7, 8, 9, 10))
  }

  test("it should wind up two lists") {
    pending //TODO: remove
    assert(lister.windUpTwoLists(List(1,2,3), List("a", "b", "c")) === List((1,"a"),("b",2),(3,"c")))
    assert(lister.windUpTwoLists(List(1,2,3), List(4,5,6)) === List((1,4),(5,2),(3,6)))
  }

  test("it should chop a list from both ends") {
    pending //TODO: remove
    assert(lister.chopFromBothsEndsAtAList(List(1,2,3,4,5,6,7,8)) === List(1,8,2,7,3,6,4,5))
  }

  test("it should find the sum of a list of Ints") {
    pending //TODO: remove
    assert(lister.sumAllNumbersInList((1 to 10).toList) === 55)
    assert(lister.sumAllNumbersInList((1 to 100).toList) === 5050)
  }

  test("it should encode runlength of a sorted list of Strings") {
    pending //TODO: remove
    assert(lister.encodeSequenceLengthInSortedList(List("a", "a", "b", "b", "c", "d", "d", "d", "d")) === List((2,"a"),(2,"b"),(1,"c"),(4,"d")))
  }

}
