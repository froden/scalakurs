package oppg2_oo

import org.scalatest.FunSuite

class HttpClientTest extends FunSuite {

  test("A logging http client should log every request and response") {
    pending //TODO: remove
    Log.reset()
    val res = MyApp.loggingClient.get("www.bekk.no")
    assert(res === "<html><body>The real thing</body></html>")
    assert(Log.toString === """Sending GET to www.bekk.no
                     |Response was <html><body>The real thing</body></html>""".stripMargin)
  }

  test("A filteringLoggingClient should not execute request and not log anything when url is illegal") {
    pending //TODO: remove
    Log.reset()
    intercept[IllegalArgumentException] {
      MyApp.filteringLoggingClient.get("www.illegal.com")
    }
    assert(Log.toString === "")
  }

  test("A filteringLoggingClient should log when url is legal") {
    pending //TODO: remove
    Log.reset()
    val res = MyApp.filteringLoggingClient.get("www.legal.com")
    assert(res === "<html><body>The real thing</body></html>")
    assert(Log.toString === """Sending GET to www.legal.com
                              |Response was <html><body>The real thing</body></html>""".stripMargin)
  }
}
