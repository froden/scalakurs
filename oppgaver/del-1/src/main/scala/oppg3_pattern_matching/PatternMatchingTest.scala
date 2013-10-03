package oppg3_pattern_matching;

case class Person(name: String, age: Int)

object PatternMatching {

  def computeSquareOfIntOrString(number: Any): Int = {
    val n = number match {
      case i: Int => i
      case s: String => s.toInt
    }
    n * n
  }

  def checkIfParamIsPersonOlaAtAge20(param: Any): Boolean = {
    param match {
      case Person("Ola", 20) => true
      case _ => false
    }
  }

  // Try to use sequence pattern matching
  // Hint: Use _* for arbitrary many elements i sequence
  def checkIfSecondElementIsAPersonAtAge30(persons: Seq[Person]): Boolean = {
    persons match {
      case Seq(_, Person(_, age), _*)  => age == 30
      case _ => false
    }
  }

}

