package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b0(int i, Object obj, boolean z) {
        this.c = i;
        this.e = obj;
        this.d = z;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((FocusMeteringControl) this.e).lambda$enableExternalFlashAeMode$5(this.d, completer);
            default:
                return ((TorchControl) this.e).lambda$enableTorch$2(this.d, completer);
        }
    }
}
