scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  guice,
  "org.scalatest"          %% "scalatest"          % "3.0.5" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.0" % Test,
)

enablePlugins(PlayScala)
