import scala.io.Source
import scala.util.{Success, Failure, Try}

object TryEx extends App {

  case class Kunde(alder: Int)
  class Sigaretter
  case class ForUngException(melding: String) extends Exception(melding)

  def kjøpSigg(kunde: Kunde): Sigaretter =
    if (kunde.alder < 18)
      throw ForUngException(s"Kunden må være over 18, men er ${kunde.alder}")
    else new Sigaretter

  val ungKunde = Kunde(15)
  val melding = Try(kjøpSigg(ungKunde)) match {
    case Success(røyken) => s"Her har du $røyken din!"
    case Failure(e) => e.getMessage
  }
  println(melding)
}

object TryEx2 extends App {
  case class Kunde(alder: Int)
  trait Produkt
  class Sigaretter extends Produkt
  class Tyggis extends Produkt
  case class ForUngException(melding: String) extends Exception(melding)

def kjøpSigg(kunde: Kunde): Try[Produkt] =
  if (kunde.alder < 18)
    Failure(ForUngException(s"Kunden må være over 18, men er ${kunde.alder}"))
  else
    Success(new Sigaretter)

val ungKunde = Kunde(15)
val produkt = kjøpSigg(ungKunde) recover {
  case fue: ForUngException => new Tyggis
}
println(s"Hurra jeg fikk kjøpt ${produkt.get}")

}

object TryEx3 extends App {
val keyValues = for {
  keys <- Try(Source.fromFile("keys.txt").getLines())
  values <- Try(Source.fromFile("values.txt").getLines())
} yield keys zip values toMap

val result: Map[String, String] = keyValues.getOrElse(Map())
}
