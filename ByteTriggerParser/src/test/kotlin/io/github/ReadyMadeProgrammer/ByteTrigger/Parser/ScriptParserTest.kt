package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.SourceCode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScriptParserTest{
    @Test
    fun noArgument() {
        var code = "@STOP"
        val expected = Script("STOP", Argument())
        assertEquals(expected, parse(code))
        code = " @STOP"
        assertEquals(expected, parse(code))
    }

    @Test fun argument() {
        var code = "@STOP now"
        var expected = Script("STOP", Argument(Constant("now")))
        assertEquals(expected, parse(code))
        code = "  @STOP 132 s"
        expected = Script("STOP", Argument(Constant(132), Constant("s")))
        assertEquals(expected, parse(code))
    }
    fun parse(code: String) = createParserPool().scriptParser.parse(SourceCode(code.split("\n"),"",current= io.github.ReadyMadeProgrammer.ByteTrigger.Parser.CodePoint(0, code.indexOf("@") + 1)),setOf())
}