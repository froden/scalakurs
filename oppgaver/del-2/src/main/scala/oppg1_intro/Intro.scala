package oppg1_intro

object Intro {

  sealed trait Tree

  case class Node(left: Tree, right: Tree) extends Tree
  case class Leaf(value: String) extends Tree

  /**
   * Complete the implementation of this method
   * The following tree would yield the result List(left, right, Frode) for input "Frode"
   *                  root
   *               /       \
   *            /    \   /    \
   *        Sjur Frode Arild Torbjørn
   */
  def findPath(name: String, tree: Tree): List[String] = tree match {
    case _ => ???
  }

}
