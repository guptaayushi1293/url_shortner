package repositories

import configs.DbConfiguration
import models.{User, UserTable}

import scala.concurrent.Future

class UserRepository extends DbConfiguration with UserTable {
  import config.driver.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def findById(id: Int): Future[Option[User]] =
    db.run((for (user <- users if user.userId === id) yield user).result.headOption)

  def insertUser(user: User): Future[User] = db
    .run(users returning users.map(_.userId) += user)
    .map(id => user.copy(userId = id))

  def fetchAll: Future[Seq[User]] = db.run(users.result)
}
