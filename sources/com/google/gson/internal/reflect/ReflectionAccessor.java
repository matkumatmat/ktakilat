package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        ReflectionAccessor reflectionAccessor;
        if (JavaVersion.getMajorJavaVersion() < 9) {
            reflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            reflectionAccessor = new UnsafeReflectionAccessor();
        }
        instance = reflectionAccessor;
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
