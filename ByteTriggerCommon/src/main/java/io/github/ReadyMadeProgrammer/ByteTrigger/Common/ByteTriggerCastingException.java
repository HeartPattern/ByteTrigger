package io.github.ReadyMadeProgrammer.ByteTrigger.Common;

public class ByteTriggerCastingException extends RuntimeException {
    private BTVariable variable;

    public ByteTriggerCastingException(BTVariable variable) {
        this.variable = variable;
    }

    public ByteTriggerCastingException(String message, BTVariable variable) {
        super(message);
        this.variable = variable;
    }

    public ByteTriggerCastingException(String message, Throwable cause, BTVariable variable) {
        super(message, cause);
        this.variable = variable;
    }

    public ByteTriggerCastingException(Throwable cause, BTVariable variable) {
        super(cause);
        this.variable = variable;
    }

    public ByteTriggerCastingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BTVariable variable) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.variable = variable;
    }
    public BTVariable getVariable(){
        return variable;
    }
}
