package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e0 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f5a;
    public final /* synthetic */ long b;
    public final /* synthetic */ CallbackToFutureAdapter.Completer c;

    public /* synthetic */ e0(FocusMeteringControl focusMeteringControl, long j, CallbackToFutureAdapter.Completer completer) {
        this.f5a = focusMeteringControl;
        this.b = j;
        this.c = completer;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.f5a.lambda$enableExternalFlashAeMode$6(this.b, this.c, totalCaptureResult);
    }
}
