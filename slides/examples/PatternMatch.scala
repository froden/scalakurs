object PatternMatch extends App {

  case class Person(name: String, age: Int)

  def finnOla(person: Person) = person match {
    case Person("Ola", 32) => println("Fant Ola 32!")
    case Person("Ola", alder) => println("Fant en annen Ola som er " + alder)
    case Person(navn, _) if navn.startsWith("O") => println("Fant en med navn på O")
    case Person(navn, alder) => println("Fant: " + navn + ", " + alder)
  }

  finnOla(Person("Olga", 33))

}
