package edge.wfa.ip.rest

import akka.http.scaladsl.server.Directives._

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
          complete(s"Not Implemented. Your IP: $ip")
        }
      }
    }
}
