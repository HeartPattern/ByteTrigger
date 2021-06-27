package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode

abstract class Parser<out R>(protected val parserPool: ParserPool) {
    abstract fun parse(code: SourceCode, end: Set<Char>): R
}