package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler

class CompileException : Exception{
    constructor(message: String):super(message)
    constructor(message: String, throwable: Throwable):super(message, throwable)
}