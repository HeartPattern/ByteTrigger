package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArgumentParserTest{
    @Test fun argumentParserTest(){
        val code = "ABC\\ DEF\\\\\\H 123 true <place: hold  :er> $<a>.b"
        val expected = Argument(
                Constant("ABC DEF\\H"),
                Constant(123),
                Constant(true),
                PlaceHolder("place",Argument(Constant(" hold  "),Constant("er"))),
                Variable(PlaceHolder("a",Argument()),Constant("b"))
                )
        assertEquals(expected, parse(code))
    }
    fun parse(code: String) = createParserPool().argumentParser.parse(codeOf(code,""),setOf())
}