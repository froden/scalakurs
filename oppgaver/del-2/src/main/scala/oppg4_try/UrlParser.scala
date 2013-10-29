package oppg4_try

import scala.util.{Failure, Try}
import java.net.URL
import java.io.InputStream

object UrlParser {

  def parseURL(url: String): Try[URL] = {
    Try(new URL(url))
  }

  /** this method needs to have Try[InputStream] as return type. Hint: flatMap can help us with that */
  def inputStreamForURL(url: String): Try[Try[Try[InputStream]]] = parseURL(url).map { u =>
    Try(u.openConnection()).map(conn => Try(conn.getInputStream))
  }

  /** this method should be returing an error if the protocol of the URL is something other than http
    * HINT: read the name of the test testing this method */
  def parseHttpUrl(url: String): Try[URL] = {
    parseURL(url)
  }

  import scala.io.Source
  def getURLContent(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- new Failure(new Throwable) /** this Failure needs to be replaced by a Try(_something_) */
      source = Source.fromInputStream(is)
    } yield source.getLines()

}
