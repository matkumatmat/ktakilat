package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {
    private final List<SynchronizedCaptureSession.StateCallback> mCallbacks;

    public SynchronizedCaptureSessionStateCallbacks(@NonNull List<SynchronizedCaptureSession.StateCallback> list) {
        ArrayList arrayList = new ArrayList();
        this.mCallbacks = arrayList;
        arrayList.addAll(list);
    }

    @NonNull
    public static SynchronizedCaptureSession.StateCallback createComboCallback(@NonNull SynchronizedCaptureSession.StateCallback... stateCallbackArr) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(stateCallbackArr));
    }

    public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onActive : this.mCallbacks) {
            onActive.onActive(synchronizedCaptureSession);
        }
    }

    @RequiresApi(api = 26)
    public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onCaptureQueueEmpty : this.mCallbacks) {
            onCaptureQueueEmpty.onCaptureQueueEmpty(synchronizedCaptureSession);
        }
    }

    public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onClosed : this.mCallbacks) {
            onClosed.onClosed(synchronizedCaptureSession);
        }
    }

    public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onConfigureFailed : this.mCallbacks) {
            onConfigureFailed.onConfigureFailed(synchronizedCaptureSession);
        }
    }

    public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onConfigured : this.mCallbacks) {
            onConfigured.onConfigured(synchronizedCaptureSession);
        }
    }

    public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onReady : this.mCallbacks) {
            onReady.onReady(synchronizedCaptureSession);
        }
    }

    public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onSessionFinished : this.mCallbacks) {
            onSessionFinished.onSessionFinished(synchronizedCaptureSession);
        }
    }

    @RequiresApi(api = 23)
    public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        for (SynchronizedCaptureSession.StateCallback onSurfacePrepared : this.mCallbacks) {
            onSurfacePrepared.onSurfacePrepared(synchronizedCaptureSession, surface);
        }
    }

    public static class Adapter extends SynchronizedCaptureSession.StateCallback {
        @NonNull
        private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

        public Adapter(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.mCameraCaptureSessionStateCallback = stateCallback;
        }

        public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onActive(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onClosed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigured(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onReady(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onSessionFinished(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession(), surface);
        }

        public Adapter(@NonNull List<CameraCaptureSession.StateCallback> list) {
            this(CameraCaptureSessionStateCallbacks.createComboCallback(list));
        }
    }
}
