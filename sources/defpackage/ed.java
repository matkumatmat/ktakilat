package defpackage;

import androidx.core.util.Predicate;
import java.util.Objects;

/* renamed from: ed  reason: default package */
public abstract /* synthetic */ class ed {
    public static Predicate a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new dd(predicate, predicate2, 1);
    }

    public static Predicate b(Predicate predicate) {
        return new va(predicate, 2);
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new dd(predicate, predicate2, 0);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) || !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) || predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    public static Predicate g(Object obj) {
        if (obj == null) {
            return new wa(11);
        }
        return new va(obj, 1);
    }

    public static /* synthetic */ boolean h(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static Predicate j(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
