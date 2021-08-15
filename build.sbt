name := "log4j2-custom-appender"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.apache.logging.log4j" % "log4j-core" % "2.11.0",
  "log4j" % "log4j" % "1.2.17",
  "com.lmax" % "disruptor" % "3.4.2"
)
