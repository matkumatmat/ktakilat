package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableFunction;

/* renamed from: w7  reason: default package */
public abstract /* synthetic */ class w7 {
    public static FailableFunction a(FailableFunction failableFunction, FailableFunction failableFunction2) {
        Objects.requireNonNull(failableFunction2);
        return new v7(failableFunction, failableFunction2, 1);
    }

    public static FailableFunction b(FailableFunction failableFunction, FailableFunction failableFunction2) {
        Objects.requireNonNull(failableFunction2);
        return new v7(failableFunction, failableFunction2, 0);
    }

    public static FailableFunction e() {
        return new x2(20);
    }

    public static /* synthetic */ Object g(Object obj) {
        return null;
    }

    public static FailableFunction h() {
        return FailableFunction.NOP;
    }

    public static /* synthetic */ Object f(Object obj) {
        return obj;
    }
}
