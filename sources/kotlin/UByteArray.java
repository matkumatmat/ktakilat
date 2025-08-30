package kotlin;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@ExperimentalUnsignedTypes
@JvmInline
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1734#2,3:83\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n58#1:83,3\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u0001\u0004\u0001\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "Iterator", "storage", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UByteArray implements Collection<UByte>, KMappedMarker {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        public final boolean hasNext() {
            throw null;
        }

        public final Object next() {
            throw null;
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        ((UByte) obj).getClass();
        ArraysKt.d((byte) 0);
        throw null;
    }

    public final boolean containsAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        Iterable iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        java.util.Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        if (!(next instanceof UByte)) {
            return false;
        }
        ((UByte) next).getClass();
        ArraysKt.d((byte) 0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UByteArray)) {
            return false;
        }
        ((UByteArray) obj).getClass();
        if (!Intrinsics.a((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode((byte[]) null);
    }

    public final boolean isEmpty() {
        throw null;
    }

    public final java.util.Iterator iterator() {
        Intrinsics.checkNotNullParameter((Object) null, "array");
        throw null;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        throw null;
    }

    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "UByteArray(storage=" + Arrays.toString((byte[]) null) + ')';
    }

    public final Object[] toArray(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        return CollectionToArray.b(this, objArr);
    }
}
