package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.LinkedHashSet;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(Object obj, int i, int i2) {
        this.c = i2;
        this.e = obj;
        this.d = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((CameraCaptureCallback) this.e).onCaptureCancelled(this.d);
                return;
            default:
                CaptureSessionRepository.AnonymousClass1.lambda$dispatchOnError$1((LinkedHashSet) this.e, this.d);
                return;
        }
    }
}
