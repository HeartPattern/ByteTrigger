package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Constant

class ConstantCompiler(compilerPool: CompilerPool): Compiler<Constant>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: Constant) {
        byteCodeWriter.write{
            when(element.value.type){
                BTVariable.Type.NULL, null -> aconst_null
                BTVariable.Type.INT -> autoiload(element.value.integer)
                BTVariable.Type.BOOLEAN -> autobload(element.value.boolean)
                BTVariable.Type.STRING -> ldc(element.value.string)
            }
        }
    }
}