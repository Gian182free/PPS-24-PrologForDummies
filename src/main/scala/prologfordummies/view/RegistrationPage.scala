package prologfordummies.view

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Label, TextField}
import scalafx.scene.layout.*
import scalafx.scene.text.Font
import prologfordummies.controller.RegistrationController
import prologfordummies.Main
import prologfordummies.view.UIComponents.{logoView, styledButton}
import scalafx.animation.PauseTransition

object RegistrationPage {
  def asParent: Region = new VBox {
    alignment = Pos.Center
    spacing = 15
    padding = Insets(20)
    style = "-fx-background-color: #f4f4f4;"

    val backBtnContainer = new HBox {
      alignment = Pos.TopLeft
      children = styledButton(
        text = "←",
        bgColor = "#white",
        textColor = "#333",
        prologfordummies.Main.setPage(LoginPage.asParent)
      )
    }

    val logo = logoView(myFitWidth = 250)
    
    val registrationCard = new GridPane {
      alignment = Pos.Center
      hgap = 10
      vgap = 10
      padding = Insets(25)
      style = """
            -fx-background-color: white;
            -fx-background-radius: 10;
            -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);
          """

      val userLabel = new Label("Nome Utente") {
        font = Font.font("System", 18)
      }

      val userField = new TextField {
        promptText = "User"
        prefWidth = 200
      }

      val stateLabel = new Label("") {
        style = "-fx-text-fill: #d32f2f; -fx-font-style: italic;"
        visible = false
      }

      val registerBtn =styledButton(
        text = "Registrati",
        bgColor = "#e0e0e0",
        textColor = "#333",
        {
          val username = userField.text.value.trim

          if username == "User" then
            stateLabel.visible = true
          else
            stateLabel.visible = false

          println(s"Tentativo registrazione: $username")
        }
      )

      add(userLabel, 0, 0)
      add(userField, 1, 0)
      add(stateLabel, 0, 1, 2, 1)
      GridPane.setHalignment(stateLabel, scalafx.geometry.HPos.Center)
      
      add(registerBtn, 0, 2, 2, 1)
      GridPane.setMargin(registerBtn, Insets(20, 0, 0, 0))

      registerBtn.onAction = _ => {
        val inputName = userField.text.value
        
        RegistrationController.handleRegistration(
          inputName,
          user => {
            stateLabel.visible = true
            stateLabel.text = s"Registrazione avvenuta con successo! Benvenuto ${user.username}!"
            stateLabel.style = "-fx-text-fill: #388e3c; -fx-font-style: italic;"
            val pause = new PauseTransition(scalafx.util.Duration(2000))
            
            pause.onFinished = _ => {
              Main.setPage(LoginPage.asParent)
            }
            pause.play()
          },
          errorMsg => {
            // Caso Errore: mostra il messaggio nel label del mockup
            stateLabel.text = errorMsg
            stateLabel.visible = true
          }
        )
      }
    }

    registrationCard.maxWidthProperty().bind(width * 0.8)

    children = Seq(backBtnContainer, logo, registrationCard)
  }
}