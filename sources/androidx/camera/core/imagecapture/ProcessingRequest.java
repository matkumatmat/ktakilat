package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ProcessingRequest {
    static final int PROGRESS_NOT_RECEIVED = -1;
    @NonNull
    private final TakePictureCallback mCallback;
    @NonNull
    final ListenableFuture<Void> mCaptureFuture;
    @NonNull
    private final Rect mCropRect;
    private final int mJpegQuality;
    private int mLastCaptureProcessProgressed;
    @Nullable
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRequestId;
    private final int mRotationDegrees;
    @NonNull
    private final Matrix mSensorToBufferTransform;
    @NonNull
    private final List<Integer> mStageIds;
    @NonNull
    private final String mTagBundleKey;

    public ProcessingRequest(@NonNull CaptureBundle captureBundle, @Nullable ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, int i, int i2, @NonNull Matrix matrix, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        this(captureBundle, outputFileOptions, rect, i, i2, matrix, takePictureCallback, listenableFuture, 0);
    }

    @NonNull
    public ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }

    @NonNull
    public Rect getCropRect() {
        return this.mCropRect;
    }

    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    @Nullable
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    @NonNull
    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    @NonNull
    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public boolean isInMemoryCapture() {
        if (getOutputFileOptions() == null) {
            return true;
        }
        return false;
    }

    @MainThread
    public void onCaptureFailure(@NonNull ImageCaptureException imageCaptureException) {
        this.mCallback.onCaptureFailure(imageCaptureException);
    }

    @MainThread
    public void onCaptureProcessProgressed(int i) {
        if (this.mLastCaptureProcessProgressed != i) {
            this.mLastCaptureProcessProgressed = i;
            this.mCallback.onCaptureProcessProgressed(i);
        }
    }

    @MainThread
    public void onCaptureStarted() {
        this.mCallback.onCaptureStarted();
    }

    @MainThread
    public void onFinalResult(@NonNull ImageCapture.OutputFileResults outputFileResults) {
        this.mCallback.onFinalResult(outputFileResults);
    }

    @MainThread
    public void onImageCaptured() {
        if (this.mLastCaptureProcessProgressed != -1) {
            onCaptureProcessProgressed(100);
        }
        this.mCallback.onImageCaptured();
    }

    public void onPostviewBitmapAvailable(@NonNull Bitmap bitmap) {
        this.mCallback.onPostviewBitmapAvailable(bitmap);
    }

    @MainThread
    public void onProcessFailure(@NonNull ImageCaptureException imageCaptureException) {
        this.mCallback.onProcessFailure(imageCaptureException);
    }

    public ProcessingRequest(@NonNull CaptureBundle captureBundle, @Nullable ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, int i, int i2, @NonNull Matrix matrix, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture, int i3) {
        this.mLastCaptureProcessProgressed = -1;
        this.mRequestId = i3;
        this.mOutputFileOptions = outputFileOptions;
        this.mJpegQuality = i2;
        this.mRotationDegrees = i;
        this.mCropRect = rect;
        this.mSensorToBufferTransform = matrix;
        this.mCallback = takePictureCallback;
        this.mTagBundleKey = String.valueOf(captureBundle.hashCode());
        this.mStageIds = new ArrayList();
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        for (CaptureStage id : captureStages) {
            this.mStageIds.add(Integer.valueOf(id.getId()));
        }
        this.mCaptureFuture = listenableFuture;
    }

    @MainThread
    public void onFinalResult(@NonNull ImageProxy imageProxy) {
        this.mCallback.onFinalResult(imageProxy);
    }
}
