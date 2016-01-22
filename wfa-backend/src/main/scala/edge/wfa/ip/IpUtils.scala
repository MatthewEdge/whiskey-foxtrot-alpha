package edge.wfa.ip

/**
  * Created by medge on 1/21/16.
  */
object IpUtils {

  def isIpVersion4(ip: String) = {
    val ipv4Pattern = """^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$""".r

    ipv4Pattern.findFirstIn(ip) match {
      case Some(s) => true
      case _ => false
    }
  }

  def isIpVersion6(ip: String) = {
    val ipv6Pattern = """^(?:[a-fA-F0-9]{1,4}:){7}[a-fA-F0-9]{1,4}$""".r

    ipv6Pattern.findFirstIn(ip) match {
      case Some(s) => true
      case _ => false
    }
  }

  /**
    * Delegating method to parse either an IPv4 or IPv6 IP address to it's integer
    * representation
    *
    * @param ipAddress String IP Address
    * @return BigInt to account for IPv6
    */
  def ipToInt(ipAddress: String): BigInt = {

    if(isIpVersion4(ipAddress)) {
      ipv4toLong(ipAddress)
    } else if(isIpVersion6(ipAddress)) {
      ipv6toLong(ipAddress)
    } else {
      throw new RuntimeException(s"Invalid IP format. Only IPv4 and IPv6 addresses supported. Got: $ipAddress")
    }
  }

  /**
    * Convert an IPv4 address to a Long integer. Long used to handle large values generated
    * by larger octets
    *
    * @param ipAddress String IPv4 address
    * @return Long
    */
  def ipv4toLong(ipAddress: String): Long = {
    val octets = ipAddress.split("\\.").map(_.toLong)

    octets
      .reverse // To give the appropriate indexes
      .zipWithIndex
      .map {
        case (octet, idx) => octet * Math.pow(256, idx).toLong
      }
      .sum
  }

  /**
    * Convert an IPv4 address to a Long integer. Long used to handle large values generated
    * by larger octets
    *
    * @param ipAddress String IPv4 address
    * @return Long
    */
  def ipv6toLong(ipAddress: String): BigInt = {
    val groups = ipAddress.split("\\:")

    groups
      .reverse // To give the appropriate indexes
      .zipWithIndex
      .map {
        case (group, idx) =>
          BigInt(BigInt(group, 16).toLong * Math.pow(65535, idx).toLong)
      }
      .sum
  }

}
