package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureSessionStateCallbacks {

    public static final class ComboSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final List<CameraCaptureSession.StateCallback> mCallbacks = new ArrayList();

        public ComboSessionStateCallback(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback next : list) {
                if (!(next instanceof NoOpSessionStateCallback)) {
                    this.mCallbacks.add(next);
                }
            }
        }

        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onActive : this.mCallbacks) {
                onActive.onActive(cameraCaptureSession);
            }
        }

        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onCaptureQueueEmpty : this.mCallbacks) {
                ApiCompat.Api26Impl.onCaptureQueueEmpty(onCaptureQueueEmpty, cameraCaptureSession);
            }
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onClosed : this.mCallbacks) {
                onClosed.onClosed(cameraCaptureSession);
            }
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigureFailed : this.mCallbacks) {
                onConfigureFailed.onConfigureFailed(cameraCaptureSession);
            }
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigured : this.mCallbacks) {
                onConfigured.onConfigured(cameraCaptureSession);
            }
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onReady : this.mCallbacks) {
                onReady.onReady(cameraCaptureSession);
            }
        }

        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            for (CameraCaptureSession.StateCallback onSurfacePrepared : this.mCallbacks) {
                ApiCompat.Api23Impl.onSurfacePrepared(onSurfacePrepared, cameraCaptureSession, surface);
            }
        }
    }

    public static final class NoOpSessionStateCallback extends CameraCaptureSession.StateCallback {
        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
        }
    }

    private CameraCaptureSessionStateCallbacks() {
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createComboCallback(@NonNull List<CameraCaptureSession.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboSessionStateCallback(list);
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        return new NoOpSessionStateCallback();
    }

    @NonNull
    public static CameraCaptureSession.StateCallback createComboCallback(@NonNull CameraCaptureSession.StateCallback... stateCallbackArr) {
        return createComboCallback((List<CameraCaptureSession.StateCallback>) Arrays.asList(stateCallbackArr));
    }
}
