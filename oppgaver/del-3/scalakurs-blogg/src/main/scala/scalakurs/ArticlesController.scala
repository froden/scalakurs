package scalakurs

import org.slf4j.LoggerFactory


class ArticlesController extends ScalakursbloggStack {

  val log = LoggerFactory.getLogger(getClass)

  /**
   * ArticlesController is mounted under /articles so the root path here will be /articles/
   */
  get("/") {

  }

  post("/echo") {
    val message = parsedBody.extract[Echo]
    log.info("Got message: " + message)
    message
  }
}
