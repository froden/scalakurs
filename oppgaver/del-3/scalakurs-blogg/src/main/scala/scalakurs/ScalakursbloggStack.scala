package scalakurs

import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.json4s.{DefaultFormats, Formats}

trait ScalakursbloggStack extends ScalatraServlet with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  notFound {
    contentType = null
    NotFound
  }
}
