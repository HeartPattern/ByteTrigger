package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

class ParseException(val code: SourceCode, val point: io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint = code.current, message: String?=null, cause: Throwable?=null):RuntimeException(message,cause)