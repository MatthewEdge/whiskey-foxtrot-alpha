package edge.wfa

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import edge.wfa.ip.rest.IpService

/**
  * Created by medge on 1/21/16.
  */
object Main extends App with IpService {

  implicit val system = ActorSystem("WFAApplication")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}
