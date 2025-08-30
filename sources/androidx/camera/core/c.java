package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer c;
    public final /* synthetic */ ImageProxy d;
    public final /* synthetic */ Matrix e;
    public final /* synthetic */ ImageProxy f;
    public final /* synthetic */ Rect g;
    public final /* synthetic */ ImageAnalysis.Analyzer i;
    public final /* synthetic */ CallbackToFutureAdapter.Completer j;

    public /* synthetic */ c(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        this.c = imageAnalysisAbstractAnalyzer;
        this.d = imageProxy;
        this.e = matrix;
        this.f = imageProxy2;
        this.g = rect;
        this.i = analyzer;
        this.j = completer;
    }

    public final void run() {
        this.c.lambda$analyzeImage$0(this.d, this.e, this.f, this.g, this.i, this.j);
    }
}
