package tutorial.components

import org.scalajs.dom
import slinky.core.{FunctionalComponent, SyntheticEvent}
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useState
import slinky.web.html._

import java.util.UUID
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@react object TodoForm {
  type Props = Unit
  private val css = AppCSS
  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { _ =>
    val (todo, setTodo) = useState[String]("")
    val (listTodo, setListTodo) = useState[List[String]](List.empty)

    def handleSubmit(e: SyntheticEvent[_, dom.Event]): Unit = {
      e.preventDefault()
      setListTodo(_ :+ todo)
      setTodo("")
    }

    def handleChange(e: SyntheticEvent[_, dom.Event]): Unit = {
      val target = e.target.asInstanceOf[dom.html.Input]
      setTodo(target.value)
    }

    div(className := "App")(
      Timer(),
      form(
        input(
          `type` := "text",
          placeholder := "Introduce the todo",
          onChange := (handleChange(_)),
          value := todo
        ),
        input(
          `type` := "submit",
          className := "btn",
          value := "Add",
          onClick := (handleSubmit(_))
        )
      ),
      div(className:="container-todo")(
        div(className:="container-info-todo")(
          listTodo.map( todo =>
            span(todo)
          )
        )
      )
    )
  }

}