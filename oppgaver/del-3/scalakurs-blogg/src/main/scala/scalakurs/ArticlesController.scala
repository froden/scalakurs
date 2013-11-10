package scalakurs

import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._
import org.json4s.mongo.JObjectParser
import org.json4s._
import org.scalatra.{Created, BadRequest}


class ArticlesController(articles: MongoCollection) extends ScalakursbloggStack {

  val log = LoggerFactory.getLogger(getClass)

  /**
   * ArticlesController is mounted under /articles so the root path here will be /articles/
   */
  get("/articles") {
    println("** /articles");
    articles.find().map(toArticle).toList
  }

  get("/articles/:id") {
    val query = MongoDBObject("_id" -> new ObjectId(params("id")))
    articles.findOne(query) map toArticle
  }

  post("/articles/:id/comments") {
    parsedBody.extractOpt[Comment].flatMap { comment =>
      val doc = jsToMongo(Extraction.decompose(comment))
      val query = MongoDBObject("_id" -> new ObjectId(params("id")))
      val update = $addToSet("comments" -> doc)
      articles.update(query, update)
      articles.findOne(query) map toArticle
    }
  }

  post("/articles") {
    parsedBody.extractOpt[Article].map { article =>
      val doc = jsToMongo(Extraction.decompose(article))
      articles.insert(doc)
      toArticle(doc)
    } match {
      case None => BadRequest
      case Some(article) => Created(article)
    }
  }

  post("/articles/echo") {
    val message = parsedBody.extract[Echo]
    log.info("Got message: " + message)
    message
  }

  def toArticle(obj: DBObject) = mongoToJs(obj).extract[Article]
  def jsToMongo(value: JValue): DBObject = JObjectParser.parse(value)
  def mongoToJs(obj: Any): JValue = JObjectParser.serialize(obj)
}
