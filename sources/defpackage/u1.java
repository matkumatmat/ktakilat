package defpackage;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: u1  reason: default package */
public final /* synthetic */ class u1 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f210a;
    public final /* synthetic */ CallbackToFutureAdapter.Completer b;

    public /* synthetic */ u1(long j, CallbackToFutureAdapter.Completer completer) {
        this.f210a = j;
        this.b = completer;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return Camera2CameraControlImpl.lambda$waitForSessionUpdateId$2(this.f210a, this.b, totalCaptureResult);
    }
}
