package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.ByteCodeWriter
import io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Method
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.AbstractByteTriggerExecutable
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorage
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.ByteTriggerRuntime
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type

class BTClassWriter(event:Class<*>,source:String){
    val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES)
    val execute: MethodVisitor
    val executeWriter: ByteCodeWriter
    var blockCount = 0
    init{
        val eventName = Type.getInternalName(event)
        classWriter.visit(V1_8,ACC_PUBLIC+ACC_SUPER,source,"Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/AbstractByteTriggerExecutable<L$eventName;>;","io/github/ReadyMadeProgrammer/ByteTrigger/Common/AbstractByteTriggerExecutable",null)
        classWriter.visitSource(source,null)
        val annotationVisitor = classWriter.visitAnnotation("Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/lib/Execute;",true)
        annotationVisitor.visit("event",Type.getType("L$eventName;"))
        annotationVisitor.visitEnd()
        val constructor = classWriter.visitMethod(ACC_PUBLIC,"<init>","(Ljava/lang/String;Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/ByteTriggerRuntime;Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariableStorage;)V",null,null)
        val constructorWriter = ByteCodeWriter(classWriter, constructor)
        constructorWriter.write{
            aload(0)
            aload(1)
            aload(2)
            aload(3)
            invokespecial(Method(AbstractByteTriggerExecutable::class.java.getDeclaredConstructor(java.lang.String::class.java, ByteTriggerRuntime::class.java,BTVariableStorage::class.java)))
            Return
        }
        val bridge = classWriter.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "execute", "(Ljava/lang/Object;[Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;)Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;", null, null)
        val bridgeWriter = ByteCodeWriter(classWriter,bridge)
        bridgeWriter.write{
            aload(0)
            aload(1)
            checkcast(io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator.Type(event))
            aload(2)
            invokevirtual(Method(source,"execute","(L$eventName;[Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;)Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;",false))
            areturn
        }
        execute = classWriter.visitMethod(ACC_PUBLIC+ACC_VARARGS,"execute","(L$eventName;[Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;)Lio/github/ReadyMadeProgrammer/ByteTrigger/Common/BTVariable;", null, null)
        executeWriter = ByteCodeWriter(classWriter,execute)
    }
}