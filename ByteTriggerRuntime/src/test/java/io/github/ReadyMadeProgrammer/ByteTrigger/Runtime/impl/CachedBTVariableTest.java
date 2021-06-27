package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO: 18. 2. 15 Write whole testcases
class CachedBTVariableTest {

    @Test
    public void intAnd(){
        BTVariable variable = new CachedBTVariable(123);
        assertEquals(true,variable.equals(new CachedBTVariable(123)),"Int<->Int");
        assertEquals(false,variable.equals(new CachedBTVariable(132)),"Int<->Int");
        assertEquals(true,variable.equals(new CachedBTVariable("  123  ")),"Int<->String");
    }
}