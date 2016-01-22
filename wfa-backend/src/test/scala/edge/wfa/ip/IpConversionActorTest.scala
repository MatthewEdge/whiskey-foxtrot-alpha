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
    val expectedResult = IpConverted(testIp, BigInt(3232235521L))

    within(250 millis) {
      actorRef ! ConvertIp(testIp)
      expectMsg(expectedResult)
    }
  }

  "IpConversionActor" should "not respond for an unknown message" in {
    actorRef ! "HAI"
    expectNoMsg
  }

  "IpConversionActor" should "emit an event to the eventStream with the converted IP values" in {
    // Subscribe the TestActor implicit sender to the Akka event stream to listen for the expected messages
    system.eventStream.subscribe(self, classOf[EdgeEvent])

    val testIp = "192.168.0.1"
    val expectedResult = IpConverted(testIp, BigInt(3232235521L))

    actorRef ! ConvertIp(testIp)

    // First we should get the expected result
    expectMsg(expectedResult)

    // Then the event should be emitted
    expectMsgClass(classOf[EdgeEvent])
  }

}
