package oppg3_pattern_matching

import org.scalatest.FunSuite

class PatternMatchingTest extends FunSuite {

  test ("should compute square of int or string") {
    assert(PatternMatching.computeSquareOfIntOrString(4) == 16)
  }
}

