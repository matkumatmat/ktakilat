package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class m0 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10a = 0;
    public final /* synthetic */ CameraDevice b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ m0(ProcessingCaptureSession processingCaptureSession, SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSession.Opener opener) {
        this.c = processingCaptureSession;
        this.d = sessionConfig;
        this.b = cameraDevice;
        this.e = opener;
    }

    public final ListenableFuture apply(Object obj) {
        List list = (List) obj;
        switch (this.f10a) {
            case 0:
                CameraDevice cameraDevice = this.b;
                return ((ProcessingCaptureSession) this.c).lambda$open$2((SessionConfig) this.d, cameraDevice, (SynchronizedCaptureSession.Opener) this.e, list);
            default:
                return ((SynchronizedCaptureSessionImpl) this.c).lambda$openCaptureSession$0(this.b, (SessionConfigurationCompat) this.d, (List) this.e, list);
        }
    }

    public /* synthetic */ m0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        this.c = synchronizedCaptureSessionImpl;
        this.b = cameraDevice;
        this.d = sessionConfigurationCompat;
        this.e = list;
    }
}
