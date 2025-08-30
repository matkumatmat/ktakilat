package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer c;
    public final /* synthetic */ Executor d;
    public final /* synthetic */ ImageProxy e;
    public final /* synthetic */ Matrix f;
    public final /* synthetic */ ImageProxy g;
    public final /* synthetic */ Rect i;
    public final /* synthetic */ ImageAnalysis.Analyzer j;

    public /* synthetic */ d(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer) {
        this.c = imageAnalysisAbstractAnalyzer;
        this.d = executor;
        this.e = imageProxy;
        this.f = matrix;
        this.g = imageProxy2;
        this.i = rect;
        this.j = analyzer;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        Rect rect = this.i;
        return this.c.lambda$analyzeImage$1(this.d, this.e, this.f, this.g, rect, this.j, completer);
    }
}
