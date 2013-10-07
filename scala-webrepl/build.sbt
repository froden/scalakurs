name := "webrepl"

organization := "no.arktekk"

scalaVersion := "2.10.0"

libraryDependencies ++=
  Seq(
      "net.databinder" %% "unfiltered" % "0.6.7",
      "net.databinder" %% "unfiltered-filter" % "0.6.7",
      "net.databinder" %% "unfiltered-jetty" % "0.6.7",
      "org.scala-lang" % "scala-compiler" % "2.10.0",
      "org.apache.commons" % "commons-lang3" % "3.1"
     )
