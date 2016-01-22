package edge.wfa.actor

import akka.actor.{Actor, ActorLogging}
import edge.wfa.ip.EdgeEvent

/**
  * Trait to provide common functionality to Actor classes
  *
  * Created by medge on 1/21/16.
  */
trait EdgeActor extends Actor with ActorLogging {

  val eventBus = context.system.eventStream

  /**
    * Publish an EdgeEvent object to the Akka Event Stream
    *
    * @param event EdgeEvent
    */
  def emit(event: EdgeEvent): Unit = {
    eventBus.publish(event)
  }
}
