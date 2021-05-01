package models

import configs.DbConfiguration
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{Rep, Tag}

case class UrlMap(urlId: Option[Int], userId: Int, longUrl: String, tinyUrl: String)

trait UrlMapTable { this: DbConfiguration =>

  class UrlMaps(tag: Tag) extends Table[UrlMap](tag, None, "url_map") {

    def * = (urlId, userId, longUrl, tinyUrl) <> (UrlMap.tupled, UrlMap.unapply)
    val urlId : Rep[Option[Int]] = column[Int]("urlId", O.AutoInc, O.PrimaryKey)
    val userId : Rep[Int] = column[Int]("userId")
    val longUrl: Rep[String] = column[String]("longUrl")
    val tinyUrl : Rep[String] = column[String]("tinyUrl", O.Unique)
  }

  val urlMapList = TableQuery[UrlMaps]

}