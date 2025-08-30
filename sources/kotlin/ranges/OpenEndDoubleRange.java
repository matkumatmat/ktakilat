package kotlin.ranges;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof OpenEndDoubleRange)) {
            return false;
        }
        ((OpenEndDoubleRange) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return -1;
    }

    public final String toString() {
        return "0.0..<0.0";
    }
}
