package tutorial.components

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class TodoTitle extends StatelessComponent{
  case class Props(name: String)

  override def render(): ReactElement = {
        h1(className:="Title", props.name)
  }
}
