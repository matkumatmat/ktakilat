package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.LinkedHashSet;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ n(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Camera2CameraImpl.StateCallback.ScheduledReopen) this.d).lambda$run$0();
                return;
            case 1:
                ((Camera2CapturePipeline.Pipeline) this.d).executePostCapture();
                return;
            case 2:
                ((CaptureSession) this.d).lambda$issuePendingCaptureRequest$2();
                return;
            case 3:
                CaptureSessionRepository.forceOnClosed((LinkedHashSet) this.d);
                return;
            case 4:
                ((ProcessingCaptureSession) this.d).lambda$release$4();
                return;
            case 5:
                ProcessingCaptureSession.sHeldProcessorSurfaces.remove((DeferrableSurface) this.d);
                return;
            case 6:
                ((SynchronizedCaptureSessionBaseImpl) this.d).lambda$close$2();
                return;
            default:
                ((SynchronizedCaptureSessionImpl) this.d).lambda$close$2();
                return;
        }
    }
}
