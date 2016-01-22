package edge.wfa.ip.rest

import akka.http.scaladsl.server.Directives._
import akka.pattern.ask
import edge.wfa.Akka
import edge.wfa.ip.{ConvertIp, IpConversionActor}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * REST API to access IP Conversion logic
  *
  * Created by medge on 1/21/16.
  */
trait IpService extends Service {
  import Akka._

  val routes =
    path("ip") {
      get {
        parameters('ip) { (ip) =>
          complete {
            val ipActor = createActor(IpConversionActor.props())

            val result = Await.result((ipActor ? ConvertIp(ip)).mapTo[BigInt], 5.seconds)

            s"$ip as an integer: ${result.toString}"

            //case r@_ => reject(s"Failed to convert the given IP address: $ip")
          }
        }
      }
    }
}
