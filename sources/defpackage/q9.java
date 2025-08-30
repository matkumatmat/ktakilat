package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* renamed from: q9  reason: default package */
public final /* synthetic */ class q9 implements Callable {
    public final /* synthetic */ CallbackToFutureAdapter.Completer c;
    public final /* synthetic */ ListenableFuture d;
    public final /* synthetic */ long e;

    public /* synthetic */ q9(CallbackToFutureAdapter.Completer completer, ListenableFuture listenableFuture, long j) {
        this.c = completer;
        this.d = listenableFuture;
        this.e = j;
    }

    public final Object call() {
        return Boolean.valueOf(this.c.setException(new TimeoutException("Future[" + this.d + "] is not done within " + this.e + " ms.")));
    }
}
