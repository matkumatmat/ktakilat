package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

public final /* synthetic */ class b implements Function {
    public final /* synthetic */ Types.JavaVersion c;

    public /* synthetic */ b(Types.JavaVersion javaVersion) {
        this.c = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.c.typeName((Type) obj);
    }
}
