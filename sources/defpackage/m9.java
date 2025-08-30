package defpackage;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: m9  reason: default package */
public final /* synthetic */ class m9 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ ListenableFuture d;

    public /* synthetic */ m9(ListenableFuture listenableFuture, int i) {
        this.c = i;
        this.d = listenableFuture;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.addListener(new f5(1, completer), CameraXExecutors.directExecutor());
            default:
                return Futures.propagateTransform(false, this.d, Futures.IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
        }
    }
}
