package oppg3_option

import org.scalatest._
import support.ScalakursSupport
import oppg3_option.Options.Person

class OptionsTest extends FunSuite with ShouldMatchers with ScalakursSupport {

  /*
   * Complete this test by replacing all __ with actual implementation
   */
  test("Options can be either Some(value) or None") {
    val someValue = Some("A string")
    someValue.get should be(__)

    val noValue1 = None
    noValue1 should be(None)

    val noValue2 = Option(null)
    noValue2 should be(__)
  }

  /*
   * Complete the test by replacing ___ with implementation
   */
  test("You can get the value from Some but not from None") {
    pending //remove this line to unignore test
    val noValue = None

    //replace ___ with the expected exception type
    intercept[___] {
      noValue.get
    }
  }

  /*
   * Complete this test by replacing all __ with actual values
   */
  test("Option can also be used with pattern matching") {
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    value should be(__)

    val noValue: Option[Double] = None
    val value1 = noValue match {
      case Some(v) => v
      case None => 0.0
    }
    value1 should be(__)
  }

  /*
   * Complete the implementation of Options.getGender()
   */
  test("getGender should return a person's gender or a default value") {
    assert(Options.getGender(Person("Frode", Some("male"))) === "male")
    assert(Options.getGender(Person("Sjur", None)) === "not specified")
  }

  /*
   * Complete this test by replacing all ___ with actual values
   */
  test("Option is more than just a replacement of null, its also a collection") {
    Some(10) map (_ + 10) should be(__)
    Some(10) filter (_ == 20) should be(__)
    Some(Some(10)) flatMap (_ map (_ + 5)) should be(__)

    var newValue1 = 0
    Some(20) foreach (newValue1 = _)
    newValue1 should be(__)

    var newValue2 = 0
    None foreach (newValue2 = _)
    newValue2 should be(__)
  }

  /*
   * Complete this test by replacing all __ with actual values
   */
  test("Option can be mixed with other collection types") {
    //casting null to Int
    val intNull = null.asInstanceOf[Int]
    //List containing null
    val withNulls = List(intNull, 1, 2, intNull, 3, intNull)
    //filter all nullvalues
    val withoutNulls = withNulls.map(n => Option(n)).flatten

    withoutNulls should be(__)
  }

  /*
   * Complete the implementation of Options.warmest()
   */
  test("warmest should indicate the place with the highest temperature") {
    pending //remove
    Options.warmest("Oslo", "Trondheim") should be(Some("Oslo"))
    Options.warmest("Trondheim", "Tromsø") should be(Some("Trondheim"))
    Options.warmest("Trondheim", "Bergen") should be(None)
  }

  /*
   * Complete the implemetation of Options.warmest2()
   */
  test("warmest2 should indicate the warmest location given a list of locations") {
    pending //remove
    Options.warmest2(List("Trondheim", "Oslo", "Tromsø")) should be(Some("Oslo"))
    Options.warmest2(List("Trondheim", "Tromsø")) should be(Some("Trondheim"))
    Options.warmest2(List("Tromsø", "Bergen", "Harstad")) should be(Some("Tromsø"))
    Options.warmest2(List("Kristiansand", "Bergen", "Harstad")) should be(None)
  }

  /*
   * Complete this test by replacing all __ with actual values
   */
  test("Using in for comprehension") {
    val values = List(Some(10), Some(20), None, Some(15))
    val newValues = for {
      someValue <- values
      value <- someValue
    } yield value
    newValues should be(List(__, __, __))
  }
}
