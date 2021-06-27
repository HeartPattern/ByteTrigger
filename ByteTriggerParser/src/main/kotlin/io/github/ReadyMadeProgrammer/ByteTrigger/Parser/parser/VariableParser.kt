package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.ParseException
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Variable
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.message

class VariableParser(parserPool: ParserPool):Parser<Variable>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Variable {
        if(code.char!='$') throw ParseException(code,message = message("variable.start"))
        val endNew = setOf('.')
        code.letterNumber++
        val major = parserPool.valueSupplierParser.parse(code,endNew)
        if(code.char!='.') throw ParseException(code,message = message("variable.split"))
        code.letterNumber++
        val minor = parserPool.valueSupplierParser.parse(code,end)
        return Variable(major,minor)
    }

}
/*
@Override
    public Variable parse(SourceCode code, Set<Character> end) {
        MessageFormat.format("a","b");
        //Check Again
        if(code.getCurrentChar()!='$'){
            throw new IllegalArgumentException(message.get("variable.start"));
        }
        Set<Character> endNew = new HashSet<>();
        endNew.add('.');
        code.getPoint().increaseLetter();
        ValueSupplier major = getParserPool().getValueSupplierParser().parse(code,endNew);
        if(code.getCurrentChar()!='.') throw new ParseException(message.get("variable.split"));
        code.getPoint().increaseLetter();
        ValueSupplier minor = getParserPool().getValueSupplierParser().parse(code,end);
        return new Variable(major,minor);
    }
 */