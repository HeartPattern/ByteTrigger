package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

import io.github.ReadyMadeProgrammer.ByteTrigger.Common.BTVariable;
import io.github.ReadyMadeProgrammer.ByteTrigger.Common.ByteTriggerCastingException;

public class CachedBTVariable implements BTVariable {
    private Type type;
    private String stringValue;
    private Integer intValue;
    private Boolean booleanValue;

    public CachedBTVariable(String value){
        type = Type.STRING;
        booleanValue = null;
        intValue = null;
        stringValue = value;
    }
    public CachedBTVariable(int value){
        type = Type.INT;
        booleanValue = null;
        stringValue = null;
        intValue = value;
    }
    public CachedBTVariable(boolean value){
        type = Type.BOOLEAN;
        stringValue = null;
        intValue = null;
        booleanValue = value;
    }
    public CachedBTVariable(){
        type = Type.NULL;
        stringValue = null;
        intValue = null;
        booleanValue = null;
    }
    @Override
    public String getString() {
        if (stringValue == null) {
            switch (type) {
                case INT:
                    stringValue = intValue.toString();
                    break;
                case BOOLEAN:
                    stringValue = booleanValue.toString();
                    break;
                case NULL:
                    stringValue = "";
            }
        }
        return stringValue;
    }

    @Override
    public int getInteger() {
        if (intValue == null) {
            switch (type) {
                case STRING:
                    try {
                        intValue = Integer.parseInt(stringValue.trim());
                    } catch (Exception e) {
                        if(stringValue.isEmpty()) intValue = 0;
                        else throw new ByteTriggerCastingException(this);
                    }
                    break;
                case BOOLEAN:
                    intValue = booleanValue ? 1 : 0;
                    break;
                case NULL:
                    intValue = 0;
            }
        }
        return intValue;
    }

    @Override
    public boolean getBoolean() {
        if (booleanValue == null) {
            switch (type) {
                case STRING:
                    if (stringValue == null) booleanValue = false;
                    else if (stringValue.trim().equalsIgnoreCase("true")) booleanValue = true;
                    else if (stringValue.trim().equalsIgnoreCase("false")) booleanValue = false;
                    else throw new ByteTriggerCastingException(this);
                    break;
                case INT:
                    booleanValue = intValue != 0;
                    break;
                case NULL:
                    booleanValue = false;
            }
        }
        return booleanValue;
    }

    @Override
    public void set(String value) {
        type = Type.STRING;
        booleanValue = null;
        intValue = null;
        stringValue = value;
    }

    @Override
    public void set(int value) {
        type = Type.INT;
        booleanValue = null;
        stringValue = null;
        intValue = value;
    }

    @Override
    public void set(boolean value) {
        type = Type.BOOLEAN;
        stringValue = null;
        intValue = null;
        booleanValue = value;
    }

    @Override
    public void setNull() {
        type = Type.NULL;
        stringValue = null;
        intValue = null;
        booleanValue = null;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean isNull() {
        return type == Type.NULL || (stringValue == null && booleanValue == null && intValue == null);
    }

    @Override
    public int hashCode(){
        switch (type) {
            case NULL: return 0;
            case INT: return intValue.hashCode();
            case STRING: return stringValue.hashCode();
            case BOOLEAN: return booleanValue.hashCode();
            default: return 0;
        }
    }

    /**
     * Only for debugging
     * @return Information of BTVariable
     */
    @Override
    public String toString(){
        return "{type:"+type+",data:"+getString()+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BTVariable)) return false;

        BTVariable that = (BTVariable) o;
        switch(this.getType()){
            case NULL:
                switch(that.getType()){
                    case NULL:
                        return true;
                    case BOOLEAN:
                        return false;
                    case INT:
                        return false;
                    case STRING:
                        return that.getString().isEmpty();
                }
            case BOOLEAN:
                switch(that.getType()){
                    case NULL:
                        return false;
                    case BOOLEAN:
                        return getBoolean()==that.getBoolean();
                    case INT:
                        return (that.getInteger()!=0)==getBoolean();
                    case STRING:
                        return that.getBoolean()==getBoolean();
                }
            case INT:
                switch(that.getType()){
                    case NULL:
                        return false;
                    case BOOLEAN:
                        return (getInteger()!=0)==that.getBoolean();
                    case INT:
                        return that.getInteger()==getInteger();
                    case STRING:
                        return that.getInteger()==getInteger();
                }
            case STRING:
                switch(that.getType()){
                    case NULL:
                        return getString().isEmpty();
                    case BOOLEAN:
                        return that.getBoolean()==getBoolean();
                    case INT:
                        return that.getInteger()==getInteger();
                    case STRING:
                        return that.getString().equals(getString());
                }
        }
        return that.getString().equals(getString());
    }
}
