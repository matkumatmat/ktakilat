package defpackage;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Supplier;

/* renamed from: wb  reason: default package */
public final /* synthetic */ class wb implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f844a;
    public final /* synthetic */ ReadWriteLock b;

    public /* synthetic */ wb(ReadWriteLock readWriteLock, int i) {
        this.f844a = i;
        this.b = readWriteLock;
    }

    public final Object get() {
        switch (this.f844a) {
            case 0:
                return this.b.readLock();
            default:
                return this.b.writeLock();
        }
    }
}
