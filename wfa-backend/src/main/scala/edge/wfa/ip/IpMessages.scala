package edge.wfa.ip

/**
  * Message models relating to IP Conversion requests
  *
  * Created by medge on 1/21/16.
  */

/**
  * Command to convert an IP Address to an Integer representation
  *
  * @param ipAddress String IP Address
  */
case class ConvertIp(ipAddress: String)

/**
  * Trait to mark Events emitted from Actor classes to the eventStream
  */
trait EdgeEvent

/**
  * Event for a converted IP Address
  * @param ipAddress String IP Address
  * @param intValue BigInt Converted integer value
  */
case class IpConverted(ipAddress: String, intValue: BigInt) extends EdgeEvent
