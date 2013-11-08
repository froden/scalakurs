package scalakurs

case class Echo(msg: String)

case class Article(_id: Option[String], author: String, title: String, content: String, comments: List[Comment] = Nil)

case class Comment(author: String, content: String)