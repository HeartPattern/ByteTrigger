package io.github.ReadyMadeProgrammer.ByteTrigger.Common.lib;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Execute {
    Class<?> event();
}
