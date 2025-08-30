package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class x implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f21a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x(Object obj, int i) {
        this.f21a = i;
        this.b = obj;
    }

    public final ListenableFuture apply(Object obj) {
        switch (this.f21a) {
            case 0:
                return ((Camera2CapturePipeline.TorchTask) this.b).lambda$preCapture$1((Void) obj);
            case 1:
                return ((Camera2CapturePipeline.TorchTask) this.b).lambda$preCapture$3((Void) obj);
            default:
                return ((Camera2CapturePipeline.Pipeline) this.b).lambda$executePreCapture$3((Boolean) obj);
        }
    }
}
