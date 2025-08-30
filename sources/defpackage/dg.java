package defpackage;

import java.util.Objects;
import java.util.function.Function;
import org.apache.commons.lang3.function.TriFunction;

/* renamed from: dg  reason: default package */
public abstract /* synthetic */ class dg {
    public static TriFunction a(TriFunction triFunction, Function function) {
        Objects.requireNonNull(function);
        return new t2(29, triFunction, function);
    }
}
