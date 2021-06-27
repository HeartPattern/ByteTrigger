package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Method
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Type
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompileException
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.Compiler
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.CompilerPool
import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.message
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.PlaceHolder
import java.util.ArrayList

class PlaceHolderCompiler(compilerPool: CompilerPool):Compiler<PlaceHolder>(compilerPool){
    override fun attach(byteCodeWriter: ByteCodeWriter, element: PlaceHolder) {
        val ph = compilerPool.placeHolders[element.name] ?: throw CompileException(message("placeholder.not_exists",element.name))
        byteCodeWriter.write{
            new(Type(ArrayList::class.java))
            dup
            invokespecial(Method(ArrayList::class.java.getDeclaredConstructor()))
            for(v in element.argument.values){
                dup
                compilerPool.valueSupplierCompiler.attach(byteCodeWriter,v)
            }
            invokestatic(Method(ph))
        }
    }
}