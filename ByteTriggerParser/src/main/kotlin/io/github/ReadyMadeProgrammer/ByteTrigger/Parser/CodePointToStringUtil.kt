package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

fun SourceCode.toStringPoint(codePoint: io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint):String = "[$identifier:${codePoint.line+1}:${codePoint.letter+1}]"
fun SourceCode.toStringPoint(line_: Int, letter_: Int):String = "[$identifier:${line_+1}:${letter_+1}]"
fun SourceCode.toStringPoint(line_: Int):String = "[$identifier:${line_+1}]"
fun SourceCode.toStringPoint():String = "[$identifier:${lineNumber+1}:${letterNumber+1}]"
