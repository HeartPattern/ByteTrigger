package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler

import io.github.ReadyMadeProgrammer.ByteTrigger.Compiler.compiler.*
import java.lang.reflect.Method

class CompilerPool(
        val placeHolders: Map<String,Method>,
        val scripts: Map<String,Method>,
        val valueSupplierCompiler: ValueSupplierCompiler,
        val constantCompiler: ConstantCompiler,
        val variableCompiler: VariableCompiler,
        val placeHolderCompiler: PlaceHolderCompiler,
        val valueBridgeCompiler: ValueBridgeCompiler
)