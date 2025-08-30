package androidx.camera.extensions.internal.sessionprocessor;

import androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor;
import java.util.HashMap;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ StillCaptureProcessor c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ HashMap e;
    public final /* synthetic */ StillCaptureProcessor.OnCaptureResultCallback f;

    public /* synthetic */ f(StillCaptureProcessor stillCaptureProcessor, boolean z, HashMap hashMap, StillCaptureProcessor.OnCaptureResultCallback onCaptureResultCallback) {
        this.c = stillCaptureProcessor;
        this.d = z;
        this.e = hashMap;
        this.f = onCaptureResultCallback;
    }

    public final void run() {
        this.c.lambda$process$1(this.d, this.e, this.f);
    }
}
