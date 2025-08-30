package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.Threads;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

public class RequestWithCallback implements TakePictureCallback {
    private CallbackToFutureAdapter.Completer<Void> mCaptureCompleter;
    private final ListenableFuture<Void> mCaptureFuture;
    @Nullable
    private ListenableFuture<Void> mCaptureRequestFuture;
    private CallbackToFutureAdapter.Completer<Void> mCompleteCompleter;
    private final ListenableFuture<Void> mCompleteFuture;
    private boolean mIsAborted = false;
    private boolean mIsStarted = false;
    private final TakePictureRequest.RetryControl mRetryControl;
    private final TakePictureRequest mTakePictureRequest;

    public RequestWithCallback(@NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureRequest.RetryControl retryControl) {
        this.mTakePictureRequest = takePictureRequest;
        this.mRetryControl = retryControl;
        this.mCaptureFuture = CallbackToFutureAdapter.getFuture(new be(this, 0));
        this.mCompleteFuture = CallbackToFutureAdapter.getFuture(new be(this, 1));
    }

    @MainThread
    private void abort(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        this.mIsAborted = true;
        ListenableFuture<Void> listenableFuture = this.mCaptureRequestFuture;
        Objects.requireNonNull(listenableFuture);
        listenableFuture.cancel(true);
        this.mCaptureCompleter.setException(imageCaptureException);
        this.mCompleteCompleter.set(null);
    }

    private void checkOnImageCaptured() {
        Preconditions.checkState(this.mCaptureFuture.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCaptureCompleter = completer;
        return "CaptureCompleteFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCompleteCompleter = completer;
        return "RequestCompleteFuture";
    }

    private void markComplete() {
        Preconditions.checkState(!this.mCompleteFuture.isDone(), "The callback can only complete once.");
        this.mCompleteCompleter.set(null);
    }

    @MainThread
    private void onFailure(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        this.mTakePictureRequest.onError(imageCaptureException);
    }

    @MainThread
    public void abortAndSendErrorToApp(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mCompleteFuture.isDone()) {
            abort(imageCaptureException);
            onFailure(imageCaptureException);
        }
    }

    @MainThread
    public void abortSilentlyAndRetry() {
        Threads.checkMainThread();
        if (!this.mCompleteFuture.isDone()) {
            abort(new ImageCaptureException(3, "The request is aborted silently and retried.", (Throwable) null));
            this.mRetryControl.retryRequest(this.mTakePictureRequest);
        }
    }

    @MainThread
    @NonNull
    public ListenableFuture<Void> getCaptureFuture() {
        Threads.checkMainThread();
        return this.mCaptureFuture;
    }

    @MainThread
    @NonNull
    public ListenableFuture<Void> getCompleteFuture() {
        Threads.checkMainThread();
        return this.mCompleteFuture;
    }

    @VisibleForTesting
    @NonNull
    public TakePictureRequest getTakePictureRequest() {
        return this.mTakePictureRequest;
    }

    public boolean isAborted() {
        return this.mIsAborted;
    }

    @MainThread
    public void onCaptureFailure(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            boolean decrementRetryCounter = this.mTakePictureRequest.decrementRetryCounter();
            if (!decrementRetryCounter) {
                onFailure(imageCaptureException);
            }
            markComplete();
            this.mCaptureCompleter.setException(imageCaptureException);
            if (decrementRetryCounter) {
                this.mRetryControl.retryRequest(this.mTakePictureRequest);
            }
        }
    }

    public void onCaptureProcessProgressed(int i) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            this.mTakePictureRequest.onCaptureProcessProgressed(i);
        }
    }

    @MainThread
    public void onCaptureStarted() {
        Threads.checkMainThread();
        if (!this.mIsAborted && !this.mIsStarted) {
            this.mIsStarted = true;
            ImageCapture.OnImageCapturedCallback inMemoryCallback = this.mTakePictureRequest.getInMemoryCallback();
            if (inMemoryCallback != null) {
                inMemoryCallback.onCaptureStarted();
            }
            ImageCapture.OnImageSavedCallback onDiskCallback = this.mTakePictureRequest.getOnDiskCallback();
            if (onDiskCallback != null) {
                onDiskCallback.onCaptureStarted();
            }
        }
    }

    @MainThread
    public void onFinalResult(@NonNull ImageCapture.OutputFileResults outputFileResults) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            checkOnImageCaptured();
            markComplete();
            this.mTakePictureRequest.onResult(outputFileResults);
        }
    }

    @MainThread
    public void onImageCaptured() {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            if (!this.mIsStarted) {
                onCaptureStarted();
            }
            this.mCaptureCompleter.set(null);
        }
    }

    public void onPostviewBitmapAvailable(@NonNull Bitmap bitmap) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            this.mTakePictureRequest.onPostviewBitmapAvailable(bitmap);
        }
    }

    @MainThread
    public void onProcessFailure(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        if (!this.mIsAborted) {
            checkOnImageCaptured();
            markComplete();
            onFailure(imageCaptureException);
        }
    }

    @MainThread
    public void setCaptureRequestFuture(@NonNull ListenableFuture<Void> listenableFuture) {
        boolean z;
        Threads.checkMainThread();
        if (this.mCaptureRequestFuture == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "CaptureRequestFuture can only be set once.");
        this.mCaptureRequestFuture = listenableFuture;
    }

    @MainThread
    public void onFinalResult(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mIsAborted) {
            imageProxy.close();
            return;
        }
        checkOnImageCaptured();
        markComplete();
        this.mTakePictureRequest.onResult(imageProxy);
    }
}
