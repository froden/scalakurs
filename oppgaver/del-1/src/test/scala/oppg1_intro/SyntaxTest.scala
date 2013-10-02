package oppg1_intro

import org.scalatest._

class SyntaxTest extends FunSuite {

  test ("SyntaxIntro should have a value called fixed") {
    fail("Replace me with the test below")
//    assert(SyntaxIntro.fixed === 100)
  }

  test ("SyntaxIntro should have a variable called reAssignable") {
    assert(SyntaxIntro.reAssignable === "Change me!")
  }

  test ("SyntaxIntro should have a new value assigned to reAssignable") {
    assert(SyntaxIntro.reAssignable === "I feel changed!")
  }

  test ("SyntaxIntro should have a method we could call") {
    fail("Replace me with the test below")
//    assert(SyntaxIntro.callMe === "Hello!")
  }

  test ("SyntaxIntro should have a method with a wrong return type that we should fix") {
    assert(SyntaxIntro.theMeaningOfLife === 42)
  }

  test ("SyntaxIntro should have a method for adding two numbers together") {
    assert(SyntaxIntro.add() === 7)
  }

  test ("SyntaxIntro should have a method for choosing the right language") {
    assert(SyntaxIntro.rightLanguage("Scala") === "YES")
    assert(SyntaxIntro.rightLanguage("Java") === "NO")
  }

  test ("SyntaxIntro should count to ten") {
    SyntaxIntro.countToTen()
    assert(SyntaxIntro.nr === 10)
  }

}
