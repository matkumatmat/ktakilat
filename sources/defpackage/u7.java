package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableDoubleUnaryOperator;

/* renamed from: u7  reason: default package */
public abstract /* synthetic */ class u7 {
    public static FailableDoubleUnaryOperator a(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2) {
        Objects.requireNonNull(failableDoubleUnaryOperator2);
        return new t7(failableDoubleUnaryOperator, failableDoubleUnaryOperator2, 1);
    }

    public static FailableDoubleUnaryOperator b(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2) {
        Objects.requireNonNull(failableDoubleUnaryOperator2);
        return new t7(failableDoubleUnaryOperator, failableDoubleUnaryOperator2, 0);
    }

    public static FailableDoubleUnaryOperator e() {
        return new x2(17);
    }

    public static /* synthetic */ double g(double d) {
        return 0.0d;
    }

    public static FailableDoubleUnaryOperator h() {
        return FailableDoubleUnaryOperator.NOP;
    }

    public static /* synthetic */ double f(double d) {
        return d;
    }
}
