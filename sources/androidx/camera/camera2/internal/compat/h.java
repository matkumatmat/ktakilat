package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CameraDeviceCompat.StateCallbackExecutorWrapper d;
    public final /* synthetic */ CameraDevice e;

    public /* synthetic */ h(CameraDeviceCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraDevice cameraDevice, int i) {
        this.c = i;
        this.d = stateCallbackExecutorWrapper;
        this.e = cameraDevice;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onClosed$3(this.e);
                return;
            case 1:
                this.d.lambda$onDisconnected$1(this.e);
                return;
            default:
                this.d.lambda$onOpened$0(this.e);
                return;
        }
    }
}
