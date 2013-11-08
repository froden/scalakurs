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

  addServlet(new ArticlesController(articles), "/*")

  val jsonContentType = "Content-Type" -> "application/json"

  "ArticlesController" should "have an echo path that responds to a echo json message" in {
    val message = Echo("Looking good!")

    post("/echo", body = write(message).getBytes, headers = Map(jsonContentType)) {
      status must be(200)
      fromJson[Echo](body) must equal(message)
    }
  }

  it should "store a new article" in {
    articles.drop()
    val article = Article("Cool article")

    post("/articles", body = write(article).getBytes, headers = Map(jsonContentType)) {
      status must be(201)
      fromJson[Article](body) must equal(Article("Cool article"))
    }
  }

  it should "list all articles" in {
    articles.drop()
    val article = Article("Cool article")

    post("/articles", body = write(article).getBytes, headers = Map(jsonContentType)) {
      status must be(201)
      fromJson[Article](body) must equal(Article("Cool article"))
    }

    get("/articles") {
      status must be(200)
      fromJson[List[Article]](body) must equal(List(Article("Cool article")))
    }
  }

  def fromJson[T: Manifest](body: String) = parse(body).extract[T]
}
