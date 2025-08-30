package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableBiPredicate;

/* renamed from: l7  reason: default package */
public abstract /* synthetic */ class l7 {
    public static FailableBiPredicate a(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2) {
        Objects.requireNonNull(failableBiPredicate2);
        return new k7(failableBiPredicate, failableBiPredicate2, 0);
    }

    public static FailableBiPredicate b(FailableBiPredicate failableBiPredicate) {
        return new k0(failableBiPredicate, 19);
    }

    public static FailableBiPredicate c(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2) {
        Objects.requireNonNull(failableBiPredicate2);
        return new k7(failableBiPredicate, failableBiPredicate2, 1);
    }

    public static /* synthetic */ boolean d(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2, Object obj, Object obj2) {
        if (!failableBiPredicate.test(obj, obj2) || !failableBiPredicate2.test(obj, obj2)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(FailableBiPredicate failableBiPredicate, Object obj, Object obj2) {
        return !failableBiPredicate.test(obj, obj2);
    }

    public static /* synthetic */ boolean f(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2, Object obj, Object obj2) {
        if (failableBiPredicate.test(obj, obj2) || failableBiPredicate2.test(obj, obj2)) {
            return true;
        }
        return false;
    }

    public static FailableBiPredicate g() {
        return FailableBiPredicate.FALSE;
    }

    public static /* synthetic */ boolean h(Object obj, Object obj2) {
        return false;
    }

    public static /* synthetic */ boolean i(Object obj, Object obj2) {
        return true;
    }

    public static FailableBiPredicate j() {
        return FailableBiPredicate.TRUE;
    }
}
