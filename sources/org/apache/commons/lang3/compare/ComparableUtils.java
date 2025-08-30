package org.apache.commons.lang3.compare;

import java.util.function.Predicate;

public class ComparableUtils {

    public static class ComparableCheckBuilder<A extends Comparable<A>> {

        /* renamed from: a  reason: collision with root package name */
        private final A f825a;

        private boolean betweenOrdered(A a2, A a3) {
            if (!greaterThanOrEqualTo(a2) || !lessThanOrEqualTo(a3)) {
                return false;
            }
            return true;
        }

        private boolean betweenOrderedExclusive(A a2, A a3) {
            if (!greaterThan(a2) || !lessThan(a3)) {
                return false;
            }
            return true;
        }

        public boolean between(A a2, A a3) {
            if (betweenOrdered(a2, a3) || betweenOrdered(a3, a2)) {
                return true;
            }
            return false;
        }

        public boolean betweenExclusive(A a2, A a3) {
            if (betweenOrderedExclusive(a2, a3) || betweenOrderedExclusive(a3, a2)) {
                return true;
            }
            return false;
        }

        public boolean equalTo(A a2) {
            if (this.f825a.compareTo(a2) == 0) {
                return true;
            }
            return false;
        }

        public boolean greaterThan(A a2) {
            if (this.f825a.compareTo(a2) > 0) {
                return true;
            }
            return false;
        }

        public boolean greaterThanOrEqualTo(A a2) {
            if (this.f825a.compareTo(a2) >= 0) {
                return true;
            }
            return false;
        }

        public boolean lessThan(A a2) {
            if (this.f825a.compareTo(a2) < 0) {
                return true;
            }
            return false;
        }

        public boolean lessThanOrEqualTo(A a2) {
            if (this.f825a.compareTo(a2) <= 0) {
                return true;
            }
            return false;
        }

        private ComparableCheckBuilder(A a2) {
            this.f825a = a2;
        }
    }

    private ComparableUtils() {
    }

    public static <A extends Comparable<A>> Predicate<A> between(A a2, A a3) {
        return new k3(a2, a3, 0);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A a2, A a3) {
        return new k3(a2, a3, 1);
    }

    public static <A extends Comparable<A>> Predicate<A> ge(A a2) {
        return new j3(a2, 0);
    }

    public static <A extends Comparable<A>> Predicate<A> gt(A a2) {
        return new j3(a2, 1);
    }

    public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A a2) {
        return new ComparableCheckBuilder<>(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> le(A a2) {
        return new j3(a2, 3);
    }

    public static <A extends Comparable<A>> Predicate<A> lt(A a2) {
        return new j3(a2, 2);
    }
}
