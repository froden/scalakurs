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
    articles.find().flatMap(m => mongoToJs(m).extractOpt[Article]).toList
  }

  post("/articles") {
    parsedBody.extractOpt[Article].map { article =>
      articles.insert(jsToMongo(Extraction.decompose(article)))
      article
    } match {
      case None => BadRequest
      case Some(article) => Created(article)
    }

  }

  post("/echo") {
    val message = parsedBody.extract[Echo]
    log.info("Got message: " + message)
    message
  }

  def toArticle(obj: DBObject) = mongoToJs(obj).extractOpt[Article]
  def jsToMongo(value: JValue): DBObject = JObjectParser.parse(value)
  def mongoToJs(obj: Any): JValue = JObjectParser.serialize(obj)
}
