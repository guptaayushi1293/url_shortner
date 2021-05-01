package models

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import configs.DbConfiguration
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{Rep, Tag}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class User(userId: Option[Int], username: String, password: Option[String])

trait UserTable { this: DbConfiguration =>

  class Users(tag: Tag) extends Table[User](tag, None, "user") {

    def * = (userId, username, password) <> (User.tupled, User.unapply)
    val userId : Rep[Option[Int]] = column[Int]("userId", O.AutoInc, O.PrimaryKey)
    val username: Rep[String] = column[String]("username")
    val password : Rep[Option[String]] = column[Option[String]]("user_pass")
  }

  val users = TableQuery[Users]
}

// collect your json format instances into a support trait:
trait UserJsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat3(User)
}