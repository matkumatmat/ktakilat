package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "f", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CharRange extends CharProgression implements ClosedRange<Character>, OpenEndRange<Character> {
    @NotNull
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/CharRange$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new CharProgression();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                charRange.getClass();
                if (this.c == charRange.c) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final Comparable getEndInclusive() {
        return Character.valueOf(this.c);
    }

    public final Comparable getStart() {
        return 1;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.c + 31;
    }

    public final boolean isEmpty() {
        if (Intrinsics.f(1, this.c) > 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "\u0001.." + this.c;
    }
}
