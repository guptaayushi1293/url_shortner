import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.util.Timeout
import routes.UserRouter

import scala.concurrent.duration.DurationInt

object TinyUrlApp extends App {
  implicit val system = ActorSystem("TinyUrlApp")
  implicit val matrializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(5.seconds)

  val userRouter = new UserRouter

  val routes = userRouter.routes

  Http().bindAndHandle(routes, "127.0.0.1", 8080)
}
