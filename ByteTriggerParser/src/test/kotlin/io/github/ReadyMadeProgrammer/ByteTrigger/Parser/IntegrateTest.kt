package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*
import org.junit.jupiter.api.Test

class IntegrateTest{
    @Test fun integrateTest(){
        val code = """
            |!Event Start
            |!Author HeartPattern
            |!Event End
            |@SET ${'$'}Data.INPUT <readall:INPUT.TXT>
            |@SET ${'$'}local.i 0
            |>ForEach ${'$'}local.char ${'$'}Data.INPUT
            |   @PRINTLN ${'$'}Data.INPUT
            |   >LOOP ${'$'}local.i
            |       @PRINT <space:1>
            |   <
            |   @PRINT ${'$'}local.char
            |   @PRINTLN
            |<
            |@CLOSE INPUT.TXT
            |@EXIT
            """.trimMargin()
        val expected = Trigger(mapOf("event" to "End", "Author" to "HeartPattern"),
                Block(listOf(
                        Line(4,Script("READ", Argument(Constant("INPUT.TXT"),Variable(Constant("Data"),Constant("INPUT")))))
                )))
    }
}