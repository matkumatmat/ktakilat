package kotlin.ranges;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof ClosedDoubleRange)) {
            return false;
        }
        ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
        closedDoubleRange.getClass();
        closedDoubleRange.getClass();
        return true;
    }

    public final /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return Double.valueOf(0.0d);
    }

    public final /* bridge */ /* synthetic */ Comparable getStart() {
        return Double.valueOf(0.0d);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(0.0d);
        long doubleToLongBits2 = Double.doubleToLongBits(0.0d);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
