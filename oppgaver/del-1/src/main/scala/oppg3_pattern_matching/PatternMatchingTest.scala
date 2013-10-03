package oppg3_pattern_matching;

object PatternMatching {

  def computeSquareOfIntOrString(number: Any): Int = {
    val n = number match {
      case i: Int => i
      case s: String => s.toInt
    }
    n * n
  }
}

