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
    parsed should be(23)

    val parsed2 = try {
      "23.5".toInt
    } catch {
      case _: NumberFormatException => 0
    }
    parsed2 should be(0)
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Last expression is always returned") {
    def sayHi(name: String) = {
      val greeting = "Hi there " + name
      greeting
    }
    sayHi("Sjur") should be("Hi there Sjur")

    def sayHi2(name: String) = {
      val greeting = "Hi there " + name
      println(greeting)
    }
    sayHi2("Frode") should be()
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Functions are values too") {
    //inferred type for lambda1 and explicit types for parameters
    val lambda1 = (x: Int, y: Int) => x + y

    //explicit type for lambda2, shorthand syntax for function body
    val lambda2: (Int, Int) => Int = _ + _

    //the underlying representation of a function with 2 args
    val lambda3 = new Function2[Int, Int, Int] {
      def apply(x: Int, y: Int) = x + y
    }

    val x = 2
    //closure
    val closure = (y: Int) => x + y

    lambda1(1, 2) should be(3)
    lambda2(2, 2) should be(4)
    lambda3(1, 3) should be(4)
    lambda3.apply(1, 2) should be (3)
    closure(2) should be(4)
  }

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Higher order functions and composition") {
    val addOne = (x: Int) => x + 1
    val addOneMore = (f: Int => Int) => (y: Int) => f(y + 1)

    val addTwo = addOneMore(addOne)

    addTwo(2) should be(4)

    val addTwoMore = addOneMore andThen addOneMore
    addTwoMore(addOne)(2) should be(5)
  }


  /*
   * Complete the implementation of Intro.findPath()
   * The method should return a list of paths through the tree to a given name
   * The following tree would yield the result List(left, right, Frode) for input "Frode"
   *
   *                  root
   *               /       \
   *            /    \   /    \
   *        Sjur Frode Arild Torbjørn
   *
   */
  test("Pattern matching") {
    val tree1 = Node(Node(Leaf("Sjur"), Leaf("Frode")), Node(Leaf("Arild"), Leaf("Trobjørn")))
    val tree2 =
      Node(
        Node(Leaf("Sjur"), Node(Leaf("Frode"), Node(Leaf("Arild"), Leaf("Torbjørn")))),
        Node(Leaf("Gry"), Node(Leaf("Lene"), Node(Leaf("Ida"), Leaf("Linn")))))

    Intro.findPath("Frode", tree1) should be(List("left", "right", "Frode"))
    Intro.findPath("Torbjørn", tree2) should be(List("left", "right", "right", "right", "Torbjørn"))
  }

  /**
   * Make the method applyFunction generic so that it can
   * apply any function from any type to any other type
   * Hint: This involves adding type parameters like myMethod[X]
   **/
  test("Type signatures (generics)") {
    // make thid method generic
    def applyFunction[A, B](value: A, f: (A => B)): B = f(value)

    val lengthOfString: String => Int = _.length
    val equalTo5: Int => Boolean = _ == 5

    applyFunction("Hi", lengthOfString) should be(2)

    applyFunction(5, equalTo5) should be(true)
  }
}
