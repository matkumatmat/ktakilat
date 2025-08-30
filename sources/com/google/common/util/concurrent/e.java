package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {
    public final /* synthetic */ Method c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object[] e;

    public /* synthetic */ e(Method method, Object obj, Object[] objArr) {
        this.c = method;
        this.d = obj;
        this.e = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(this.c, this.d, this.e);
    }
}
