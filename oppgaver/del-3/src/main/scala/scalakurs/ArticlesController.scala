package scalakurs

import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._
import org.json4s.mongo.JObjectParser
import org.json4s._
import org.scalatra.{NotFound, Ok, Created, BadRequest}


class ArticlesController(articles: MongoCollection) extends ScalakursbloggStack {

  val log = LoggerFactory.getLogger(getClass)

  /**
   * ArticlesController is mounted under /articles so the root path here will be /articles/
   */
  get("/articles") {
    articles.find().map(mongoObjToCaseClass[Article]).toList
  }

  post("/articles") {
    parsedBody.extractOpt[Article].map { article =>
      val doc = caseClassToMongoObj(article)
      articles.insert(doc)
      mongoObjToCaseClass[Article](doc)
    } match {
      case None => BadRequest
      case Some(article) => Created(article)
    }
  }

  get("/articles/:id") {
    val query = MongoDBObject("_id" -> new ObjectId(params("id")))
    articles.findOne(query).map(mongoObjToCaseClass[Article]).fold(NotFound())(a => Ok(a))
  }

  put("/articles/:id") {
    parsedBody.extractOpt[Article].map { article =>
      val query = MongoDBObject("_id" -> new ObjectId(params("id")))
      val doc = caseClassToMongoObj(article)
      articles.update(query, doc)
      mongoObjToCaseClass[Article](doc)
    } match {
      case None => BadRequest
      case Some(article) => Ok(article)
    }
  }

  delete("/articles/:id") {
    val query = MongoDBObject("_id" -> new ObjectId(params("id")))
    articles.remove(query)
  }

  post("/articles/:id/comments") {
    parsedBody.extractOpt[Comment].flatMap { comment =>
      val doc = jsToMongo(Extraction.decompose(comment))
      val query = MongoDBObject("_id" -> new ObjectId(params("id")))
      val update = $addToSet("comments" -> doc)
      articles.update(query, update)
      articles.findOne(query) map mongoObjToCaseClass[Article]
    }
  }

  post("/articles/echo") {
    parsedBody.extractOpt[Echo].map { message =>
      log.info("Got message: " + message)
      val document = caseClassToMongoObj(message)
      articles.insert(document)
      mongoObjToCaseClass[Echo](document)
    } match {
      case None => BadRequest
      case Some(message) => Created(message)
    }
  }

  def mongoObjToCaseClass[T: Manifest](obj: DBObject): T = mongoToJs(obj).extract[T]
  def caseClassToMongoObj(obj: Any): DBObject = jsToMongo(Extraction.decompose(obj))
  def jsToMongo(value: JValue): DBObject = JObjectParser.parse(value)
  def mongoToJs(obj: Any): JValue = JObjectParser.serialize(obj)
}
