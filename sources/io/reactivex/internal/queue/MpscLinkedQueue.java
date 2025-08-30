package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    public final AtomicReference c;
    public final AtomicReference d;

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        public Object c;
    }

    public MpscLinkedQueue() {
        AtomicReference atomicReference = new AtomicReference();
        this.c = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.d = atomicReference2;
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        atomicReference2.lazySet(linkedQueueNode);
        LinkedQueueNode linkedQueueNode2 = (LinkedQueueNode) atomicReference.getAndSet(linkedQueueNode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    public final boolean isEmpty() {
        if (((LinkedQueueNode) this.d.get()) == ((LinkedQueueNode) this.c.get())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.internal.queue.MpscLinkedQueue$LinkedQueueNode, java.lang.Object, java.util.concurrent.atomic.AtomicReference] */
    public final boolean offer(Object obj) {
        if (obj != null) {
            ? atomicReference = new AtomicReference();
            atomicReference.c = obj;
            ((LinkedQueueNode) this.c.getAndSet(atomicReference)).lazySet(atomicReference);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public final Object poll() {
        LinkedQueueNode linkedQueueNode;
        AtomicReference atomicReference = this.d;
        LinkedQueueNode linkedQueueNode2 = (LinkedQueueNode) atomicReference.get();
        LinkedQueueNode linkedQueueNode3 = (LinkedQueueNode) linkedQueueNode2.get();
        if (linkedQueueNode3 != null) {
            Object obj = linkedQueueNode3.c;
            linkedQueueNode3.c = null;
            atomicReference.lazySet(linkedQueueNode3);
            return obj;
        } else if (linkedQueueNode2 == ((LinkedQueueNode) this.c.get())) {
            return null;
        } else {
            do {
                linkedQueueNode = (LinkedQueueNode) linkedQueueNode2.get();
            } while (linkedQueueNode == null);
            Object obj2 = linkedQueueNode.c;
            linkedQueueNode.c = null;
            atomicReference.lazySet(linkedQueueNode);
            return obj2;
        }
    }
}
