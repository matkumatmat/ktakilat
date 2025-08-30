package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,698:1\n1#2:699\n*E\n"})
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Sequence f735a;
    public final int b;

    public DropSequence(Sequence sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f735a = sequence;
        this.b = i;
        if (i < 0) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
    }

    public final Sequence a(int i) {
        int i2 = this.b + i;
        if (i2 < 0) {
            return new DropSequence(this, i);
        }
        return new DropSequence(this.f735a, i2);
    }

    public final Iterator iterator() {
        return new DropSequence$iterator$1(this);
    }
}
