package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*

class BlockParser(parserPool: ParserPool):Parser<Block>(parserPool){
    override fun parse(code: SourceCode, end: Set<Char>): Block {
        val parsedCode = mutableListOf<Line>()
        while(code.lineNumber<=code.end.line&&!end.contains(code.line.trim()[0])){ //Check end of file and end char
            val line = code.line.trim() //Trimed line
            if(line.isBlank()||line[0]=='#'){ //Check comment or empty line
                code.lineNumber++
                continue
            }
            when (line[0]) {
                '@' -> {
                    code.letterNumber = code.line.indexOf('@') + 1
                    parsedCode += Line(code.lineNumber, parserPool.scriptParser.parse(code, setOf()))
                }
                '>' -> {
                    code.letterNumber = code.line.indexOf('>') + 1
                    parsedCode += Line(code.lineNumber, parserPool.controlParser.parse(code, setOf()))
                }
                else -> {
                    throw ParseException(code, message = message("unexpected_token"))
                }
            }

        }
        code.lineNumber++
        return Block(parsedCode.toList())
    }
}
