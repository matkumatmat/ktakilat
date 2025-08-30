package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class p0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl c;
    public final /* synthetic */ List d;
    public final /* synthetic */ CameraDeviceCompat e;
    public final /* synthetic */ SessionConfigurationCompat f;

    public /* synthetic */ p0(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, List list, CameraDeviceCompat cameraDeviceCompat, SessionConfigurationCompat sessionConfigurationCompat) {
        this.c = synchronizedCaptureSessionBaseImpl;
        this.d = list;
        this.e = cameraDeviceCompat;
        this.f = sessionConfigurationCompat;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$openCaptureSession$0(this.d, this.e, this.f, completer);
    }
}
