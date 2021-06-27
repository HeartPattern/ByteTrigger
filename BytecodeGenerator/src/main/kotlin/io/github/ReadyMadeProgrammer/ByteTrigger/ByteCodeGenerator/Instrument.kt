//package io.github.ReadyMadeProgrammer.ByteTrigger.ByteCodeGenerator
//
//import org.objectweb.asm.ClassWriter
//
//sealed class ByteCode
//sealed class Insn : ByteCode()
//
//class AALOAD: ByteCode()
//class AASTORE: ByteCode()
//class ACONST_NULL: ByteCode()
//data class ALOAD(val index: Int) : ByteCode()
//class ALOAD_0: ByteCode()
//class ALOAD_1: ByteCode()
//class ALOAD_2: ByteCode()
//class ALOAD_3: ByteCode()
//data class ANEWARRAY(val index: Int) : ByteCode()
//class ARETURN: ByteCode()
//class ARRAYLENGTH: ByteCode()
//data class ASTORE(val index: Int) : ByteCode()
//class ASTORE_0: ByteCode()
//class ASTORE_1: ByteCode()
//class ASTORE_2: ByteCode()
//class ASTORE_3: ByteCode()
//class ATHROW: ByteCode()
//class BALOAD: ByteCode()
//class BASTORE: ByteCode()
//data class BISPUSH(val byte: Int) : ByteCode()
//class CALOAD : ByteCode()
//class CASTORE : ByteCode()
//data class CHECKCAST(val index: Int) : ByteCode()
//class D2F : ByteCode()
//class D2I : ByteCode()
//class D2L : ByteCode()
//class DADD : ByteCode()
//class DALOAD : ByteCode()
//class DASTORE : ByteCode()
//class DCMPG : ByteCode()
//class DCMPL : ByteCode()
//class DCONST_0 : ByteCode()
//class DCONST_1 : ByteCode()
//class DDIV : ByteCode()
//data class DLOAD(val index: Int) : ByteCode()
//class DLOAD_0 : ByteCode()
//class DLOAD_1 : ByteCode()
//class DLOAD_2 : ByteCode()
//class DLOAD_3 : ByteCode()
//class DMUL : ByteCode()
//class DNEG : ByteCode()
//class DREM : ByteCode()
//class DRETURN : ByteCode()
//data class DSTORE(val index: Int) : ByteCode()
//class DSTORE_0 : ByteCode()
//class DSTORE_1 : ByteCode()
//class DSTORE_2 : ByteCode()
//class DSTORE_3 : ByteCode()
//class DSUB : ByteCode()
//class DUP : ByteCode()
//class DUP_X1 : ByteCode()
//class DUP_X2 : ByteCode()
//class DUP2 : ByteCode()
//class DUP2_X1 : ByteCode()
//class DUP2_X2 : ByteCode()
//class F2D : ByteCode()
//class F2I : ByteCode()
//class F2L : ByteCode()
//class FADD : ByteCode()
//class FALOAD : ByteCode()
//class FASTORE : ByteCode()
//class FCMPG : ByteCode()
//class FCMPL : ByteCode()
//class FCONST_0 : ByteCode()
//class FCONST_1 : ByteCode()
//class FCONST_2 : ByteCode()
//class FDIV : ByteCode()
//data class FLOAD(val index: Int) : ByteCode()
//class FLOAD_0 : ByteCode()
//class FLOAD_1 : ByteCode()
//class FLOAD_2 : ByteCode()
//class FLOAD_3 : ByteCode()
//class FMUL : ByteCode()
//class FNEG : ByteCode()
//class FREM : ByteCode()
//class FRETURN : ByteCode()
//data class FSTORE(val index: Int) : ByteCode()
//class FSTORE_0 : ByteCode()
//class FSTORE_1 : ByteCode()
//class FSTORE_2 : ByteCode()
//class FSTORE_3 : ByteCode()
//class FSUB : ByteCode()
//data class GETFIELD(val index: Int) : ByteCode()
//data class GETSTATIC(val index: Int) : ByteCode()
//data class GOTO(val index: Int) : ByteCode()
//data class GOTO_W(val index: Int) : ByteCode()
//class I2B : ByteCode()
//class I2C : ByteCode()
//class I2D : ByteCode()
//class I2F : ByteCode()
//class I2L : ByteCode()
//class I2S : ByteCode()
//class IADD : ByteCode()
//class IALOAD : ByteCode()
//class IAND: ByteCode()
//class IASTORE: ByteCode()
//class ICONST_M1: ByteCode()
//class ICONST_0: ByteCode()
//class ICONST_1: ByteCode()
//class ICONST_2: ByteCode()
//class ICONST_3: ByteCode()
//class ICONST_4: ByteCode()
//class ICONST_5: ByteCode()
//class IDIV: ByteCode()
//data class IF_ACMPEQ(val branch: Int) : ByteCode()
//data class IF_ACMPNE(val branch: Int) : ByteCode()
//data class IF_ICMPEQ(val branch: Int) : ByteCode()
//data class IF_ICMPNE(val branch: Int) : ByteCode()
//data class IF_ICMPLT(val branch: Int) : ByteCode()
//data class IF_ICMPGE(val branch: Int) : ByteCode()
//data class IF_ICMPGT(val branch: Int) : ByteCode()
//data class IF_ICMPLE(val branch: Int) : ByteCode()
//data class IFEQ(val branch:Int):ByteCode()
//data class IFNE(val branch:Int):ByteCode()
//data class IFLT(val branch:Int):ByteCode()
//data class IFGE(val branch:Int):ByteCode()
//data class IFGT(val branch:Int):ByteCode()
//data class IFLE(val branch:Int):ByteCode()
//data class IFNONNULL(val branch:Int):ByteCode()
//data class IFNULL(val branch:Int):ByteCode()
//data class IINC(val index:Int, val const: Int):ByteCode()
//data class ILOAD(val index:Int):ByteCode()
//class ILOAD_0(val index:Int):ByteCode()
//class ILOAD_1(val index:Int):ByteCode()
//class ILOAD_2(val index:Int):ByteCode()
//class ILOAD_3(val index:Int):ByteCode()
//class IMUL:ByteCode()
//class INEG:ByteCode()
//data class INSTANCEOF(val index:Int):ByteCode()
//data class INVOKEDYNAMIC(val index:Int):ByteCode()
//data class INVOKEINTERFACE(val index:Int, val count:Int)
//data class INVOKESPECIAL(val index:Int):ByteCode()
//data class INVOKESTATIC(val index:Int):ByteCode()
//data class INVOKEVIRTUAL(val index:Int):ByteCode()
//class IOR(val index:Int):ByteCode()
//class IREM(val index:Int):ByteCode()
//class IRETURN(val index:Int):ByteCode()
//class ISHL(val index:Int):ByteCode()
//class ISHR(val index:Int):ByteCode()
//data class ISTORE(val index:Int):ByteCode()
//class ISTORE_0:ByteCode()
//class ISTORE_1:ByteCode()
//class ISTORE_2:ByteCode()
//class ISTORE_3:ByteCode()
//class ISUB:ByteCode()
//class IUSHR:ByteCode()
//class IXOR:ByteCode()
//data class JSR(val branch:Int):ByteCode()
//data class JSR_W(val branch:Int):ByteCode()
//class L2D:ByteCode()
//class L2F:ByteCode()
//class L2I:ByteCode()
//class LADD:ByteCode()
//class LALOAD:ByteCode()
//class LAND:ByteCode()
//class LASTORE:ByteCode()
//class LCMP:ByteCode()
//class LCONST_0:ByteCode()
//class LCONST_1:ByteCode()
//class LDC(val index:Int):ByteCode()
//class LDC_W(val index:Int):ByteCode()
//class LDC2_W(val index:Int):ByteCode()
//class LDIV:ByteCode()
//class LLOAD(val index:Int):ByteCode()
//class LLOAD_0:ByteCode()
//class LLOAD_1:ByteCode()
//class LLOAD_2:ByteCode()
//class LLOAD_3:ByteCode()
//class LMUL:ByteCode()
//class LNEG:ByteCode()
////class LOOKUPSWITCH()
//class LOR:ByteCode()
//class LREM:ByteCode()
//class LRETURN:ByteCode()
//class LSHL:ByteCode()
//class LSHR:ByteCode()
//class LSTORE(val index:Int):ByteCode()
//class LSTORE_0:ByteCode()
//class LSTORE_1:ByteCode()
//class LSTORE_2:ByteCode()
//class LSTORE_3:ByteCode()
//class LSUB:ByteCode()
//class LUSHR:ByteCode()
//class LXOR:ByteCode()
//class MONITORENTER:ByteCode()
//class MONITOREXIT:ByteCode()
//class MULTIANEWARRAY:ByteCode()
//class NEW:ByteCode()
//class NEWARRAY(val atype:Int):ByteCode()
//class NOP:ByteCode()
//class POP:ByteCode()
//class POP2:ByteCode()
//class PUTFIELD(val index:Int):ByteCode()
//class PUTSTATIC(val index:Int):ByteCode()
//class RET(val index:Int):ByteCode()
//class RETURN:ByteCode()
//class SALOAD:ByteCode()
//class SASTORE:ByteCode()
//class SIPUSH(val short:Short):ByteCode()
//class SWAP:ByteCode()
////class TABLESWITCH
////class WIDE