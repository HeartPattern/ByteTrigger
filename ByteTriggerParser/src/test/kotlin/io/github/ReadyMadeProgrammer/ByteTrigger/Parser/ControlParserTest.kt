package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ControlParserTest{
    @Test fun non(){
        val code = """   >Control
            |<""".trimMargin()
        val expected = Control("Control", Argument(), Block())
        assertEquals(expected,parse(code))
    }
    @Test fun simple(){
        val code = """ >Control arg1
            |@Print Hello
        |<""".trimMargin()
        val script = Script("Print",Argument(Constant("Hello")))
        val line = Line(1,script)
        val list = listOf(line)
        val block = Block(list)
        val expected = Control("Control",Argument(Constant("arg1")),block)
        assertEquals(expected,parse(code));
    }
    fun parse(code: String) = createParserPool().controlParser.parse(SourceCode(code.split("\n"),"",current= io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(0, code.indexOf('>') + 1)),setOf())
}