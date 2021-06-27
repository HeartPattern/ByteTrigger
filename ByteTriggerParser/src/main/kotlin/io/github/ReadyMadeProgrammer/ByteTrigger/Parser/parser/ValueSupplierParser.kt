package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Constant
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.ValueBridge
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.ValueSupplier

class ValueSupplierParser(parserPool: ParserPool):Parser<ValueSupplier>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): ValueSupplier {
        if(code.char=='$'){ //Treat variable separately. Do not allow variable in constants.
            return parserPool.variableParser.parse(code,end)
        }
        val values = mutableListOf<ValueSupplier>()
        val newEnd = mutableSetOf('<')
        newEnd+=end
        while((!code.over)&&(!end.contains(code.char))) {
            values += if(code.char=='<'){
                parserPool.placeHolderParser.parse(code,newEnd)
            } else{
                parserPool.constantParser.parse(code,newEnd)
            }
        }
        //ValueBridge Optimizing
        return when(values.size){
            0->Constant()
            1->values[0]
            else->ValueBridge(values.toList())
        }
    }
}