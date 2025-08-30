package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Serializable f;

    public /* synthetic */ j(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.Completer completer, String str) {
        this.e = camera2CameraImpl;
        this.d = completer;
        this.f = str;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Camera2CameraImpl) this.e).lambda$isUseCaseAttached$11(this.d, (String) this.f);
                return;
            default:
                ((Camera2CapturePipeline.ScreenFlashTask) this.e).lambda$preCapture$2((AtomicReference) this.f, this.d);
                return;
        }
    }

    public /* synthetic */ j(Camera2CapturePipeline.ScreenFlashTask screenFlashTask, AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        this.e = screenFlashTask;
        this.f = atomicReference;
        this.d = completer;
    }
}
