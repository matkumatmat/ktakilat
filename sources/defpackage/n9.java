package defpackage;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: n9  reason: default package */
public final /* synthetic */ class n9 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ListenableFuture c;
    public final /* synthetic */ ScheduledExecutorService d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ long g;

    public /* synthetic */ n9(long j, ScheduledExecutorService scheduledExecutorService, Object obj, boolean z, ListenableFuture listenableFuture) {
        this.c = listenableFuture;
        this.d = scheduledExecutorService;
        this.e = obj;
        this.f = z;
        this.g = j;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return Futures.lambda$makeTimeoutFuture$6(this.c, this.d, this.e, this.f, this.g, completer);
    }
}
