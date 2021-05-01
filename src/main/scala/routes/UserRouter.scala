package routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import models.{User, UserJsonSupport}
import repositories.UserRepository
import service.UserService

import scala.concurrent.ExecutionContextExecutor

class UserRouter(implicit system: ActorSystem, ex: ExecutionContextExecutor) extends UserJsonSupport {
  val userRepository = new UserRepository()
  val userService = new UserService(userRepository)

  def routes: Route = {
    pathPrefix("api") {
      pathPrefix("v1") {
        get {
          path("users") {
            onSuccess(userService.getAllUsers) {
              value => complete(value.seq)
            }
          }
        } ~
        post {
          path("insert") {
            entity(as[User]) { user =>
              onSuccess(userService.insertUser(user)) {
                value => complete(value)
              }
            }
          }
        }
      }
    }
  }
}