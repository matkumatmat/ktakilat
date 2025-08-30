package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableFunction;

/* renamed from: j7  reason: default package */
public abstract /* synthetic */ class j7 {
    public static FailableBiFunction a(FailableBiFunction failableBiFunction, FailableFunction failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new t2(12, failableBiFunction, failableFunction);
    }

    public static /* synthetic */ Object c(Object obj, Object obj2) {
        return null;
    }

    public static FailableBiFunction d() {
        return FailableBiFunction.NOP;
    }
}
