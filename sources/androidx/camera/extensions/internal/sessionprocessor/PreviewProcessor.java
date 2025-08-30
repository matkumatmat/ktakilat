package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.PreviewImageProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import java.util.List;

class PreviewProcessor {
    private static final String TAG = "PreviewProcessor";
    @NonNull
    private final CaptureResultImageMatcher mCaptureResultImageMatcher = new CaptureResultImageMatcher();
    @GuardedBy("mLock")
    private boolean mIsClosed = false;
    @GuardedBy("mLock")
    private boolean mIsPaused = false;
    private final Object mLock = new Object();
    @NonNull
    private final PreviewImageProcessorImpl mPreviewImageProcessor;

    public interface OnCaptureResultCallback {
        void onCaptureResult(long j, @NonNull List<Pair<CaptureResult.Key, Object>> list);
    }

    public PreviewProcessor(@NonNull PreviewImageProcessorImpl previewImageProcessorImpl, @NonNull Surface surface, @NonNull Size size) {
        this.mPreviewImageProcessor = previewImageProcessorImpl;
        previewImageProcessorImpl.onResolutionUpdate(size);
        previewImageProcessorImpl.onOutputSurface(surface, 1);
        previewImageProcessorImpl.onImageFormatUpdate(35);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(final OnCaptureResultCallback onCaptureResultCallback, ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            try {
                if (this.mIsClosed || this.mIsPaused) {
                    imageReference.decrement();
                    Logger.d(TAG, "Ignore image in closed or paused state");
                    return;
                }
                Version version = Version.VERSION_1_3;
                if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
                    this.mPreviewImageProcessor.process(imageReference.get(), totalCaptureResult);
                } else {
                    this.mPreviewImageProcessor.process(imageReference.get(), totalCaptureResult, new ProcessResultImpl() {
                        public void onCaptureCompleted(long j, @NonNull List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureResult(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                        }
                    }, CameraXExecutors.ioExecutor());
                }
                imageReference.decrement();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        synchronized (this.mLock) {
            this.mIsClosed = true;
            this.mCaptureResultImageMatcher.clear();
            this.mCaptureResultImageMatcher.clearImageReferenceListener();
        }
    }

    public void notifyCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
        this.mCaptureResultImageMatcher.captureResultIncoming(totalCaptureResult);
    }

    public void notifyImage(@NonNull ImageReference imageReference) {
        this.mCaptureResultImageMatcher.imageIncoming(imageReference);
    }

    public void pause() {
        synchronized (this.mLock) {
            this.mIsPaused = true;
        }
    }

    public void resume() {
        synchronized (this.mLock) {
            this.mIsPaused = false;
        }
    }

    public void start(@NonNull OnCaptureResultCallback onCaptureResultCallback) {
        this.mCaptureResultImageMatcher.setImageReferenceListener(new c(this, onCaptureResultCallback));
    }
}
