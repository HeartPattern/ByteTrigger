package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

public interface BTVariableFactory {
    BTVariable create();

    default BTVariable create(String value) {
        BTVariable var = create();
        var.set(value);
        return var;
    }

    default BTVariable create(int value) {
        BTVariable var = create();
        var.set(value);
        return var;
    }

    default BTVariable create(boolean value) {
        BTVariable var = create();
        var.set(value);
        return var;
    }

    default BTVariable create(BTVariable value) {
        BTVariable var = create();
        switch (value.getType()) {
            case STRING:
                var.set(value.getString());
            case INT:
                var.set(value.getInteger());
            case BOOLEAN:
                var.set(value.getBoolean());
        }
        return var;
    }
}
