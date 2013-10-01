import java.util.Date
import scala.util.Random

object Ex1 {
  class Person

  val p = new Person
}

object Ex2 {
  class Person(val name: String, var age: Int)

  val p = new Person("Bob", 25)
  p.name // Bob
  p.age = 26
}

//metode
object Ex3 extends App {
  class Person(val name: String) {

    def greet(someone: Person) = name + "says hi to " + someone.name
  }

  val p = new Person("frode")
  val j = p.greet(new Person("bob"))
  println(j)
}

//constructor
object Ex4 extends App {
  class Person(age: Int) {
    val category = if (age < 35) "young" else "old"

    def sayHi = "Hi, I'm " + category
  }

  new Person(30).sayHi
}

object Ex5 {
  class Date(val time: Long) {

    def this(date: Date) = this(date.time)
  }
}

object Ex6 {
  object Logger {
    def log(msg: String) = println(msg)
  }

  Logger.log("It's all good!")
}

object Ex7 {
  class Person(val name: String, val age: Int)

  //I samme fil
  object Person {
    def apply(name: String, age: Int) = new Person(name, age)
  }

  val p = Person("Frode", 33)
}

object Ex8 {
  trait Employee {
    def work(): String
  }

  class Junior extends Employee {
    def work() = "I work all day"
  }

  class Senior extends Employee {
    def work() = "I delegate my work"
  }

  val employees = List(new Junior, new Senior)

  trait Consulting extends Employee {
    override def work() = "I tell others how to work"
  }

  class SeniorConsulatant extends Employee with Consulting
}

object Ex9 {
  trait Animal {
    def greet = "I'm an animal"
  }

  class Dog extends Animal
  class Fox extends Animal
}

object Ex10 {
  trait Animal {
    def say: String

    def greet = "I'm an animal that says " + say
  }

  class Dog extends Animal {
    def say = "woof"
  }

  class Fox extends Animal {
    def say = ???
  }
}

object Ex11 {
  trait Animal {
    def say: String

    def greet = "I'm an animal that says " + say
  }

  trait Fourlegged
  trait Furry

  class Dog extends Animal with Fourlegged with Furry {
    def say = "woof"
  }
}

object Ex12 {
  class Person(val name: String) {

  }

  class Student(val studentId: Int, name: String) extends Person(name) {

  }
}