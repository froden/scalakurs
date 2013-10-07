package oppg4_pattern_matching_and_case_classes;

case class Person(name: String, age: Int) {
  def isOlderThan(that: Person): Boolean = {
    this.age > that.age
  }
}

object PatternMatchingAndCaseClasses {

  def computeSquareOfIntOrString(number: Any): Int = ???

  def checkIfParameterIsPersonOlaAtAge20(parameter: Any): Boolean = ???

  // Try to use pattern matching for lists
  // Hint: Use _* for arbitrary many elements i list
  def checkIfSecondElementIsAPersonAtAge30(persons: List[Person]): Boolean = ???
}

