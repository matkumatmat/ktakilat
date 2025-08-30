package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableLongPredicate;

/* renamed from: j8  reason: default package */
public abstract /* synthetic */ class j8 {
    public static FailableLongPredicate a(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2) {
        Objects.requireNonNull(failableLongPredicate2);
        return new i8(failableLongPredicate, failableLongPredicate2, 0);
    }

    public static FailableLongPredicate b(FailableLongPredicate failableLongPredicate) {
        return new k0(failableLongPredicate, 22);
    }

    public static FailableLongPredicate c(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2) {
        Objects.requireNonNull(failableLongPredicate2);
        return new i8(failableLongPredicate, failableLongPredicate2, 1);
    }

    public static /* synthetic */ boolean d(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2, long j) {
        if (!failableLongPredicate.test(j) || !failableLongPredicate2.test(j)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(FailableLongPredicate failableLongPredicate, long j) {
        return !failableLongPredicate.test(j);
    }

    public static /* synthetic */ boolean f(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2, long j) {
        if (failableLongPredicate.test(j) || failableLongPredicate2.test(j)) {
            return true;
        }
        return false;
    }

    public static FailableLongPredicate g() {
        return FailableLongPredicate.FALSE;
    }

    public static /* synthetic */ boolean h(long j) {
        return false;
    }

    public static /* synthetic */ boolean i(long j) {
        return true;
    }

    public static FailableLongPredicate j() {
        return FailableLongPredicate.TRUE;
    }
}
