package webrepl

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._
import org.apache.commons.lang3.StringEscapeUtils
import unfiltered.response.Html5
import scala.Some
import java.io.{PrintStream, StringWriter}
import javax.servlet.http.HttpSession

object ReplPlan extends Plan {

  def intent = {
    case GET(Path(Seg(Nil))) => Ok ~> Html5(Pages.page)
    case req@POST(Path(Seg(Nil))) & Params(p) => {
      val session: HttpSession = req.underlying.getSession(true)
      val cmd = p("cmd").mkString(" ")

      var result = "<div class=\"input\">" + escapeHtml(cmd) + "</div>"
      val console = getConsole(session)
      import scala.tools.nsc._
      console.execute(cmd) match {
        case interpreter.Results.Incomplete =>
          result += "<div class=\"error\">ERROR " +
            escapeHtml(getBucket(session).toString) +
            "</div>"
          dropBucket(session)
        case interpreter.Results.Error =>
          result += "<div class=\"error\">ERROR " +
            escapeHtml(getBucket(session).toString) +
            "</div>"
          dropBucket(session)
        case interpreter.Results.Success =>
          result += "<div class=\"success\">" +
            escapeHtml(getBucket(session).toString) +
            "</div>"
          dropBucket(session)
      }
      Ok ~> HtmlContent ~> ResponseString(result)
    }
  }

  def escapeHtml(text: String) = StringEscapeUtils.escapeHtml4(text).replaceAll("\'", "&#x27;")

  def getConsole(session: HttpSession): ScalaConsole = Option(session.getAttribute("scala.console")) match {
    case Some(c: ScalaConsole) => c
    case _ =>
      val c = new ScalaConsole(() => getBucket(session))
      session.setAttribute("scala.console", c)
      c
  }

  def getBucket(session: HttpSession): StringWriter = Option(session.getAttribute("scala.console.bucket")) match {
    case Some(w: StringWriter) => {
      w
    }
    case _ =>
      val w = new StringWriter
      session.setAttribute("scala.console.bucket", w)
      w
  }

  def dropBucket(session: HttpSession) {
    session.removeAttribute("scala.console.bucket")
  }
}

object Pages {
  def page =
    <html>
      <head>
        <meta charset="utf-8"/>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css"/>
        <link rel="shortcut icon" href="/img/favicon.gif" type="image/x-icon"/>
        <script type="text/javascript"
                src="http://cdn.savant.pro/js/jquery.js">
        </script>
        <script type="text/javascript" src="http://cdn.savant.pro/js/ea.ui.js">
        </script>
        <script type="text/javascript">
          {"""
              $(function(){
                eaui.init();
              });
           """}
        </script>
        <title>WebRepl</title>
      </head>
      <body>
        <div id="outer">
          <a id="header" href="/"></a>
          <div id="content">
            <div class="section-tabs toggler">
              <a href="javascript:;"
                 data-for="#repl-expression"
                 data-set-focus="#cmd-e">
                <span>Expression</span>
              </a>
              <a href="javascript:;"
                 data-for="#repl-block"
                 data-set-focus="#cmd-b">
                <span>Block</span>
              </a>
            </div>
            <div id="repl-output"
                 class="section-body">
              <div class="prompt">Welcome to Scala console! Type Scala code below to have it evaluated.</div>
            </div>
            <form id="repl-input"
                  action="/"
                  method="post"
                  class="submission">
              <div id="repl-expression" class="field">
                <div class="input">
                  <input id="cmd-e"
                         type="text"
                         name="cmd"
                         class="focus"/>
                </div>
                <a href="javascript:;" class="icon submit" title="Evaluate">
                  <img class="glyph" src="http://cdn.savant.pro/img/glyph/32/play.png"/>
                </a>
              </div>
              <div id="repl-block" class="field-area hidden">
                <textarea id="cmd-b"
                          rows="8"
                          name="cmd"></textarea>
              </div>
            </form>
            <script type="text/javascript" src="webrepl.js">
            </script>
          </div>
        </div>
      </body>
    </html>
}
