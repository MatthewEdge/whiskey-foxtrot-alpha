package edge.wfa.ip.rest

/**
  * Response object representation for an IP Conversion request. convertedValue is a String
  * to account for larger integers
  *
  * Created by medge on 1/22/16.
  */
trait IpResponse {
  val ipAddress: String
  val convertedValue: String
  val failed: Boolean
  val reason: String
}

case class SuccessResponse(ipAddress: String, convertedValue: String, failed: Boolean = false, reason: String = "") extends IpResponse
case class FailureResponse(ipAddress: String, reason: String, convertedValue: String = "", failed: Boolean = true) extends IpResponse
