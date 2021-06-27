package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter

abstract class Compiler<T>(val compilerPool: CompilerPool){
    abstract fun attach(byteCodeWriter: ByteCodeWriter, element: T)
}