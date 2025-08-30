package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher;
import androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor;
import java.util.List;

public final /* synthetic */ class g implements CaptureResultImageMatcher.ImageReferenceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StillCaptureProcessor f33a;
    public final /* synthetic */ List b;
    public final /* synthetic */ StillCaptureProcessor.OnCaptureResultCallback c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ g(StillCaptureProcessor stillCaptureProcessor, List list, StillCaptureProcessor.OnCaptureResultCallback onCaptureResultCallback, boolean z) {
        this.f33a = stillCaptureProcessor;
        this.b = list;
        this.c = onCaptureResultCallback;
        this.d = z;
    }

    public final void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
        this.f33a.lambda$startCapture$0(this.b, this.c, this.d, imageReference, totalCaptureResult, i);
    }
}
