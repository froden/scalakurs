package oppg4_pattern_matching_and_case_classes;

case class Person(name: String, age: Int) {
  def isOlderThan(that: Person): Boolean = {
    this.age > that.age
  }
}

object PatternMatchingAndCaseClasses {

  def computeSquareOfIntOrString(number: Any): Int = {
    val n = number match {
      case i: Int => i
      case s: String => s.toInt
    }
    n * n
  }

  def checkIfParameterIsPersonOlaAtAge20(parameter: Any): Boolean = {
    parameter match {
      case Person("Ola", 20) => true
      case _ => false
    }

  }

  // Try to use pattern matching for lists
  // Hint: Use _* for arbitrary many elements i list
  def checkIfSecondElementIsAPersonAtAge30(persons: List[Person]): Boolean = {
    persons match {
      case List(_, Person(_, age), _*)  => age == 30
      case _ => false
    }
  }
}

