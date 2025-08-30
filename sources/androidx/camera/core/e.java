package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;

public final /* synthetic */ class e implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy f24a;

    public /* synthetic */ e(ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy cacheAnalyzingImageProxy) {
        this.f24a = cacheAnalyzingImageProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f24a.lambda$new$1(imageProxy);
    }
}
