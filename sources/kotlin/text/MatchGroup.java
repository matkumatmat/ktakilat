package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/text/MatchGroup;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MatchGroup {

    /* renamed from: a  reason: collision with root package name */
    public final String f750a;
    public final IntRange b;

    public MatchGroup(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(intRange, "range");
        this.f750a = str;
        this.b = intRange;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.a(this.f750a, matchGroup.f750a) && Intrinsics.a(this.b, matchGroup.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f750a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f750a + ", range=" + this.b + ')';
    }
}
