package scalakurs

import org.scalatra.servlet.ScalatraListener
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.server.Server

object BlogMain {
  def main(args: Array[String]) {
    val port = sys.props.get("port").map(_.toInt).getOrElse(8080)

    val server = new Server(port)
    val context = new WebAppContext()

    context.setContextPath("/")
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new ScalatraListener)

    server.setHandler(context)

    server.start()
    server.join()
  }
}
