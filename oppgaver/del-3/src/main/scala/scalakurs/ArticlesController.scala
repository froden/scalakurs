package scalakurs

import org.slf4j.LoggerFactory
import com.mongodb.casbah.Imports._
import org.json4s.mongo.JObjectParser
import org.json4s._
import org.scalatra.{NotFound, Ok, Created, BadRequest}


class ArticlesController(articles: MongoCollection) extends ScalakursbloggStack {

  val log = LoggerFactory.getLogger(getClass)

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
