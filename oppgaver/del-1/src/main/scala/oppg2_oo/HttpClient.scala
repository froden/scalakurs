package oppg2_oo

import scala.collection.mutable.ListBuffer

object MyApp {

  class LoggingHttpClient extends BasicHttpClient with Logging

  /**
   * Hint: Define your own class that mix in the necessary functionality
   * Syntax: class MyClass extends Something with SomeTrait
   */
  lazy val loggingClient: HttpClient = new LoggingHttpClient

  /**
   * Hint: Alternatively you can use the following syntax to mix in functionality at construction time
   * new Something with SomeTrait
   */
  lazy val filteringLoggingClient: HttpClient = new BasicHttpClient with Logging with UrlFilter {
    val illegalUrlPattern: String = "illegal"
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

  /**
   * Hint: throw new IllegalArgumentException()
   * You can call the original overrided method using super.xxx()
   */
  abstract override def get(url: String): String =
    if (url.contains(illegalUrlPattern))
      throw new IllegalArgumentException("Illegal url")
    else
      super.get(url)

}

object Log {
  private val log = ListBuffer[String]()

  def info(str: String) = log += str

  def reset() = log.clear()

  override def toString = log.mkString("\n")
}
