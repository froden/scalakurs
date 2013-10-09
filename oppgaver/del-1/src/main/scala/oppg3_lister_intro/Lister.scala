package oppg3_lister_intro

/**
 * Find all methods in the scala immutable list API:
 * http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List
 */
class Lister {

  /**
   * Should flip a list : List(1,2,3) -> List(3,2,1)
   */
  def reverse[A](myList: List[A]) =
    myList.reverse

  /**
   * Should keep only unique, distinct elements in a list:
   * List(1,1,1,1,1,1,1,2) -> List(1,2)
   */
  def removeDuplicates[A](myList: List[A]) =
    myList.distinct

  /**
   * Should return first element in a list (not as a list) :
   * List(1,2,3) -> 1
   */
  def findFirstElement[A](myList: List[A]) =
    myList.head

  /**
   * Should return last element in a list (not as a list)
   * List(1,2,3) -> 3
   */
  def findLastElement[A](myList: List[A]) =
    myList.last

  /**
   * Should return two first elements in a list (as a list):
   * List(1,2,3) -> List(1,2)
   */
  def findTwoFirstElements[A](myList: List[A]) =
    myList.take(2)

  /**
   * Should return remaining of a list when first element is removed (as a list)
   * List(1,2,3) -> List(2,3)
   */
  def findAllButFirstElement[A](myList: List[A]) =
    myList.tail

  /**
   * Should return remaining of a list when first two elements are removed (as a list)
   * List(1,2,3) -> List(3)
   */
  def findAllButTwoFirstElements[A](myList: List[A]) =
    myList.drop(2)

  /**
   * Should return a sublist of Ints with only the even numbers in it
   * List(1,2,3,4) -> List(2,4)
   */
  def findEvenNumbers(myList: List[Int]) =
    myList.filter( _ % 2 == 0)

  /**
   * Given a list of Ints, should think of these Ints as side-lengths in a cube
   * Return value should be a list of equal length with the volume spanned out of a cube with this element as a side :
   * List(1,2,3) -> List(1,8,27)
   * Each cube volum is calculated from this one value in the list
   * The sides come in as a list of Ints. The result is also a list of Ints.
   */
  def calculateCubes(myList: List[Int]) =
    myList.map((n: Int) => n * n * n)

  /**
   * Given any predicate in the form of a function from Int to boolean (f: Int => Boolean), and a list of Ints, 
   * a new List of Ints are to be returned
   * The returned list should contain the subset of elements for which the predicate is true:
   * List(1,2,3,4,5), (_ < 3) -> List(1,2)
   */
  def findSublistFromPredicate(myList: List[Int], predicate: Int => Boolean) =
    myList.filter(predicate)

  /**
   * Tvinner to like lange lister til en liste av tupler
   * Winds up two lists of equal length to a list of tuple (where index 0,2,4 .. are unchanged but index 1,3,5,.. is flipped) :
   * List(1,2,3), List(a,b,c) -> List((1,a),(b,2),(3,c))
   * List(a,b,c), List(1,2,3) -> List((a,1),(2,b),(c,3))
   */
  def windUpTwoLists[A, B](myList1: List[A], myList2: List[B]) = {
    val index: List[((A, B), Int)] = myList1.zip(myList2).zipWithIndex
    index.map (
      (element: ((Any, Any), Int)) =>
        if(element._2 % 2 == 0)
          element._1
        else
          element._1.swap
    )
  }

  /**
   * chops values from left and right side of the list until the list is empty. Returns these values as a list :
   * List(1,2,3,4,5) -> List(1,5,2,4,3)
   */
  def chopFromBothsEndsAtAList[A](myList: List[A]): List[A] = {
    if (myList.isEmpty)
      Nil
    else
      myList.head :: chopFromBothsEndsAtAList(myList.tail.reverse)
  }

  /**
   * Sums a list of Ints and returns the sum as an Int :
   * List(1,2,3) -> 6
   */
  def sumAllNumbersInList(myList: List[Int]) =
    myList.reduce((r,c) => r + c)

  /**
   * Takes a sorted list in. Returns a list of tuples where the first element in each tuple is the number of elements of this distinct value :
   * List("a", "b") -> List((1,"a"),(1,"b"))
   * List("a", "a", "a") -> List((3,"a"))
   * List("a", "b", "b") -> List((1,"a"),(2,"b"))
   *
   * Hint: consider
   * - the function 'span (which is a combination of takeWhile and dropWhile),
   * - concatenating of an element in a list with ::
   * - buffering calculated values in a tuple
   * - recursive calls
   */
  def encodeSequenceLengthInSortedList[A](myList: List[A]) : List[(Int, A)] =
    if (myList.isEmpty)
      Nil
    else {
      val (packed, next) = myList span {
        _ == myList.head
      }
      (packed.length, packed.head) :: encodeSequenceLengthInSortedList(next)
    }

}