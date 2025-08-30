package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class u implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f19a;
    public final /* synthetic */ Camera2CapturePipeline.ScreenFlashTask b;

    public /* synthetic */ u(Camera2CapturePipeline.ScreenFlashTask screenFlashTask, int i) {
        this.f19a = i;
        this.b = screenFlashTask;
    }

    public final ListenableFuture apply(Object obj) {
        switch (this.f19a) {
            case 0:
                return this.b.lambda$preCapture$10((Void) obj);
            case 1:
                return this.b.lambda$preCapture$4((Void) obj);
            case 2:
                return this.b.lambda$preCapture$6((Void) obj);
            default:
                return this.b.lambda$preCapture$8((Void) obj);
        }
    }
}
