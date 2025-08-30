package defpackage;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.concurrent.Executor;

/* renamed from: j5  reason: default package */
public final /* synthetic */ class j5 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ListenableFuture c;
    public final /* synthetic */ Executor d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Collection f;

    public /* synthetic */ j5(ListenableFuture listenableFuture, Executor executor, boolean z, Collection collection) {
        this.c = listenableFuture;
        this.d = executor;
        this.e = z;
        this.f = collection;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return DeferrableSurfaces.lambda$surfaceListWithTimeout$1(this.c, this.d, this.e, this.f, completer);
    }
}
