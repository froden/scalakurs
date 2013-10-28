package oppg3_option

object Options {

  /**
   * Compare the temp from two locations using the predefined getTemp method below.
   * The warmest place is only defined when the temp from both locations are known.
   */
  def warmest(location1: String, location2: String): Option[String] = ???


  /**
   * Find the warmest location given a list of locations by calling the predefined getTemp method below.
   * The result should be defined if at least one of the locations return a temperature.
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
