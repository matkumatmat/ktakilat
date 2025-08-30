package kotlin.ranges;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
        closedFloatRange.getClass();
        closedFloatRange.getClass();
        return true;
    }

    public final /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return Float.valueOf(0.0f);
    }

    public final /* bridge */ /* synthetic */ Comparable getStart() {
        return Float.valueOf(0.0f);
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + (Float.floatToIntBits(0.0f) * 31);
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
