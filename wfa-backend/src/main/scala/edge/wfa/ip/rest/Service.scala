package edge.wfa.ip.rest

import akka.http.scaladsl.server.Route
import akka.util.Timeout
import scala.concurrent.duration._

/**
  * Trait for Akka HTTP Services. Defines what each sub-trait should implement
  *
  * Created by medge on 1/21/16.
  */
trait Service {

  // Default Timeout value for Ask pattern
  implicit val timeout = Timeout(5 seconds)

  val routes: Route
}
