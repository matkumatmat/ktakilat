package defpackage;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

/* renamed from: yd  reason: default package */
public final /* synthetic */ class yd implements RemovalListener {
    public final /* synthetic */ Executor c;
    public final /* synthetic */ RemovalListener d;

    public /* synthetic */ yd(RemovalListener removalListener, Executor executor) {
        this.c = executor;
        this.d = removalListener;
    }

    public final void onRemoval(RemovalNotification removalNotification) {
        this.c.execute(new ib(10, this.d, removalNotification));
    }
}
