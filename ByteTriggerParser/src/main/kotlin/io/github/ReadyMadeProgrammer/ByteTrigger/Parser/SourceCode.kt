package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

data class SourceCode(
        val code:List<String>,
        val identifier:String,
        val end: io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint = io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(code.size - 1, code[code.size - 1].length),
        var current: io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint = io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(0, 0)){
    var lineNumber: Int
        get()=current.line
        set(value){
            current = io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(value, letterNumber)
        }
    var letterNumber: Int
        get()=current.letter
        set(value){
            current = io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(lineNumber, value)
        }
    val char: Char
        get()=code[lineNumber][letterNumber]
    val line: String
        get()=code[lineNumber]
    val over: Boolean
        get()=lineNumber>end.line||letterNumber>=line.length
}