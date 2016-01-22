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

    /**
      * Request to convert an IP Address
      */
    case ConvertIp(ipAddress) =>
      try {
        val result = IpConversions.ipToInt(ipAddress)
        sender ! result

        // Emit converted event
        emit(IpConverted(ipAddress, result))
      } catch {
        case e: RuntimeException => sender ! e.getMessage
      }

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