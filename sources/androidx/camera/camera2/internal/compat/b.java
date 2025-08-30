package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper d;
    public final /* synthetic */ CameraCaptureSession e;
    public final /* synthetic */ CaptureRequest f;
    public final /* synthetic */ Object g;

    public /* synthetic */ b(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Object obj, int i) {
        this.c = i;
        this.d = captureCallbackExecutorWrapper;
        this.e = cameraCaptureSession;
        this.f = captureRequest;
        this.g = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onCaptureCompleted$2(this.e, this.f, (TotalCaptureResult) this.g);
                return;
            case 1:
                this.d.lambda$onCaptureProgressed$1(this.e, this.f, (CaptureResult) this.g);
                return;
            default:
                this.d.lambda$onCaptureFailed$3(this.e, this.f, (CaptureFailure) this.g);
                return;
        }
    }
}
