package scalakurs

import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.json4s.jackson.Serialization._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.slf4j.LoggerFactory


class ArticlesControllerTest extends ScalatraFlatSpec with ShouldMatchers{

  val log = LoggerFactory.getLogger(getClass)

  implicit val jsonFormats = DefaultFormats

  addServlet(new ArticlesController, "/articles/*")

  val jsonContentType = "Content-Type" -> "application/json"

  "ArticlesController" should "have an echo path that responds to a echo json message" in {
    val message = Echo("Looking good!")

    post("/articles/echo", body = write(message).getBytes, headers = Map(jsonContentType)) {
      status must be(200)
      fromJson[Echo](body) must equal(message)
    }
  }

  def fromJson[T: Manifest](body: String) = parse(body).extract[T]
}
