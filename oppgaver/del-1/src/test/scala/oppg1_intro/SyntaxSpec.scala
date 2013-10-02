package oppg1_intro

import org.scalatest._

class SyntaxSpec extends FunSuite {

  test ("SyntaxIntro should have a value called fixed") {
    assert(SyntaxIntro.fixed === 42)
  }

  test ("SyntaxIntro should have a variable called reAssignable") {
    assert(SyntaxIntro.reAssignable === "Change me!")
  }

  test ("SyntaxIntro should have a new value assigned to reAssignable") {
    SyntaxIntro.reAssignable = "I feel changed!"
    assert(SyntaxIntro.reAssignable === "I feel changed!")
  }

  test ("SyntaxIntro should have a method we could call") {
    assert(SyntaxIntro.callMe === "Hello!")
  }


}
