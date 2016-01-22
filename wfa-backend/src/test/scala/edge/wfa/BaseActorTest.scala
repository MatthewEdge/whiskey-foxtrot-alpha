package edge.wfa

import akka.actor.ActorSystem
import akka.testkit.{DefaultTimeout, ImplicitSender, TestKitBase}

/**
  * Created by medge on 1/21/16.
  */
trait BaseActorTest extends BaseTest
with TestKitBase with DefaultTimeout with ImplicitSender {

  implicit lazy val system = ActorSystem()

}
