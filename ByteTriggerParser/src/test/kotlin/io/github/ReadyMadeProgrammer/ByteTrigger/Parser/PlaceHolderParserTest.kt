package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlaceHolderParserTest{
    @Test
    fun Simple() {
        assertEquals(PlaceHolder("PlaceHolder", Argument()), parse("<PlaceHolder>"))
    }

    @Test fun Arguments() {
        val expected = PlaceHolder("PlaceHolder1",
                Argument(Constant("arg1"), Constant(false), Constant(-402)))
        val actual = parse("<PlaceHolder1:arg1:false:-402>")
        assertEquals(expected, actual)
    }

    @Test fun Recursive() {
        val expected = PlaceHolder("P1", Argument(PlaceHolder("P2", Argument(Constant(132)))))
        val actual = parse("<P1:<P2:132>>")
        assertEquals(expected, actual)
    }

    @Test fun WhiteSpace() {
        val expected = PlaceHolder("P1", Argument(Constant("Str "),Constant(13)))
        val actual = parse("<P1:Str :13>")
        assertEquals(expected, actual)
    }
    fun parse(code: String) = createParserPool().placeHolderParser.parse(codeOf(code),setOf())
}