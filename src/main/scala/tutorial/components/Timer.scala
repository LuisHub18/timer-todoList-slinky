package tutorial.components

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js.timers.RawTimers._
import scala.scalajs.js.timers.SetIntervalHandle

@react class Timer extends Component {
  type Props = Unit
  case class State(secondsElapsed: Int)
  override def initialState: State = State(secondsElapsed = 0)

  def tick(): Unit = {
    setState(prevState => State(prevState.secondsElapsed + 1))
  }
  private var interval = (-1).asInstanceOf[SetIntervalHandle]
  override def componentDidMount(): Unit = {
    interval = setInterval(() => tick(), 1000)
  }
  override def componentWillUnmount(): Unit = {
    clearInterval(interval)
  }
  override def render(): ReactElement = {
    div(className:="time")(
      "Seconds: ", state.secondsElapsed.toString
    )
  }
}
