package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariableStorage;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.ByteTriggerRuntime;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapBTVariableStorage extends BTVariableStorage {
    private ConcurrentHashMap<String, ConcurrentHashMap<String, BTVariable>> value;

    public ConcurrentHashMapBTVariableStorage(String id, ByteTriggerRuntime runtime) {
        super(id, runtime);
    }

    private ConcurrentHashMap<String, BTVariable> getMinor(String major) {
        ConcurrentHashMap<String, BTVariable> tmp;
        tmp = value.get(major);
        if (tmp == null) {
            tmp = new ConcurrentHashMap<>();
            value.put(major, tmp);
        }
        return tmp;
    }

    private BTVariable getValue(String major, String minor) {
        ConcurrentHashMap<String, BTVariable> minorStorage = getMinor(major);
        BTVariable tmp = minorStorage.get(minor);
        if (tmp == null) {
            tmp = runtime.getVariableFactory().create();
            minorStorage.put(minor, tmp);
        }
        return tmp;
    }

    @Override
    public BTVariable get(String major, String minor) {
        return getValue(major, minor);
    }

    @Override
    public void set(String major, String minor, BTVariable value) {
        getMinor(major).put(minor, value);
    }

    @Override
    public boolean isExist(String major, String minor) {
        return value.containsKey(major) && value.get(major).containsKey(minor);
    }

    @Override
    public Map<String, BTVariable> getAll() {
        ConcurrentHashMap<String, BTVariable> tmp = new ConcurrentHashMap<>();
        value.forEach((s, v) -> v.forEach((ss, vv) -> tmp.put((s + "." + ss), vv)));
        return tmp;
    }
}
