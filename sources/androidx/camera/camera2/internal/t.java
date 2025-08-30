package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.RingBuffer;

public final /* synthetic */ class t implements Camera2CapturePipeline.ResultListener.Checker, RingBuffer.OnRemoveCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17a;

    public /* synthetic */ t(int i) {
        this.f17a = i;
    }

    public boolean check(TotalCaptureResult totalCaptureResult) {
        switch (this.f17a) {
            case 0:
                return Camera2CapturePipeline.is3AConverged(totalCaptureResult, false);
            case 1:
                return Camera2CapturePipeline.is3AConverged(totalCaptureResult, false);
            default:
                return Camera2CapturePipeline.is3AConverged(totalCaptureResult, true);
        }
    }

    public void onRemove(Object obj) {
        ((ImageProxy) obj).close();
    }
}
