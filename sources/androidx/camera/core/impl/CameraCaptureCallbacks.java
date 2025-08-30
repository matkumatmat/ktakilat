package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureCallbacks {

    public static final class ComboCameraCaptureCallback extends CameraCaptureCallback {
        private final List<CameraCaptureCallback> mCallbacks = new ArrayList();

        public ComboCameraCaptureCallback(@NonNull List<CameraCaptureCallback> list) {
            for (CameraCaptureCallback next : list) {
                if (!(next instanceof NoOpCameraCaptureCallback)) {
                    this.mCallbacks.add(next);
                }
            }
        }

        @NonNull
        public List<CameraCaptureCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public void onCaptureCancelled(int i) {
            for (CameraCaptureCallback onCaptureCancelled : this.mCallbacks) {
                onCaptureCancelled.onCaptureCancelled(i);
            }
        }

        public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
            for (CameraCaptureCallback onCaptureCompleted : this.mCallbacks) {
                onCaptureCompleted.onCaptureCompleted(i, cameraCaptureResult);
            }
        }

        public void onCaptureFailed(int i, @NonNull CameraCaptureFailure cameraCaptureFailure) {
            for (CameraCaptureCallback onCaptureFailed : this.mCallbacks) {
                onCaptureFailed.onCaptureFailed(i, cameraCaptureFailure);
            }
        }

        public void onCaptureProcessProgressed(int i, int i2) {
            for (CameraCaptureCallback onCaptureProcessProgressed : this.mCallbacks) {
                onCaptureProcessProgressed.onCaptureProcessProgressed(i, i2);
            }
        }

        public void onCaptureStarted(int i) {
            for (CameraCaptureCallback onCaptureStarted : this.mCallbacks) {
                onCaptureStarted.onCaptureStarted(i);
            }
        }
    }

    public static final class NoOpCameraCaptureCallback extends CameraCaptureCallback {
        public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
        }

        public void onCaptureFailed(int i, @NonNull CameraCaptureFailure cameraCaptureFailure) {
        }

        public void onCaptureStarted(int i) {
        }
    }

    private CameraCaptureCallbacks() {
    }

    @NonNull
    public static CameraCaptureCallback createComboCallback(@NonNull List<CameraCaptureCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboCameraCaptureCallback(list);
    }

    @NonNull
    public static CameraCaptureCallback createNoOpCallback() {
        return new NoOpCameraCaptureCallback();
    }

    @NonNull
    public static CameraCaptureCallback createComboCallback(@NonNull CameraCaptureCallback... cameraCaptureCallbackArr) {
        return createComboCallback((List<CameraCaptureCallback>) Arrays.asList(cameraCaptureCallbackArr));
    }
}
