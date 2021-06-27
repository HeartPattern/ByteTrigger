package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableFactory;

public class CachedBTVariableFactory implements BTVariableFactory {
    @Override
    public BTVariable create() {
        return new CachedBTVariable();
    }
}
