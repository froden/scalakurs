package scalakurs

import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.json4s.{DefaultFormats, Formats}

trait ScalakursbloggStack extends ScalatraFilter with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  notFound {
    status = 404
  }
}
