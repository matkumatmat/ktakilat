package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FocusMeteringControl d;
    public final /* synthetic */ CallbackToFutureAdapter.Completer e;

    public /* synthetic */ f0(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter.Completer completer, int i) {
        this.c = i;
        this.d = focusMeteringControl;
        this.e = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$cancelFocusAndMetering$12(this.e);
                return;
            default:
                this.d.lambda$triggerAePrecapture$2(this.e);
                return;
        }
    }
}
