package io.github.ReadyMadeProgrammer.ByteTrigger.Compiler;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.AbstractByteTriggerExecutable;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorage;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.ByteTriggerRuntime;
import io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.EmptyEvent;

public class ByteCodeTest extends AbstractByteTriggerExecutable<EmptyEvent> {
    public ByteCodeTest(String id, ByteTriggerRuntime runtime, BTVariableStorage runtimeStorage) {
        super(id, runtime, runtimeStorage);
    }

    @Override
    public BTVariable execute(EmptyEvent event, BTVariable... arguments) {
        runtimeStorage.get("a","b");
        return null;
    }
}
