package edge.wfa.ip.rest

import akka.http.scaladsl.server.Directives._
import akka.pattern.ask
import edge.wfa.Akka
import edge.wfa.ip.{ConvertIp, IpConversionActor}

import scala.util.{Failure, Success}

/**
  * REST API to access IP Conversion logic
  *
  * Created by medge on 1/21/16.
  */
trait IpService extends Service {

  val routes =
    path("ip") {
      get {
        parameters('ip) { (ip) =>
          val ipActor = Akka.createActor(IpConversionActor.props())
          val future = (ipActor ? ConvertIp(ip)).mapTo[BigInt]

          onComplete(future) {
            case Success(res) => complete(IpResponse(ip, res.toString))
            case Failure(ex) => failWith(ex)
          }
        }
      }
    }
}
