package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import java.util.logging.Logger

private object LoggerContainer{
    val logger = Logger.getLogger("Parser")
}

fun info(message: String){
    LoggerContainer.logger.info(message)
}
fun warning(message: String){
    LoggerContainer.logger.warning(message)
}
fun severe(message: String){
    LoggerContainer.logger.severe(message)
}