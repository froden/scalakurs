package webrepl


import tools.nsc._, interpreter._
import java.io._
import java.net.URLClassLoader
import util.ClassPath
import scala.Console


class WriterOutputStream(writer: Writer) extends OutputStream {
  private val buf = new Array[Byte](1)
  override def close() {
    writer.close()
  }
  override def flush() {
    writer.flush()
  }
  override def write(b: Array[Byte]) {
    writer.write(new String(b))
  }
  override def write(b: Array[Byte], off: Int, len: Int) {
    writer.write(new String(b, off, len))
  }
  def write(b: Int) {
    synchronized {
      buf(0) = b.toByte
      write(buf)
    }
  }
}

class ScalaConsole(val bucketFunc: () => StringWriter) {

  val settings = new Settings
  val loader = getClass.getClassLoader.asInstanceOf[URLClassLoader]
  val entries = loader.getURLs map (_.getPath)
  // annoyingly, the Scala library is not in our classpath, so we have to add it manually
  val sclpath = entries find (_.endsWith("scala-compiler.jar")) map (_.replaceAll("scala-compiler.jar", "scala-library.jar"))
  settings.classpath.value = ClassPath.join((entries ++ sclpath): _*)
  settings.Yreplsync.value = true

  val writer = {
    val w = new PrintWriter(
     new Writer {
      def write(cbuf: Array[Char], off: Int, len: Int) {
        bucketFunc().write(cbuf, off, len)
      }

      def flush() {}

      def close() {}
    })
    System.setOut(new PrintStream(new WriterOutputStream(w)))
    Console.setOut(new PrintStream(new WriterOutputStream(w)))
    w
  }

  var imain = new IMain(settings, writer)

  def execute(cmd: String): Results.Result = try {
    imain.interpret(cmd)
  } finally {
  }

  def reset() {
    imain.reset()
    imain.close()
    imain = new IMain(settings, new PrintWriter(writer))
  }

}