package oppg2_forcomprehensions

//    http://tataryn.net/2011/10/whats-in-a-scala-for-comprehension/
object ForComprehensions {

  def incrementAllNumbers(numbers: List[Int]) : List[Int] =
    for (n <- numbers) yield n + 1

  def keepAllEvenNumbersInAList(numbers: List[Int]) : List[Int] =
    for (n <- numbers if n % 2 == 0) yield n

  def findAllPairs(firstList: List[Any], secondList: List[Any]) : List[(Any, Any)] =
    for (a <- firstList; b <- secondList) yield (a,b)

  def findAllPairsWhereFirstElementIsEven(firstList: List[Int], secondList: List[Int]) : List[(Int, Int)] =
    for (a <- firstList; b <- secondList if a % 2 == 0) yield (a,b)

  /**
   * Hint : use new FactorNumber on the elements of the list
   * Hint : FactorNumber has a method perform()
   * Hint : FactorNumber stores a number accessible with the 'n'
   */
  def findAllPrimes(numbers: List[Long]) : List[Long] =
    for (n <- numbers;
         factors = new FactorNumber(n).perform();
         if factors.length == 2;
         if factors(0) == 1;
         if factors(1) == n
    ) yield n

}