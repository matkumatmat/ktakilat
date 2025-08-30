package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class y implements CameraBurstCaptureCallback.CaptureSequenceCallback, CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CaptureSession c;

    public /* synthetic */ y(CaptureSession captureSession) {
        this.c = captureSession;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$release$1(completer);
    }

    public void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        this.c.lambda$issueBurstCaptureRequest$3(cameraCaptureSession, i, z);
    }
}
