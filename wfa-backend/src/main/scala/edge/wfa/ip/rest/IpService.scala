package edge.wfa.ip.rest

import akka.http.scaladsl.server.Directives._
import akka.pattern.ask
import edge.wfa.Akka
import edge.wfa.ip.{IpConversionFailed, IpConverted, ConvertIp, IpConversionActor}

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
          val future = ipActor ? ConvertIp(ip)

          onComplete(future) {
            case Success(res) =>
              // A successful future doesn't necessarily mean a successful conversion
              res match {
                case IpConverted(_, intValue) => complete(SuccessResponse(ip, intValue.toString()))
                case IpConversionFailed(_, failedReason) => complete(FailureResponse(ip, failedReason))
              }
            case Failure(ex) => failWith(ex)
          }
        }
      }
    }
}
