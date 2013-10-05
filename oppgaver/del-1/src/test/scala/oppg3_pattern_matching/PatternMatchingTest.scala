package oppg3_pattern_matching

import org.scalatest.FunSuite

class PatternMatchingTest extends FunSuite {

  test ("should compute square of int or string") {
    assert(PatternMatching.computeSquareOfIntOrString(4) == 16)
    assert(PatternMatching.computeSquareOfIntOrString(6) == 36)
  }

  test ("person case class should have name and age attributes") {
    //fail("Replace me with the test below")
    val p = Person("Ola", 20)
    assert(p.name === "Ola" && p.age === 20)
  }

  test ("should check if parameter is person Ola at age 20") {
//    fail("Replace me with the test below")
    assert(PatternMatching.checkIfParamIsPersonOlaAtAge20(new Person("Hans", 20)) === false)
    assert(PatternMatching.checkIfParamIsPersonOlaAtAge20("Ola") == false)
    assert(PatternMatching.checkIfParamIsPersonOlaAtAge20(new Person("Ola", 20)) === true)
  }

  test ("should check if second person is Person at age 30") {
//    fail("Replace me with the test below")
    assert(PatternMatching.checkIfSecondElementIsAPersonAtAge30(Seq(new Person("Ola", 30), new Person("Hans", 20), new Person("Ola", 30), new Person("Hans", 30))) === false)
    assert(PatternMatching.checkIfSecondElementIsAPersonAtAge30(Seq(new Person("Hans", 20), new Person("Hans", 30), new Person("Hans", 20), new Person("Hans", 20))) === true)
  }
}

