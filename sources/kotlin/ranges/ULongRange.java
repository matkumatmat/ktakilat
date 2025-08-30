package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\nB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "g", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    @NotNull
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new ULongRange(-1, 0, (DefaultConstructorMarker) null);
    }

    public ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        super(j, j2, 1, (DefaultConstructorMarker) null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) obj).isEmpty()) {
                ULongRange uLongRange = (ULongRange) obj;
                if (this.c == uLongRange.c) {
                    if (this.d == uLongRange.d) {
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final Comparable getEndInclusive() {
        return new ULong(this.d);
    }

    public final Comparable getStart() {
        return new ULong(this.c);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.c;
        ULong.Companion companion = ULong.d;
        long j2 = this.d;
        return ((int) (j2 ^ (j2 >>> 32))) + (((int) (j ^ (j >>> 32))) * 31);
    }

    public final boolean isEmpty() {
        if (Long.compare(this.c ^ Long.MIN_VALUE, Long.MIN_VALUE ^ this.d) > 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return ULong.b(this.c) + ".." + ULong.b(this.d);
    }
}
