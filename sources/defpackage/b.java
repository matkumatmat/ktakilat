package defpackage;

import com.google.common.util.concurrent.AbstractFuture;
import sun.misc.Unsafe;

/* renamed from: b  reason: default package */
public abstract /* synthetic */ class b {
    public static /* synthetic */ boolean a(Unsafe unsafe, AbstractFuture abstractFuture, long j, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j, obj, obj2)) {
            if (unsafe.getObject(abstractFuture, j) != obj) {
                return false;
            }
        }
        return true;
    }
}
