package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable
import io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl.CachedBTVariable

data class Argument(val values: List<ValueSupplier>){
    constructor(vararg value: ValueSupplier):this(listOf(*value))
}

data class Block(val codes: List<Line> = listOf())

data class Trigger(val attribute:Map<String,String>, val code: Block)

/*
 * Code Lines
 */
sealed class CodeLine

data class Control(val name: String, val argument: Argument, val block: Block):CodeLine()

data class Script(val name: String, val argument: Argument):CodeLine()


/*
 * Value Suppliers
 */
sealed class ValueSupplier

data class ValueBridge(val values: List<ValueSupplier>):ValueSupplier(){
    constructor(vararg value:ValueSupplier):this(listOf(*value))
}

data class Variable(val major:ValueSupplier, val minor:ValueSupplier):ValueSupplier()

data class PlaceHolder(val name: String, val argument: Argument):ValueSupplier()

data class Constant(val value: BTVariable):ValueSupplier(){
    constructor(value: String):this(CachedBTVariable(value))
    constructor(value: Int):this(CachedBTVariable(value))
    constructor(value: Boolean):this(CachedBTVariable(value))
    constructor():this(CachedBTVariable())
}