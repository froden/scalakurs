object ForComp extends App {
  def even(start: Int, end: Int) =
    for (i <- start until end if i % 2 == 0) yield i

  println(even(0, 20))
}

object ForComp2 {

  val firstName: Option[String] = Some("Frode")
  val lastName: Option[String] = Some("Nerbråten")

  val fullName = firstName.flatMap(first => lastName.map(last => first + " " + last))

  val fullName2 = for {
    first <- firstName
    last <- lastName
  } yield first + " " + last

}
