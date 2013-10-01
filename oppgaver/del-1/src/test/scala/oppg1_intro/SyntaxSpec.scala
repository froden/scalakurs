package oppg1_intro

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class SyntaxSpec extends FlatSpec with ShouldMatchers {

  "Syntaks" should "have a value called fixed" in {
    assert(Syntax.fixed === 42)
  }

  it should "have a variable called reAssignable" in {
    assert(Syntax.reAssignable === "Change me!")
  }

  it should "have a new value assigned to reAssignable" in {
    Syntax.reAssignable = "I feel changed!"
    assert(Syntax.reAssignable === "I feel changed!")
  }

  it should "have a method we could call" in {
    assert(Syntax.callMe === "Hello!")
  }


}
