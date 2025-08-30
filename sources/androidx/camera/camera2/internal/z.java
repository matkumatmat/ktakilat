package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class z implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f22a;
    public final /* synthetic */ SessionConfig b;
    public final /* synthetic */ CameraDevice c;

    public /* synthetic */ z(CaptureSession captureSession, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        this.f22a = captureSession;
        this.b = sessionConfig;
        this.c = cameraDevice;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f22a.lambda$open$0(this.b, this.c, (List) obj);
    }
}
