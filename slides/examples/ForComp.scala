object ForComp extends App {
  def even(start: Int, end: Int) =
    for (i <- start until end if i % 2 == 0) yield i

  println(even(0, 20))
}
