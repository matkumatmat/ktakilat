package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class k implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(int i, Object obj, Object obj2) {
        this.f8a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final ListenableFuture apply(Object obj) {
        switch (this.f8a) {
            case 0:
                return Camera2CameraImpl.lambda$configAndClose$3((CaptureSession) this.b, (ImmediateSurface) this.c, (Void) obj);
            case 1:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.b).lambda$preCapture$7((ListenableFuture) this.c, obj);
            default:
                return ((SynchronizedCaptureSessionBaseImpl) this.b).lambda$startWithDeferrableSurface$1((List) this.c, (List) obj);
        }
    }
}
