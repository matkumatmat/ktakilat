package defpackage;

import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import java.util.List;

/* renamed from: h5  reason: default package */
public final /* synthetic */ class h5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f197a;

    public /* synthetic */ h5(int i) {
        this.f197a = i;
    }

    public final Object apply(Object obj) {
        switch (this.f197a) {
            case 0:
                return new DefaultSurfaceProcessor((DynamicRange) obj);
            case 1:
                return ImageCapture.lambda$submitStillCaptureRequest$4((List) obj);
            case 2:
                return RequestMonitor.lambda$getRequestsProcessedFuture$0((List) obj);
            default:
                return VideoEncoderInfoImpl.lambda$static$0((VideoEncoderConfig) obj);
        }
    }
}
