package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Constant
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.codeOf
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.createParserPool
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstantParserTest{
    @Test fun stringEndWithSpace(){
        assertEquals(Constant("2a132be0"), parse("2a132be0 oijdoi1j0idjo oasijdoaijd0    aoidjoaijw",setOf(' ')))
        assertEquals(Constant("a4124"), parse("a4124   joidjqowd 101923 oidq",setOf(' ')))
    }
    @Test fun intEndWithSpace(){
        assertEquals(Constant(1423),parse("1423 k0d1-2 p12-00o odkpoqd",setOf(' ')))
        assertEquals(Constant(),parse("  142331 13 akdok 1234 a",setOf(' ')))
    }
    @Test fun booleanEndWithSpace(){
        assertEquals(Constant(true),parse("true false true 142 afapodkp",setOf(' ')))
        assertEquals(Constant(false),parse("false false true true 1152123 apsodk",setOf(' ')))
    }
    @Test fun stringEndWithColon(){
        assertEquals(Constant("a b c    d e f 1  34   true"),parse("a b c    d e f 1  34   true:oiedjoi:oiwejdoiqj:false:true:13",setOf(':')))
        assertEquals(Constant(),parse(":::",setOf(':')))
        assertEquals(Constant("   a 1 true"),parse("   a 1 true:asd:   aspdoik:",setOf(':')))
        assertEquals(Constant("   true a  "),parse("   true a  :",setOf(':')))
    }
    @Test fun booleanEndWithColon(){
        assertEquals(Constant(true),parse("   true  : oiajsd : asd12314:",setOf(':')))
        assertEquals(Constant(false),parse("false:ads:  124: ",setOf(':')))
    }
    @Test fun intEndWithColon(){
        assertEquals(Constant(1234),parse("   1234    :a:g:",setOf(':')))
        assertEquals(Constant(123444),parse("123444",setOf(':')))
    }
    @Test fun stringEndWithQuote(){
        assertEquals(Constant("hello world!"),parse("hello world!\"",setOf('"')))
        assertEquals(Constant("\"I'm not a shit\""),parse("\\\"I'm not a shit\\\"\"",setOf('"')))
    }
    fun parse(code: String, set:Set<Char>) = createParserPool().constantParser.parse(codeOf(code),set)
}