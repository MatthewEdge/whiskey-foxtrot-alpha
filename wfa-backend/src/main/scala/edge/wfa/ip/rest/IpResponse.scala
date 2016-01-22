package edge.wfa.ip.rest

/**
  * Response object representation for an IP Conversion request. convertedValue is a String
  * to account for larger integers
  *
  * Created by medge on 1/22/16.
  */
case class IpResponse(ipAddress: String, convertedValue: String)
