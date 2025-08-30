package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class s0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ZoomControl d;
    public final /* synthetic */ CallbackToFutureAdapter.Completer e;
    public final /* synthetic */ ZoomState f;

    public /* synthetic */ s0(ZoomControl zoomControl, CallbackToFutureAdapter.Completer completer, ZoomState zoomState, int i) {
        this.c = i;
        this.d = zoomControl;
        this.e = completer;
        this.f = zoomState;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$setZoomRatio$0(this.e, this.f);
                return;
            default:
                this.d.lambda$setLinearZoom$2(this.e, this.f);
                return;
        }
    }
}
