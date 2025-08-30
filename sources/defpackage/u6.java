package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: u6  reason: default package */
public final /* synthetic */ class u6 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f211a;
    public final /* synthetic */ CallbackToFutureAdapter.Completer b;

    public /* synthetic */ u6(int i, CallbackToFutureAdapter.Completer completer) {
        this.f211a = i;
        this.b = completer;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return ExposureControl.lambda$setExposureCompensationIndex$0(this.f211a, this.b, totalCaptureResult);
    }
}
