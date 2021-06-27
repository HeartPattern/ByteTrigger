package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

public abstract class AbstractByteTriggerExecutable<E> implements ByteTriggerExecutable<E>{
    protected String id;
    protected ByteTriggerRuntime runtime;
    protected BTVariableStorage runtimeStorage;
    protected Class<E> event;

    public AbstractByteTriggerExecutable(String id, ByteTriggerRuntime runtime, BTVariableStorage runtimeStorage) {
        this.id = id;
        this.runtime = runtime;
        this.runtimeStorage = runtimeStorage;
    }
}
