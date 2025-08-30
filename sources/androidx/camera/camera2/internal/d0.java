package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Object f;

    public /* synthetic */ d0(FocusMeteringControl focusMeteringControl, boolean z, CallbackToFutureAdapter.Completer completer) {
        this.f = focusMeteringControl;
        this.e = z;
        this.d = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((FocusMeteringControl) this.f).lambda$enableExternalFlashAeMode$4(this.e, this.d);
                return;
            default:
                ((TorchControl) this.f).lambda$enableTorch$1(this.d, this.e);
                return;
        }
    }

    public /* synthetic */ d0(TorchControl torchControl, CallbackToFutureAdapter.Completer completer, boolean z) {
        this.f = torchControl;
        this.d = completer;
        this.e = z;
    }
}
