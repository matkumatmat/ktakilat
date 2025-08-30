package androidx.camera.camera2.internal;

import androidx.camera.core.FocusMeteringAction;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ FocusMeteringControl c;
    public final /* synthetic */ CallbackToFutureAdapter.Completer d;
    public final /* synthetic */ FocusMeteringAction e;
    public final /* synthetic */ long f;

    public /* synthetic */ g0(long j, FocusMeteringControl focusMeteringControl, FocusMeteringAction focusMeteringAction, CallbackToFutureAdapter.Completer completer) {
        this.c = focusMeteringControl;
        this.d = completer;
        this.e = focusMeteringAction;
        this.f = j;
    }

    public final void run() {
        FocusMeteringControl focusMeteringControl = this.c;
        CallbackToFutureAdapter.Completer completer = this.d;
        focusMeteringControl.lambda$startFocusAndMetering$0(completer, this.e, this.f);
    }
}
