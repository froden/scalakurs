package oppg4_try

import org.scalatest._
import oppg4_try.UrlParser._
import support.ScalakursSupport
import scala.util.{Try, Failure, Success}
import java.net.{MalformedURLException, URL}
import org.scalatest.matchers.Matcher
import java.io.InputStream

class TryTest extends FunSuite with ShouldMatchers with ScalakursSupport {

  def beSuccess[T](t: T) = {
    be(new Success(t))
  }

  def beFailure(t: Throwable) = {
    hasSameExceptionMessage(new Failure[URL](t))
  }

  /**
   * Complete these tests by replacing __ and _t_ with actual values
   */
  test("parse an URL") {
    parseURL("http://www.ntnu.no") should beSuccess(__)
    parseURL("oooops") should beFailure(_t_)
  }

  /** replace the *** in this test with the correct alternative URL */
  test("visit an alternative URL if the first one fails") {
    parseURL("oooops").getOrElse(***) should be(__)
  }

  /** replace x=>x inside map() with the correct function and replace __ with the string in the comment */
  test("get the URL´s protocol with map") {
    parseURL("http://www.ntnu.no").map(x=>x) should beSuccess(/**"http"*/ __)
  }

  /** You have to rewrite inputStreamForURL() using flatMap to avoid the stacking up of Trys*/
  test("avoid making a Try train wreck using flatMap") {
    val inputStream = inputStreamForURL("http://www.ntnu.no")
    inputStream match {
      case Success(stream: InputStream) => stream.read() should be > 0
      case Failure(_) => fail("This test should be successful")
      case _ => __
    }
  }

  /** parseHttpUrl needs to be smarter so it failes if the protocol is something other than http */
  test("filter out the correct protocol") {
    parseHttpUrl("http://www.ntnu.no") match {
      case Success(url) => url.getProtocol should be === "http"
      case Failure(_) => __
    }

    parseHttpUrl("ftp://www.ntnu.no") match {
      case Success(_) => __
      case Failure(e) => e.getMessage should be === "Predicate does not hold for ftp://www.ntnu.no"
    }
  }

  test("chaining Try´s in a for comprehension") {

  }
}
