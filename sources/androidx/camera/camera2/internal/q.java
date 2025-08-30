package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import java.util.List;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13a;

    public /* synthetic */ q(int i) {
        this.f13a = i;
    }

    public final Object apply(Object obj) {
        switch (this.f13a) {
            case 0:
                return Boolean.TRUE;
            case 1:
                return Camera2CapturePipeline.CameraCapturePipelineImpl.lambda$invokePreCapture$0((TotalCaptureResult) obj);
            case 2:
                return Boolean.valueOf(((List) obj).contains(Boolean.TRUE));
            case 3:
                return Boolean.FALSE;
            default:
                return Boolean.FALSE;
        }
    }
}
