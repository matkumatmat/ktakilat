package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,698:1\n1#2:699\n*E\n"})
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f742a;

    public SubSequence(int i) {
        Intrinsics.checkNotNullParameter((Object) null, "sequence");
        this.f742a = i;
        if (i < 0) {
            throw new IllegalArgumentException(ba.k(i, "startIndex should be non-negative, but is ").toString());
        } else if (i > 0) {
            throw new IllegalArgumentException(ba.k(i, "endIndex should be not less than startIndex, but was 0 < ").toString());
        }
    }

    public final Sequence a(int i) {
        int i2 = this.f742a;
        if (i >= 0 - i2) {
            return EmptySequence.f736a;
        }
        return new SubSequence(i2 + i);
    }

    public final Iterator iterator() {
        new SubSequence$iterator$1(this);
        throw null;
    }
}
