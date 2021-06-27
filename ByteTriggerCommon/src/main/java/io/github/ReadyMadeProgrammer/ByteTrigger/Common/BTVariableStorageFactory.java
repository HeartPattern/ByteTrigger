package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

public interface BTVariableStorageFactory {
    BTVariableStorage create(String id, ByteTriggerRuntime runtime);
}
