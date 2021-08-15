name := "log4j2-custom-appender"

version := "0.2"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
  "com.lmax" % "disruptor" % "3.4.2"
)
