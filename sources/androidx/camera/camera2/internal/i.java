package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl d;
    public final /* synthetic */ CallbackToFutureAdapter.Completer e;

    public /* synthetic */ i(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.Completer completer, int i) {
        this.c = i;
        this.d = camera2CameraImpl;
        this.e = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$release$4(this.e);
                return;
            default:
                this.d.lambda$isMeteringRepeatingAttached$13(this.e);
                return;
        }
    }
}
