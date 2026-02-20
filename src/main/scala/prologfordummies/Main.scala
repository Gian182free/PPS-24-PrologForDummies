import prologfordummies.view.{LoginPage, SplashView}
import scalafx.animation.PauseTransition
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage

import scalafx.scene
import scalafx.scene.Scene
import scalafx.stage.{Stage, StageStyle}
import scalafx.util.Duration

object HelloStageDemo extends JFXApp3 {
  override def start(): Unit = {

    val splashStage = new PrimaryStage {
      initStyle(StageStyle.Transparent)
      scene = new Scene {
        fill = scalafx.scene.paint.Color.Transparent
        root = SplashView.asParent
      }
    }

    val waitTimer = new PauseTransition(Duration(3000)) {
      onFinished = _ => {
        splashStage.hide()
        showLoginScreen()
      }
    }

    splashStage.show()
    waitTimer.play()
  }

  def showLoginScreen(): Unit = {
    val loginStage = new Stage {

      title = "Login"
      scene = new Scene {
        root = LoginPage.asParent
      }
    }
    loginStage.show()
  }

}

@main def hello(): Unit =
  val fansiStr: fansi.Str = fansi.Color.Red("This should be a red string")
  println("Hello world!")
  println(fansiStr)

def msg = "I was compiled by Scala 3. :)"
