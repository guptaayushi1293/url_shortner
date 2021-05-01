name := "tiny_url"

version := "0.1"

scalaVersion := "2.12.12"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.4"

libraryDependencies ++= Seq(

  //Akka packages
  "com.typesafe.akka" %% "akka-http"            % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream"          % AkkaVersion,

  //Database packages
  "com.typesafe.slick" %% "slick"               % "3.2.0",
  "com.typesafe.slick" %% "slick-hikaricp"      % "3.2.0",
  "mysql"              % "mysql-connector-java" % "8.0.16",

  //miscellaneous
  "joda-time" % "joda-time" % "2.10.10"

  //Test packages
//  "com.typesafe.akka" %% "akka-http-testkit"    % "10.1.5" % Test,
//  "com.typesafe.akka" %% "akka-testkit"         % "2.5.18"     % Test,
//  "com.typesafe.akka" %% "akka-stream-testkit"  % "2.5.18"     % Test,
//  "org.scalatest"     %% "scalatest"            % "3.0.5"         % Test,
)
