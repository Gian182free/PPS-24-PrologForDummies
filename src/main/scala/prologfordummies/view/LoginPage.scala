package prologfordummies.view

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.image
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{ColumnConstraints, GridPane, Priority, Region, VBox}
import scalafx.scene.text.Font

object LoginPage {
  def asParent: Region = new VBox {

    alignment = Pos.Center
    spacing = 10
    padding = Insets(20)
    style = "-fx-background-color: #f4f4f4;"

    val logoView = new ImageView {

      image = new Image(getClass.getResourceAsStream("/logo_pfd.png"))
      preserveRatio = true
      fitWidth = 250
    }

    val loginCard = new GridPane {
      alignment = Pos.Center
      hgap = 10
      vgap = 15
      padding = Insets(25)
      style =
        """
            -fx-background-color: white;
            -fx-background-radius: 10;
            -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);
          """

      val column1 = new ColumnConstraints()
      column1.hgrow = Priority.Always
      columnConstraints.add(column1)


      val header = new Label("Inserisci il tuo account") {
        alignment = Pos.TopRight
        font = Font.font("System", 24)
        style = "-fx-font-weight: bold; -fx-text-fill: #333;"
      }

      val userLabel = new Label("Username:")
      val userField = new TextField {
        promptText = "Inserisci username"
      }

      val loginBtn = new Button("Accedi") {
        maxWidth = Double.MaxValue
        style =
          """
              -fx-background-color: #4a90e2;
              -fx-text-fill: white;
              -fx-font-weight: bold;
              -fx-cursor: hand;
            """
      }

      add(logoView, 0, 0)
      GridPane.setHalignment(logoView, scalafx.geometry.HPos.Center)
      GridPane.setMargin(logoView, Insets(0, 0, 20, 0))

      add(header, 0, 1, 2, 1)
      GridPane.setHalignment(header, scalafx.geometry.HPos.Center)
      add(userLabel, 0, 2)
      add(userField, 0, 3)
      add(loginBtn, 0, 5)


      //Cambiare login in scelta da utenti salvati con immagine del profilo + tasto crea nuovo utente?
      loginBtn.onAction = _ => println(s"Login tentato per: ${userField.text.value}")
    }

    loginCard.maxWidthProperty().bind(width * 0.8)

    children = Seq(logoView, loginCard)
  }
}



