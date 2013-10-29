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
    case Node(left, right) =>
      findPath(name, left) match {
        case Nil =>
          findPath(name, right) match {
            case Nil => Nil
            case list => "right" :: list
          }
        case list => "left" :: list
      }
    case Leaf(found) => if (found == name) found :: Nil else Nil
  }

}
