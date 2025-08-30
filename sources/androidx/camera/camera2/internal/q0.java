package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final /* synthetic */ class q0 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TorchControl f14a;

    public /* synthetic */ q0(TorchControl torchControl) {
        this.f14a = torchControl;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.f14a.lambda$new$0(totalCaptureResult);
    }
}
