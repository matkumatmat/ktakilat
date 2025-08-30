package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ RequestMonitor.RequestCompleteListener c;

    public /* synthetic */ b(RequestMonitor.RequestCompleteListener requestCompleteListener) {
        this.c = requestCompleteListener;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$new$0(completer);
    }
}
