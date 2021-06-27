package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Method
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Type
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.ValueBridge

class ValueBridgeCompiler(compilerPool: CompilerPool): Compiler<ValueBridge>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: ValueBridge) {
        byteCodeWriter.write{
            new(Type(StringBuilder::class.java))
            dup
            invokespecial(Method(owner="java/lang/StringBuilder",name="<init>",desc="()V",isInterface=false))
            element.values.forEach{
                compilerPool.valueSupplierCompiler.attach(byteCodeWriter,it)
                invokevirtual(Method(StringBuilder::class.java.getDeclaredMethod("append",Array<String>::class.java)))
            }
            invokevirtual(Method(StringBuilder::class.java.getDeclaredMethod("toString")))
        }
    }
}