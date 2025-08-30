package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";
    @NonNull
    private final float[] mAdditionalTransform;
    @NonNull
    private final SurfaceOutput.CameraInputInfo mCameraInputInfo;
    @NonNull
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.Completer<Void> mCloseFutureCompleter;
    @GuardedBy("mLock")
    @Nullable
    private Consumer<SurfaceOutput.Event> mEventListener;
    @GuardedBy("mLock")
    @Nullable
    private Executor mExecutor;
    private final int mFormat;
    @GuardedBy("mLock")
    private boolean mHasPendingCloseRequest;
    @NonNull
    private final float[] mInvertedTextureTransform;
    @GuardedBy("mLock")
    private boolean mIsClosed;
    private final Object mLock = new Object();
    @NonNull
    private final float[] mSecondaryAdditionalTransform;
    @Nullable
    private final SurfaceOutput.CameraInputInfo mSecondaryCameraInputInfo;
    @NonNull
    private final float[] mSecondaryInvertedTextureTransform;
    @NonNull
    private Matrix mSensorToBufferTransform;
    @NonNull
    private final Size mSize;
    @NonNull
    private final Surface mSurface;
    private final int mTargets;

    public SurfaceOutputImpl(@NonNull Surface surface, int i, int i2, @NonNull Size size, @NonNull SurfaceOutput.CameraInputInfo cameraInputInfo, @Nullable SurfaceOutput.CameraInputInfo cameraInputInfo2, @NonNull Matrix matrix) {
        float[] fArr = new float[16];
        this.mAdditionalTransform = fArr;
        float[] fArr2 = new float[16];
        this.mSecondaryAdditionalTransform = fArr2;
        float[] fArr3 = new float[16];
        this.mInvertedTextureTransform = fArr3;
        float[] fArr4 = new float[16];
        this.mSecondaryInvertedTextureTransform = fArr4;
        this.mHasPendingCloseRequest = false;
        this.mIsClosed = false;
        this.mSurface = surface;
        this.mTargets = i;
        this.mFormat = i2;
        this.mSize = size;
        this.mCameraInputInfo = cameraInputInfo;
        this.mSecondaryCameraInputInfo = cameraInputInfo2;
        this.mSensorToBufferTransform = matrix;
        calculateAdditionalTransform(fArr, fArr3, cameraInputInfo);
        calculateAdditionalTransform(fArr2, fArr4, cameraInputInfo2);
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new d(this, 1));
    }

    private static void calculateAdditionalTransform(@NonNull float[] fArr, @NonNull float[] fArr2, @Nullable SurfaceOutput.CameraInputInfo cameraInputInfo) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        if (cameraInputInfo != null) {
            MatrixExt.preVerticalFlip(fArr, 0.5f);
            MatrixExt.preRotate(fArr, (float) cameraInputInfo.getRotationDegrees(), 0.5f, 0.5f);
            if (cameraInputInfo.getMirroring()) {
                android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
            }
            Size rotateSize = TransformUtils.rotateSize(cameraInputInfo.getInputSize(), cameraInputInfo.getRotationDegrees());
            Matrix rectToRect = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(cameraInputInfo.getInputSize()), TransformUtils.sizeToRectF(rotateSize), cameraInputInfo.getRotationDegrees(), cameraInputInfo.getMirroring());
            RectF rectF = new RectF(cameraInputInfo.getInputCropRect());
            rectToRect.mapRect(rectF);
            android.opengl.Matrix.translateM(fArr, 0, rectF.left / ((float) rotateSize.getWidth()), ((((float) rotateSize.getHeight()) - rectF.height()) - rectF.top) / ((float) rotateSize.getHeight()), 0.0f);
            android.opengl.Matrix.scaleM(fArr, 0, rectF.width() / ((float) rotateSize.getWidth()), rectF.height() / ((float) rotateSize.getHeight()), 1.0f);
            calculateInvertedTextureTransform(fArr2, cameraInputInfo.getCameraInternal());
            android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
        }
    }

    private static void calculateInvertedTextureTransform(@NonNull float[] fArr, @Nullable CameraInternal cameraInternal) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        MatrixExt.preVerticalFlip(fArr, 0.5f);
        if (cameraInternal != null) {
            Preconditions.checkState(cameraInternal.getHasTransform(), "Camera has no transform.");
            MatrixExt.preRotate(fArr, (float) cameraInternal.getCameraInfo().getSensorRotationDegrees(), 0.5f, 0.5f);
            if (cameraInternal.isFrontFacing()) {
                android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCloseFutureCompleter = completer;
        return "SurfaceOutputImpl close future complete";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestClose$1(AtomicReference atomicReference) {
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.of(0, this));
    }

    @AnyThread
    public void close() {
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed) {
                    this.mIsClosed = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mCloseFutureCompleter.set(null);
    }

    @VisibleForTesting
    @Nullable
    public CameraInternal getCamera() {
        return this.mCameraInputInfo.getCameraInternal();
    }

    @NonNull
    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    public int getFormat() {
        return this.mFormat;
    }

    @VisibleForTesting
    public Rect getInputCropRect() {
        return this.mCameraInputInfo.getInputCropRect();
    }

    @VisibleForTesting
    public Size getInputSize() {
        return this.mCameraInputInfo.getInputSize();
    }

    @VisibleForTesting
    public int getRotationDegrees() {
        return this.mCameraInputInfo.getRotationDegrees();
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return new Matrix(this.mSensorToBufferTransform);
    }

    @NonNull
    public Size getSize() {
        return this.mSize;
    }

    @NonNull
    public Surface getSurface(@NonNull Executor executor, @NonNull Consumer<SurfaceOutput.Event> consumer) {
        boolean z;
        synchronized (this.mLock) {
            this.mExecutor = executor;
            this.mEventListener = consumer;
            z = this.mHasPendingCloseRequest;
        }
        if (z) {
            requestClose();
        }
        return this.mSurface;
    }

    public int getTargets() {
        return this.mTargets;
    }

    @VisibleForTesting
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsClosed;
        }
        return z;
    }

    @VisibleForTesting
    public boolean isMirroring() {
        return this.mCameraInputInfo.getMirroring();
    }

    public void requestClose() {
        Executor executor;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            try {
                if (this.mExecutor != null) {
                    Consumer<SurfaceOutput.Event> consumer = this.mEventListener;
                    if (consumer != null) {
                        if (!this.mIsClosed) {
                            atomicReference.set(consumer);
                            executor = this.mExecutor;
                            this.mHasPendingCloseRequest = false;
                        }
                        executor = null;
                    }
                }
                this.mHasPendingCloseRequest = true;
                executor = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (executor != null) {
            try {
                executor.execute(new a(1, this, atomicReference));
            } catch (RejectedExecutionException e) {
                Logger.d(TAG, "Processor executor closed. Close request not posted.", e);
            }
        }
    }

    @AnyThread
    public void updateTransformMatrix(@NonNull float[] fArr, @NonNull float[] fArr2) {
        updateTransformMatrix(fArr, fArr2, true);
    }

    @AnyThread
    public void updateTransformMatrix(@NonNull float[] fArr, @NonNull float[] fArr2, boolean z) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, z ? this.mAdditionalTransform : this.mSecondaryAdditionalTransform, 0);
    }
}
