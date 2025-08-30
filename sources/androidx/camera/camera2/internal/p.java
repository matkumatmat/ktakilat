package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class p implements CallbackToFutureAdapter.Resolver, ForceCloseCaptureSession.OnConfigured {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ p(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((Camera2CapturePipeline.AePreCaptureTask) this.d).lambda$preCapture$0(completer);
            case 1:
                return ((Camera2CapturePipeline.CameraCapturePipelineImpl) this.d).lambda$invokePostCapture$1(completer);
            case 2:
                return ((Camera2CapturePipeline.ResultListener) this.d).lambda$new$0(completer);
            case 3:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.d).lambda$preCapture$5(completer);
            case 4:
                return ((AtomicReference) this.d).set(new w(completer));
            default:
                return ((Camera2CapturePipeline.TorchTask) this.d).lambda$preCapture$0(completer);
        }
    }

    public void run(SynchronizedCaptureSession synchronizedCaptureSession) {
        ((SynchronizedCaptureSessionImpl) this.d).lambda$onConfigured$1(synchronizedCaptureSession);
    }
}
