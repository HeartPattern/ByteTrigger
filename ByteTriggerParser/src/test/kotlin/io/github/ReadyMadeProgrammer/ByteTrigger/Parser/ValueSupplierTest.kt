package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValueSupplierTest {
    @Test fun complex() {
        val code = "My\\ name\\ is\\ <playername:itself>.\\ And,\\ my\\ age\\ is\\ \\<\\ <!:\$value.value2>."
        val expected = ValueBridge(
                Constant("My name is "),
                PlaceHolder("playername", Argument(Constant("itself"))),
                Constant(". And, my age is < "),
                PlaceHolder("!", Argument(Variable(Constant("value"), Constant("value2")))),
                Constant("."))
        assertEquals(expected, parse(code))
    }
    fun parse(code: String) = createParserPool().valueSupplierParser.parse(codeOf(code),setOf())
}