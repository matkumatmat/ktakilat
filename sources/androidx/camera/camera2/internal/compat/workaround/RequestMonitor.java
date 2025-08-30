package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RequestMonitor {
    private static final String TAG = "RequestMonitor";
    private final boolean mQuirkEnabled;
    private final List<ListenableFuture<Void>> mRequestTasks = Collections.synchronizedList(new ArrayList());

    public static class RequestCompleteListener extends CameraCaptureSession.CaptureCallback {
        CallbackToFutureAdapter.Completer<Void> mStartRequestCompleter;
        @NonNull
        final ListenableFuture<Void> mStartRequestFuture = CallbackToFutureAdapter.getFuture(new b(this));

        private void completeFuture() {
            CallbackToFutureAdapter.Completer<Void> completer = this.mStartRequestCompleter;
            if (completer != null) {
                completer.set(null);
                this.mStartRequestCompleter = null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mStartRequestCompleter = completer;
            return "RequestCompleteListener[" + this + "]";
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            completeFuture();
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            completeFuture();
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
            completeFuture();
        }

        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
            completeFuture();
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            completeFuture();
        }
    }

    public RequestMonitor(boolean z) {
        this.mQuirkEnabled = z;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createMonitorListener$1(RequestCompleteListener requestCompleteListener, ListenableFuture listenableFuture) {
        Objects.toString(requestCompleteListener);
        toString();
        this.mRequestTasks.remove(listenableFuture);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getRequestsProcessedFuture$0(List list) {
        return null;
    }

    @NonNull
    public CameraCaptureSession.CaptureCallback createMonitorListener(@NonNull CameraCaptureSession.CaptureCallback captureCallback) {
        if (!shouldMonitorRequest()) {
            return captureCallback;
        }
        return Camera2CaptureCallbacks.createComboCallback(createMonitorListener(), captureCallback);
    }

    @NonNull
    public ListenableFuture<Void> getRequestsProcessedFuture() {
        if (this.mRequestTasks.isEmpty()) {
            return Futures.immediateFuture(null);
        }
        return Futures.nonCancellationPropagating(Futures.transform(Futures.successfulAsList(new ArrayList(this.mRequestTasks)), new h5(2), CameraXExecutors.directExecutor()));
    }

    public boolean shouldMonitorRequest() {
        return this.mQuirkEnabled;
    }

    public void stop() {
        LinkedList linkedList = new LinkedList(this.mRequestTasks);
        while (!linkedList.isEmpty()) {
            ListenableFuture listenableFuture = (ListenableFuture) linkedList.poll();
            Objects.requireNonNull(listenableFuture);
            listenableFuture.cancel(true);
        }
    }

    private CameraCaptureSession.CaptureCallback createMonitorListener() {
        RequestCompleteListener requestCompleteListener = new RequestCompleteListener();
        ListenableFuture<Void> listenableFuture = requestCompleteListener.mStartRequestFuture;
        this.mRequestTasks.add(listenableFuture);
        toString();
        listenableFuture.addListener(new a(this, requestCompleteListener, listenableFuture), CameraXExecutors.directExecutor());
        return requestCompleteListener;
    }
}
