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
        val response = IpConverted(ipAddress, result)

        // Emit converted event, then return the event to the sender
        emit(response)
        sender ! response
      }
      catch {
        case e: RuntimeException =>
          val evt = IpConversionFailed(ipAddress, e.getMessage)

          // Emit the failure, then send it to the sender
          emit(evt)
          sender ! evt
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