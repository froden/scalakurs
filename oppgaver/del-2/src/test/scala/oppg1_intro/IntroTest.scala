package oppg1_intro

import org.scalatest._
import support.ScalakursSupport
import oppg1_intro.Intro.{Node, Leaf}

class IntroTest extends FunSuite with ShouldMatchers with ScalakursSupport {

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Everything is expressions") {
    val parsed = try {
      "23".toInt
    } catch {
      case _: NumberFormatException => 0
    }
    parsed should be(__)

    val parsed2 = try {
      "hello".toInt
    } catch {
      case _: NumberFormatException => 0
    }
    parsed2 should be(__)
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Last expression is always returned") {
    def sayHi(name: String) = {
      val greeting = "Hi there " + name
      greeting
    }
    sayHi("Sjur") should be(__)

    def sayHi2(name: String) = {
      val greeting = "Hi there " + name
      println(greeting)
    }
    sayHi2("Frode") should be(__)
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Functions are values too") {
    //inferred type for add1, explicit types for parameters
    val add1 = (x: Int, y: Int) => x + y

    //explicit type for add2, shorthand syntax for function body
    val add2: (Int, Int) => Int = _ + _

    //the underlying representation of a function with 2 args
    val add3 = new Function2[Int, Int, Int] {
      def apply(x: Int, y: Int) = x + y
    }

    val x = 2
    //closure
    val add4 = (y: Int) => x + y

    add1(1, 2) should be(__)
    add2(1, 2) should be(__)
    add3(1, 2) should be(__)
    add3.apply(1, 2) should be (__)
    add4(2) should be(__)
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Higher order functions and composition") {
    val addOne = (x: Int) => x + 1
    val addOneMore = (f: Int => Int) => (y: Int) => f(y + 1)

    val addTwo = addOneMore(addOne)

    addTwo(2) should be(__)

    val addTwoMore = addOneMore andThen addOneMore
    addTwoMore(addOne)(1) should be(__)
  }


  /*
   * Complete the implementation of findPath
   * The following tree would yield the result List(left, right, Frode) for input "Frode"
   *                  root
   *               /       \
   *            /    \   /    \
   *        Sjur Frode Arild Torbjørn
   */
  test("Pattern matching") {
    val tree1 = Node(Node(Leaf("Sjur"), Leaf("Frode")), Node(Leaf("Arild"), Leaf("Trobjørn")))
    val tree2 =
      Node(
        Node(Leaf("Sjur"), Node(Leaf("Frode"), Node(Leaf("Arild"), Leaf("Torbjørn")))), (
          Node(Leaf("Gry"), Node(Leaf("Lene"), Node(Leaf("Ida"), Leaf("Linn"))))))

    Intro.findPath("Frode", tree1) should be(List("left", "right", "Frode"))
    Intro.findPath("Torbjørn", tree2) should be(List("left", "right", "right", "right", "Torbjørn"))
  }

  /**
   * Make the method applyFunction generic so that it can
   * apply any function from any type to any other type
   **/
  test("Type signatures (generics)") {
    def applyFunction(value: String, f: (String => Int)): Int = f(value)

    val lengthOfString: String => Int = _.length
    val equalTo5: Int => Boolean = _ == 5

    applyFunction("Hi", lengthOfString) should be(2)

    pending //remove this line and uncomment the next
//    applyFunction(5, equalTo5) should be(true)
  }
}
