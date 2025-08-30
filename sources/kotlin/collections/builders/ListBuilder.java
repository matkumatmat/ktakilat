package kotlin.collections.builders;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u0000 G*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0003HIJB\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010!J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010\"\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\"\u0010%J\u001d\u0010(\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0004\b(\u0010)J%\u0010(\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0004\b(\u0010*J\u000f\u0010+\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\u0014J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b.\u0010#J\u001d\u0010/\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0004\b/\u0010)J\u001d\u00100\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0004\b0\u0010)J%\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u00104J)\u00108\u001a\b\u0012\u0004\u0012\u00028\u000106\"\u0004\b\u0001\u001052\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000106H\u0016¢\u0006\u0004\b8\u00109J\u0017\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:06H\u0016¢\u0006\u0004\b8\u0010;J\u001a\u0010=\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0004\b=\u0010#J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020:H\u0002¢\u0006\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010?¨\u0006K"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "initialCapacity", "<init>", "(I)V", "", "build", "()Ljava/util/List;", "", "isEmpty", "()Z", "index", "get", "(I)Ljava/lang/Object;", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "()V", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "T", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "writeReplace", "()Ljava/lang/Object;", "getSize", "size", "f", "Companion", "Itr", "BuilderSubList", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    @NotNull
    private static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final ListBuilder g;
    public Object[] c;
    public int d;
    public boolean e;

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001IBC\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0019\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010$J\u0017\u0010%\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010%\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b%\u0010(J\u001d\u0010+\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0016¢\u0006\u0004\b+\u0010,J%\u0010+\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0016¢\u0006\u0004\b+\u0010-J\u000f\u0010.\u001a\u00020'H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\u0017J\u0017\u00101\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b1\u0010&J\u001d\u00102\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0016¢\u0006\u0004\b2\u0010,J\u001d\u00103\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0016¢\u0006\u0004\b3\u0010,J%\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0016¢\u0006\u0004\b6\u00107J)\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0002\u001082\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00020\bH\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\bH\u0016¢\u0006\u0004\b:\u0010=J\u001a\u0010?\u001a\u00020\u00122\b\u0010>\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0004\b?\u0010&J\u000f\u0010@\u001a\u00020\nH\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020<H\u0002¢\u0006\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010A¨\u0006J"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "backing", "", "offset", "length", "parent", "Lkotlin/collections/builders/ListBuilder;", "root", "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "", "isEmpty", "()Z", "index", "get", "(I)Ljava/lang/Object;", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "()V", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "T", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "writeReplace", "()Ljava/lang/Object;", "getSize", "size", "Itr", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
        public Object[] c;
        public final int d;
        public int e;
        public final BuilderSubList f;
        public final ListBuilder g;

        @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$BuilderSubList$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", "E", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            public final BuilderSubList c;
            public int d;
            public int e = -1;
            public int f;

            public Itr(BuilderSubList builderSubList, int i) {
                Intrinsics.checkNotNullParameter(builderSubList, "list");
                this.c = builderSubList;
                this.d = i;
                this.f = builderSubList.modCount;
            }

            public final void a() {
                if (this.c.g.modCount != this.f) {
                    throw new ConcurrentModificationException();
                }
            }

            public final void add(Object obj) {
                a();
                int i = this.d;
                this.d = i + 1;
                BuilderSubList builderSubList = this.c;
                builderSubList.add(i, obj);
                this.e = -1;
                this.f = builderSubList.modCount;
            }

            public final boolean hasNext() {
                if (this.d < this.c.e) {
                    return true;
                }
                return false;
            }

            public final boolean hasPrevious() {
                if (this.d > 0) {
                    return true;
                }
                return false;
            }

            public final Object next() {
                a();
                int i = this.d;
                BuilderSubList builderSubList = this.c;
                if (i < builderSubList.e) {
                    int i2 = this.d;
                    this.d = i2 + 1;
                    this.e = i2;
                    return builderSubList.c[builderSubList.d + this.e];
                }
                throw new NoSuchElementException();
            }

            public final int nextIndex() {
                return this.d;
            }

            public final Object previous() {
                a();
                int i = this.d;
                if (i > 0) {
                    int i2 = i - 1;
                    this.d = i2;
                    this.e = i2;
                    BuilderSubList builderSubList = this.c;
                    return builderSubList.c[builderSubList.d + this.e];
                }
                throw new NoSuchElementException();
            }

            public final int previousIndex() {
                return this.d - 1;
            }

            public final void remove() {
                a();
                int i = this.e;
                if (i != -1) {
                    BuilderSubList builderSubList = this.c;
                    builderSubList.remove(i);
                    this.d = this.e;
                    this.e = -1;
                    this.f = builderSubList.modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            public final void set(Object obj) {
                a();
                int i = this.e;
                if (i != -1) {
                    this.c.set(i, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        public BuilderSubList(@NotNull E[] eArr, int i, int i2, @Nullable BuilderSubList<E> builderSubList, @NotNull ListBuilder<E> listBuilder) {
            Intrinsics.checkNotNullParameter(eArr, "backing");
            Intrinsics.checkNotNullParameter(listBuilder, "root");
            this.c = eArr;
            this.d = i;
            this.e = i2;
            this.f = builderSubList;
            this.g = listBuilder;
            this.modCount = listBuilder.modCount;
        }

        private final Object writeReplace() {
            if (this.g.e) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        public final void a(int i, Collection collection, int i2) {
            this.modCount++;
            ListBuilder listBuilder = this.g;
            BuilderSubList builderSubList = this.f;
            if (builderSubList != null) {
                builderSubList.a(i, collection, i2);
            } else {
                listBuilder.a(i, collection, i2);
            }
            this.c = listBuilder.c;
            this.e += i2;
        }

        public boolean add(E e2) {
            d();
            c();
            b(this.d + this.e, e2);
            return true;
        }

        public boolean addAll(@NotNull Collection<? extends E> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            d();
            c();
            int size = collection.size();
            a(this.d + this.e, collection, size);
            return size > 0;
        }

        public final void b(int i, Object obj) {
            this.modCount++;
            ListBuilder listBuilder = this.g;
            BuilderSubList builderSubList = this.f;
            if (builderSubList != null) {
                builderSubList.b(i, obj);
            } else {
                ListBuilder.access$addAtInternal(listBuilder, i, obj);
            }
            this.c = listBuilder.c;
            this.e++;
        }

        public final void c() {
            if (this.g.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public void clear() {
            d();
            c();
            f(this.d, this.e);
        }

        public final void d() {
            if (this.g.e) {
                throw new UnsupportedOperationException();
            }
        }

        public final Object e(int i) {
            Object obj;
            this.modCount++;
            BuilderSubList builderSubList = this.f;
            if (builderSubList != null) {
                obj = builderSubList.e(i);
            } else {
                obj = this.g.d(i);
            }
            this.e--;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            c();
            if (obj != this) {
                if (obj instanceof List) {
                    if (ListBuilderKt.a(this.c, this.d, this.e, (List) obj)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public final void f(int i, int i2) {
            if (i2 > 0) {
                this.modCount++;
            }
            BuilderSubList builderSubList = this.f;
            if (builderSubList != null) {
                builderSubList.f(i, i2);
            } else {
                this.g.e(i, i2);
            }
            this.e -= i2;
        }

        public final int g(int i, int i2, Collection collection, boolean z) {
            int i3;
            BuilderSubList builderSubList = this.f;
            if (builderSubList != null) {
                i3 = builderSubList.g(i, i2, collection, z);
            } else {
                i3 = this.g.f(i, i2, collection, z);
            }
            if (i3 > 0) {
                this.modCount++;
            }
            this.e -= i3;
            return i3;
        }

        public E get(int i) {
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.b(i, i2);
            return this.c[this.d + i];
        }

        public int getSize() {
            c();
            return this.e;
        }

        public int hashCode() {
            int i;
            c();
            Object[] objArr = this.c;
            int i2 = this.e;
            int i3 = 1;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[this.d + i4];
                int i5 = i3 * 31;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                i3 = i5 + i;
            }
            return i3;
        }

        public int indexOf(Object obj) {
            c();
            for (int i = 0; i < this.e; i++) {
                if (Intrinsics.a(this.c[this.d + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            c();
            if (this.e == 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        public int lastIndexOf(Object obj) {
            c();
            for (int i = this.e - 1; i >= 0; i--) {
                if (Intrinsics.a(this.c[this.d + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @NotNull
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public boolean remove(Object obj) {
            d();
            c();
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                remove(indexOf);
            }
            if (indexOf >= 0) {
                return true;
            }
            return false;
        }

        public boolean removeAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            d();
            c();
            if (g(this.d, this.e, collection, false) > 0) {
                return true;
            }
            return false;
        }

        public E removeAt(int i) {
            d();
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.b(i, i2);
            return e(this.d + i);
        }

        public boolean retainAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            d();
            c();
            if (g(this.d, this.e, collection, true) > 0) {
                return true;
            }
            return false;
        }

        public E set(int i, E e2) {
            d();
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.b(i, i2);
            E[] eArr = this.c;
            int i3 = this.d + i;
            E e3 = eArr[i3];
            eArr[i3] = e2;
            return e3;
        }

        @NotNull
        public List<E> subList(int i, int i2) {
            AbstractList.Companion companion = AbstractList.Companion;
            int i3 = this.e;
            companion.getClass();
            AbstractList.Companion.d(i, i2, i3);
            return new BuilderSubList(this.c, this.d + i, i2 - i, this, this.g);
        }

        @NotNull
        public <T> T[] toArray(@NotNull T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            c();
            int length = tArr.length;
            int i = this.e;
            int i2 = this.d;
            if (length < i) {
                T[] copyOfRange = Arrays.copyOfRange(this.c, i2, i + i2, tArr.getClass());
                Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
                return copyOfRange;
            }
            ArraysKt.j(this.c, 0, tArr, i2, i + i2);
            CollectionsKt.B(this.e, tArr);
            return tArr;
        }

        @NotNull
        public String toString() {
            c();
            return ListBuilderKt.b(this.c, this.d, this.e, this);
        }

        @NotNull
        public ListIterator<E> listIterator(int i) {
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.c(i, i2);
            return new Itr(this, i);
        }

        public void add(int i, E e2) {
            d();
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.c(i, i2);
            b(this.d + i, e2);
        }

        public boolean addAll(int i, @NotNull Collection<? extends E> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            d();
            c();
            AbstractList.Companion companion = AbstractList.Companion;
            int i2 = this.e;
            companion.getClass();
            AbstractList.Companion.c(i, i2);
            int size = collection.size();
            a(this.d + i, collection, size);
            return size > 0;
        }

        @NotNull
        public Object[] toArray() {
            c();
            Object[] objArr = this.c;
            int i = this.e;
            int i2 = this.d;
            return ArraysKt.l(i2, i + i2, objArr);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "Lkotlin/collections/builders/ListBuilder;", "", "Empty", "Lkotlin/collections/builders/ListBuilder;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        public final ListBuilder c;
        public int d;
        public int e = -1;
        public int f;

        public Itr(ListBuilder listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.c = listBuilder;
            this.d = i;
            this.f = listBuilder.modCount;
        }

        public final void a() {
            if (this.c.modCount != this.f) {
                throw new ConcurrentModificationException();
            }
        }

        public final void add(Object obj) {
            a();
            int i = this.d;
            this.d = i + 1;
            ListBuilder listBuilder = this.c;
            listBuilder.add(i, obj);
            this.e = -1;
            this.f = listBuilder.modCount;
        }

        public final boolean hasNext() {
            if (this.d < this.c.d) {
                return true;
            }
            return false;
        }

        public final boolean hasPrevious() {
            if (this.d > 0) {
                return true;
            }
            return false;
        }

        public final Object next() {
            a();
            int i = this.d;
            ListBuilder listBuilder = this.c;
            if (i < listBuilder.d) {
                int i2 = this.d;
                this.d = i2 + 1;
                this.e = i2;
                return listBuilder.c[this.e];
            }
            throw new NoSuchElementException();
        }

        public final int nextIndex() {
            return this.d;
        }

        public final Object previous() {
            a();
            int i = this.d;
            if (i > 0) {
                int i2 = i - 1;
                this.d = i2;
                this.e = i2;
                return this.c.c[this.e];
            }
            throw new NoSuchElementException();
        }

        public final int previousIndex() {
            return this.d - 1;
        }

        public final void remove() {
            a();
            int i = this.e;
            if (i != -1) {
                ListBuilder listBuilder = this.c;
                listBuilder.remove(i);
                this.d = this.e;
                this.e = -1;
                this.f = listBuilder.modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        public final void set(Object obj) {
            a();
            int i = this.e;
            if (i != -1) {
                this.c.set(i, obj);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.e = true;
        g = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static final void access$addAtInternal(ListBuilder listBuilder, int i, Object obj) {
        listBuilder.modCount++;
        listBuilder.c(i, 1);
        listBuilder.c[i] = obj;
    }

    private final Object writeReplace() {
        if (this.e) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public final void a(int i, Collection collection, int i2) {
        this.modCount++;
        c(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.c[i + i3] = it.next();
        }
    }

    public boolean add(E e2) {
        b();
        int i = this.d;
        this.modCount++;
        c(i, 1);
        this.c[i] = e2;
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        b();
        int size = collection.size();
        a(this.d, collection, size);
        return size > 0;
    }

    public final void b() {
        if (this.e) {
            throw new UnsupportedOperationException();
        }
    }

    @NotNull
    public final List<E> build() {
        b();
        this.e = true;
        if (this.d > 0) {
            return this;
        }
        return g;
    }

    public final void c(int i, int i2) {
        int i3 = this.d + i2;
        if (i3 >= 0) {
            Object[] objArr = this.c;
            if (i3 > objArr.length) {
                AbstractList.Companion companion = AbstractList.Companion;
                int length = objArr.length;
                companion.getClass();
                int e2 = AbstractList.Companion.e(length, i3);
                Object[] objArr2 = this.c;
                Intrinsics.checkNotNullParameter(objArr2, "<this>");
                Object[] copyOf = Arrays.copyOf(objArr2, e2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.c = copyOf;
            }
            Object[] objArr3 = this.c;
            ArraysKt.j(objArr3, i + i2, objArr3, i, this.d);
            this.d += i2;
            return;
        }
        throw new OutOfMemoryError();
    }

    public void clear() {
        b();
        e(0, this.d);
    }

    public final Object d(int i) {
        this.modCount++;
        Object[] objArr = this.c;
        Object obj = objArr[i];
        ArraysKt.j(objArr, i, objArr, i + 1, this.d);
        Object[] objArr2 = this.c;
        Intrinsics.checkNotNullParameter(objArr2, "<this>");
        objArr2[this.d - 1] = null;
        this.d--;
        return obj;
    }

    public final void e(int i, int i2) {
        if (i2 > 0) {
            this.modCount++;
        }
        Object[] objArr = this.c;
        ArraysKt.j(objArr, i, objArr, i + i2, this.d);
        Object[] objArr2 = this.c;
        int i3 = this.d;
        ListBuilderKt.c(i3 - i2, i3, objArr2);
        this.d -= i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            if (ListBuilderKt.a(this.c, 0, this.d, (List) obj)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int f(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.c[i5]) == z) {
                Object[] objArr = this.c;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.c;
        ArraysKt.j(objArr2, i + i4, objArr2, i2 + i, this.d);
        Object[] objArr3 = this.c;
        int i7 = this.d;
        ListBuilderKt.c(i7 - i6, i7, objArr3);
        if (i6 > 0) {
            this.modCount++;
        }
        this.d -= i6;
        return i6;
    }

    public E get(int i) {
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.b(i, i2);
        return this.c[i];
    }

    public int getSize() {
        return this.d;
    }

    public int hashCode() {
        int i;
        Object[] objArr = this.c;
        int i2 = this.d;
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            int i5 = i3 * 31;
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i3 = i5 + i;
        }
        return i3;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.d; i++) {
            if (Intrinsics.a(this.c[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.d == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        for (int i = this.d - 1; i >= 0; i--) {
            if (Intrinsics.a(this.c[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public boolean remove(Object obj) {
        b();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        b();
        if (f(0, this.d, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public E removeAt(int i) {
        b();
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.b(i, i2);
        return d(i);
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        b();
        if (f(0, this.d, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public E set(int i, E e2) {
        b();
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.b(i, i2);
        E[] eArr = this.c;
        E e3 = eArr[i];
        eArr[i] = e2;
        return e3;
    }

    @NotNull
    public List<E> subList(int i, int i2) {
        AbstractList.Companion companion = AbstractList.Companion;
        int i3 = this.d;
        companion.getClass();
        AbstractList.Companion.d(i, i2, i3);
        return new BuilderSubList(this.c, i, i2 - i, (BuilderSubList) null, this);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        int length = tArr.length;
        int i = this.d;
        if (length < i) {
            T[] copyOfRange = Arrays.copyOfRange(this.c, 0, i, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        ArraysKt.j(this.c, 0, tArr, 0, i);
        CollectionsKt.B(this.d, tArr);
        return tArr;
    }

    @NotNull
    public String toString() {
        return ListBuilderKt.b(this.c, 0, this.d, this);
    }

    public ListBuilder(int i) {
        if (i >= 0) {
            this.c = new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @NotNull
    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.c(i, i2);
        return new Itr(this, i);
    }

    public boolean addAll(int i, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        b();
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.c(i, i2);
        int size = collection.size();
        a(i, collection, size);
        return size > 0;
    }

    @NotNull
    public Object[] toArray() {
        return ArraysKt.l(0, this.d, this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    public void add(int i, E e2) {
        b();
        AbstractList.Companion companion = AbstractList.Companion;
        int i2 = this.d;
        companion.getClass();
        AbstractList.Companion.c(i, i2);
        this.modCount++;
        c(i, 1);
        this.c[i] = e2;
    }
}
