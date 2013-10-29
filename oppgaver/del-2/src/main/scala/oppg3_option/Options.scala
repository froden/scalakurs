package oppg3_option

object Options {

  /**
   * No need to edit the Person class.
   */
  case class Person(name: String, gender: Option[String])

  /**
   * You can get a value out of an option if you supply a default value.
   * In the Person class above, gender is optional.
   * This method should take person and return its gender or the string "not specified"
   * if it's a None
   */
  def getGender(person: Person): String = ???

  /**
   * Compare the temperature from two locations using the predefined getTemp method below.
   * The warmest place is only defined when the temp from both locations are known.
   * Hint: for-comprehension
   */
  def warmest(location1: String, location2: String): Option[String] = ???


  /**
   * Find the warmest location given a list of locations by calling the predefined getTemp method below.
   * The result should be defined if at least one of the locations return a temperature.
   * Hint: to sort a list use sortBy(elem => elem.fieldToSortBy)
   */
  def warmest2(locations: List[String]): Option[String] = ???

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
