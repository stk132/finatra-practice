import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "finatra-practice",
    //libraryDependencies += scalaTest % Test
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.twitter" %% "finatra-http-server" % "21.6.0",
      "com.twitter" %% "finagle-mysql" % "21.6.0",
      "ch.qos.logback" % "logback-classic" % "1.2.4",
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
