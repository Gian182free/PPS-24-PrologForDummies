import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

object HelloStageDemo extends JFXApp3 {

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "Hello Stage"
      width = 600
      height = 450
      scene = new Scene {
        fill = LightGreen
        content = new Rectangle {
          x = 25
          y = 40
          width = 100
          height = 100
          
        }
      }
    }
  }
}

@main def hello(): Unit =
  val fansiStr: fansi.Str = fansi.Color.Red("This should be a red string")
  println("Hello world!")
  println(fansiStr)

def msg = "I was compiled by Scala 3. :)"
