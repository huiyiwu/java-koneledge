package com.huchx.annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    String name();
    int leng();
}
