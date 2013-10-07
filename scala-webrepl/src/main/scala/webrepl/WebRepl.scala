package webrepl

import java.io.File
import java.net.URL
import org.eclipse.jetty.server.session.SessionHandler
import unfiltered.jetty.Http

object WebRepl extends App{
  val resources: URL = new File("src/main/webapp").toURL
  println(resources)

  val http: Http = unfiltered.jetty.Http(1338)
  http.current.setSessionHandler(new SessionHandler)
  http.plan(ReplPlan).resources(resources).start()
}
