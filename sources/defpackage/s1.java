package defpackage;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: s1  reason: default package */
public final /* synthetic */ class s1 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraControl d;
    public final /* synthetic */ CallbackToFutureAdapter.Completer e;

    public /* synthetic */ s1(Camera2CameraControl camera2CameraControl, CallbackToFutureAdapter.Completer completer, int i) {
        this.c = i;
        this.d = camera2CameraControl;
        this.e = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$clearCaptureRequestOptions$4(this.e);
                return;
            case 1:
                this.d.lambda$setCaptureRequestOptions$0(this.e);
                return;
            default:
                this.d.lambda$addCaptureRequestOptions$2(this.e);
                return;
        }
    }
}
