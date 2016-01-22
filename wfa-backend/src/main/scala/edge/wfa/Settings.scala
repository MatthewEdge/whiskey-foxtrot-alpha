package edge.wfa

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Class to wrap around Typesafe's Config file. Allows for required and optional parameters
  * to be handled and provides type safe vals for each settings key for safer, quicker refactoring
  *
  * Created by medge on 1/22/16.
  */
class Settings(config: Config) {

  def get[T](key: String): Option[T] = {
    config.getAnyRef(key) match {
      case v: T => Some(v)
      case ex: ClassCastException => None
    }
  }

  val httpInterface = get[String]("app.interface").getOrElse("localhost")
  val httpPort = get[Int]("app.port").getOrElse(8080)
}

object Settings {
  def apply() = new Settings(ConfigFactory.load())
}
