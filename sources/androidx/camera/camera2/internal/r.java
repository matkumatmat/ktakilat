package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class r implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CapturePipeline.Pipeline f15a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;

    public /* synthetic */ r(Camera2CapturePipeline.Pipeline pipeline, List list, int i) {
        this.f15a = pipeline;
        this.b = list;
        this.c = i;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f15a.lambda$executeCapture$0(this.b, this.c, (TotalCaptureResult) obj);
    }
}
