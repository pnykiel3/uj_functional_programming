version := "0.1.0"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "cask" % "0.9.2",
  "com.lihaoyi" %% "ujson" % "3.1.0"
)

fork in run := true