package edge.wfa.ip.rest

import akka.http.scaladsl.server.Route

/**
  * Trait for Akka HTTP Services. Defines what each sub-trait should implement
  *
  * Created by medge on 1/21/16.
  */
trait Service {
  val routes: Route
}
