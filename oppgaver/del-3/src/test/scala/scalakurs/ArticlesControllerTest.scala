package scalakurs

import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.json4s.jackson.Serialization._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._

class ArticlesControllerTest extends ScalatraFlatSpec with ShouldMatchers{

  val log = LoggerFactory.getLogger(getClass)

  implicit val jsonFormats = DefaultFormats

  val mongoClient = MongoClient()
  val db = mongoClient("blog-test")
  val articles = db("articles")

  addFilter(new ArticlesController(articles), "/articles/*")

  val jsonContentType = "Content-Type" -> "application/json"

  "ArticlesController" should "have an echo path that stores and responds to an echo json message" in {
    val message = Echo("Looking good!")

    post("/articles/echo", body = write(message).getBytes, headers = Map(jsonContentType)) {
      status must be(201)
      fromJson[Echo](body) must equal(message)
    }
  }

  def fromJson[T: Manifest](body: String) = parse(body).extract[T]
}
