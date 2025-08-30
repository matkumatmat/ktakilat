package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class s implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CapturePipeline.Pipeline f16a;
    public final /* synthetic */ int b;

    public /* synthetic */ s(Camera2CapturePipeline.Pipeline pipeline, int i) {
        this.f16a = pipeline;
        this.b = i;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f16a.lambda$executePreCapture$1(this.b, (TotalCaptureResult) obj);
    }
}
