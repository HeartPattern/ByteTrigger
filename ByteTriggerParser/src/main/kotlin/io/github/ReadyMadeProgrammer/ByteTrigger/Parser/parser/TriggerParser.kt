package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*

class TriggerParser(parserPool: ParserPool):Parser<Trigger>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Trigger {
        val attribute = mutableMapOf<String,String>()
        outer@while(code.lineNumber<=code.end.line){
            val line = code.line.trim()
            if(line.isBlank()){
                code.lineNumber++
                continue
            }
            when(line[0]){
                '!'->{
                    val (name,data) = cutAndTrim(line.substring(1),' ')
                    if(name.isBlank()) throw ParseException(code,message = message("attribute.name"))
                    if(attribute.containsKey(name)){
                        warning(message("attribute.overwrite",name))
                    }
                    attribute[name]=data
                }
                '@','>'->break@outer
                else -> throw ParseException(code,message=message("unexpected_token"))
            }
            code.lineNumber++
        }
        val block = parserPool.blockParser.parse(code,setOf())
        return Trigger(attribute,block)
    }
}