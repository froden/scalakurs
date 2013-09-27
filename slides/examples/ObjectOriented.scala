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

object Ex3 extends App {
  class Person(val name: String) {

    def greet(someone: Person) = name + "says hi to " + someone.name
  }

  val p = new Person("frode")
  val j = p.greet(new Person("bob"))
  println(j)
}