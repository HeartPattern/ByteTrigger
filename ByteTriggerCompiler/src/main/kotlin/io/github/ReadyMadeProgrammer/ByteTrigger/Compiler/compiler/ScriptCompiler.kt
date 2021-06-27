package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Method
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompileException
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.message
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Script

class ScriptCompiler(compilerPool: CompilerPool): Compiler<Script>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: Script) {
        val sc = compilerPool.scripts[element.name]?:throw CompileException(message("script.not_exists",element.name))
        element.argument.values.forEach{
            compilerPool.valueSupplierCompiler.attach(byteCodeWriter,it)
        }
        byteCodeWriter.write{
            invokestatic(Method(sc))
        }
    }
}