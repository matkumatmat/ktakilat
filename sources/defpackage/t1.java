package defpackage;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: t1  reason: default package */
public final /* synthetic */ class t1 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraControl d;

    public /* synthetic */ t1(Camera2CameraControl camera2CameraControl, int i) {
        this.c = i;
        this.d = camera2CameraControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$addCaptureRequestOptions$3(completer);
            case 1:
                return this.d.lambda$setCaptureRequestOptions$1(completer);
            default:
                return this.d.lambda$clearCaptureRequestOptions$5(completer);
        }
    }
}
