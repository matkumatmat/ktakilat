package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Camera2CameraControlImpl.CameraControlSessionCallback) this.d).lambda$onCaptureCompleted$0((TotalCaptureResult) this.e);
                return;
            case 1:
                ((SessionConfig.ErrorListener) this.d).onError((SessionConfig) this.e, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
                return;
            case 2:
                Camera2CameraImpl.lambda$configAndClose$2((Surface) this.d, (SurfaceTexture) this.e);
                return;
            case 3:
                ((Camera2CameraImpl) this.d).lambda$onUseCaseInactive$8((String) this.e);
                return;
            case 4:
                ((Camera2CameraControlImpl) this.d).removeCaptureResultListener((Camera2CapturePipeline.ResultListener) this.e);
                return;
            default:
                ((ProcessingCaptureSession) this.d).lambda$open$0((DeferrableSurface) this.e);
                return;
        }
    }
}
