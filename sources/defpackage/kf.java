package defpackage;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: kf  reason: default package */
public final /* synthetic */ class kf implements Supplier {
    public final /* synthetic */ int c;

    public /* synthetic */ kf(int i) {
        this.c = i;
    }

    public final Object get() {
        switch (this.c) {
            case 0:
                return Striped.lambda$lazyWeakLock$0();
            default:
                return new ReentrantReadWriteLock();
        }
    }
}
