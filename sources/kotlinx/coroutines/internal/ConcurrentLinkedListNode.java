package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002R\u0013\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00038\u0002X\u0004R\u0013\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00038\u0002X\u0004¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,265:1\n103#1,7:266\n1#2:273\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n111#1:266,7\n*E\n"})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Class<ConcurrentLinkedListNode> cls = ConcurrentLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev$volatile");
    }

    public ConcurrentLinkedListNode(Segment segment) {
        this._prev$volatile = segment;
    }

    public final void a() {
        d.set(this, (Object) null);
    }

    public final ConcurrentLinkedListNode b() {
        Object obj = c.get(this);
        if (obj == ConcurrentLinkedListKt.f793a) {
            return null;
        }
        return (ConcurrentLinkedListNode) obj;
    }

    public abstract boolean c();

    public final void e() {
        ConcurrentLinkedListNode concurrentLinkedListNode;
        ConcurrentLinkedListNode b;
        if (b() != null) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(this);
                while (concurrentLinkedListNode2 != null && concurrentLinkedListNode2.c()) {
                    concurrentLinkedListNode2 = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(concurrentLinkedListNode2);
                }
                ConcurrentLinkedListNode b2 = b();
                Intrinsics.c(b2);
                while (b2.c() && (b = b2.b()) != null) {
                    b2 = b;
                }
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(b2);
                    if (((ConcurrentLinkedListNode) obj) == null) {
                        concurrentLinkedListNode = null;
                    } else {
                        concurrentLinkedListNode = concurrentLinkedListNode2;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(b2, obj, concurrentLinkedListNode)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(b2) != obj) {
                        }
                    }
                }
                if (concurrentLinkedListNode2 != null) {
                    c.set(concurrentLinkedListNode2, b2);
                }
                if ((!b2.c() || b2.b() == null) && (concurrentLinkedListNode2 == null || !concurrentLinkedListNode2.c())) {
                    return;
                }
            }
        }
    }
}
