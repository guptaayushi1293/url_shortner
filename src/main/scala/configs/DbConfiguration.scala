package configs

import slick.basic.DatabaseConfig
import slick.jdbc.{JdbcBackend, JdbcProfile}

trait DbConfiguration {
  val config: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig("slick.mysql")
  val db: JdbcBackend#DatabaseDef = config.db
}
