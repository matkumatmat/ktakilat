package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001R\u0011\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0002X\u0004R\u0011\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0002X\u0004R\u0013\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0002X\u0004¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "Lkotlinx/coroutines/internal/Removed;", "_removedRef", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
@InternalCoroutinesApi
public class LockFreeLinkedListNode {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Class<LockFreeLinkedListNode> cls = LockFreeLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev$volatile");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef$volatile");
    }

    public final boolean c(LockFreeLinkedListNode lockFreeLinkedListNode, int i) {
        while (true) {
            LockFreeLinkedListNode e2 = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            if (e2 == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    e2 = (LockFreeLinkedListNode) obj;
                    if (!e2.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(e2);
                }
            }
            if (!(e2 instanceof ListClosed)) {
                atomicReferenceFieldUpdater.set(lockFreeLinkedListNode, e2);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = c;
                atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode, this);
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(e2, this, lockFreeLinkedListNode)) {
                        lockFreeLinkedListNode.f(this);
                        return true;
                    } else if (atomicReferenceFieldUpdater2.get(e2) != this) {
                    }
                }
            } else if ((((ListClosed) e2).f & i) != 0 || !e2.c(lockFreeLinkedListNode, i)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public final void d(int i) {
        c(new ListClosed(i), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r6 = ((kotlinx.coroutines.internal.Removed) r6).f803a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r5.compareAndSet(r4, r3, r6) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (r5.get(r4) == r3) goto L_0x0035;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode e() {
        /*
            r9 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = d
            java.lang.Object r1 = r0.get(r9)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            r3 = r1
        L_0x000a:
            r4 = r2
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = c
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L_0x0024
            if (r1 != r3) goto L_0x0016
            return r3
        L_0x0016:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L_0x001d
            return r3
        L_0x001d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L_0x0016
            goto L_0x0000
        L_0x0024:
            boolean r7 = r9.h()
            if (r7 == 0) goto L_0x002b
            return r2
        L_0x002b:
            boolean r7 = r6 instanceof kotlinx.coroutines.internal.Removed
            if (r7 == 0) goto L_0x004b
            if (r4 == 0) goto L_0x0044
            kotlinx.coroutines.internal.Removed r6 = (kotlinx.coroutines.internal.Removed) r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = r6.f803a
        L_0x0035:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L_0x003d
            r3 = r4
            goto L_0x000a
        L_0x003d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L_0x0035
            goto L_0x0000
        L_0x0044:
            java.lang.Object r3 = r0.get(r3)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            goto L_0x000b
        L_0x004b:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.Intrinsics.d(r6, r4)
            r4 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.e():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final void f(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (c.get(this) == lockFreeLinkedListNode) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                        if (h()) {
                            lockFreeLinkedListNode.e();
                            return;
                        }
                        return;
                    } else if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != lockFreeLinkedListNode2) {
                    }
                }
            } else {
                return;
            }
        }
    }

    public final LockFreeLinkedListNode g() {
        Removed removed;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object obj = c.get(this);
        if (obj instanceof Removed) {
            removed = (Removed) obj;
        } else {
            removed = null;
        }
        if (removed != null && (lockFreeLinkedListNode = removed.f803a) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode) obj;
    }

    public boolean h() {
        return c.get(this) instanceof Removed;
    }

    public final void i() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Removed) {
                LockFreeLinkedListNode lockFreeLinkedListNode = ((Removed) obj).f803a;
                return;
            } else if (obj == this) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                return;
            } else {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                LockFreeLinkedListNode lockFreeLinkedListNode3 = (LockFreeLinkedListNode) obj;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
                Removed removed = (Removed) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode3);
                if (removed == null) {
                    removed = new Removed(lockFreeLinkedListNode3);
                    atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode3, removed);
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, removed)) {
                        lockFreeLinkedListNode3.e();
                        return;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
            }
        }
    }

    public String toString() {
        return new PropertyReference0Impl(this, DebugStringsKt.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + DebugStringsKt.a(this);
    }
}
