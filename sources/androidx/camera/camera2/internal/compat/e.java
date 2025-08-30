package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ AutoCloseable f;

    public /* synthetic */ e(Object obj, AutoCloseable autoCloseable, int i, int i2) {
        this.c = i2;
        this.e = obj;
        this.f = autoCloseable;
        this.d = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper) this.e).lambda$onCaptureSequenceAborted$5((CameraCaptureSession) this.f, this.d);
                return;
            default:
                ((CameraDeviceCompat.StateCallbackExecutorWrapper) this.e).lambda$onError$2((CameraDevice) this.f, this.d);
                return;
        }
    }
}
