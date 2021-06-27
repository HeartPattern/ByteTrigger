package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

import java.util.Map;

public abstract class BTVariableStorage {
    protected ByteTriggerRuntime runtime;
    private String id;

    protected BTVariableStorage(String id, ByteTriggerRuntime runtime) {
        this.runtime = runtime;
        this.id = id;
    }

    public abstract BTVariable get(String major, String minor);

    public abstract void set(String major, String minor, BTVariable value);

    public abstract boolean isExist(String major, String minor);

    public abstract Map<String, BTVariable> getAll();

    public String getString(String major, String minor) {
        return get(major, minor).getString();
    }

    public double getInteger(String major, String minor) {
        return get(major, minor).getInteger();
    }

    public boolean getBoolean(String major, String minor) {
        return get(major, minor).getBoolean();
    }

    public String getId() {
        return id;
    }

    public void set(String major, String minor, String value) {
        if (isExist(major, minor)) {
            get(major, minor).set(value);
        } else {
            set(major, minor, runtime.getVariableFactory().create(value));
        }
    }

    public void set(String major, String minor, int value) {
        if (isExist(major, minor)) {
            get(major, minor).set(value);
        } else {
            set(major, minor, runtime.getVariableFactory().create(value));
        }
    }

    public void set(String major, String minor, boolean value) {
        if (isExist(major, minor)) {
            get(major, minor).set(value);
        } else {
            set(major, minor, runtime.getVariableFactory().create(value));
        }
    }
}
