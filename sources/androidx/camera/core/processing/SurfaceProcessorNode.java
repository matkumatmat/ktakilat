package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";
    @NonNull
    final CameraInternal mCameraInternal;
    @Nullable
    private In mInput;
    @Nullable
    private Out mOutput;
    @NonNull
    final SurfaceProcessorInternal mSurfaceProcessor;

    @AutoValue
    public static abstract class In {
        @NonNull
        public static In of(@NonNull SurfaceEdge surfaceEdge, @NonNull List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }

        @NonNull
        public abstract List<OutConfig> getOutConfigs();

        @NonNull
        public abstract SurfaceEdge getSurfaceEdge();
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAndSendSurfaceOutput */
    public void lambda$sendSurfaceOutputs$0(@NonNull SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        CameraInternal cameraInternal;
        final SurfaceEdge value = entry.getValue();
        Size resolution = surfaceEdge.getStreamSpec().getResolution();
        Rect cropRect = entry.getKey().getCropRect();
        if (surfaceEdge.hasCameraTransform()) {
            cameraInternal = this.mCameraInternal;
        } else {
            cameraInternal = null;
        }
        Futures.addCallback(value.createSurfaceOutputFuture(entry.getKey().getFormat(), SurfaceOutput.CameraInputInfo.of(resolution, cropRect, cameraInternal, entry.getKey().getRotationDegrees(), entry.getKey().isMirroring()), (SurfaceOutput.CameraInputInfo) null), new FutureCallback<SurfaceOutput>() {
            public void onFailure(@NonNull Throwable th) {
                if (value.getTargets() != 2 || !(th instanceof CancellationException)) {
                    Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface. Target: " + TargetUtils.getHumanReadableName(value.getTargets()), th);
                    return;
                }
                Logger.d(SurfaceProcessorNode.TAG, "Downstream VideoCapture failed to provide Surface.");
            }

            public void onSuccess(@Nullable SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            for (SurfaceEdge close : out.values()) {
                close.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).isMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    private void sendSurfaceOutputs(@NonNull SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        for (Map.Entry next : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, next);
            ((SurfaceEdge) next.getValue()).addOnInvalidatedListener(new m0(this, 13, surfaceEdge, next));
        }
    }

    private void sendSurfaceRequest(@NonNull SurfaceEdge surfaceEdge) {
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceEdge.createSurfaceRequest(this.mCameraInternal));
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    @NonNull
    private SurfaceEdge transformSingleOutput(@NonNull SurfaceEdge surfaceEdge, @NonNull OutConfig outConfig) {
        Rect sizeToRect;
        boolean z;
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean isMirroring = outConfig.isMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, isMirroring);
        matrix.postConcat(rectToRect);
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        if (outConfig.shouldRespectInputCropRect()) {
            boolean contains = outConfig.getCropRect().contains(surfaceEdge.getCropRect());
            Rect cropRect2 = outConfig.getCropRect();
            Rect cropRect3 = surfaceEdge.getCropRect();
            Preconditions.checkArgument(contains, "Output crop rect " + cropRect2 + " must contain input crop rect " + cropRect3);
            sizeToRect = new Rect();
            RectF rectF = new RectF(surfaceEdge.getCropRect());
            rectToRect.mapRect(rectF);
            rectF.round(sizeToRect);
        } else {
            sizeToRect = TransformUtils.sizeToRect(outConfig.getSize());
        }
        Rect rect = sizeToRect;
        StreamSpec build = surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build();
        int targets = outConfig.getTargets();
        int format = outConfig.getFormat();
        int rotationDegrees2 = surfaceEdge.getRotationDegrees() - rotationDegrees;
        if (surfaceEdge.isMirroring() != isMirroring) {
            z = true;
        } else {
            z = false;
        }
        return new SurfaceEdge(targets, format, build, matrix, false, rect, rotationDegrees2, -1, z);
    }

    @NonNull
    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public void release() {
        this.mSurfaceProcessor.release();
        Threads.runOnMain(new gd(this, 6));
    }

    public void setUpRotationUpdates(@NonNull SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        surfaceEdge.addTransformationUpdateListener(new od(map, 2));
    }

    @MainThread
    @NonNull
    public Out transform(@NonNull In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig next : in.getOutConfigs()) {
            this.mOutput.put(next, transformSingleOutput(surfaceEdge, next));
        }
        sendSurfaceRequest(surfaceEdge);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        setUpRotationUpdates(surfaceEdge, this.mOutput);
        return this.mOutput;
    }
}
