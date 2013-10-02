package oppg2_oo

import scala.collection.mutable.ListBuffer

object MyApp {

  class LoggingClient extends BasicHttpClient with Logging

  /**
   * Hint: Definer en egen klasse med nødvendig funksjonalitet
   * Syntax: class MyClass extends Something with SomeTrait
   */
  val loggingClient: HttpClient = new LoggingClient

  /**
   * Hint: Alternativ til å lage en egen klasse er å bruke følgende syntax:
   * new Something with SomeTrait
   */
  val filteringLoggingClient: HttpClient = new BasicHttpClient with Logging with UrlFilter {
    val illegalUrlPattern = ".*illegal.*"
  }
}

abstract class HttpClient {
  def get(url: String): String
}

class BasicHttpClient extends HttpClient {
  def get(url: String) = "<html><body>The real thing</body></html>"
}

trait Logging extends HttpClient {
  abstract override def get(url: String) = {
    Log.info("Sending GET to " + url)
    val response = super.get(url)
    Log.info("Response was " + response)
    response
  }
}

trait UrlFilter extends HttpClient {
  val illegalUrlPattern: String

  //Oppg lag denne
  abstract override def get(url: String): String =
    if (url.matches(illegalUrlPattern))
      throw new IllegalArgumentException("Suspicious url " + url)
    else
      super.get(url)
}

object Log {
  private val log = ListBuffer[String]()

  def info(str: String) = log += str

  def reset() = log.clear()

  override def toString = log.mkString("\n")
}
