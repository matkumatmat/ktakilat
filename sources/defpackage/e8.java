package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableIntUnaryOperator;

/* renamed from: e8  reason: default package */
public abstract /* synthetic */ class e8 {
    public static FailableIntUnaryOperator a(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2) {
        Objects.requireNonNull(failableIntUnaryOperator2);
        return new d8(failableIntUnaryOperator, failableIntUnaryOperator2, 1);
    }

    public static FailableIntUnaryOperator b(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2) {
        Objects.requireNonNull(failableIntUnaryOperator2);
        return new d8(failableIntUnaryOperator, failableIntUnaryOperator2, 0);
    }

    public static FailableIntUnaryOperator e() {
        return new x2(28);
    }

    public static /* synthetic */ int g(int i) {
        return 0;
    }

    public static FailableIntUnaryOperator h() {
        return FailableIntUnaryOperator.NOP;
    }

    public static /* synthetic */ int f(int i) {
        return i;
    }
}
