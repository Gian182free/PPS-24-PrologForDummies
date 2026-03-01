package prologfordummies.view

import scalafx.geometry.Pos
import scalafx.scene.layout.{Region, VBox}
import UIComponents._

object SplashView {
  def asParent: Region = new VBox {
    alignment = Pos.Center
    prefWidth = 600
    prefHeight = 400

    style = "-fx-background-color: white; -fx-background-radius: 20;"

    children = Seq(

      logoView(myFitWidth = 250)
    )
  }
}
