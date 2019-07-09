lazy val commonSettings = Seq(
  version      := "1.0",
  organization := "jp.nnno",
  scalaVersion := "2.12.7",
  scalacOptions ++= Seq(
		"-deprecation",
		"-feature",
		"-unchecked",
		"-Xfatal-warnings",
		"-Xlint",
		"-Ywarn-adapted-args",
		"-Ywarn-dead-code",
		"-Ywarn-inaccessible",
		"-Ywarn-nullary-override",
		"-Ywarn-numeric-widen"
	),
  resolvers ++= Seq(
    "Artima Maven Repository" at "http://repo.artima.com/releases",
  ),
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "3.0.8",
    "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  )
)

lazy val root = (project in file("."))
  .settings(name := "scala-study")
  .settings(commonSettings)

