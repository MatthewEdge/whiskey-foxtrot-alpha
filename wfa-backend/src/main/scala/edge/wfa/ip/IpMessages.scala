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
  * Event for a converted IP Address
  * @param ipAddress String IP Address
  * @param intValue Long Converted integer value
  */
case class IpConverted(ipAddress: String, intValue: Long)
