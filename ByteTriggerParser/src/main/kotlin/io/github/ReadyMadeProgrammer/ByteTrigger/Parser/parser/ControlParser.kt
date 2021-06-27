package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*

class ControlParser(parserPool: ParserPool):Parser<Control>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Control {
        val line = code.line.substring(code.letterNumber)
        val (script, _) = cutAndTrim(line,' ')
        val endNew = setOf('<')
        return when{
            script.isEmpty()->throw ParseException(code,message=message("control.name"))
            parserPool.customControlParser.containsKey(script)->parserPool.customControlParser[script]!!.parse(code,endNew)
            else->{
                val cuttingLine = line.indexOf(' ')
                code.letterNumber = if(cuttingLine==-1)code.line.length else code.letterNumber+cuttingLine
                val arguments = parserPool.argumentParser.parse(code,setOf())
                code.lineNumber++
                Control(script,arguments,parserPool.blockParser.parse(code,endNew))
            }
        }
    }
}