package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,747:1\n1#2:748\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000 a*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0006abcdefB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0019\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u001a\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u000f\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010,\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b-\u0010\u0013J#\u00103\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b1\u00102J\u001b\u00108\u001a\u00020\u000e2\n\u00105\u001a\u0006\u0012\u0002\b\u000304H\u0000¢\u0006\u0004\b6\u00107J#\u0010:\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b9\u00102J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010;\u001a\u00028\u0001H\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>H\u0000¢\u0006\u0004\b?\u0010@J\u001b\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010BH\u0000¢\u0006\u0004\bC\u0010DJ\u001b\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020 H\u0002¢\u0006\u0004\bJ\u0010KR$\u0010O\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8\u0016@RX\u000e¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010$R$\u0010S\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8\u0000@BX\u000e¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0010R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000T8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00010X8VX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR&\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\\0T8VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010VR\u0014\u0010`\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b_\u0010$¨\u0006g"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "initialCapacity", "(I)V", "", "build", "()Ljava/util/Map;", "", "isEmpty", "()Z", "key", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "from", "", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "checkIsMutable$kotlin_stdlib", "checkIsMutable", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "addKey", "removeKey$kotlin_stdlib", "removeKey", "", "entry", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "", "m", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator", "writeReplace", "()Ljava/lang/Object;", "l", "I", "getSize", "size", "p", "Z", "isReadOnly$kotlin_stdlib", "isReadOnly", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "getCapacity$kotlin_stdlib", "capacity", "Companion", "Itr", "KeysItr", "ValuesItr", "EntriesItr", "EntryRef", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final MapBuilder q;
    public Object[] c;
    public Object[] d;
    public int[] e;
    public int[] f;
    public int g;
    public int i;
    public int j;
    public int k;
    public int l;
    public MapBuilderKeys m;
    public MapBuilderValues n;
    public MapBuilderEntries o;
    public boolean p;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "", "MAGIC", "I", "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        public final Object next() {
            a();
            int i = this.d;
            MapBuilder mapBuilder = this.c;
            if (i < mapBuilder.i) {
                int i2 = this.d;
                this.d = i2 + 1;
                this.e = i2;
                EntryRef entryRef = new EntryRef(mapBuilder, i2);
                b();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final MapBuilder c;
        public final int d;
        public final int e;

        public EntryRef(MapBuilder mapBuilder, int i) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.c = mapBuilder;
            this.d = i;
            this.e = mapBuilder.k;
        }

        public final void a() {
            if (this.c.k != this.e) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (!Intrinsics.a(entry.getKey(), getKey()) || !Intrinsics.a(entry.getValue(), getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final Object getKey() {
            a();
            return this.c.c[this.d];
        }

        public final Object getValue() {
            a();
            Object[] access$getValuesArray$p = this.c.d;
            Intrinsics.c(access$getValuesArray$p);
            return access$getValuesArray$p[this.d];
        }

        public final int hashCode() {
            int i;
            Object key = getKey();
            int i2 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            Object value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        public final Object setValue(Object obj) {
            a();
            MapBuilder mapBuilder = this.c;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] access$allocateValuesArray = MapBuilder.access$allocateValuesArray(mapBuilder);
            int i = this.d;
            Object obj2 = access$allocateValuesArray[i];
            access$allocateValuesArray[i] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,747:1\n1#2:748\n*E\n"})
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Itr<K, V> {
        public final MapBuilder c;
        public int d;
        public int e = -1;
        public int f;

        public Itr(MapBuilder mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.c = mapBuilder;
            this.f = mapBuilder.k;
            b();
        }

        public final void a() {
            if (this.c.k != this.f) {
                throw new ConcurrentModificationException();
            }
        }

        public final void b() {
            while (true) {
                int i = this.d;
                MapBuilder mapBuilder = this.c;
                if (i < mapBuilder.i) {
                    int[] access$getPresenceArray$p = mapBuilder.e;
                    int i2 = this.d;
                    if (access$getPresenceArray$p[i2] < 0) {
                        this.d = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final boolean hasNext() {
            if (this.d < this.c.i) {
                return true;
            }
            return false;
        }

        public final void remove() {
            a();
            if (this.e != -1) {
                MapBuilder mapBuilder = this.c;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                mapBuilder.g(this.e);
                this.e = -1;
                this.f = mapBuilder.k;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        public final Object next() {
            a();
            int i = this.d;
            MapBuilder mapBuilder = this.c;
            if (i < mapBuilder.i) {
                int i2 = this.d;
                this.d = i2 + 1;
                this.e = i2;
                Object obj = mapBuilder.c[this.e];
                b();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        public final Object next() {
            a();
            int i = this.d;
            MapBuilder mapBuilder = this.c;
            if (i < mapBuilder.i) {
                int i2 = this.d;
                this.d = i2 + 1;
                this.e = i2;
                Object[] access$getValuesArray$p = mapBuilder.d;
                Intrinsics.c(access$getValuesArray$p);
                Object obj = access$getValuesArray$p[this.e];
                b();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.p = true;
        q = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    public static final Object[] access$allocateValuesArray(MapBuilder mapBuilder) {
        Object[] objArr = mapBuilder.d;
        if (objArr != null) {
            return objArr;
        }
        int capacity$kotlin_stdlib = mapBuilder.getCapacity$kotlin_stdlib();
        if (capacity$kotlin_stdlib >= 0) {
            Object[] objArr2 = new Object[capacity$kotlin_stdlib];
            mapBuilder.d = objArr2;
            return objArr2;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    private final Object writeReplace() {
        if (this.p) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final void a(boolean z) {
        int i2;
        Object[] objArr = this.d;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.i;
            if (i3 >= i2) {
                break;
            }
            int[] iArr = this.e;
            int i5 = iArr[i3];
            if (i5 >= 0) {
                Object[] objArr2 = this.c;
                objArr2[i4] = objArr2[i3];
                if (objArr != null) {
                    objArr[i4] = objArr[i3];
                }
                if (z) {
                    iArr[i4] = i5;
                    this.f[i5] = i4 + 1;
                }
                i4++;
            }
            i3++;
        }
        ListBuilderKt.c(i4, i2, this.c);
        if (objArr != null) {
            ListBuilderKt.c(i4, this.i, objArr);
        }
        this.i = i4;
    }

    public final int addKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int e2 = e(k2);
            int i2 = this.g * 2;
            int length = this.f.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i3 = 0;
            while (true) {
                int i4 = this.f[e2];
                if (i4 <= 0) {
                    if (this.i >= getCapacity$kotlin_stdlib()) {
                        b(1);
                    } else {
                        int i5 = this.i;
                        int i6 = i5 + 1;
                        this.i = i6;
                        this.c[i5] = k2;
                        this.e[i5] = e2;
                        this.f[e2] = i6;
                        this.l = size() + 1;
                        this.k++;
                        if (i3 > this.g) {
                            this.g = i3;
                        }
                        return i5;
                    }
                } else if (Intrinsics.a(this.c[i4 - 1], k2)) {
                    return -i4;
                } else {
                    i3++;
                    if (i3 > i2) {
                        f(this.f.length * 2);
                        break;
                    }
                    int i7 = e2 - 1;
                    if (e2 == 0) {
                        e2 = this.f.length - 1;
                    } else {
                        e2 = i7;
                    }
                }
            }
        }
    }

    public final void b(int i2) {
        Object[] objArr;
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i3 = this.i;
        int i4 = capacity$kotlin_stdlib - i3;
        int size = i3 - size();
        int i5 = 1;
        if (i4 >= i2 || i4 + size < i2 || size < getCapacity$kotlin_stdlib() / 4) {
            int i6 = this.i + i2;
            if (i6 < 0) {
                throw new OutOfMemoryError();
            } else if (i6 > getCapacity$kotlin_stdlib()) {
                AbstractList.Companion companion = AbstractList.Companion;
                int capacity$kotlin_stdlib2 = getCapacity$kotlin_stdlib();
                companion.getClass();
                int e2 = AbstractList.Companion.e(capacity$kotlin_stdlib2, i6);
                Object[] objArr2 = this.c;
                Intrinsics.checkNotNullParameter(objArr2, "<this>");
                Object[] copyOf = Arrays.copyOf(objArr2, e2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.c = copyOf;
                Object[] objArr3 = this.d;
                if (objArr3 != null) {
                    Intrinsics.checkNotNullParameter(objArr3, "<this>");
                    objArr = Arrays.copyOf(objArr3, e2);
                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(...)");
                } else {
                    objArr = null;
                }
                this.d = objArr;
                int[] copyOf2 = Arrays.copyOf(this.e, e2);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                this.e = copyOf2;
                Companion.getClass();
                if (e2 >= 1) {
                    i5 = e2;
                }
                int highestOneBit = Integer.highestOneBit(i5 * 3);
                if (highestOneBit > this.f.length) {
                    f(highestOneBit);
                }
            }
        } else {
            a(true);
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.p = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = q;
        Intrinsics.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final int c(Object obj) {
        int e2 = e(obj);
        int i2 = this.g;
        while (true) {
            int i3 = this.f[e2];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (Intrinsics.a(this.c[i4], obj)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            int i5 = e2 - 1;
            if (e2 == 0) {
                e2 = this.f.length - 1;
            } else {
                e2 = i5;
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.p) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i2 = this.i - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.e;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.f[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        ListBuilderKt.c(0, this.i, this.c);
        Object[] objArr = this.d;
        if (objArr != null) {
            ListBuilderKt.c(0, this.i, objArr);
        }
        this.l = 0;
        this.i = 0;
        this.k++;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int c2 = c(entry.getKey());
        if (c2 < 0) {
            return false;
        }
        Object[] objArr = this.d;
        Intrinsics.c(objArr);
        return Intrinsics.a(objArr[c2], entry.getValue());
    }

    public boolean containsKey(Object obj) {
        if (c(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (d(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final int d(Object obj) {
        int i2 = this.i;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.e[i2] >= 0) {
                Object[] objArr = this.d;
                Intrinsics.c(objArr);
                if (Intrinsics.a(objArr[i2], obj)) {
                    return i2;
                }
            }
        }
    }

    public final int e(Object obj) {
        int i2;
        if (obj != null) {
            i2 = obj.hashCode();
        } else {
            i2 = 0;
        }
        return (i2 * -1640531527) >>> this.j;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.collections.builders.MapBuilder$EntriesItr<K, V>, kotlin.collections.builders.MapBuilder$Itr] */
    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        Intrinsics.checkNotNullParameter(this, "map");
        return new Itr(this);
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size() || !containsAllEntries$kotlin_stdlib(map.entrySet())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r3[r0] = r6;
        r5.e[r2] = r0;
        r2 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r6) {
        /*
            r5 = this;
            int r0 = r5.k
            int r0 = r0 + 1
            r5.k = r0
            int r0 = r5.i
            int r1 = r5.size()
            r2 = 0
            if (r0 <= r1) goto L_0x0012
            r5.a(r2)
        L_0x0012:
            int[] r0 = new int[r6]
            r5.f = r0
            kotlin.collections.builders.MapBuilder$Companion r0 = Companion
            r0.getClass()
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.j = r6
        L_0x0023:
            int r6 = r5.i
            if (r2 >= r6) goto L_0x0057
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.c
            r0 = r0[r2]
            int r0 = r5.e(r0)
            int r1 = r5.g
        L_0x0033:
            int[] r3 = r5.f
            r4 = r3[r0]
            if (r4 != 0) goto L_0x0041
            r3[r0] = r6
            int[] r1 = r5.e
            r1[r2] = r0
            r2 = r6
            goto L_0x0023
        L_0x0041:
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x004f
            int r4 = r0 + -1
            if (r0 != 0) goto L_0x004d
            int r0 = r3.length
            int r0 = r0 + -1
            goto L_0x0033
        L_0x004d:
            r0 = r4
            goto L_0x0033
        L_0x004f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.f(int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.c
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r2 = 0
            r0[r12] = r2
            java.lang.Object[] r0 = r11.d
            if (r0 == 0) goto L_0x0013
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0[r12] = r2
        L_0x0013:
            int[] r0 = r11.e
            r0 = r0[r12]
            int r1 = r11.g
            int r1 = r1 * 2
            int[] r2 = r11.f
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L_0x0023
            r1 = r2
        L_0x0023:
            r2 = 0
            r3 = r1
            r4 = 0
            r1 = r0
        L_0x0027:
            int r5 = r0 + -1
            if (r0 != 0) goto L_0x0031
            int[] r0 = r11.f
            int r0 = r0.length
            int r0 = r0 + -1
            goto L_0x0032
        L_0x0031:
            r0 = r5
        L_0x0032:
            int r4 = r4 + 1
            int r5 = r11.g
            r6 = -1
            if (r4 <= r5) goto L_0x003e
            int[] r0 = r11.f
            r0[r1] = r2
            goto L_0x006f
        L_0x003e:
            int[] r5 = r11.f
            r7 = r5[r0]
            if (r7 != 0) goto L_0x0047
            r5[r1] = r2
            goto L_0x006f
        L_0x0047:
            if (r7 >= 0) goto L_0x004e
            r5[r1] = r6
        L_0x004b:
            r1 = r0
            r4 = 0
            goto L_0x0068
        L_0x004e:
            java.lang.Object[] r5 = r11.c
            int r8 = r7 + -1
            r5 = r5[r8]
            int r5 = r11.e(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f
            int r10 = r9.length
            int r10 = r10 + -1
            r5 = r5 & r10
            if (r5 < r4) goto L_0x0068
            r9[r1] = r7
            int[] r4 = r11.e
            r4[r8] = r1
            goto L_0x004b
        L_0x0068:
            int r3 = r3 + r6
            if (r3 >= 0) goto L_0x0027
            int[] r0 = r11.f
            r0[r1] = r6
        L_0x006f:
            int[] r0 = r11.e
            r0[r12] = r6
            int r12 = r11.size()
            int r12 = r12 + r6
            r11.l = r12
            int r12 = r11.k
            int r12 = r12 + 1
            r11.k = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.g(int):void");
    }

    @Nullable
    public V get(Object obj) {
        int c2 = c(obj);
        if (c2 < 0) {
            return null;
        }
        V[] vArr = this.d;
        Intrinsics.c(vArr);
        return vArr[c2];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.c.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries mapBuilderEntries = this.o;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries mapBuilderEntries2 = new MapBuilderEntries(this);
        this.o = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    @NotNull
    public Set<K> getKeys() {
        MapBuilderKeys mapBuilderKeys = this.m;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this);
        this.m = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int getSize() {
        return this.l;
    }

    @NotNull
    public Collection<V> getValues() {
        MapBuilderValues mapBuilderValues = this.n;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues mapBuilderValues2 = new MapBuilderValues(this);
        this.n = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public int hashCode() {
        int i2;
        int i3;
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i4 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            int i5 = entriesIterator$kotlin_stdlib.d;
            MapBuilder mapBuilder = entriesIterator$kotlin_stdlib.c;
            if (i5 < mapBuilder.i) {
                int i6 = entriesIterator$kotlin_stdlib.d;
                entriesIterator$kotlin_stdlib.d = i6 + 1;
                entriesIterator$kotlin_stdlib.e = i6;
                Object obj = mapBuilder.c[entriesIterator$kotlin_stdlib.e];
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = 0;
                }
                Object[] access$getValuesArray$p = mapBuilder.d;
                Intrinsics.c(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[entriesIterator$kotlin_stdlib.e];
                if (obj2 != null) {
                    i3 = obj2.hashCode();
                } else {
                    i3 = 0;
                }
                entriesIterator$kotlin_stdlib.b();
                i4 += i2 ^ i3;
            } else {
                throw new NoSuchElementException();
            }
        }
        return i4;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.p;
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.collections.builders.MapBuilder$KeysItr<K, V>, kotlin.collections.builders.MapBuilder$Itr] */
    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        Intrinsics.checkNotNullParameter(this, "map");
        return new Itr(this);
    }

    @Nullable
    public V put(K k2, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k2);
        V[] vArr = this.d;
        if (vArr == null) {
            int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
            if (capacity$kotlin_stdlib >= 0) {
                vArr = new Object[capacity$kotlin_stdlib];
                this.d = vArr;
            } else {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
        }
        if (addKey$kotlin_stdlib < 0) {
            int i2 = (-addKey$kotlin_stdlib) - 1;
            V v2 = vArr[i2];
            vArr[i2] = v;
            return v2;
        }
        vArr[addKey$kotlin_stdlib] = v;
        return null;
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
        if (!entrySet.isEmpty()) {
            b(entrySet.size());
            for (Map.Entry next : entrySet) {
                int addKey$kotlin_stdlib = addKey$kotlin_stdlib(next.getKey());
                Object[] objArr = this.d;
                if (objArr == null) {
                    int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
                    if (capacity$kotlin_stdlib >= 0) {
                        objArr = new Object[capacity$kotlin_stdlib];
                        this.d = objArr;
                    } else {
                        throw new IllegalArgumentException("capacity must be non-negative.");
                    }
                }
                if (addKey$kotlin_stdlib >= 0) {
                    objArr[addKey$kotlin_stdlib] = next.getValue();
                } else {
                    int i2 = (-addKey$kotlin_stdlib) - 1;
                    if (!Intrinsics.a(next.getValue(), objArr[i2])) {
                        objArr[i2] = next.getValue();
                    }
                }
            }
        }
    }

    @Nullable
    public V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int c2 = c(obj);
        if (c2 < 0) {
            return null;
        }
        V[] vArr = this.d;
        Intrinsics.c(vArr);
        V v = vArr[c2];
        g(c2);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int c2 = c(entry.getKey());
        if (c2 < 0) {
            return false;
        }
        Object[] objArr = this.d;
        Intrinsics.c(objArr);
        if (!Intrinsics.a(objArr[c2], entry.getValue())) {
            return false;
        }
        g(c2);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        int c2 = c(k2);
        if (c2 < 0) {
            return false;
        }
        g(c2);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int d2 = d(v);
        if (d2 < 0) {
            return false;
        }
        g(d2);
        return true;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Intrinsics.checkNotNullParameter(sb, "sb");
            int i3 = entriesIterator$kotlin_stdlib.d;
            MapBuilder mapBuilder = entriesIterator$kotlin_stdlib.c;
            if (i3 < mapBuilder.i) {
                int i4 = entriesIterator$kotlin_stdlib.d;
                entriesIterator$kotlin_stdlib.d = i4 + 1;
                entriesIterator$kotlin_stdlib.e = i4;
                Object obj = mapBuilder.c[entriesIterator$kotlin_stdlib.e];
                if (obj == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] access$getValuesArray$p = mapBuilder.d;
                Intrinsics.c(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[entriesIterator$kotlin_stdlib.e];
                if (obj2 == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                entriesIterator$kotlin_stdlib.b();
                i2++;
            } else {
                throw new NoSuchElementException();
            }
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.collections.builders.MapBuilder$Itr, kotlin.collections.builders.MapBuilder$ValuesItr<K, V>] */
    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        Intrinsics.checkNotNullParameter(this, "map");
        return new Itr(this);
    }

    public MapBuilder(int i2) {
        if (i2 >= 0) {
            Object[] objArr = new Object[i2];
            int[] iArr = new int[i2];
            Companion.getClass();
            int highestOneBit = Integer.highestOneBit((i2 < 1 ? 1 : i2) * 3);
            this.c = objArr;
            this.d = null;
            this.e = iArr;
            this.f = new int[highestOneBit];
            this.g = 2;
            this.i = 0;
            this.j = Integer.numberOfLeadingZeros(highestOneBit) + 1;
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }
}
