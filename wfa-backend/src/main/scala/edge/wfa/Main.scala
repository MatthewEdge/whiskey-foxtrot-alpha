package edge.wfa

import akka.http.scaladsl.Http
import edge.wfa.ip.rest.IpService

/**
  * Created by medge on 1/21/16.
  */
object Main extends App with IpService {

  import Akka._

  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}
