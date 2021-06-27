package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

public interface ByteTriggerExecutable<E> {
    BTVariable execute(E event, BTVariable... arguments);
}