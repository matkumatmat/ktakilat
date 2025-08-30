package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;

@SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n1#2:281\n*E\n"})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\n\u000b\fR\u000b\u0010\u0006\u001a\u00020\u00058\u0002X\u0004R!\u0010\t\u001a\u0018\u0012\u0014\u0012\u00120\bR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u00078\u0002X\u0004¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Lkotlinx/atomicfu/AtomicInt;", "_size", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "core", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e;
    private volatile /* synthetic */ int _size$volatile;
    public final ReferenceQueue c;
    private volatile /* synthetic */ Object core$volatile = new Core(16);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001:\u0001\bR\u000b\u0010\u0003\u001a\u00020\u00028\u0002X\u0004R\u0019\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00048\u0002X\u0004R\u0013\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0002X\u0004¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "Lkotlinx/atomicfu/AtomicInt;", "load", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "keys", "values", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Core {
        public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load$volatile");

        /* renamed from: a  reason: collision with root package name */
        public final int f779a;
        public final int b;
        public final int c;
        public final /* synthetic */ AtomicReferenceArray d;
        public final /* synthetic */ AtomicReferenceArray e;
        private volatile /* synthetic */ int load$volatile;

        @SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n1#2:281\n*E\n"})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            public final Function2 c;
            public int d = -1;
            public Object e;
            public Object f;

            public KeyValueIterator(Function2 function2) {
                this.c = function2;
                a();
            }

            public final void a() {
                Object obj;
                while (true) {
                    int i = this.d + 1;
                    this.d = i;
                    Core core = Core.this;
                    if (i < core.f779a) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) core.d.get(i);
                        if (!(hashedWeakRef == null || (obj = hashedWeakRef.get()) == null)) {
                            this.e = obj;
                            Object obj2 = core.e.get(this.d);
                            if (obj2 instanceof Marked) {
                                obj2 = ((Marked) obj2).f782a;
                            }
                            if (obj2 != null) {
                                this.f = obj2;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            public final boolean hasNext() {
                if (this.d < Core.this.f779a) {
                    return true;
                }
                return false;
            }

            public final Object next() {
                if (this.d < Core.this.f779a) {
                    Object obj = this.e;
                    if (obj != null) {
                        Object obj2 = this.f;
                        if (obj2 != null) {
                            Object invoke = this.c.invoke(obj, obj2);
                            a();
                            return invoke;
                        }
                        Intrinsics.k("value");
                        throw null;
                    }
                    Intrinsics.k("key");
                    throw null;
                }
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException("not implemented");
            }
        }

        public Core(int i) {
            this.f779a = i;
            this.b = Integer.numberOfLeadingZeros(i) + 1;
            this.c = (i * 2) / 3;
            this.d = new AtomicReferenceArray(i);
            this.e = new AtomicReferenceArray(i);
        }

        /* JADX WARNING: Failed to insert additional move for type inference */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(java.lang.Object r10, java.lang.Object r11, kotlinx.coroutines.debug.internal.HashedWeakRef r12) {
            /*
                r9 = this;
                int r0 = r10.hashCode()
                r1 = -1640531527(0xffffffff9e3779b9, float:-9.713111E-21)
                int r0 = r0 * r1
                int r1 = r9.b
                int r0 = r0 >>> r1
                r1 = 0
            L_0x000d:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r9.d
                java.lang.Object r3 = r2.get(r0)
                kotlinx.coroutines.debug.internal.HashedWeakRef r3 = (kotlinx.coroutines.debug.internal.HashedWeakRef) r3
                kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.f780a
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = g
                if (r3 != 0) goto L_0x0055
                r6 = 0
                if (r11 != 0) goto L_0x001f
                return r6
            L_0x001f:
                if (r1 != 0) goto L_0x0035
            L_0x0021:
                int r1 = r5.get(r9)
                int r3 = r9.c
                if (r1 < r3) goto L_0x002a
                return r4
            L_0x002a:
                int r3 = r1 + 1
                boolean r1 = r5.compareAndSet(r9, r1, r3)
                if (r1 == 0) goto L_0x0021
                r1 = 1
                r7 = 1
                goto L_0x0036
            L_0x0035:
                r7 = r1
            L_0x0036:
                if (r12 != 0) goto L_0x0044
                kotlinx.coroutines.debug.internal.HashedWeakRef r12 = new kotlinx.coroutines.debug.internal.HashedWeakRef
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap r1 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r1 = r1.c
                r12.<init>(r10, r1)
                r10.hashCode()
            L_0x0044:
                r8 = r12
            L_0x0045:
                boolean r12 = r2.compareAndSet(r0, r6, r8)
                if (r12 == 0) goto L_0x004c
                goto L_0x0064
            L_0x004c:
                java.lang.Object r12 = r2.get(r0)
                if (r12 == 0) goto L_0x0045
                r1 = r7
                r12 = r8
                goto L_0x000d
            L_0x0055:
                java.lang.Object r2 = r3.get()
                boolean r3 = r10.equals(r2)
                if (r3 == 0) goto L_0x007d
                if (r1 == 0) goto L_0x0064
                r5.decrementAndGet(r9)
            L_0x0064:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r9.e
                java.lang.Object r5 = r3.get(r0)
                boolean r10 = r5 instanceof kotlinx.coroutines.debug.internal.Marked
                if (r10 == 0) goto L_0x006f
                return r4
            L_0x006f:
                boolean r10 = r3.compareAndSet(r0, r5, r11)
                if (r10 == 0) goto L_0x0076
                return r5
            L_0x0076:
                java.lang.Object r10 = r3.get(r0)
                if (r10 == r5) goto L_0x006f
                goto L_0x0064
            L_0x007d:
                if (r2 != 0) goto L_0x0082
                r9.c(r0)
            L_0x0082:
                if (r0 != 0) goto L_0x0086
                int r0 = r9.f779a
            L_0x0086:
                int r0 = r0 + -1
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.a(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.HashedWeakRef):java.lang.Object");
        }

        public final Core b() {
            Object obj;
            Object obj2;
            Marked marked;
            while (true) {
                ConcurrentWeakMap concurrentWeakMap = ConcurrentWeakMap.this;
                int c2 = concurrentWeakMap.c();
                if (c2 < 4) {
                    c2 = 4;
                }
                Core core = new Core(Integer.highestOneBit(c2) * 4);
                int i = 0;
                while (true) {
                    if (i >= this.f779a) {
                        return core;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.d.get(i);
                    if (hashedWeakRef != null) {
                        obj = hashedWeakRef.get();
                    } else {
                        obj = null;
                    }
                    if (hashedWeakRef != null && obj == null) {
                        c(i);
                    }
                    while (true) {
                        AtomicReferenceArray atomicReferenceArray = this.e;
                        obj2 = atomicReferenceArray.get(i);
                        if (obj2 instanceof Marked) {
                            obj2 = ((Marked) obj2).f782a;
                            break;
                        }
                        if (obj2 == null) {
                            marked = ConcurrentWeakMapKt.b;
                        } else if (obj2.equals(Boolean.TRUE)) {
                            marked = ConcurrentWeakMapKt.c;
                        } else {
                            marked = new Marked(obj2);
                        }
                        while (true) {
                            if (atomicReferenceArray.compareAndSet(i, obj2, marked)) {
                                break;
                            } else if (atomicReferenceArray.get(i) != obj2) {
                            }
                        }
                    }
                    if (obj == null || obj2 == null || core.a(obj, obj2, hashedWeakRef) != ConcurrentWeakMapKt.f780a) {
                        i++;
                    }
                }
            }
        }

        public final void c(int i) {
            while (true) {
                AtomicReferenceArray atomicReferenceArray = this.e;
                Object obj = atomicReferenceArray.get(i);
                if (obj != null && !(obj instanceof Marked)) {
                    while (true) {
                        if (atomicReferenceArray.compareAndSet(i, obj, (Object) null)) {
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ConcurrentWeakMap.d;
                            ConcurrentWeakMap concurrentWeakMap = ConcurrentWeakMap.this;
                            concurrentWeakMap.getClass();
                            ConcurrentWeakMap.d.decrementAndGet(concurrentWeakMap);
                            return;
                        } else if (atomicReferenceArray.get(i) != obj) {
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final Object c;
        public final Object d;

        public Entry(Object obj, Object obj2) {
            this.c = obj;
            this.d = obj2;
        }

        public final Object getKey() {
            return this.c;
        }

        public final Object getValue() {
            return this.d;
        }

        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("not implemented");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {
        public final Function2 c;

        public KeyValueSet(Function2 function2) {
            this.c = function2;
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException("not implemented");
        }

        public final int getSize() {
            return ConcurrentWeakMap.this.c();
        }

        public final Iterator iterator() {
            Core core = (Core) ConcurrentWeakMap.e.get(ConcurrentWeakMap.this);
            core.getClass();
            return new Core.KeyValueIterator(this.c);
        }
    }

    static {
        Class<ConcurrentWeakMap> cls = ConcurrentWeakMap.class;
        d = AtomicIntegerFieldUpdater.newUpdater(cls, "_size$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "core$volatile");
    }

    public ConcurrentWeakMap(boolean z) {
        ReferenceQueue referenceQueue;
        if (z) {
            referenceQueue = new ReferenceQueue();
        } else {
            referenceQueue = null;
        }
        this.c = referenceQueue;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    public final Set a() {
        return new KeyValueSet(new Object());
    }

    public final Set b() {
        return new KeyValueSet(new e3(1));
    }

    public final int c() {
        return d.get(this);
    }

    public final void clear() {
        Iterator it = ((KeyValueSet) b()).iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final synchronized Object d(Object obj, Object obj2) {
        Object a2;
        Core core = (Core) e.get(this);
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.g;
            a2 = core.a(obj, obj2, (HashedWeakRef) null);
            if (a2 == ConcurrentWeakMapKt.f780a) {
                core = core.b();
                e.set(this, core);
            }
        }
        return a2;
    }

    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        Core core = (Core) e.get(this);
        core.getClass();
        int hashCode = (obj.hashCode() * -1640531527) >>> core.b;
        while (true) {
            HashedWeakRef hashedWeakRef = (HashedWeakRef) core.d.get(hashCode);
            if (hashedWeakRef == null) {
                return null;
            }
            Object obj2 = hashedWeakRef.get();
            if (obj.equals(obj2)) {
                Object obj3 = core.e.get(hashCode);
                if (obj3 instanceof Marked) {
                    obj3 = ((Marked) obj3).f782a;
                }
                return obj3;
            }
            if (obj2 == null) {
                core.c(hashCode);
            }
            if (hashCode == 0) {
                hashCode = core.f779a;
            }
            hashCode--;
        }
    }

    public final Object put(Object obj, Object obj2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.g;
        Object a2 = ((Core) e.get(this)).a(obj, obj2, (HashedWeakRef) null);
        if (a2 == ConcurrentWeakMapKt.f780a) {
            a2 = d(obj, obj2);
        }
        if (a2 == null) {
            d.incrementAndGet(this);
        }
        return a2;
    }

    public final Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Core.g;
        Object a2 = ((Core) e.get(this)).a(obj, (Object) null, (HashedWeakRef) null);
        if (a2 == ConcurrentWeakMapKt.f780a) {
            a2 = d(obj, (Object) null);
        }
        if (a2 != null) {
            d.decrementAndGet(this);
        }
        return a2;
    }
}
