package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class LinesSequence implements Sequence<String> {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f712a;

    public LinesSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "reader");
        this.f712a = bufferedReader;
    }

    public final Iterator iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
