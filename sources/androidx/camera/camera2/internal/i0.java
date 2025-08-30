package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final /* synthetic */ class i0 implements Camera2CameraControlImpl.CaptureResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f6a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public /* synthetic */ i0(int i, long j, FocusMeteringControl focusMeteringControl) {
        this.f6a = focusMeteringControl;
        this.b = i;
        this.c = j;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.f6a.lambda$cancelFocusAndMeteringInternal$14(this.b, this.c, totalCaptureResult);
    }
}
