package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Script
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.cutAndTrim

class ScriptParser(parserPool: ParserPool):Parser<Script>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Script {
        val line = code.line.substring(code.letterNumber)
        val (name, _) = cutAndTrim(line,' ')
        if(parserPool.customScriptParser.containsKey(name)){
            return parserPool.customScriptParser[name]!!.parse(code,setOf())
        }
        val cuttingLine = line.indexOf(' ')
        if(cuttingLine==-1){
            code.letterNumber = code.line.length
        }
        else{
            code.letterNumber += cuttingLine
        }
        val arguments = parserPool.argumentParser.parse(code,setOf())
        code.lineNumber++
        return Script(name,arguments)
    }
}