package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import org.junit.jupiter.api.Test

class Foo(var a:Int){
    var b:Int
        get(){
            println("read")
            return a
        }
        set(value){
            println("write")
            a=value
        }
}

class TestClass{
    @Test fun test(){
        val foo = Foo(3)
        println(foo.b)
        println(foo.a)
        foo.b++
        println(foo.b)
        println(foo.a)
    }
}
