package edge.wfa.ip

import akka.actor.Props
import edge.wfa.actor.EdgeActor

/**
  * Actor to convert an IP Address to an integer representation
  *
  * Created by medge on 1/21/16.
  */
class IpConversionActor extends EdgeActor {

  def receive = {

    case ConvertIp(ipAddress) =>
      val result = IpConversions.ipToInt(ipAddress)
      sender ! result
      emit(IpConverted(ipAddress, result))

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