package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailablePredicate;

/* renamed from: s8  reason: default package */
public abstract /* synthetic */ class s8 {
    public static FailablePredicate a(FailablePredicate failablePredicate, FailablePredicate failablePredicate2) {
        Objects.requireNonNull(failablePredicate2);
        return new r8(failablePredicate, failablePredicate2, 1);
    }

    public static FailablePredicate b(FailablePredicate failablePredicate) {
        return new k0(failablePredicate, 23);
    }

    public static FailablePredicate c(FailablePredicate failablePredicate, FailablePredicate failablePredicate2) {
        Objects.requireNonNull(failablePredicate2);
        return new r8(failablePredicate, failablePredicate2, 0);
    }

    public static /* synthetic */ boolean d(FailablePredicate failablePredicate, FailablePredicate failablePredicate2, Object obj) {
        if (!failablePredicate.test(obj) || !failablePredicate2.test(obj)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(FailablePredicate failablePredicate, Object obj) {
        return !failablePredicate.test(obj);
    }

    public static /* synthetic */ boolean f(FailablePredicate failablePredicate, FailablePredicate failablePredicate2, Object obj) {
        if (failablePredicate.test(obj) || failablePredicate2.test(obj)) {
            return true;
        }
        return false;
    }

    public static FailablePredicate g() {
        return FailablePredicate.FALSE;
    }

    public static /* synthetic */ boolean h(Object obj) {
        return false;
    }

    public static /* synthetic */ boolean i(Object obj) {
        return true;
    }

    public static FailablePredicate j() {
        return FailablePredicate.TRUE;
    }
}
