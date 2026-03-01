package prologfordummies.model

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite
import java.time.LocalDateTime
import java.util.UUID

class UserSessionTest extends AnyFunSuite with BeforeAndAfterEach {

  val testUser = User(
    id = User.Id(UUID.fromString("78487944-0f3a-4eb3-bcaf-e4d58b45b442")),
    username = User.Name("User"), 
    registrationDate = LocalDateTime.parse("2026-02-25T23:00:56.638427600")
  )

  test("UserSession dovrebbe salvare correttamente l'utente dopo il login") {
    UserSession.login(testUser)
    
    assert(UserSession.isAuthenticated)
    assert(UserSession.currentSessionUser.contains(testUser))
    assert(UserSession.currentSessionUser.map(_.username).contains("User"))
  }

  test("UserSession dovrebbe tornare Guest dopo aver fatto il logout") {
    UserSession.login(testUser)
    UserSession.logout()
    
    assert(!UserSession.isAuthenticated)
    assert(UserSession.currentSessionUser.isEmpty)
  }
}