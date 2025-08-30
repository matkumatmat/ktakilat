package androidx.camera.camera2.internal;

import androidx.camera.core.FocusMeteringAction;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class h0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ FocusMeteringControl c;
    public final /* synthetic */ FocusMeteringAction d;
    public final /* synthetic */ long e;

    public /* synthetic */ h0(FocusMeteringControl focusMeteringControl, FocusMeteringAction focusMeteringAction, long j) {
        this.c = focusMeteringControl;
        this.d = focusMeteringAction;
        this.e = j;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$startFocusAndMetering$1(this.d, this.e, completer);
    }
}
