package defpackage;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

/* renamed from: jf  reason: default package */
public final /* synthetic */ class jf implements Supplier {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ jf(int i, int i2) {
        this.c = i2;
        this.d = i;
    }

    public final Object get() {
        switch (this.c) {
            case 0:
                return Striped.lambda$semaphore$1(this.d);
            default:
                return Striped.lambda$lazyWeakSemaphore$2(this.d);
        }
    }
}
