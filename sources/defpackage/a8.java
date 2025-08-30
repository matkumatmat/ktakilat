package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableIntPredicate;

/* renamed from: a8  reason: default package */
public abstract /* synthetic */ class a8 {
    public static FailableIntPredicate a(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2) {
        Objects.requireNonNull(failableIntPredicate2);
        return new z7(failableIntPredicate, failableIntPredicate2, 0);
    }

    public static FailableIntPredicate b(FailableIntPredicate failableIntPredicate) {
        return new k0(failableIntPredicate, 21);
    }

    public static FailableIntPredicate c(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2) {
        Objects.requireNonNull(failableIntPredicate2);
        return new z7(failableIntPredicate, failableIntPredicate2, 1);
    }

    public static /* synthetic */ boolean d(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2, int i) {
        if (!failableIntPredicate.test(i) || !failableIntPredicate2.test(i)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(FailableIntPredicate failableIntPredicate, int i) {
        return !failableIntPredicate.test(i);
    }

    public static /* synthetic */ boolean f(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2, int i) {
        if (failableIntPredicate.test(i) || failableIntPredicate2.test(i)) {
            return true;
        }
        return false;
    }

    public static FailableIntPredicate g() {
        return FailableIntPredicate.FALSE;
    }

    public static /* synthetic */ boolean h(int i) {
        return false;
    }

    public static /* synthetic */ boolean i(int i) {
        return true;
    }

    public static FailableIntPredicate j() {
        return FailableIntPredicate.TRUE;
    }
}
