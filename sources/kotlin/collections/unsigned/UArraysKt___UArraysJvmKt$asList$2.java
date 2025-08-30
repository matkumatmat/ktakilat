package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    public final boolean contains(Object obj) {
        if (!(obj instanceof ULong)) {
            return false;
        }
        ArraysKt.f(((ULong) obj).c);
        throw null;
    }

    public final Object get(int i) {
        throw null;
    }

    public final int getSize() {
        throw null;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof ULong)) {
            return -1;
        }
        ArraysKt.s(((ULong) obj).c);
        throw null;
    }

    public final boolean isEmpty() {
        throw null;
    }

    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof ULong)) {
            return -1;
        }
        long j = ((ULong) obj).c;
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }
}
