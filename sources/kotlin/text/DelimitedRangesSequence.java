package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f745a;
    public final int b;
    public final int c;
    public final Function2 d;

    public DelimitedRangesSequence(CharSequence charSequence, int i, int i2, Function2 function2) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(function2, "getNextMatch");
        this.f745a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    public final Iterator iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
