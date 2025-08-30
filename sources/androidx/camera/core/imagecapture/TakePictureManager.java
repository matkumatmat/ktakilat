package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener, TakePictureRequest.RetryControl {
    private static final String TAG = "TakePictureManager";
    @Nullable
    private RequestWithCallback mCapturingRequest;
    final ImageCaptureControl mImageCaptureControl;
    ImagePipeline mImagePipeline;
    private final List<RequestWithCallback> mIncompleteRequests;
    @VisibleForTesting
    final Deque<TakePictureRequest> mNewRequests = new ArrayDeque();
    boolean mPaused = false;

    @AutoValue
    public static abstract class CaptureError {
        public static CaptureError of(int i, @NonNull ImageCaptureException imageCaptureException) {
            return new AutoValue_TakePictureManager_CaptureError(i, imageCaptureException);
        }

        @NonNull
        public abstract ImageCaptureException getImageCaptureException();

        public abstract int getRequestId();
    }

    @MainThread
    public TakePictureManager(@NonNull ImageCaptureControl imageCaptureControl) {
        Threads.checkMainThread();
        this.mImageCaptureControl = imageCaptureControl;
        this.mIncompleteRequests = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackCurrentRequests$0() {
        this.mCapturingRequest = null;
        issueNextRequest();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackCurrentRequests$1(RequestWithCallback requestWithCallback) {
        this.mIncompleteRequests.remove(requestWithCallback);
    }

    @MainThread
    private ListenableFuture<Void> submitCameraRequest(@NonNull final CameraRequest cameraRequest) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        ListenableFuture<Void> submitStillCaptureRequests = this.mImageCaptureControl.submitStillCaptureRequests(cameraRequest.getCaptureConfigs());
        Futures.addCallback(submitStillCaptureRequests, new FutureCallback<Void>() {
            public void onFailure(@NonNull Throwable th) {
                if (!cameraRequest.isAborted()) {
                    int id = cameraRequest.getCaptureConfigs().get(0).getId();
                    if (th instanceof ImageCaptureException) {
                        TakePictureManager.this.mImagePipeline.notifyCaptureError(CaptureError.of(id, (ImageCaptureException) th));
                    } else {
                        TakePictureManager.this.mImagePipeline.notifyCaptureError(CaptureError.of(id, new ImageCaptureException(2, "Failed to submit capture request", th)));
                    }
                    TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
                }
            }

            public void onSuccess(@Nullable Void voidR) {
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }
        }, CameraXExecutors.mainThreadExecutor());
        return submitStillCaptureRequests;
    }

    private void trackCurrentRequests(@NonNull RequestWithCallback requestWithCallback) {
        Preconditions.checkState(!hasCapturingRequest());
        this.mCapturingRequest = requestWithCallback;
        requestWithCallback.getCaptureFuture().addListener(new wf(this, 0), CameraXExecutors.directExecutor());
        this.mIncompleteRequests.add(requestWithCallback);
        requestWithCallback.getCompleteFuture().addListener(new ib(15, this, requestWithCallback), CameraXExecutors.directExecutor());
    }

    @MainThread
    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", (Throwable) null);
        for (TakePictureRequest onError : this.mNewRequests) {
            onError.onError(imageCaptureException);
        }
        this.mNewRequests.clear();
        Iterator it = new ArrayList(this.mIncompleteRequests).iterator();
        while (it.hasNext()) {
            ((RequestWithCallback) it.next()).abortAndSendErrorToApp(imageCaptureException);
        }
    }

    @VisibleForTesting
    @Nullable
    public RequestWithCallback getCapturingRequest() {
        return this.mCapturingRequest;
    }

    @VisibleForTesting
    @NonNull
    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    @VisibleForTesting
    public List<RequestWithCallback> getIncompleteRequests() {
        return this.mIncompleteRequests;
    }

    @VisibleForTesting
    public boolean hasCapturingRequest() {
        if (this.mCapturingRequest != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public void issueNextRequest() {
        TakePictureRequest poll;
        Threads.checkMainThread();
        if (!hasCapturingRequest() && !this.mPaused && this.mImagePipeline.getCapacity() != 0 && (poll = this.mNewRequests.poll()) != null) {
            RequestWithCallback requestWithCallback = new RequestWithCallback(poll, this);
            trackCurrentRequests(requestWithCallback);
            Pair<CameraRequest, ProcessingRequest> createRequests = this.mImagePipeline.createRequests(poll, requestWithCallback, requestWithCallback.getCaptureFuture());
            CameraRequest cameraRequest = (CameraRequest) createRequests.first;
            Objects.requireNonNull(cameraRequest);
            ProcessingRequest processingRequest = (ProcessingRequest) createRequests.second;
            Objects.requireNonNull(processingRequest);
            this.mImagePipeline.submitProcessingRequest(processingRequest);
            requestWithCallback.setCaptureRequestFuture(submitCameraRequest(cameraRequest));
        }
    }

    @MainThread
    public void offerRequest(@NonNull TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        this.mNewRequests.offer(takePictureRequest);
        issueNextRequest();
    }

    public void onImageClose(@NonNull ImageProxy imageProxy) {
        CameraXExecutors.mainThreadExecutor().execute(new wf(this, 1));
    }

    @MainThread
    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
        RequestWithCallback requestWithCallback = this.mCapturingRequest;
        if (requestWithCallback != null) {
            requestWithCallback.abortSilentlyAndRetry();
        }
    }

    @MainThread
    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    @MainThread
    public void retryRequest(@NonNull TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        Logger.d(TAG, "Add a new request for retrying.");
        this.mNewRequests.addFirst(takePictureRequest);
        issueNextRequest();
    }

    @MainThread
    public void setImagePipeline(@NonNull ImagePipeline imagePipeline) {
        Threads.checkMainThread();
        this.mImagePipeline = imagePipeline;
        imagePipeline.setOnImageCloseListener(this);
    }
}
