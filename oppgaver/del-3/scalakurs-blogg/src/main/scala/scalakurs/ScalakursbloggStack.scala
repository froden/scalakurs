package scalakurs

import org.scalatra._

trait ScalakursbloggStack extends ScalatraServlet {

  notFound {
    contentType = null
    NotFound
  }
}
