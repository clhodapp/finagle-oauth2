import sbt._
import sbt.Keys._

object FinaleOAuth2 extends Build {

  val baseSettings = Defaults.defaultSettings ++ Seq(
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "6.14.0",
      "org.scalatest" %% "scalatest" % "2.0" % "test"
    )
  )

  lazy val buildSettings = Seq(
    organization := "com.twitter",
    version := "0.1.2",
    scalaVersion := "2.10.3"
  )

  lazy val publishSettings = Seq(
    publishMavenStyle := true,
    publishArtifact := true,
    publishTo := Some(Resolver.file("localDirectory", file(Path.userHome.absolutePath + "/repo"))),
    licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url("https://github.com/vkostyukov/finagle-oauth2")),
    pomExtra := (
      <scm>
        <url>git://github.com/vkostyukov/finagle-ouath2.git</url>
        <connection>scm:git://github.com/vkostyukov/finagle-oauth2.git</connection>
      </scm>
      <developers>
        <developer>
          <id>vkostyukov</id>
          <name>Vladimir Kostyukov</name>
          <url>http://vkostyukov.ru</url>
        </developer>
      </developers>
    )
  )

  lazy val root = Project(id = "finagle-oauth2",
    base = file("."),
    settings = baseSettings ++ buildSettings ++ publishSettings)
}
