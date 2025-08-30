package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper c;
    public final /* synthetic */ CameraCaptureSession d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;

    public /* synthetic */ c(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int i, long j) {
        this.c = captureCallbackExecutorWrapper;
        this.d = cameraCaptureSession;
        this.e = i;
        this.f = j;
    }

    public final void run() {
        this.c.lambda$onCaptureSequenceCompleted$4(this.d, this.e, this.f);
    }
}
