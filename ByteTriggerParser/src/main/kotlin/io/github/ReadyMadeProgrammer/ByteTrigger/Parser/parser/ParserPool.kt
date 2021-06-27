package io.github.ReadyMadeProgrammer.ByteTrigger.Parser.parser

import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Control
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.PlaceHolder
import io.github.ReadyMadeProgrammer.ByteTrigger.Parser.Script

class ParserPool {
    lateinit var argumentParser: ArgumentParser
    lateinit var blockParser: BlockParser
    lateinit var constantParser: ConstantParser
    lateinit var controlParser: ControlParser
    lateinit var placeHolderParser: PlaceHolderParser
    lateinit var scriptParser: ScriptParser
    lateinit var triggerParser: TriggerParser
    lateinit var valueSupplierParser: ValueSupplierParser
    lateinit var variableParser: VariableParser
    lateinit var customControlParser: Map<String,Parser<Control>>
    lateinit var customScriptParser: Map<String,Parser<Script>>
    lateinit var customPlaceHolderParser: Map<String,Parser<PlaceHolder>>
    fun setup(
            argumentParser: ArgumentParser,
            blockParser: BlockParser,
            constantParser: ConstantParser,
            controlParser: ControlParser,
            placeHolderParser: PlaceHolderParser,
            scriptParser: ScriptParser,
            triggerParser: TriggerParser,
            valueSupplierParser: ValueSupplierParser,
            variableParser: VariableParser,
            customControlParser: Map<String,Parser<Control>>,
            customScriptParser: Map<String,Parser<Script>>,
            customPlaceHolderParser: Map<String,Parser<PlaceHolder>>
    ){
        this.argumentParser = argumentParser
        this.blockParser = blockParser
        this.constantParser = constantParser
        this.controlParser = controlParser
        this.placeHolderParser = placeHolderParser
        this.scriptParser = scriptParser
        this.triggerParser = triggerParser
        this.valueSupplierParser = valueSupplierParser
        this.variableParser = variableParser
        this.customControlParser = customControlParser
        this.customScriptParser = customScriptParser
        this.customPlaceHolderParser = customPlaceHolderParser
    }
}