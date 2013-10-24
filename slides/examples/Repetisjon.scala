import java.io.IOException
import java.nio.file.{Paths, Files}
import java.util.Date
import scala.io.Source

object Repetisjon {

  //immutable value, type inferred
  val name = "Frode"

  //immutable value with type
  val name2: String = "Frode"

  //method
  def sayHiTo(name: String) = s"Hi $name"

  //method with explicit return type
  def add(a: Int, b:Int): Int = a + b
}

object Rep2 {

  //result of last expression is returned
  val date = {
    println("getting the date")
    new Date()
  }

  //if is an expression
  def checkLength(str: String) = if (str.length < 50) "ok" else "too long"

  //try catch is an expression
  val head = try {
    Source.fromFile("app.log").getLines().take(10)
  } catch {
    case _: IOException => List()
  }
}

object Rep3 {

  //functions are values too
  val add = (a: Int, b: Int) => a + b

  //convert method to function
  val replaceAll = "Frode".replaceAll _
  replaceAll("e", "3")
  //res0: String = Frod3

  //functions as arguments
  def combine(a: Int, b: Int, func: (Int, Int) => Int) = func(a, b)
  //short form for functions
  combine(2, 3, _ * _)
  //res1: Int = 6
}

object Rep5 {

  //class
  class Person(val name: String, val age: Int) {
    override def toString = name + " " + age
  }

  //object with apply factory method
  object Person {
    def apply(name: String, age: Int) = new Person(name, age)
  }
  Person("Frode", 33)
  //res2: Person = Frode 33

  //trait
  trait Tree

  //case class
  case class Node(left: Tree, right: Tree) extends Tree
  case class Leaf(value: String) extends Tree

  //object
  Node(Leaf("left"), Leaf("right")) match {
    case Node(_, Leaf(value)) => "right tree was leaf with value " + value
    case Node(_, right) => "right was " + right
  }
  //res3: String = left was leaf with value right

}

object Rep4 {

//value of generic type List with type argument String
val names: List[String] = List("Arild", "Sjur", "Frode")

//generic method with one type parameter
def lastElement[A](list: List[A]) = list.last

//generic mapping function with two type parameters
def map[A, B](value: A)(func: A => B): B = func(value)
map("Frode".toList)(lastElement)
//res4: Char = e
}
