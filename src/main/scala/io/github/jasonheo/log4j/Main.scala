package io.github.jasonheo.log4j

import org.apache.log4j.{AppenderSkeleton, Logger}
import org.apache.log4j.spi.LoggingEvent

// https://gist.github.com/kengelke/4664612
class MyAppender extends AppenderSkeleton {
  override def append(event: LoggingEvent): Unit = {
    println(s"[${event.getLevel}][${event.timeStamp}] ${event.getMessage.toString}")

    if (event.getThrowableInformation != null) {
      event.getThrowableInformation.getThrowable.printStackTrace()
    }
  }

  override def close(): Unit = {

  }

  override def requiresLayout(): Boolean = {
    false
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val logger: Logger = Logger.getLogger(getClass.getName)

    logger.info("hello info")
    logger.debug("hello debug")
    logger.warn("hello warn")

    try {
      throw new IllegalStateException("exception thrown")
    }
    catch {
      case e: Throwable => {
        logger.error("hello exception", e)
      }
    }
  }
}
