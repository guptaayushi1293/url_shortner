package service

import models.User
import repositories.UserRepository

import scala.concurrent.{ExecutionContext, Future}

class UserService(userRepository: UserRepository) {

  def getAllUsers(implicit ec: ExecutionContext): Future[Seq[User]] = userRepository.fetchAll

  def getUserById(userId: Int)(implicit ec: ExecutionContext): Future[Option[User]] = userRepository.findById(userId)

  def insertUser(user: User): Future[User] = userRepository.insertUser(user)
}
