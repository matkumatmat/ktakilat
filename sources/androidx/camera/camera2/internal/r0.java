package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class r0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ ZoomControl d;
    public final /* synthetic */ ZoomState e;

    public /* synthetic */ r0(ZoomControl zoomControl, ZoomState zoomState, int i) {
        this.c = i;
        this.d = zoomControl;
        this.e = zoomState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$setZoomRatio$1(this.e, completer);
            default:
                return this.d.lambda$setLinearZoom$3(this.e, completer);
        }
    }
}
