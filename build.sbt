name := "simples-dental"

version := "1.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final",
  "org.dbunit" % "dbunit" % "2.4.9",
  cache,
  javaWs,
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.8.5",
  "org.postgresql" % "postgresql" % "9.4.1208.jre7"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
