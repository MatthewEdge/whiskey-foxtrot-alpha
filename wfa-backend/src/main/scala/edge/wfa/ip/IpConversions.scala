package edge.wfa.ip

/**
  * Conversion class to handle converting IPv4 and IPv6 addresses
  *
  * Created by medge on 1/21/16.
  */
object IpConversions {

  /**
    * Delegating method to parse either an IPv4 or IPv6 IP address to it's integer
    * representation
    *
    * @param ipAddress String IP Address
    * @return BigInt to account for IPv6
    */
  def ipToInt(ipAddress: String): BigInt = {

    if (isIpVersion4(ipAddress)) {
      ipv4ToBigInt(ipAddress)
    } else if (isIpVersion6(ipAddress)) {
      ipv6ToBigInt(ipAddress)
    } else {
      throw new RuntimeException(s"Invalid IP format. Only IPv4 and IPv6 addresses supported. Got: $ipAddress")
    }
  }

  /**
    * Check if the given IP Address string is an IPv4 address
    *
    * @param ip String IP Address
    * @return Boolean
    */
  def isIpVersion4(ip: String): Boolean = {
    val ipv4Pattern = """^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$""".r

    ipv4Pattern.findFirstIn(ip) match {
      case Some(s) => true
      case _ => false
    }
  }

  /**
    * Convert an IPv4 address to a Long integer. Long used to handle large values generated
    * by larger octets
    *
    * @param ipAddress String IPv4 address
    * @return Long
    */
  def ipv4ToBigInt(ipAddress: String): BigInt = {
    val octets = ipAddress.split("\\.").map(_.toLong)

    octets
      .reverse // To give the appropriate indexes
      .zipWithIndex
      .map {
        case (octet, idx) => BigInt(octet * Math.pow(256, idx).toLong)
      }
      .sum
  }

  /**
    * Check if the given IP Address string is an IPv6 address
    *
    * @param ip String IP Address
    * @return Boolean
    */
  def isIpVersion6(ip: String): Boolean = {
    val ipv6Pattern = """^(?:[a-fA-F0-9]{1,4}:){7}[a-fA-F0-9]{1,4}$""".r

    ipv6Pattern.findFirstIn(ip) match {
      case Some(s) => true
      case _ => false
    }
  }

  /**
    * Convert an IPv6 address to a Long integer. BigInt is used since an IPv6 value is 128bits total
    *
    * @param ipAddress String IPv6 address
    * @return BigInt
    */
  def ipv6ToBigInt(ipAddress: String): BigInt = {
    val groups = ipAddress.split("\\:")

    groups
      .reverse // To give the appropriate indexes
      .map(hexToBigInt)
      .zipWithIndex
      .map { case (groupBigInt, idx) => groupBigInt * BigInt(65535).pow(idx) }
      .sum
  }

  /**
    * Handy method to convert a Hexadecimal string to a BigInt.
    *
    * Credit: http://stackoverflow.com/a/18605816
    *
    * @param hex Hexadecimal string
    * @return BigInt
    */
  def hexToBigInt(hex: String): BigInt = {
    hex
      .toLowerCase()
      .toList
      .map("0123456789abcdef".indexOf(_))
      .map(BigInt(_))
      .reduceLeft(_ * 16 + _)
  }

}
