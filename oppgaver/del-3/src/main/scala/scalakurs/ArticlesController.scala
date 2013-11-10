package scalakurs

import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._
import org.json4s.mongo.JObjectParser
import org.json4s._
import org.scalatra.{Ok, Created, BadRequest}


class ArticlesController(articles: MongoCollection) extends ScalakursbloggStack {

  val log = LoggerFactory.getLogger(getClass)

  /**
   * ArticlesController is mounted under /articles so the root path here will be /articles/
   */
  get("/articles") {
    articles.find().map(jsonToCaseClass[Article]).toList
  }

  post("/articles") {
    parsedBody.extractOpt[Article].map { article =>
      val doc = jsToMongo(caseClassToJson(article))
      articles.insert(doc)
      jsonToCaseClass[Article](doc)
    } match {
      case None => BadRequest
      case Some(article) => Created(article)
    }
  }

  get("/articles/:id") {
    val query = MongoDBObject("_id" -> new ObjectId(params("id")))
    articles.findOne(query) map jsonToCaseClass[Article]
  }

  post("/articles/:id") {
    parsedBody.extractOpt[Article].map { article =>
      val query = MongoDBObject("_id" -> new ObjectId(params("id")))
      val update = $set("author" -> article.author, "title" -> article.title, "content" -> article.content)
      articles.update(query, update)
      articles.findOne(query).map(jsonToCaseClass[Article])
    } match {
      case None => BadRequest
      case Some(article) => Ok(article)
    }
  }

  post("/articles/:id/comments") {
    parsedBody.extractOpt[Comment].flatMap { comment =>
      val doc = jsToMongo(Extraction.decompose(comment))
      val query = MongoDBObject("_id" -> new ObjectId(params("id")))
      val update = $addToSet("comments" -> doc)
      articles.update(query, update)
      articles.findOne(query) map jsonToCaseClass[Article]
    }
  }

  post("/articles/echo") {
    parsedBody.extractOpt[Echo].map { message =>
      log.info("Got message: " + message)
      val document = jsToMongo(caseClassToJson(message))
      articles.insert(document)
      jsonToCaseClass[Echo](document)
    } match {
      case None => BadRequest
      case Some(message) => Created(message)
    }
  }

  def jsonToCaseClass[T: Manifest](obj: DBObject): T = mongoToJs(obj).extract[T]
  def caseClassToJson(obj: Any): JValue = Extraction.decompose(obj)
  def jsToMongo(value: JValue): DBObject = JObjectParser.parse(value)
  def mongoToJs(obj: Any): JValue = JObjectParser.serialize(obj)
}
