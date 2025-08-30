package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper c;
    public final /* synthetic */ CameraCaptureSession d;
    public final /* synthetic */ CaptureRequest e;
    public final /* synthetic */ Surface f;
    public final /* synthetic */ long g;

    public /* synthetic */ d(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
        this.c = captureCallbackExecutorWrapper;
        this.d = cameraCaptureSession;
        this.e = captureRequest;
        this.f = surface;
        this.g = j;
    }

    public final void run() {
        this.c.lambda$onCaptureBufferLost$6(this.d, this.e, this.f, this.g);
    }
}
