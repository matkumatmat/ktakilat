package defpackage;

import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.lifecycle.ProcessCameraProvider;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.functions.Function1;

/* renamed from: ih  reason: default package */
public final /* synthetic */ class ih implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f202a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ih(Object obj, int i) {
        this.f202a = i;
        this.b = obj;
    }

    public final ListenableFuture apply(Object obj) {
        switch (this.f202a) {
            case 0:
                return ((CameraCapturePipeline) ((ListenableFuture) this.b).get()).invokePreCapture();
            case 1:
                return ((CameraCapturePipeline) ((ListenableFuture) this.b).get()).invokePostCapture();
            default:
                return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15((Function1) this.b, obj);
        }
    }
}
