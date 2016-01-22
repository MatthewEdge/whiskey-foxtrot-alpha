package edge.wfa

import akka.http.scaladsl.Http
import edge.wfa.ip.rest.IpService

/**
  * Created by medge on 1/21/16.
  */
object Main extends App with IpService {

  import Akka._

  val settings = Settings()

  val bindingFuture = Http().bindAndHandle(routes, settings.httpInterface, settings.httpPort)

  println(s"Server online at http://${settings.httpInterface}:${settings.httpPort}/")
}
