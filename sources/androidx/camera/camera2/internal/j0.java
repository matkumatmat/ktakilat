package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final /* synthetic */ class j0 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f7a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;

    public /* synthetic */ j0(FocusMeteringControl focusMeteringControl, boolean z, long j) {
        this.f7a = focusMeteringControl;
        this.b = z;
        this.c = j;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.f7a.lambda$executeMeteringAction$7(this.b, this.c, totalCaptureResult);
    }
}
