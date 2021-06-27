package io.github.ReadyMadeProgrammer.ByteTrigger.Runtime.impl;

public class ConstantBTVariable extends CachedBTVariable{
    public ConstantBTVariable(){
        super();
    }
    public ConstantBTVariable(String value){
        super(value);
    }
    public ConstantBTVariable(int value){
        super(value);
    }
    public ConstantBTVariable(boolean value){
        super(value);
    }

    @Override
    public void set(String value) {
        //Do nothing. It's constant.
    }

    @Override
    public void set(int value) {
        //Do nothing. It's constant.
    }

    @Override
    public void set(boolean value) {
        //Do nothing. It's constant.
    }

    @Override
    public void setNull() {
        //Do nothing. It's constant.
    }
}
