package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class c0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ FocusMeteringControl d;

    public /* synthetic */ c0(FocusMeteringControl focusMeteringControl, int i) {
        this.c = i;
        this.d = focusMeteringControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$cancelFocusAndMetering$13(completer);
            default:
                return this.d.lambda$triggerAePrecapture$3(completer);
        }
    }
}
