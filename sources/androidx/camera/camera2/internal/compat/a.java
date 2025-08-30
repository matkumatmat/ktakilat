package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper c;
    public final /* synthetic */ CameraCaptureSession d;
    public final /* synthetic */ CaptureRequest e;
    public final /* synthetic */ long f;
    public final /* synthetic */ long g;

    public /* synthetic */ a(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        this.c = captureCallbackExecutorWrapper;
        this.d = cameraCaptureSession;
        this.e = captureRequest;
        this.f = j;
        this.g = j2;
    }

    public final void run() {
        this.c.lambda$onCaptureStarted$0(this.d, this.e, this.f, this.g);
    }
}
