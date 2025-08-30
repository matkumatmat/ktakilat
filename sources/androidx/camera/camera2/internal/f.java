package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class f implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((Camera2CameraImpl) this.d).lambda$isUseCaseAttached$12((String) this.e, completer);
            case 1:
                return ((Camera2CapturePipeline.Pipeline) this.d).lambda$submitConfigsInternal$4((CaptureConfig.Builder) this.e, completer);
            default:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.d).lambda$preCapture$3((AtomicReference) this.e, completer);
        }
    }
}
