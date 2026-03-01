package prologfordummies.view

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{ColumnConstraints, GridPane, Priority, VBox, Region}
import scalafx.scene.text.Font
import scalafx.scene.control.Separator
import prologfordummies.Main
import scalafx.geometry.Orientation
import prologfordummies.model.UserSession
import prologfordummies.controller.EditUserController
import scalafx.animation.PauseTransition
import prologfordummies.model.User
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.ButtonType

object EditUserPage {

  def currentUserName: String = 
    UserSession.currentSessionUser match
      case Some(user) => user.username.asString
      case None => "Guest"
  def currentUser: User = 
    UserSession.currentSessionUser match
      case Some(user) => user
      case None => throw new RuntimeException("No user logged in")
  
  def asParent: Region = new VBox {
    alignment = Pos.Center
    spacing = 10
    padding = Insets(20)
    style = "-fx-background-color: #f4f4f4;"

    val logoView = new ImageView {
        image = new Image(getClass.getResourceAsStream("/logo_pfd.png"), 400, 0, true, true)
        preserveRatio = true
        fitWidth = 300
        smooth = true
    }

    val loginCard = new GridPane {
      alignment = Pos.Center
      hgap = 10
      vgap = 15
      padding = Insets(25)
      style = """
          -fx-background-color: white;
          -fx-background-radius: 10;
          -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);
      """

      val column1 = new ColumnConstraints()
      column1.hgrow = Priority.Always
      columnConstraints.add(column1)

      val header = new Label(currentUserName) {
        font = Font.font("System", 24)
        style = "-fx-font-weight: bold; -fx-text-fill: #333;"
      }

      val userLabel = new Label("Inserisci il nuovo nome:")
      val userField = new TextField {
        promptText = "Inserisci username"
      }

      val stateLabel = new Label("") {
        style = "-fx-text-fill: #66d32f; -fx-font-style: italic;"
        visible = false
      }

      val editBtn = new Button("Modifica Utenza") {
        maxWidth = Double.MaxValue
        style = """
            -fx-background-color: #4a90e2;
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-cursor: hand;
        """
      }

      val separator = new Separator:
        orientation = Orientation.Horizontal
        maxWidth = Double.MaxValue

      val deleteBtn = new Button("Elimina Utenza") {
        maxWidth = Double.MaxValue
        style = """
              -fx-background-color: #e0e0e0;
              -fx-text-fill: #333;
              -fx-border-color: #999;
              -fx-font-weight: bold;
              -fx-cursor: hand;
              """
        onAction = _ => {
          prologfordummies.Main.setPage(RegistrationPage.asParent)
        }
      }

      add(logoView, 0, 0)
      GridPane.setHalignment(logoView, scalafx.geometry.HPos.Center)
      GridPane.setMargin(logoView, Insets(0, 0, 20, 0))

      add(header, 0, 1, 2, 1)
      GridPane.setHalignment(header, scalafx.geometry.HPos.Center)
      add(userLabel, 0, 2)
      add(userField, 0, 3)
      add(editBtn, 0, 4)
      add(stateLabel, 0, 5)
      add(separator, 0, 6)
      add(deleteBtn, 0, 7)  

      editBtn.onAction = _ => {
        val inputName = userField.text.value.trim

        UserSession.currentSessionUser match {
          case Some(currentUser) =>
            val updatedUser = currentUser.copy(username = User.Name(inputName))

            EditUserController.handleEdit(
              updatedUser,
              user => {

                stateLabel.visible = true
                userField.clear()
                stateLabel.text = s"Utente aggiornato!"
                stateLabel.style = "-fx-text-fill: #388e3c; -fx-font-weight: bold;"
                
                header.text = user.username.asString

                val pause = new PauseTransition(scalafx.util.Duration(2000))
                pause.onFinished = _ => stateLabel.visible = false
                pause.play()
              },
              errorMsg => {
                stateLabel.text = errorMsg
                stateLabel.style = "-fx-text-fill: #d32f2f; -fx-font-weight: bold;"
                stateLabel.visible = true
              }
            )

          case None => 
            Main.setPage(LoginPage.asParent)
      }
}

deleteBtn.onAction = _ => {
  UserSession.currentSessionUser.foreach { user =>
    // TODO: migliorare questo alert con un dialog custom più bello
    val alert = new Alert(AlertType.Confirmation) {
      initOwner(Main.stage)
      title = "Conferma Eliminazione"
      headerText = s"Stai per eliminare l'utente: ${user.username.asString}"
      contentText = "Sei sicuro di voler procedere? L'operazione non è reversibile."
    }
    val result = alert.showAndWait()
    result match {
      case Some(ButtonType.OK) => 
        EditUserController.handleDelete(
          user,
          _ => {
            Main.setPage(RegistrationPage.asParent)
          },
          error => {
            stateLabel.text = error
            stateLabel.visible = true
          }
        )
    }
  }
}
    }

    loginCard.maxWidthProperty().bind(width * 0.8)
    children = Seq(loginCard)
  }
}