package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    public enum ComparableComparator implements Comparator {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    private Range(T t, T t2, Comparator<T> comparator2) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
        }
        if (comparator2 == null) {
            this.comparator = ComparableComparator.INSTANCE;
        } else {
            this.comparator = comparator2;
        }
        if (this.comparator.compare(t, t2) < 1) {
            this.minimum = t;
            this.maximum = t2;
            return;
        }
        this.minimum = t2;
        this.maximum = t;
    }

    public static <T extends Comparable<T>> Range<T> between(T t, T t2) {
        return between(t, t2, (Comparator) null);
    }

    public static <T extends Comparable<T>> Range<T> is(T t) {
        return between(t, t, (Comparator) null);
    }

    public boolean contains(T t) {
        if (t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1) {
            return true;
        }
        return false;
    }

    public boolean containsRange(Range<T> range) {
        if (range != null && contains(range.minimum) && contains(range.maximum)) {
            return true;
        }
        return false;
    }

    public int elementCompareTo(T t) {
        Validate.notNull(t, "element", new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        if (isBefore(t)) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.minimum.equals(range.minimum) || !this.maximum.equals(range.maximum)) {
            return false;
        }
        return true;
    }

    public T fit(T t) {
        Validate.notNull(t, "element", new Object[0]);
        if (isAfter(t)) {
            return this.minimum;
        }
        if (isBefore(t)) {
            return this.maximum;
        }
        return t;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = this.minimum.hashCode();
        int hashCode3 = this.maximum.hashCode() + ((hashCode2 + ((Range.class.hashCode() + 629) * 37)) * 37);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public Range<T> intersectionWith(Range<T> range) {
        T t;
        T t2;
        if (!isOverlappedBy(range)) {
            throw new IllegalArgumentException("Cannot calculate intersection with non-overlapping range " + range);
        } else if (equals(range)) {
            return this;
        } else {
            if (getComparator().compare(this.minimum, range.minimum) < 0) {
                t = range.minimum;
            } else {
                t = this.minimum;
            }
            if (getComparator().compare(this.maximum, range.maximum) < 0) {
                t2 = this.maximum;
            } else {
                t2 = range.maximum;
            }
            return between(t, t2, getComparator());
        }
    }

    public boolean isAfter(T t) {
        if (t != null && this.comparator.compare(t, this.minimum) < 0) {
            return true;
        }
        return false;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t) {
        if (t != null && this.comparator.compare(t, this.maximum) > 0) {
            return true;
        }
        return false;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t) {
        if (t != null && this.comparator.compare(t, this.maximum) == 0) {
            return true;
        }
        return false;
    }

    public boolean isNaturalOrdering() {
        if (this.comparator == ComparableComparator.INSTANCE) {
            return true;
        }
        return false;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        if (range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum)) {
            return true;
        }
        return false;
    }

    public boolean isStartedBy(T t) {
        if (t != null && this.comparator.compare(t, this.minimum) == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = "[" + this.minimum + ".." + this.maximum + "]";
        }
        return this.toString;
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator2) {
        return new Range<>(t, t2, comparator2);
    }

    public static <T> Range<T> is(T t, Comparator<T> comparator2) {
        return between(t, t, comparator2);
    }

    public String toString(String str) {
        return String.format(str, new Object[]{this.minimum, this.maximum, this.comparator});
    }
}
