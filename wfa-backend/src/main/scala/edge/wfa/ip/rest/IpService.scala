package edge.wfa.ip.rest

import akka.http.scaladsl.server.Directives._

/**
  * Created by medge on 1/21/16.
  */
trait IpService extends Service {

  val routes =
    path("ip" / String) {
      get {
        parameters('ip) { (ip) =>
          complete(s"Not Implemented. Your IP: $ip")
        }
      }
    }
}
