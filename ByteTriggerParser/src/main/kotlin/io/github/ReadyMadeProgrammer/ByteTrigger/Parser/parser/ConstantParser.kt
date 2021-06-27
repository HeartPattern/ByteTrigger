package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Constant
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode

class ConstantParser(parserPool: ParserPool):Parser<Constant>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Constant {
        val builder = StringBuilder()
        outer@while((!code.over)&&(!end.contains(code.char))){
            if(code.char=='\\'){
                code.letterNumber++
                builder.append(code.char)
                code.letterNumber++
            }
            else{
                builder.append(code.char)
                code.letterNumber++
            }
        }
        val result = builder.toString()
        return when{
            result.equals("true",true)->Constant(true)
            result.equals("false",true)->Constant(false)
            else -> {
                val tmp = result.toIntOrNull()
                if(tmp==null) Constant(result) else Constant(tmp)
            }
        }
    }
}