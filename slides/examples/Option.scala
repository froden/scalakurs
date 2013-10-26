object Options {

  val something: Option[String] = Some("A string")
  val nothing: Option[String] = None

  something.isEmpty
  //res4: Boolean = false
  nothing.isEmpty
  //res5: Boolean = true

  something.getOrElse("")
  //res6: String = A string
  nothing.getOrElse("")
  //res7: String = ""

  something.get
  //res6: String = A string
  nothing.get
  //java.util.NoSuchElementException: None.get
}

object Options2 {

  object request {
    def getParameter(key: String) = ""
  }

  val name: String = request.getParameter("name")

  val upperCaseName = if (name != null) {
    val trimmed = name.trim
    if (!trimmed.isEmpty) {
      trimmed.toUpperCase
    } else {
      null
    }
  } else {
    null
  }
}

object Options3 {

  object request {
    def getParameter(key: String): Option[String] = Some("")
  }

  val name: Option[String] = request.getParameter("name")

  val upperCaseName = name map (_.trim) filter (!_.isEmpty) map (_.toUpperCase)

}

object Options4 {
  val myOptional: Option[String] = Some("Hello")

  myOptional.foreach(println)
  // Hello
  myOptional.exists(_.startsWith("H"))
  //res0: Boolean = true
  myOptional.isEmpty
  //res1: Boolean = false
  myOptional.map(_.toLowerCase)
  //res2: Option[String] = Some(hello)
  myOptional.flatMap(s => Some(s + " Frode"))
  //res3: Option[String] = Some(Hello Frode)
  myOptional.getOrElse("!!")
  //res4: String = Hello
}

object Options5 {
  val myOptional: Option[String] = None

  myOptional.foreach(println)
  // println is never invoked
  myOptional.exists(_.startsWith("H"))
  //res0: Boolean = false
  myOptional.isEmpty
  //res1: Boolean = true
  myOptional.map(_.toLowerCase)
  //res2: Option[String] = None
  myOptional.flatMap(s => Some(s + " Frode"))
  //res3: Option[String] = None
  myOptional.getOrElse("!!")
  //res4: String = !!
}

object Options6 {

  case class Person(name: String)

  val optionalPerson: Option[Person] = Some(Person("Frode"))

  optionalPerson match {
    case Some(Person("Frode")) => println("Fant Frode")
    case Some(_) => println("Fant noen andre")
    case None => println("Ikke en person")
  }
}

object Options7 {

  case class Person(name: String)

val firstName: Option[String] = Some("Arild")
val lastName: Option[String] = Some("Nilsen")

val fullName = for {
  first <- firstName
  last <- lastName
} yield first + " " last
}
