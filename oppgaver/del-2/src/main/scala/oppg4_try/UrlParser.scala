package oppg4_try

import scala.util.{Failure, Try}
import java.net.URL
import java.io.InputStream

object UrlParser {

  def parseURL(url: String): Try[URL] = {
    Try(new URL(url))
  }

  def inputStreamForURL(url: String): Try[InputStream] = parseURL(url).flatMap { u =>
    Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
  }

  def parseHttpUrl(url: String): Try[URL] = {
    parseURL(url).filter(_.getProtocol == "http")
  }

  import scala.io.Source
  def getURLContent(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()

}
