package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "", "T", "Lkotlin/ranges/OpenEndRange;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof ComparableOpenEndRange)) {
            return false;
        }
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "null..<null";
    }
}
