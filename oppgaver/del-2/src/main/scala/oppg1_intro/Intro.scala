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
    case n: Node=> {
      val leftPath: List[String] = findPath(name, n.left)
      val rightPath: List[String] = findPath(name, n.right)
      if (leftPath != Nil) {
        "left" :: leftPath
      }
      else if (rightPath != Nil) {
        "right" :: rightPath
      }
      else {
        Nil
      }
    }
    case l: Leaf => {
      if(name == l.value) {
        List(l.value)
      } else {
        Nil
      }
    }
  }

}
