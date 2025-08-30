package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,175:1\n360#2,7:176\n388#2,7:183\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:176,7\n29#1:183,7\n*E\n"})
@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b'\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\u001f !\u001eB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0012J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "<init>", "()V", "", "iterator", "()Ljava/util/Iterator;", "element", "", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "index", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Companion", "SubList", "IteratorImpl", "ListIteratorImpl", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int maxArraySize = 2147483639;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "", "maxArraySize", "I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                StringBuilder r = e.r(i, "startIndex: ", i2, ", endIndex: ", ", size: ");
                r.append(i3);
                throw new IndexOutOfBoundsException(r.toString());
            } else if (i > i2) {
                throw new IllegalArgumentException(e.h(i, "startIndex: ", " > endIndex: ", i2));
            }
        }

        public static void b(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(e.h(i, "index: ", ", size: ", i2));
            }
        }

        public static void c(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(e.h(i, "index: ", ", size: ", i2));
            }
        }

        public static void d(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                StringBuilder r = e.r(i, "fromIndex: ", i2, ", toIndex: ", ", size: ");
                r.append(i3);
                throw new IndexOutOfBoundsException(r.toString());
            } else if (i > i2) {
                throw new IllegalArgumentException(e.h(i, "fromIndex: ", " > toIndex: ", i2));
            }
        }

        public static int e(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - AbstractList.maxArraySize <= 0) {
                return i3;
            }
            if (i2 > AbstractList.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return AbstractList.maxArraySize;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class IteratorImpl implements Iterator<E>, KMappedMarker {
        public int c;

        public IteratorImpl() {
        }

        public final boolean hasNext() {
            if (this.c < AbstractList.this.size()) {
                return true;
            }
            return false;
        }

        public final Object next() {
            if (hasNext()) {
                int i = this.c;
                this.c = i + 1;
                return AbstractList.this.get(i);
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        public ListIteratorImpl(int i) {
            super();
            Companion companion = AbstractList.Companion;
            int size = AbstractList.this.size();
            companion.getClass();
            Companion.c(i, size);
            this.c = i;
        }

        public final void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final boolean hasPrevious() {
            if (this.c > 0) {
                return true;
            }
            return false;
        }

        public final int nextIndex() {
            return this.c;
        }

        public final Object previous() {
            if (hasPrevious()) {
                int i = this.c - 1;
                this.c = i;
                return AbstractList.this.get(i);
            }
            throw new NoSuchElementException();
        }

        public final int previousIndex() {
            return this.c - 1;
        }

        public final void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        public final AbstractList c;
        public final int d;
        public final int e;

        public SubList(AbstractList abstractList, int i, int i2) {
            Intrinsics.checkNotNullParameter(abstractList, "list");
            this.c = abstractList;
            this.d = i;
            Companion companion = AbstractList.Companion;
            int size = abstractList.size();
            companion.getClass();
            Companion.d(i, i2, size);
            this.e = i2 - i;
        }

        public final Object get(int i) {
            Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            Companion.b(i, i2);
            return this.c.get(this.d + i);
        }

        public final int getSize() {
            return this.e;
        }
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "c");
        Intrinsics.checkNotNullParameter(collection, FacebookRequestErrorClassification.KEY_OTHER);
        if (size() != collection.size()) {
            return false;
        }
        Iterator it = collection.iterator();
        for (Object a2 : this) {
            if (!Intrinsics.a(a2, it.next())) {
            }
        }
        return true;
        return false;
    }

    public abstract Object get(int i);

    public int hashCode() {
        int i;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "c");
        int i2 = 1;
        for (Object next : this) {
            int i3 = i2 * 31;
            if (next != null) {
                i = next.hashCode();
            } else {
                i = 0;
            }
            i2 = i3 + i;
        }
        return i2;
    }

    public int indexOf(E e) {
        int i = 0;
        for (Object a2 : this) {
            if (Intrinsics.a(a2, e)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    public int lastIndexOf(E e) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.a(listIterator.previous(), e)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public List<E> subList(int i, int i2) {
        return new SubList(this, i, i2);
    }

    @NotNull
    public ListIterator<E> listIterator(int i) {
        return new ListIteratorImpl(i);
    }
}
