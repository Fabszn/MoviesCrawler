name := """moviesCrawler2"""
organization := "com.movies.crawler"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= Seq(
    ws,
    "org.scala-lang.modules" %% "scala-xml" % "1.0.5"
  ))

scalaVersion := "2.11.8"

