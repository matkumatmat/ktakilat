package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

public class SurfaceProcessorWithExecutor implements SurfaceProcessorInternal {
    private static final String TAG = "SurfaceProcessor";
    @NonNull
    private final Consumer<Throwable> mErrorListener;
    @NonNull
    private final Executor mExecutor;
    @NonNull
    private final SurfaceProcessor mSurfaceProcessor;

    public SurfaceProcessorWithExecutor(@NonNull CameraEffect cameraEffect) {
        SurfaceProcessor surfaceProcessor = cameraEffect.getSurfaceProcessor();
        Objects.requireNonNull(surfaceProcessor);
        this.mSurfaceProcessor = surfaceProcessor;
        this.mExecutor = cameraEffect.getExecutor();
        this.mErrorListener = cameraEffect.getErrorListener();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest surfaceRequest) {
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceRequest);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to setup SurfaceProcessor input.", e);
            this.mErrorListener.accept(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$1(SurfaceOutput surfaceOutput) {
        try {
            this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to setup SurfaceProcessor output.", e);
            this.mErrorListener.accept(e);
        }
    }

    @VisibleForTesting
    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @VisibleForTesting
    @NonNull
    public SurfaceProcessor getProcessor() {
        return this.mSurfaceProcessor;
    }

    public void onInputSurface(@NonNull SurfaceRequest surfaceRequest) {
        this.mExecutor.execute(new ib(13, this, surfaceRequest));
    }

    public void onOutputSurface(@NonNull SurfaceOutput surfaceOutput) {
        this.mExecutor.execute(new ib(14, this, surfaceOutput));
    }

    public void release() {
    }

    @NonNull
    public ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) int i, @IntRange(from = 0, to = 359) int i2) {
        return Futures.immediateFailedFuture(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }
}
