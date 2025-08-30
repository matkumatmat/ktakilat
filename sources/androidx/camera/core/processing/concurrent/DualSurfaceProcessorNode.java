package androidx.camera.core.processing.concurrent;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

public class DualSurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "DualSurfaceProcessorNode";
    @Nullable
    private In mInput;
    @Nullable
    private Out mOutput;
    @NonNull
    final CameraInternal mPrimaryCameraInternal;
    @NonNull
    final CameraInternal mSecondaryCameraInternal;
    @NonNull
    final SurfaceProcessorInternal mSurfaceProcessor;

    @AutoValue
    public static abstract class In {
        @NonNull
        public static In of(@NonNull SurfaceEdge surfaceEdge, @NonNull SurfaceEdge surfaceEdge2, @NonNull List<DualOutConfig> list) {
            return new AutoValue_DualSurfaceProcessorNode_In(surfaceEdge, surfaceEdge2, list);
        }

        @NonNull
        public abstract List<DualOutConfig> getOutConfigs();

        @NonNull
        public abstract SurfaceEdge getPrimarySurfaceEdge();

        @NonNull
        public abstract SurfaceEdge getSecondarySurfaceEdge();
    }

    public static class Out extends HashMap<DualOutConfig, SurfaceEdge> {
    }

    public DualSurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull CameraInternal cameraInternal2, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mPrimaryCameraInternal = cameraInternal;
        this.mSecondaryCameraInternal = cameraInternal2;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAndSendSurfaceOutput */
    public void lambda$sendSurfaceOutputs$0(@NonNull CameraInternal cameraInternal, @NonNull CameraInternal cameraInternal2, @NonNull SurfaceEdge surfaceEdge, @NonNull SurfaceEdge surfaceEdge2, Map.Entry<DualOutConfig, SurfaceEdge> entry) {
        final SurfaceEdge value = entry.getValue();
        Size resolution = surfaceEdge.getStreamSpec().getResolution();
        Rect cropRect = entry.getKey().getPrimaryOutConfig().getCropRect();
        if (!surfaceEdge.hasCameraTransform()) {
            cameraInternal = null;
        }
        SurfaceOutput.CameraInputInfo of = SurfaceOutput.CameraInputInfo.of(resolution, cropRect, cameraInternal, entry.getKey().getPrimaryOutConfig().getRotationDegrees(), entry.getKey().getPrimaryOutConfig().isMirroring());
        Size resolution2 = surfaceEdge2.getStreamSpec().getResolution();
        Rect cropRect2 = entry.getKey().getSecondaryOutConfig().getCropRect();
        if (!surfaceEdge2.hasCameraTransform()) {
            cameraInternal2 = null;
        }
        Futures.addCallback(value.createSurfaceOutputFuture(entry.getKey().getPrimaryOutConfig().getFormat(), of, SurfaceOutput.CameraInputInfo.of(resolution2, cropRect2, cameraInternal2, entry.getKey().getSecondaryOutConfig().getRotationDegrees(), entry.getKey().getSecondaryOutConfig().isMirroring())), new FutureCallback<SurfaceOutput>() {
            public void onFailure(@NonNull Throwable th) {
                if (value.getTargets() != 2 || !(th instanceof CancellationException)) {
                    Logger.w(DualSurfaceProcessorNode.TAG, "Downstream node failed to provide Surface. Target: " + TargetUtils.getHumanReadableName(value.getTargets()), th);
                    return;
                }
                Logger.d(DualSurfaceProcessorNode.TAG, "Downstream VideoCapture failed to provide Surface.");
            }

            public void onSuccess(@Nullable SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    DualSurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e) {
                    Logger.e(DualSurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1() {
        Out out = this.mOutput;
        if (out != null) {
            for (SurfaceEdge close : out.values()) {
                close.close();
            }
        }
    }

    private void sendSurfaceOutputs(@NonNull CameraInternal cameraInternal, @NonNull CameraInternal cameraInternal2, @NonNull SurfaceEdge surfaceEdge, @NonNull SurfaceEdge surfaceEdge2, @NonNull Map<DualOutConfig, SurfaceEdge> map) {
        for (Map.Entry next : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(cameraInternal, cameraInternal2, surfaceEdge, surfaceEdge2, next);
            ((SurfaceEdge) next.getValue()).addOnInvalidatedListener(new t5(this, cameraInternal, cameraInternal2, surfaceEdge, surfaceEdge2, next));
        }
    }

    private void sendSurfaceRequest(@NonNull CameraInternal cameraInternal, @NonNull SurfaceEdge surfaceEdge, @NonNull Map<DualOutConfig, SurfaceEdge> map, boolean z) {
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceEdge.createSurfaceRequest(cameraInternal, z));
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    @NonNull
    private SurfaceEdge transformSingleOutput(@NonNull SurfaceEdge surfaceEdge, @NonNull OutConfig outConfig) {
        boolean z;
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean isMirroring = outConfig.isMirroring();
        Matrix matrix = new Matrix();
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        Rect sizeToRect = TransformUtils.sizeToRect(outConfig.getSize());
        StreamSpec build = surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build();
        int targets = outConfig.getTargets();
        int format = outConfig.getFormat();
        int rotationDegrees2 = surfaceEdge.getRotationDegrees() - rotationDegrees;
        if (surfaceEdge.isMirroring() != isMirroring) {
            z = true;
        } else {
            z = false;
        }
        return new SurfaceEdge(targets, format, build, matrix, false, sizeToRect, rotationDegrees2, -1, z);
    }

    public void release() {
        this.mSurfaceProcessor.release();
        Threads.runOnMain(new x0(this, 17));
    }

    @MainThread
    @NonNull
    public Out transform(@NonNull In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge primarySurfaceEdge = this.mInput.getPrimarySurfaceEdge();
        SurfaceEdge secondarySurfaceEdge = this.mInput.getSecondarySurfaceEdge();
        for (DualOutConfig next : this.mInput.getOutConfigs()) {
            this.mOutput.put(next, transformSingleOutput(primarySurfaceEdge, next.getPrimaryOutConfig()));
        }
        sendSurfaceRequest(this.mPrimaryCameraInternal, primarySurfaceEdge, this.mOutput, true);
        sendSurfaceRequest(this.mSecondaryCameraInternal, secondarySurfaceEdge, this.mOutput, false);
        sendSurfaceOutputs(this.mPrimaryCameraInternal, this.mSecondaryCameraInternal, primarySurfaceEdge, secondarySurfaceEdge, this.mOutput);
        return this.mOutput;
    }
}
