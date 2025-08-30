package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CameraCaptureCallback d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    public /* synthetic */ a(CameraCaptureCallback cameraCaptureCallback, int i, Object obj, int i2) {
        this.c = i2;
        this.d = cameraCaptureCallback;
        this.e = i;
        this.f = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onCaptureFailed(this.e, (CameraCaptureFailure) this.f);
                return;
            default:
                this.d.onCaptureCompleted(this.e, (CameraCaptureResult) this.f);
                return;
        }
    }
}
