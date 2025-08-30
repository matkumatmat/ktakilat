package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat.StateCallbackExecutorWrapper c;
    public final /* synthetic */ CameraCaptureSession d;
    public final /* synthetic */ Surface e;

    public /* synthetic */ g(CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, Surface surface) {
        this.c = stateCallbackExecutorWrapper;
        this.d = cameraCaptureSession;
        this.e = surface;
    }

    public final void run() {
        this.c.lambda$onSurfacePrepared$6(this.d, this.e);
    }
}
