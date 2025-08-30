package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {
    public final boolean contains(Object obj) {
        if (!(obj instanceof Short)) {
            return false;
        }
        ArraysKt.g(((Number) obj).shortValue());
        throw null;
    }

    public final Object get(int i) {
        throw null;
    }

    public final int getSize() {
        throw null;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Short)) {
            return -1;
        }
        ArraysKt.t(((Number) obj).shortValue());
        throw null;
    }

    public final boolean isEmpty() {
        throw null;
    }

    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Short)) {
            return -1;
        }
        ((Number) obj).shortValue();
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        throw null;
    }
}
