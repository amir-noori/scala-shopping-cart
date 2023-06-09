ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "eu.timepit" %% "refined" % "0.10.3",
  "io.estatico" %% "newtype" % "0.4.4"
)

lazy val root = (project in file("."))
  .settings(
    name := "shopping-cart",
    scalacOptions += "-Ymacro-annotations"
  )
