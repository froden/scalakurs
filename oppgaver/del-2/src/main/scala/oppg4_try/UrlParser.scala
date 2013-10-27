package oppg4_try

import scala.util.Try
import java.net.URL
import java.io.InputStream

object UrlParser {

  def parseURL(url: String): Try[URL] = {
    Try(new URL(url))
  }

  def inputStreamForURL(url: String): Try[Try[Try[InputStream]]] = parseURL(url).map { u =>
    Try(u.openConnection()).map(conn => Try(conn.getInputStream))
  }

}
