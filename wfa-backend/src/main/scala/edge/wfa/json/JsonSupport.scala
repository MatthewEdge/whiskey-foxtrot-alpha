package edge.wfa.json

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import edge.wfa.ip.rest.{FailureResponse, SuccessResponse}
import spray.json.DefaultJsonProtocol

/**
  * Trait to enable JSON marshalling/unmarshalling in an Akka HTTP Service
  *
  * Created by medge on 1/22/16.
  */
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val ipSuccessResponseFormat = jsonFormat4(SuccessResponse)
  implicit val ipFailureResponseFormat = jsonFormat4(FailureResponse)
}