package prologfordummies.view

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Node
import scalafx.scene.control.Button
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout._

object UIComponents {
  private val defaultBg = "-fx-background-color: #f4f4f4;"
  private val cardStyle =
    """
      -fx-background-color: white;
      -fx-background-radius: 10;
      -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);
    """

  def page(items: Node*): VBox = new VBox {
    alignment = Pos.Center
    spacing = 10
    padding = Insets(20)
    style = defaultBg
    children = items
  }

  def logoView(myFitWidth: Double = 300): ImageView = new ImageView {
    image = new Image(getClass.getResourceAsStream("/logo_pfd.png"), 400, 0, true, true)
    preserveRatio = true
    this.fitWidth = myFitWidth
    smooth = true
  }

  def styledButton(text: String,
                   bgColor: String = "#e0e0e0",
                   textColor: String = "#333",
                   onClick: => Unit = {}): Button =
    new Button(text) {
      maxWidth = Double.MaxValue
      style =
        s"""
           -fx-background-color: $bgColor;
           -fx-text-fill: $textColor;
           -fx-font-weight: bold;
           -fx-cursor: hand;
        """
      onAction = _ => onClick
    }

  def cardGrid(myHGap: Double = 10, myVGap: Double = 10)(init: GridPane => Unit): GridPane =
    new GridPane {
      alignment = Pos.Center
      this.hgap = myHGap
      this.vgap = myVGap
      padding = Insets(25)
      style = cardStyle

      val col = new ColumnConstraints()
      col.hgrow = Priority.Always
      columnConstraints.add(col)

      init(this)
    }
}
