package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher;
import androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor;

public final /* synthetic */ class c implements CaptureResultImageMatcher.ImageReferenceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewProcessor f31a;
    public final /* synthetic */ PreviewProcessor.OnCaptureResultCallback b;

    public /* synthetic */ c(PreviewProcessor previewProcessor, PreviewProcessor.OnCaptureResultCallback onCaptureResultCallback) {
        this.f31a = previewProcessor;
        this.b = onCaptureResultCallback;
    }

    public final void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
        this.f31a.lambda$start$0(this.b, imageReference, totalCaptureResult, i);
    }
}
