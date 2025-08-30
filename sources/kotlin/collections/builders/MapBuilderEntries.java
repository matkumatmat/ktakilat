package kotlin.collections.builders;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/MapBuilderEntries;", "K", "V", "Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    public final MapBuilder c;

    public MapBuilderEntries(MapBuilder mapBuilder) {
        Intrinsics.checkNotNullParameter(mapBuilder, "backing");
        this.c = mapBuilder;
    }

    public final boolean a(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return this.c.containsEntry$kotlin_stdlib(entry);
    }

    public final boolean add(Object obj) {
        Intrinsics.checkNotNullParameter((Map.Entry) obj, "element");
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        throw new UnsupportedOperationException();
    }

    public final boolean b(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return this.c.removeEntry$kotlin_stdlib(entry);
    }

    public final void clear() {
        this.c.clear();
    }

    public final boolean containsAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        return this.c.containsAllEntries$kotlin_stdlib(collection);
    }

    public final int getSize() {
        return this.c.size();
    }

    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final Iterator iterator() {
        return this.c.entriesIterator$kotlin_stdlib();
    }

    public final boolean removeAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        this.c.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        this.c.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
