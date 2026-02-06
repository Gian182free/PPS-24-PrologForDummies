val scala3Version = "3.8.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Scala 3 Project Template",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq("org.scalameta" %% "munit" % "1.0.0" % Test,
    "com.lihaoyi" %% "fansi" % "0.4.0",
    "org.scalafx" %% "scalafx" % "23.0.1-R34")
  )
