package io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor

class ByteCodeWriter(val classWriter: ClassWriter, val methodVisitor:MethodVisitor){
    fun write(execute: ByteCodeDSL.()->Unit){
        val dsl = ByteCodeDSL(methodVisitor)
        dsl.execute()
    }
}