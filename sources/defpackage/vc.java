package defpackage;

import rx.internal.util.atomic.LinkedQueueNode;
import rx.internal.util.unsafe.MpscLinkedQueue;
import sun.misc.Unsafe;

/* renamed from: vc  reason: default package */
public abstract /* synthetic */ class vc {
    public static /* synthetic */ boolean a(Unsafe unsafe, MpscLinkedQueue mpscLinkedQueue, long j, Object obj, LinkedQueueNode linkedQueueNode) {
        while (!unsafe.compareAndSwapObject(mpscLinkedQueue, j, obj, linkedQueueNode)) {
            if (unsafe.getObject(mpscLinkedQueue, j) != obj) {
                return false;
            }
        }
        return true;
    }
}
