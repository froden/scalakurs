package oppg3_pattern_matching_and_case_classes

import org.scalatest.FunSuite

class PatternMatchingAndCaseClassesTest extends FunSuite {

  test ("should compute square of int or string") {
    assert(PatternMatchingAndCaseClasses.computeSquareOfIntOrString(4) === 16)
    assert(PatternMatchingAndCaseClasses.computeSquareOfIntOrString(6) === 36)
  }

  test ("person case class should have name and age attributes") {
    //fail("Replace me with the test below")
    val p = Person("Ola", 20)
    assert(p.name === "Ola" && p.age === 20)
  }

  test ("person case class should compare persons by age") {
    //    fail("Replace me with the test below")
    assert(Person("Hans", 30).isOlderThan(Person("Ola", 20)) === true)
    assert(Person("Hans", 20).isOlderThan(Person("Ola", 30)) === false)
  }

  test ("should check if parameter is person Ola at age 20") {
//    fail("Replace me with the test below")
    assert(PatternMatchingAndCaseClasses.checkIfParameterIsPersonOlaAtAge20(Person("Hans", 20)) === false)
    assert(PatternMatchingAndCaseClasses.checkIfParameterIsPersonOlaAtAge20("Ola") == false)
    assert(PatternMatchingAndCaseClasses.checkIfParameterIsPersonOlaAtAge20(Person("Ola", 20)) === true)
  }

  test ("should check if second person is Person at age 30") {
//    fail("Replace me with the test below")
    assert(PatternMatchingAndCaseClasses.checkIfSecondElementIsAPersonAtAge30(List(Person("Ola", 30), Person("Hans", 20), Person("Ola", 30), Person("Hans", 30))) === false)
    assert(PatternMatchingAndCaseClasses.checkIfSecondElementIsAPersonAtAge30(List(Person("Hans", 20), Person("Hans", 30), Person("Hans", 20), Person("Hans", 20))) === true)
  }
}

