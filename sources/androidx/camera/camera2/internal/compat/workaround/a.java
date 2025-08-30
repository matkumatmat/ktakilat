package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ RequestMonitor c;
    public final /* synthetic */ RequestMonitor.RequestCompleteListener d;
    public final /* synthetic */ ListenableFuture e;

    public /* synthetic */ a(RequestMonitor requestMonitor, RequestMonitor.RequestCompleteListener requestCompleteListener, ListenableFuture listenableFuture) {
        this.c = requestMonitor;
        this.d = requestCompleteListener;
        this.e = listenableFuture;
    }

    public final void run() {
        this.c.lambda$createMonitorListener$1(this.d, this.e);
    }
}
