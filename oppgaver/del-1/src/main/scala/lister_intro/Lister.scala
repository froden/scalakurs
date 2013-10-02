package lister_intro

/**
 * Oversikt over scala immutable list api:
 * http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List
 */
class Lister {

  /**
   * Skal snu en liste : List(1,2,3) -> List(3,2,1)
   */
  def reverser (minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal beholde kun unike, distinkte elementer i en liste :
   * List(1,1,1,1,1,1,1,2) -> List(1,2)
   */
  def fjernDuplikater (minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere det første elementet i en liste (ikke som en liste) :
   * List(1,2,3) -> 1
   */
  def finneForsteElement(minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere det siste elementet i en liste (ikke som en liste)
   * List(1,2,3) -> 3
   */
  def finneSisteElement(minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere de to første elementene i en liste som en liste
   * List(1,2,3) -> List(1,2)
   */
  def finnToForsteElementer(minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere det gjenværende av en liste som mister alle elementer foruten sitt første element
   * List(1,2,3) -> List(2,3)
   */
  def finnBortsettFraForsteElement(minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere det gjenværende av en liste som mister alle elementer foruten sine to første elementer :
   * List(1,2,3) -> List(3)
   */
  def finnBortsettFraToForsteElementer(minListe: List[Any]) =
    minListe //TODO

  /**
   * Skal returnere en subliste av en Int-liste, hvor kun partallene er med :
   * List(1,2,3,4) -> List(2,4)
   */
  def finnPartall(minListe: List[Int]) =
    minListe //TODO

  /**
   * Sett at en liste med Ints sendes inn som en liste, skal denne listen anses som en liste med sidelengder.
   * Returverdien skal gi en liste med volumer, spent ut av disse sidene
   * Eks : List(1,2,3) -> List(1,8,27)
   * Hvert kubevolum beregnes ut fra denne ene verdien i listen
   * Sidene kommer inn som en liste av Ints. Resultatet skal også returneres som en liste av Ints.
   */
  def kalkulerKubene(minListe: List[Int]) =
    minListe //TODO

  /**
   * Gitt et vilkårlig predikat i formen av en funksjon fra Int til boolean, og en liste av Ints, skal en ny liste av Ints returneres.
   * Den returnerte listen skal inneholdet det subsettet av elementer hvis predikat er sant :
   * eks List(1,2,3,4,5), (_ < 3) -> List(1,2)
   */
  def finnSublisteFraPredikat(minListe: List[Int], predikat: Int => Boolean) =
    minListe //TODO

  /**
   * Tvinner to like lange lister til en liste av tupler
   * Eks : List(1,2,3), List(a,b,c) -> List((1,a),(b,2),(3,c))
   * Eks : List(a,b,c), List(1,2,3) -> List((a,1),(2,b),(c,3))
   */
  def tvinneToLister(minListe1: List[Any], minListe2: List[Any]): List[(Any, Any)] = {
    List((1,1)) //TODO
  }

  /**
   * Plukker fra venstre og høyre side av listen til listen er tom, returnerer de plukkede elementene i en liste
   * Eks: List(1,2,3,4,5) -> List(1,5,2,4,3)
   */
  def plukkeFraKanteneAvListen[A](minListe: List[A]): List[A] = {
    minListe //TODO
  }

  /**
   * Summerer en liste med Ints og returnerer sum som en Int
   * Eks: List(1,2,3) -> 6
   */
  def summereAlleIntsIEnListe(minListe: List[Int]) =
    1 //TODO

  /**
   * Tar inn en sortert liste. Returnerer en liste med tupler, hvor første element i hvert tuppel er antall elementer av hver distinkte hverdi
   * Eks: List("a", "b") -> List((1,"a"),(1,"b"))
   * Eks: List("a", "a", "a") -> List((3,"a"))
   * Eks: List("a", "b", "b") -> List((1,"a"),(2,"b"))
   *
   * Hint: Sjekk ut funksjonen 'Span' (som er en kombinasjon av takeWhile og dropWhile),
   * konkatenering av et element til en liste med :: samt mellomlagring i et tuppel
   */
  def encodeSekvensLengdeIEnSortertListe(minListe: List[Any]) : List[(Int, Any)] =
    List((1,1))//TODO

}