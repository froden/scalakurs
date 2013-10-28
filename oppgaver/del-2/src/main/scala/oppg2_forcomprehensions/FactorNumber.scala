package oppg2_forcomprehensions

class FactorNumber(val n: Long) {

  def perform(): List[Long] = factor(n)

  /**
   * Naive approach to number factorization
   * THIS VERSION RETURNS 1 AS A FACTOR
   * THIS VERSION RETURNS N AS A FACTOR
   */
  def factor(n: Long): List[Long] = {

    def factor0(a: Long, acc: List[Long]): List[Long] = {
      def isFactor(f: Long, p: Long): Boolean = p % f == 0
      if (a > 1) {
        if (isFactor(a, n))
          factor0(a - 1, List(a) ::: acc)
        else
          factor0(a - 1, acc)
      } else {
        acc
      }
    }
    List(1L) ::: factor0(n - 1, List()) ::: List(n)
  }

}
