package edge.wfa

import akka.actor.{ActorRef, Props, ActorSystem}
import akka.stream.ActorMaterializer

/**
  * Contained configuration for Akka
  *
  * Created by medge on 1/22/16.
  */
object Akka {
  implicit val system = ActorSystem("WFAApplication")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  /**
    * Abstraction for creating a new Actor given a Props object
    *
    * @param props Props
    * @return ActorRef newly created Actor
    */
  def createActor(props: Props): ActorRef = {
    system.actorOf(props)
  }
}
