package androidx.camera.core;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer c;

    public /* synthetic */ f(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        this.c = imageAnalysisNonBlockingAnalyzer;
    }

    public final void run() {
        this.c.analyzeCachedImage();
    }
}
