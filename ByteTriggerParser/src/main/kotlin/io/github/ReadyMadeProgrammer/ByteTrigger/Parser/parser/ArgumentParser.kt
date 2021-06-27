package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Argument
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.ValueSupplier

class ArgumentParser(parserPool: ParserPool):Parser<Argument>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Argument {
        val arguments = mutableListOf<ValueSupplier>()
        while(code.letterNumber<code.line.length){
            if(code.char==' '){
                code.letterNumber++
            }
            else{
                arguments+=parserPool.valueSupplierParser.parse(code,setOf(' '))
            }
        }
        return Argument(arguments.toList())
    }
}