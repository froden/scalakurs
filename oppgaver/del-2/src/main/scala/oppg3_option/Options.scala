package oppg3_option

object Options {

  /**
   * You can get a value out of an option if you supply a default value.
   *
   * What happens if you try to get a value - from a None?
   */
  def getTimeout(timeoutInSeconds: Option[Int]): Int = timeoutInSeconds.getOrElse(30)

  /**
   * Compare the temp from two locations using the predefined getTemp method.
   * The warmest place is only defined when the temp from both locations are known.
   */
  def warmest(location1: String, location2: String): Option[String] =
    for {
      temp1 <- getTemp(location1)
      temp2 <- getTemp(location2)
    } yield if (temp1 > temp2) location1 else location2


  /**
   * Find the warmest location given a list of locations.
   * The result should be defined if at least one of the locations return a temperature.
   */
  def warmest2(locations: List[String]): Option[String] = {
    val temps = locations.map(loc => getTemp(loc).map(t => (loc, t))).flatten
    temps.sortBy(_._2).reverse.headOption.map(_._1)
  }

  /**
   * Call this method without changing its implementation
   */
  def getTemp(location: String): Option[Int] = location match {
    case "Trondheim" => Some(10)
    case "Oslo" => Some(14)
    case "Tromsø" => Some(4)
    case _ => None
  }
}
