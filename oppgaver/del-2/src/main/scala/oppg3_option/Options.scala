package oppg3_option

object Options {

  /**
   * No need to edit this class.
   */
  case class Person(name: String, gender: Option[String])

  /**
   * You can get a value out of an option if you supply a default value.
   * In the Person class above, gender i optional.
   * This method should take person and return its gender or the string "not specified"
   * if it's a None
   */
  def getGender(person: Person): String = person.gender.getOrElse("not specified")

  /**
   * Compare the temp from two locations using the predefined getTemp method below.
   * The warmest place is only defined when the temp from both locations are known.
   */
  def warmest(location1: String, location2: String): Option[String] =
    for {
      temp1 <- getTemp(location1)
      temp2 <- getTemp(location2)
    } yield if (temp1 < temp2) location2 else location1


  /**
   * Find the warmest location given a list of locations by calling the predefined getTemp method below.
   * The result should be defined if at least one of the locations return a temperature.
   */
  def warmest2(locations: List[String]): Option[String] = {
    val temps = for {
      loc <- locations
      temp <- getTemp(loc)
    } yield (temp, loc)
    val sorted = temps.sortBy(_._1).reverse
    sorted.headOption.map(_._2)
  }

  /**
   * Call this method to get a location's temperature.
   * Don't change this method.
   */
  def getTemp(location: String): Option[Int] = location match {
    case "Trondheim" => Some(10)
    case "Oslo" => Some(14)
    case "Tromsø" => Some(4)
    case _ => None
  }
}
