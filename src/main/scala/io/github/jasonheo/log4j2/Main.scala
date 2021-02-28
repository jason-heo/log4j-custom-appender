package io.github.jasonheo.log4j2

import java.time.Instant

import org.apache.logging.log4j.core.LogEvent
import org.apache.logging.log4j.core.appender.AbstractAppender
import org.apache.logging.log4j.core.config.plugins.PluginFactory
import org.apache.logging.log4j.{LogManager, Logger}

import scala.collection.mutable

// 참고 자료: https://www.baeldung.com/log4j2-custom-appender
// 제대로 안 돌아간다
class MapAppender extends AbstractAppender("MyAppender", null, null) {
  val eventMap: mutable.Map[String, LogEvent] = mutable.Map[String, LogEvent]()

  override def append(event: LogEvent): Unit = {
    eventMap.put(Instant.now().toString(), event)
    println("append() called")
    println(event.getMessage.getFormattedMessage)
  }
}

object MapAppender {
  @PluginFactory
  def createAppender(): MapAppender = {
    return new MapAppender()
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val logger: Logger = LogManager.getLogger(getClass.getName)

    logger.fatal("Test started")
  }
}
