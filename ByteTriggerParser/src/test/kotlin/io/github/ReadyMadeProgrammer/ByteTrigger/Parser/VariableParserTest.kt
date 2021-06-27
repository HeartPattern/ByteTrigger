package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VariableParserTest{
    @Test
    fun simple() {
        val code = "$11.22"
        val expected = Variable(Constant(11), Constant(22))
        assertEquals(expected, parse(code))
    }

    @Test fun recursive() {
        val code = "$\$aa.bb.\$cc.dd"
        val expected = Variable(Variable(Constant("aa"), Constant("bb")), Variable(Constant("cc"), Constant("dd")))
        assertEquals(expected, parse(code))
    }

    @Test fun placeHolder() {
        val code = "$<aa>.<bb>"
        val expected = Variable(PlaceHolder("aa", Argument()), PlaceHolder("bb", Argument()))
        assertEquals(expected, parse(code))
    }
    fun parse(code: String) = createParserPool().variableParser.parse(codeOf(code),setOf())
}