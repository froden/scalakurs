package oppg4_try

import org.scalatest._
import oppg4_try.UrlParser._
import support.ScalakursSupport
import scala.util.{Try, Failure, Success}
import java.net.URL
import java.io.InputStream

class TryTest extends FunSuite with ShouldMatchers with ScalakursSupport {

  test("visit an alternative URL if the first one fails") {
    parseURL("oooops").getOrElse(new URL("http://www.vg.no")) should be(new URL("http://www.vg.no"))
  }

  test("get the URL´s protocol with map") {
    parseURL("http://www.ntnu.no").map(_.getProtocol) should be(Try("http"))
  }

  test("avoid making a Try train wreck using flatMap") {

    val inputStream = inputStreamForURL("http://www.ntnu.no")

    inputStream match {
      case Success(stream: InputStream) => stream.read() should be > 0
      case Failure(_) => fail("This test should be successful")
      case _ => ____
    }
  }

  test("filter out the correct protocol") {
    parseHttpUrl("http://www.ntnu.no") match {
      case Success(url) => url.getProtocol shouldEqual "http"
      case Failure(_) => ____
    }

    parseHttpUrl("ftp://www.ntnu.no") match {
      case Success(_) => ____
      case Failure(e) => e.getMessage shouldEqual "Predicate does not hold for ftp://www.ntnu.no"
    }
  }

  test("chaining Trys in a for comprehension") {
    getURLContent("http://www.ntnu.no") match {
      case Success(iterator) => iterator.size should be > 0
      case Failure(_) => ____
    }
  }
}
