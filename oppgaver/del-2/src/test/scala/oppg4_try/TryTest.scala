package oppg4_try

import org.scalatest._
import oppg4_try.UrlParser._
import support.ScalakursSupport
import scala.util.{Failure, Success}
import java.net.URL
import java.io.InputStream

class TryTest extends FunSuite with ShouldMatchers with ScalakursSupport {

  /* Complete these tests by replacing ____ with Try(_something_) */
  test("parse an URL") {
    parseURL("http://www.ntnu.no") should be(____)
    parseURL("oooops") should be(____)
  }

  /** replace the ____ in this test with the correct alternative URL */
  test("visit an alternative URL if the first one fails") {
    parseURL("oooops").getOrElse(____) should be(new URL("www.vg.no"))
  }

  /** replace ____ inside map() with the correct function */
  test("get the URL´s protocol with map") {
    parseURL("http://www.ntnu.no").map(____) should beSuccess("http")
  }

  /** You have to rewrite inputStreamForURL() using flatMap to avoid the stacking up of Trys */
  test("avoid making a Try train wreck using flatMap") {

    val inputStream = inputStreamForURL("http://www.ntnu.no")
                      //    ⬆︎
                      // Change this method

    inputStream match {
      case Success(stream: InputStream) => stream.read() should be > 0
      case Failure(_) => fail("This test should be successful")
      case _ => ____
    }
  }

  /** parseHttpUrl needs to be smarter so it failes if the protocol is something other than http */
  test("filter out the correct protocol") {
    // Change this method
    //   ⬇︎
    parseHttpUrl("http://www.ntnu.no") match {
      case Success(url) => url.getProtocol shouldEqual "http"
      case Failure(_) => ____
    }

    parseHttpUrl("ftp://www.ntnu.no") match {
      case Success(_) => ____
      case Failure(e) => e.getMessage shouldEqual "Predicate does not hold for ftp://www.ntnu.no"
    }
  }

  /** getURLContent needs some rewriting to successfully return a Try[Iterator[String]] */
  test("chaining Trys in a for comprehension") {
    // Change this method
    //   ⬇︎
    getURLContent("http://www.ntnu.no") match {
      case Success(iterator) => iterator.size should be > 0
      case Failure(_) => ____
    }
  }



  def beSuccess[T](t: T) = {
    be(new Success(t))
  }

  def beFailure(t: Throwable) = {
    hasSameExceptionMessage(new Failure[URL](t))
  }
}
