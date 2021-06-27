package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.lib.Execute;

@Execute(event=EmptyEvent.class)
public class EmptyByteTrigger extends AbstractByteTriggerExecutable<EmptyEvent>{
    public EmptyByteTrigger(String id, ByteTriggerRuntime runtime, BTVariableStorage runtimeStorage) {
        super(id, runtime, runtimeStorage);
    }

    public BTVariable execute(EmptyEvent event, BTVariable... arguments) {
        System.out.println("Hello");
        return null;
    }
}
