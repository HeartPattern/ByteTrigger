package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Field
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Method
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.AbstractByteTriggerExecutable
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorage
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Variable

class VariableCompiler(compilerPool: CompilerPool):Compiler<Variable>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: Variable) {
        byteCodeWriter.write{
            getfield(Field(AbstractByteTriggerExecutable::class.java.getDeclaredField("runtimeStorage")))
            ldc(element.major)
            ldc(element.minor)
            invokevirtual(Method(BTVariableStorage::class.java.getDeclaredMethod("get")))
        }
    }
}