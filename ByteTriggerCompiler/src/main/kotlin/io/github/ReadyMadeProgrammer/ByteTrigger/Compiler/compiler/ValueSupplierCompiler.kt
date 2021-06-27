package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.*

class ValueSupplierCompiler(compilerPool: CompilerPool):Compiler<ValueSupplier>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: ValueSupplier) {
        byteCodeWriter.write{
            when(element){
                is Constant -> compilerPool.constantCompiler.attach(byteCodeWriter,element)
                is Variable -> compilerPool.variableCompiler.attach(byteCodeWriter,element)
                is PlaceHolder -> compilerPool.placeHolderCompiler.attach(byteCodeWriter,element)
                is ValueBridge -> compilerPool.valueBridgeCompiler.attach(byteCodeWriter,element)
            }
        }
    }
}