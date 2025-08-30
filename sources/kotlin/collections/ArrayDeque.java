package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,660:1\n476#1,53:665\n476#1,53:718\n37#2:661\n36#2,3:662\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n471#1:665,53\n473#1:718,53\n46#1:661\n46#1:662,3\n*E\n"})
@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0005*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0006B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "<init>", "()V", "f", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    @NotNull
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final Object[] g = new Object[0];
    public int c;
    public Object[] d = g;
    public int e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "", "emptyElementData", "[Ljava/lang/Object;", "", "defaultMinCapacity", "I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final void a(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.d.length;
        while (i < length && it.hasNext()) {
            this.d[i] = it.next();
            i++;
        }
        int i2 = this.c;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.d[i3] = it.next();
        }
        this.e = collection.size() + size();
    }

    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    public final boolean addAll(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return false;
        }
        g();
        b(collection.size() + size());
        a(f(size() + this.c), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        g();
        b(size() + 1);
        int i = this.c;
        if (i == 0) {
            Object[] objArr = this.d;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            i = objArr.length;
        }
        int i2 = i - 1;
        this.c = i2;
        this.d[i2] = obj;
        this.e = size() + 1;
    }

    public final void addLast(Object obj) {
        g();
        b(size() + 1);
        this.d[f(size() + this.c)] = obj;
        this.e = size() + 1;
    }

    public final void b(int i) {
        if (i >= 0) {
            Object[] objArr = this.d;
            if (i > objArr.length) {
                if (objArr == g) {
                    if (i < 10) {
                        i = 10;
                    }
                    this.d = new Object[i];
                    return;
                }
                AbstractList.Companion companion = AbstractList.Companion;
                int length = objArr.length;
                companion.getClass();
                Object[] objArr2 = new Object[AbstractList.Companion.e(length, i)];
                Object[] objArr3 = this.d;
                ArraysKt.j(objArr3, 0, objArr2, this.c, objArr3.length);
                Object[] objArr4 = this.d;
                int length2 = objArr4.length;
                int i2 = this.c;
                ArraysKt.j(objArr4, length2 - i2, objArr2, 0, i2);
                this.c = 0;
                this.d = objArr2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int c(int i) {
        Object[] objArr = this.d;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (i == objArr.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final void clear() {
        if (!isEmpty()) {
            g();
            e(this.c, f(size() + this.c));
        }
        this.c = 0;
        this.e = 0;
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final int d(int i) {
        if (i < 0) {
            return i + this.d.length;
        }
        return i;
    }

    public final void e(int i, int i2) {
        if (i < i2) {
            ArraysKt.m(this.d, (Symbol) null, i, i2);
            return;
        }
        Object[] objArr = this.d;
        int length = objArr.length;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, i, length, (Object) null);
        ArraysKt.m(this.d, (Symbol) null, 0, i2);
    }

    public final int f(int i) {
        Object[] objArr = this.d;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    public final void g() {
        this.modCount++;
    }

    public final Object get(int i) {
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.b(i, size);
        return this.d[f(this.c + i)];
    }

    public final int getSize() {
        return this.e;
    }

    public final int indexOf(Object obj) {
        int i;
        int f2 = f(size() + this.c);
        int i2 = this.c;
        if (i2 < f2) {
            while (i2 < f2) {
                if (Intrinsics.a(obj, this.d[i2])) {
                    i = this.c;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < f2) {
            return -1;
        } else {
            int length = this.d.length;
            while (true) {
                if (i2 >= length) {
                    int i3 = 0;
                    while (i3 < f2) {
                        if (Intrinsics.a(obj, this.d[i3])) {
                            i2 = i3 + this.d.length;
                            i = this.c;
                        } else {
                            i3++;
                        }
                    }
                    return -1;
                } else if (Intrinsics.a(obj, this.d[i2])) {
                    i = this.c;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final int lastIndexOf(Object obj) {
        int i;
        int i2;
        int f2 = f(size() + this.c);
        int i3 = this.c;
        if (i3 < f2) {
            i = f2 - 1;
            if (i3 <= i) {
                while (!Intrinsics.a(obj, this.d[i])) {
                    if (i != i3) {
                        i--;
                    }
                }
                i2 = this.c;
            }
            return -1;
        }
        if (i3 > f2) {
            int i4 = f2 - 1;
            while (true) {
                if (-1 >= i4) {
                    Object[] objArr = this.d;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    int length = objArr.length - 1;
                    int i5 = this.c;
                    if (i5 <= length) {
                        while (!Intrinsics.a(obj, this.d[i])) {
                            if (i != i5) {
                                length = i - 1;
                            }
                        }
                        i2 = this.c;
                    }
                } else if (Intrinsics.a(obj, this.d[i4])) {
                    i = i4 + this.d.length;
                    i2 = this.c;
                    break;
                } else {
                    i4--;
                }
            }
        }
        return -1;
        return i - i2;
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean removeAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.d
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.c
            int r2 = r11.size()
            int r2 = r2 + r0
            int r0 = r11.f(r2)
            int r2 = r11.c
            r3 = 1
            r4 = 0
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.d
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 != 0) goto L_0x0039
            java.lang.Object[] r7 = r11.d
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.d
            kotlin.collections.ArraysKt.m(r12, r4, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.d
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.d
            r9 = r8[r2]
            r8[r2] = r4
            boolean r8 = r12.contains(r9)
            if (r8 != 0) goto L_0x005e
            java.lang.Object[] r8 = r11.d
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.f(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.d
            r6 = r2[r1]
            r2[r1] = r4
            boolean r2 = r12.contains(r6)
            if (r2 != 0) goto L_0x007e
            java.lang.Object[] r2 = r11.d
            r2[r5] = r6
            int r5 = r11.c(r5)
            goto L_0x007f
        L_0x007e:
            r7 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.g()
            int r12 = r11.c
            int r5 = r5 - r12
            int r12 = r11.d(r5)
            r11.e = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    public final Object removeAt(int i) {
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.b(i, size);
        if (i == CollectionsKt.n(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        g();
        int f2 = f(this.c + i);
        Object obj = this.d[f2];
        if (i < (size() >> 1)) {
            int i2 = this.c;
            if (f2 >= i2) {
                Object[] objArr = this.d;
                ArraysKt.j(objArr, i2 + 1, objArr, i2, f2);
            } else {
                Object[] objArr2 = this.d;
                ArraysKt.j(objArr2, 1, objArr2, 0, f2);
                Object[] objArr3 = this.d;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.c;
                ArraysKt.j(objArr3, i3 + 1, objArr3, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.d;
            int i4 = this.c;
            objArr4[i4] = null;
            this.c = c(i4);
        } else {
            int f3 = f(CollectionsKt.n(this) + this.c);
            if (f2 <= f3) {
                Object[] objArr5 = this.d;
                ArraysKt.j(objArr5, f2, objArr5, f2 + 1, f3 + 1);
            } else {
                Object[] objArr6 = this.d;
                ArraysKt.j(objArr6, f2, objArr6, f2 + 1, objArr6.length);
                Object[] objArr7 = this.d;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.j(objArr7, 0, objArr7, 1, f3 + 1);
            }
            this.d[f3] = null;
        }
        this.e = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            g();
            Object[] objArr = this.d;
            int i = this.c;
            Object obj = objArr[i];
            objArr[i] = null;
            this.c = c(i);
            this.e = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            g();
            int f2 = f(CollectionsKt.n(this) + this.c);
            Object[] objArr = this.d;
            Object obj = objArr[f2];
            objArr[f2] = null;
            this.e = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final void removeRange(int i, int i2) {
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.d(i, i2, size);
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == size()) {
                clear();
            } else if (i3 == 1) {
                remove(i);
            } else {
                g();
                if (i < size() - i2) {
                    int f2 = f((i - 1) + this.c);
                    int f3 = f((i2 - 1) + this.c);
                    while (i > 0) {
                        int i4 = f2 + 1;
                        int min = Math.min(i, Math.min(i4, f3 + 1));
                        Object[] objArr = this.d;
                        int i5 = f3 - min;
                        int i6 = f2 - min;
                        ArraysKt.j(objArr, i5 + 1, objArr, i6 + 1, i4);
                        f2 = d(i6);
                        f3 = d(i5);
                        i -= min;
                    }
                    int f4 = f(this.c + i3);
                    e(this.c, f4);
                    this.c = f4;
                } else {
                    int f5 = f(this.c + i2);
                    int f6 = f(this.c + i);
                    int size2 = size();
                    while (true) {
                        size2 -= i2;
                        if (size2 <= 0) {
                            break;
                        }
                        Object[] objArr2 = this.d;
                        i2 = Math.min(size2, Math.min(objArr2.length - f5, objArr2.length - f6));
                        Object[] objArr3 = this.d;
                        int i7 = f5 + i2;
                        ArraysKt.j(objArr3, f6, objArr3, f5, i7);
                        f5 = f(i7);
                        f6 = f(f6 + i2);
                    }
                    int f7 = f(size() + this.c);
                    e(d(f7 - i3), f7);
                }
                this.e = size() - i3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean retainAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.d
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.c
            int r2 = r11.size()
            int r2 = r2 + r0
            int r0 = r11.f(r2)
            int r2 = r11.c
            r3 = 1
            r4 = 0
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.d
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.d
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.d
            kotlin.collections.ArraysKt.m(r12, r4, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.d
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.d
            r9 = r8[r2]
            r8[r2] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.d
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.f(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.d
            r6 = r2[r1]
            r2[r1] = r4
            boolean r2 = r12.contains(r6)
            if (r2 == 0) goto L_0x007e
            java.lang.Object[] r2 = r11.d
            r2[r5] = r6
            int r5 = r11.c(r5)
            goto L_0x007f
        L_0x007e:
            r7 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.g()
            int r12 = r11.c
            int r5 = r5 - r12
            int r12 = r11.d(r5)
            r11.e = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    public final Object set(int i, Object obj) {
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.b(i, size);
        int f2 = f(this.c + i);
        Object[] objArr = this.d;
        Object obj2 = objArr[f2];
        objArr[f2] = obj;
        return obj2;
    }

    public final Object[] toArray(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        if (objArr.length < size()) {
            int size = size();
            Intrinsics.checkNotNullParameter(objArr, "reference");
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) newInstance;
        }
        int f2 = f(size() + this.c);
        int i = this.c;
        if (i < f2) {
            ArraysKt.j(this.d, 0, objArr, i, f2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.d;
            ArraysKt.j(objArr2, 0, objArr, this.c, objArr2.length);
            Object[] objArr3 = this.d;
            ArraysKt.j(objArr3, objArr3.length - this.c, objArr, 0, f2);
        }
        CollectionsKt.B(size(), objArr);
        return objArr;
    }

    public final void add(int i, Object obj) {
        int i2;
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.c(i, size);
        if (i == size()) {
            addLast(obj);
        } else if (i == 0) {
            addFirst(obj);
        } else {
            g();
            b(size() + 1);
            int f2 = f(this.c + i);
            if (i < ((size() + 1) >> 1)) {
                if (f2 == 0) {
                    Object[] objArr = this.d;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    f2 = objArr.length;
                }
                int i3 = f2 - 1;
                int i4 = this.c;
                if (i4 == 0) {
                    Object[] objArr2 = this.d;
                    Intrinsics.checkNotNullParameter(objArr2, "<this>");
                    i2 = objArr2.length - 1;
                } else {
                    i2 = i4 - 1;
                }
                int i5 = this.c;
                if (i3 >= i5) {
                    Object[] objArr3 = this.d;
                    objArr3[i2] = objArr3[i5];
                    ArraysKt.j(objArr3, i5, objArr3, i5 + 1, i3 + 1);
                } else {
                    Object[] objArr4 = this.d;
                    ArraysKt.j(objArr4, i5 - 1, objArr4, i5, objArr4.length);
                    Object[] objArr5 = this.d;
                    objArr5[objArr5.length - 1] = objArr5[0];
                    ArraysKt.j(objArr5, 0, objArr5, 1, i3 + 1);
                }
                this.d[i3] = obj;
                this.c = i2;
            } else {
                int f3 = f(size() + this.c);
                if (f2 < f3) {
                    Object[] objArr6 = this.d;
                    ArraysKt.j(objArr6, f2 + 1, objArr6, f2, f3);
                } else {
                    Object[] objArr7 = this.d;
                    ArraysKt.j(objArr7, 1, objArr7, 0, f3);
                    Object[] objArr8 = this.d;
                    objArr8[0] = objArr8[objArr8.length - 1];
                    ArraysKt.j(objArr8, f2 + 1, objArr8, f2, objArr8.length - 1);
                }
                this.d[f2] = obj;
            }
            this.e = size() + 1;
        }
    }

    public final boolean addAll(int i, Collection collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        AbstractList.Companion companion = AbstractList.Companion;
        int size = size();
        companion.getClass();
        AbstractList.Companion.c(i, size);
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        g();
        b(collection.size() + size());
        int f2 = f(size() + this.c);
        int f3 = f(this.c + i);
        int size2 = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.c;
            int i3 = i2 - size2;
            if (f3 < i2) {
                Object[] objArr = this.d;
                ArraysKt.j(objArr, i3, objArr, i2, objArr.length);
                if (size2 >= f3) {
                    Object[] objArr2 = this.d;
                    ArraysKt.j(objArr2, objArr2.length - size2, objArr2, 0, f3);
                } else {
                    Object[] objArr3 = this.d;
                    ArraysKt.j(objArr3, objArr3.length - size2, objArr3, 0, size2);
                    Object[] objArr4 = this.d;
                    ArraysKt.j(objArr4, 0, objArr4, size2, f3);
                }
            } else if (i3 >= 0) {
                Object[] objArr5 = this.d;
                ArraysKt.j(objArr5, i3, objArr5, i2, f3);
            } else {
                Object[] objArr6 = this.d;
                i3 += objArr6.length;
                int i4 = f3 - i2;
                int length = objArr6.length - i3;
                if (length >= i4) {
                    ArraysKt.j(objArr6, i3, objArr6, i2, f3);
                } else {
                    ArraysKt.j(objArr6, i3, objArr6, i2, i2 + length);
                    Object[] objArr7 = this.d;
                    ArraysKt.j(objArr7, 0, objArr7, this.c + length, f3);
                }
            }
            this.c = i3;
            a(d(f3 - size2), collection);
        } else {
            int i5 = f3 + size2;
            if (f3 < f2) {
                int i6 = size2 + f2;
                Object[] objArr8 = this.d;
                if (i6 <= objArr8.length) {
                    ArraysKt.j(objArr8, i5, objArr8, f3, f2);
                } else if (i5 >= objArr8.length) {
                    ArraysKt.j(objArr8, i5 - objArr8.length, objArr8, f3, f2);
                } else {
                    int length2 = f2 - (i6 - objArr8.length);
                    ArraysKt.j(objArr8, 0, objArr8, length2, f2);
                    Object[] objArr9 = this.d;
                    ArraysKt.j(objArr9, i5, objArr9, f3, length2);
                }
            } else {
                Object[] objArr10 = this.d;
                ArraysKt.j(objArr10, size2, objArr10, 0, f2);
                Object[] objArr11 = this.d;
                if (i5 >= objArr11.length) {
                    ArraysKt.j(objArr11, i5 - objArr11.length, objArr11, f3, objArr11.length);
                } else {
                    ArraysKt.j(objArr11, 0, objArr11, objArr11.length - size2, objArr11.length);
                    Object[] objArr12 = this.d;
                    ArraysKt.j(objArr12, i5, objArr12, f3, objArr12.length - size2);
                }
            }
            a(f3, collection);
        }
        return true;
    }

    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
