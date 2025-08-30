package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableDoublePredicate;

/* renamed from: q7  reason: default package */
public abstract /* synthetic */ class q7 {
    public static FailableDoublePredicate a(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2) {
        Objects.requireNonNull(failableDoublePredicate2);
        return new p7(failableDoublePredicate, failableDoublePredicate2, 1);
    }

    public static FailableDoublePredicate b(FailableDoublePredicate failableDoublePredicate) {
        return new k0(failableDoublePredicate, 20);
    }

    public static FailableDoublePredicate c(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2) {
        Objects.requireNonNull(failableDoublePredicate2);
        return new p7(failableDoublePredicate, failableDoublePredicate2, 0);
    }

    public static /* synthetic */ boolean d(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2, double d) {
        if (!failableDoublePredicate.test(d) || !failableDoublePredicate2.test(d)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(FailableDoublePredicate failableDoublePredicate, double d) {
        return !failableDoublePredicate.test(d);
    }

    public static /* synthetic */ boolean f(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2, double d) {
        if (failableDoublePredicate.test(d) || failableDoublePredicate2.test(d)) {
            return true;
        }
        return false;
    }

    public static FailableDoublePredicate g() {
        return FailableDoublePredicate.FALSE;
    }

    public static /* synthetic */ boolean h(double d) {
        return false;
    }

    public static /* synthetic */ boolean i(double d) {
        return true;
    }

    public static FailableDoublePredicate j() {
        return FailableDoublePredicate.TRUE;
    }
}
