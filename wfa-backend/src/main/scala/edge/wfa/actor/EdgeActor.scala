package edge.wfa.actor

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import edge.wfa.ip.EdgeEvent

/**
  * Trait to provide common functionality to Actor classes
  *
  * Created by medge on 1/21/16.
  */
trait EdgeActor extends Actor with ActorLogging {

  val eventBus = context.system.eventStream

  /**
    * Subscribe the Actor to EdgeEvent events on the Akka Event Stream
    */
  def subscribe(): Unit = {
    eventBus.subscribe(self, classOf[EdgeEvent])
  }

  /**
    * Publish an EdgeEvent object to the Akka Event Stream
    *
    * @param event EdgeEvent
    */
  def emit(event: EdgeEvent): Unit = {
    eventBus.publish(event)
  }

  /**
    * Abstraction for creating a new Actor given a Props object
    *
    * @param props Props
    * @return ActorRef newly created Actor
    */
  def createActor(props: Props): ActorRef = {
    context.system.actorOf(props)
  }
}
