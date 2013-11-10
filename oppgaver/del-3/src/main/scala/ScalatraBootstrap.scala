import com.mongodb.casbah.Imports._
import scalakurs._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    val mongoClient = MongoClient()
    val db = mongoClient("blog")
    val articles = db("articles")

    context.mount(new ArticlesController(articles), "/articles/*")
  }
}
