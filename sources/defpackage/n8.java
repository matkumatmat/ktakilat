package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableLongUnaryOperator;

/* renamed from: n8  reason: default package */
public abstract /* synthetic */ class n8 {
    public static FailableLongUnaryOperator a(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2) {
        Objects.requireNonNull(failableLongUnaryOperator2);
        return new m8(failableLongUnaryOperator, failableLongUnaryOperator2, 0);
    }

    public static FailableLongUnaryOperator b(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2) {
        Objects.requireNonNull(failableLongUnaryOperator2);
        return new m8(failableLongUnaryOperator, failableLongUnaryOperator2, 1);
    }

    public static FailableLongUnaryOperator e() {
        return new g8(5);
    }

    public static /* synthetic */ long g(long j) {
        return 0;
    }

    public static FailableLongUnaryOperator h() {
        return FailableLongUnaryOperator.NOP;
    }

    public static /* synthetic */ long f(long j) {
        return j;
    }
}
