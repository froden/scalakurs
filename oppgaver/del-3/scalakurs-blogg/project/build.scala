import sbt._
import Keys._
import org.scalatra.sbt._
import spray.revolver.RevolverPlugin.Revolver

object ScalakursbloggBuild extends Build {
  val Organization = "scalakurs"
  val Name = "scalakurs-blogg"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.10.2"
  val ScalatraVersion = "2.2.1"
  val Json4SVersion = "3.2.5"
  val JettyVersion = "8.1.8.v20121106"

  lazy val project = Project (
    "scalakurs-blogg",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ Revolver.settings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s"   %% "json4s-jackson" % Json4SVersion,
        "org.json4s"   %% "json4s-mongo" % Json4SVersion exclude("org.mongodb", "mongo-java-driver"),
        "org.mongodb"  %% "casbah" % "2.6.4",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % JettyVersion % "container;compile",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar")),
        "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test"
      )
    )
  )
}
