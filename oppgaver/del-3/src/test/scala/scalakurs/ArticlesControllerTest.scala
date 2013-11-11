package scalakurs

import org.scalatra.test.scalatest.ScalatraFlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.json4s.jackson.Serialization._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._
import scala.collection.immutable.Nil

class ArticlesControllerTest extends ScalatraFlatSpec with ShouldMatchers{

  val log = LoggerFactory.getLogger(getClass)

  implicit val jsonFormats = DefaultFormats

  val mongoClient = MongoClient()
  val db = mongoClient("blog-test")
  val articles = db("articles")

  addFilter(new ArticlesController(articles), "/articles/*")

  val jsonContentType = "Content-Type" -> "application/json"

  val newArticle = Article(None, "Frode", "Cool article", "Hei på deg")

  "ArticlesController" should "have an echo path that stores and responds to an echo json message" in {
    val message = Echo("Looking good!")

    post("/articles/echo", body = write(message).getBytes, headers = Map(jsonContentType)) {
      status must be(201)
      fromJson[Echo](body) must equal(message)
    }
  }

  it should "store a new article" in {
    articles.drop()
    createArticle(newArticle)
  }

  it should "list all articles" in {
    articles.drop()
    createArticle(newArticle)

    get("/articles") {
      status must be(200)
      fromJson[List[Article]](body).map(_.copy(_id = None)) must equal(List(newArticle))
    }
  }

  it should "get a single article" in {
    articles.drop()
    val created = createArticle(newArticle)

    get("/articles/" + created._id.get) {
      status must be(200)
      fromJson[Article](body) must equal(created)
    }
  }

  it should "update a single article" in {
    articles.drop()
    val created = createArticle(newArticle)

    val changed = created.copy(author = "new author", content = "new content")
    put("/articles/" + created._id.get, body = write(changed).getBytes, headers = Map(jsonContentType)) {
      status must be(200)
      fromJson[Article](body) must equal(changed)
    }
  }

  it should "delete a single article" in {
    articles.drop()
    val created = createArticle(newArticle)

    delete("/articles/" + created._id.get) {
      status must be(200)
    }

    get("/articles/" + created._id.get) {
      status must be(404)
    }
  }

  it should "comment on an article" in {
    articles.drop()
    val created = createArticle(newArticle)

    val comment = Comment("frode", "my comment")
    createComment(created, comment)
  }

  it should "delete all comments on an article" in {
    articles.drop()
    val created = createArticle(newArticle)

    val comment = Comment("frode", "my comment")
    createComment(created, comment)

    delete("/articles/" + created._id.get + "/comments") {
      status must be(200)
      fromJson[Article](body).comments must be(Nil)
    }
  }

  def createComment(created: Article, comment: Comment) {
    post("/articles/" + created._id.get + "/comments", body = write(comment).getBytes, headers = Map(jsonContentType)) {
      status must be(200)
      fromJson[Article](body) must equal(created.copy(comments = List(comment)))
    }
  }

  def createArticle(article: Article) =
    post("/articles", body = write(article).getBytes, headers = Map(jsonContentType)) {
      status must be(201)
      val created = fromJson[Article](body)
      created.copy(_id = None) must equal(article)
      created
    }

  def fromJson[T: Manifest](body: String) = parse(body).extract[T]
}
