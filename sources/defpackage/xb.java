package defpackage;

import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

/* renamed from: xb  reason: default package */
public final /* synthetic */ class xb implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f846a;
    public final /* synthetic */ StampedLock b;

    public /* synthetic */ xb(StampedLock stampedLock, int i) {
        this.f846a = i;
        this.b = stampedLock;
    }

    public final Object get() {
        switch (this.f846a) {
            case 0:
                return this.b.asReadLock();
            default:
                return this.b.asWriteLock();
        }
    }
}
