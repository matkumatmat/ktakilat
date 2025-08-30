package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CameraCaptureSessionCompat.StateCallbackExecutorWrapper d;
    public final /* synthetic */ CameraCaptureSession e;

    public /* synthetic */ f(CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int i) {
        this.c = i;
        this.d = stateCallbackExecutorWrapper;
        this.e = cameraCaptureSession;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onActive$3(this.e);
                return;
            case 1:
                this.d.lambda$onClosed$5(this.e);
                return;
            case 2:
                this.d.lambda$onCaptureQueueEmpty$4(this.e);
                return;
            case 3:
                this.d.lambda$onConfigured$0(this.e);
                return;
            case 4:
                this.d.lambda$onReady$2(this.e);
                return;
            default:
                this.d.lambda$onConfigureFailed$1(this.e);
                return;
        }
    }
}
