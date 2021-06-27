package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorage;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorageFactory;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.ByteTriggerRuntime;

public class ConcurrentHashMapBTVariableStorageFactory implements BTVariableStorageFactory {
    @Override
    public BTVariableStorage create(String id, ByteTriggerRuntime runtime) {
        return new ConcurrentHashMapBTVariableStorage(id, runtime);
    }
}
