package edge.wfa.ip

import akka.testkit.TestActorRef
import edge.wfa.BaseActorTest

import scala.concurrent.duration._

/**
  * Unit Test for the IpConversionActor
  *
  * Created by medge on 1/21/16.
  */
class IpConversionActorTest extends BaseActorTest {

  val actorRef = TestActorRef(IpConversionActor.props())

  "IpConversionActor" should "return the correct converted IP within the allotted time" in {
    val testIp = "192.168.0.1"
    val expectedResult = 3232235521L

    within(250 millis) {
      actorRef ! ConvertIp(testIp)
      expectMsg(3232235521L)
    }
  }

  "IpConversionActor" should "not respond for an unknown message" in {
      actorRef ! "HAI"
      expectNoMsg
  }

}
