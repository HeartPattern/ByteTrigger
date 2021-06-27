package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*

class PlaceHolderParser(parserPool: ParserPool):Parser<PlaceHolder>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): PlaceHolder {
        if(code.char!='<') throw ParseException(code,message=message("placeholder.start"))
        code.letterNumber++
        val builder = StringBuilder()
        while(code.char!=':'&&code.char!='>'){
            builder.append(code.char)
            code.letterNumber++
        }
        val name =  builder.toString()
        val arguments = mutableListOf<ValueSupplier>()
        val endNew = setOf(':','>')
        while(code.char!='>'){
            code.letterNumber++
            arguments.add(parserPool.valueSupplierParser.parse(code,endNew))
        }
        code.letterNumber++
        return PlaceHolder(name,Argument(arguments.toList()))
    }

}
