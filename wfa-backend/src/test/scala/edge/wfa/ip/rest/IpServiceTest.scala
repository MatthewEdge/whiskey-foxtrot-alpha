package edge.wfa.ip.rest

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import edge.wfa.BaseTest
import edge.wfa.json.JsonSupport

/**
  * Unit Tests for the IpService Akka Routing DSL
  *
  * Created by medge on 1/22/16.
  */
class IpServiceTest extends BaseTest with ScalatestRouteTest with JsonSupport {

  import spray.json._

  // Used to get access to IpService routes
  object TestService extends IpService

  "GET /ip" should "return the correct JSON response for a valid IPv4 address request" in {
    val testIp = "192.168.0.1"
    val expectedResponse = SuccessResponse(testIp, "3232235521")

    Get(s"/ip?ip=$testIp") ~> TestService.routes ~> check {
      responseAs[SuccessResponse] shouldEqual expectedResponse
      responseEntity shouldEqual HttpEntity(ContentTypes.`application/json`, expectedResponse.toJson.prettyPrint)
    }
  }

  "GET /ip" should "return the correct failure JSON response for an invalid IPv4 address request" in {
    val testIp = "192.168"
    val expectedResponse = FailureResponse(testIp, "Invalid IP format. Only IPv4 and IPv6 addresses supported. Got: 192.168")

    Get(s"/ip?ip=$testIp") ~> TestService.routes ~> check {
      responseAs[FailureResponse] shouldBe expectedResponse
      responseEntity shouldEqual HttpEntity(ContentTypes.`application/json`, expectedResponse.toJson.prettyPrint)
    }
  }

}
