package edge.wfa.ip.actor

import akka.actor.Props
import edge.wfa.actor.EdgeActor
import edge.wfa.ip.IpUtils

/**
  * Actor to convert an IP Address to an integer representation
  *
  * Created by medge on 1/21/16.
  */
class IpConversionActor extends EdgeActor {

  def receive = {

    case ConvertIp(ipAddress) =>
      sender ! IpUtils.iptoLong(ipAddress)

    case m @ _ => unhandled(m)
  }

}

/**
  * Companion object to control how Props are created for this Actor
  */
object IpConversionActor {

  /**
    * Props Factory
    *
    * @return Props
    */
  def props(): Props = {
    Props(new IpConversionActor)
  }
}