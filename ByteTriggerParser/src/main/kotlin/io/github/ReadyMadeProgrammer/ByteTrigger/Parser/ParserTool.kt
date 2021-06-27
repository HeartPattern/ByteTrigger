package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser.*

fun createParserPool(
        customControlParser: Map<String, Parser<Control>> = mapOf(),
        customScriptParser: Map<String, Parser<Script>> = mapOf(),
        customPlaceHolderParser: Map<String, Parser<PlaceHolder>> = mapOf()): ParserPool {
    val parserPool = ParserPool()
    parserPool.setup(
            ArgumentParser(parserPool),
            BlockParser(parserPool),
            ConstantParser(parserPool),
            ControlParser(parserPool),
            PlaceHolderParser(parserPool),
            ScriptParser(parserPool),
            TriggerParser(parserPool),
            ValueSupplierParser(parserPool),
            VariableParser(parserPool),
            customControlParser,
            customScriptParser,
            customPlaceHolderParser
    )
    return parserPool
}
fun parse(code: SourceCode, parserPool: ParserPool = createParserPool())
    =parserPool.triggerParser.parse(code,setOf())
fun codeOf(code: String,
                     identifier: String = Thread.currentThread().stackTrace[Thread.currentThread().stackTrace.size-2].methodName
                     )
    =SourceCode(code.split("\n"),identifier)
