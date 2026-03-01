package prologfordummies.controller

import prologfordummies.model.User
import prologfordummies.services.{UserService, UserServiceImpl, UserRepositoryImpl}
import prologfordummies.model.UserSession

object EditUserController {

  private given repo: prologfordummies.services.UserRepository = UserRepositoryImpl.fileRepository
  private given service: UserService = UserServiceImpl.liveService

    def handleEdit(updatedUser: User, onSuccess: User => Unit, onError: String => Unit): Unit = {
      service.updateUser(updatedUser) match {
      case Right(_) => 
        UserSession.login(updatedUser) 
        onSuccess(updatedUser)
      case Left(errorMessage) => 
        onError(errorMessage)
      }
    }

    def handleDelete(deletedUser: User, onSuccess: User => Unit, onError: String => Unit): Unit = {
      service.deleteUser(deletedUser) match {
      case Right(_) => 
        UserSession.logout()
        onSuccess(deletedUser)
      case Left(errorMessage) => 
        onError(errorMessage)
      }
    }

}