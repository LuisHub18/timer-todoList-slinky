package tutorial

import org.scalajs.dom
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useState
import slinky.core.facade.ReactElement
import slinky.web.html._
import tutorial.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@react class App extends StatelessComponent {
  type Props = Unit
  private val css = AppCSS
  def render(): ReactElement = {
    div(className:="container")(
      TodoTitle(name ="Todo App"),
      div(className :="container-form")(
        TodoForm()
      )
    )
  }
}
