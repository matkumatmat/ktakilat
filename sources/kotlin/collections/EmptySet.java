package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", "", "iterator", "", "readResolve", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptySet implements Set, Serializable, KMappedMarker {
    @NotNull
    public static final EmptySet INSTANCE = new EmptySet();
    private static final long serialVersionUID = 3406603774387020532L;

    private EmptySet() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(@NotNull Void voidR) {
        Intrinsics.checkNotNullParameter(voidR, "element");
        return false;
    }

    public boolean containsAll(@NotNull Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        return collection.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Set) || !((Set) obj).isEmpty()) {
            return false;
        }
        return true;
    }

    public int getSize() {
        return 0;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public Iterator iterator() {
        return EmptyIterator.c;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @NotNull
    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public boolean add(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return contains((Void) obj);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }
}
