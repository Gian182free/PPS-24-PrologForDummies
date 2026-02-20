package prologfordummies.view

import scalafx.geometry.Pos
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{Region, VBox}

object SplashView {
  def asParent: Region = new VBox {
    alignment = Pos.Center
    prefWidth = 600
    prefHeight = 400

    style = "-fx-background-color: white; -fx-background-radius: 20;"

    children = Seq(
      new ImageView {
        image = new Image(getClass.getResourceAsStream("/logo_pfd.png"))
        preserveRatio = true
        fitWidth = 250
        smooth = true
      }
    )
  }
}
