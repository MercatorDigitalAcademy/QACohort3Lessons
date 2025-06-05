ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "QA Academy Lessons"
  )

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "4.33.0"
)