package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CameraDeviceStateCallbacks {

    public static final class ComboDeviceStateCallback extends CameraDevice.StateCallback {
        private final List<CameraDevice.StateCallback> mCallbacks = new ArrayList();

        public ComboDeviceStateCallback(@NonNull List<CameraDevice.StateCallback> list) {
            for (CameraDevice.StateCallback next : list) {
                if (!(next instanceof NoOpDeviceStateCallback)) {
                    this.mCallbacks.add(next);
                }
            }
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onClosed : this.mCallbacks) {
                onClosed.onClosed(cameraDevice);
            }
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onDisconnected : this.mCallbacks) {
                onDisconnected.onDisconnected(cameraDevice);
            }
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            for (CameraDevice.StateCallback onError : this.mCallbacks) {
                onError.onError(cameraDevice, i);
            }
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onOpened : this.mCallbacks) {
                onOpened.onOpened(cameraDevice);
            }
        }
    }

    public static final class NoOpDeviceStateCallback extends CameraDevice.StateCallback {
        public void onClosed(@NonNull CameraDevice cameraDevice) {
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i) {
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    private CameraDeviceStateCallbacks() {
    }

    @NonNull
    public static CameraDevice.StateCallback createComboCallback(@NonNull List<CameraDevice.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboDeviceStateCallback(list);
    }

    @NonNull
    public static CameraDevice.StateCallback createNoOpCallback() {
        return new NoOpDeviceStateCallback();
    }

    @NonNull
    public static CameraDevice.StateCallback createComboCallback(@NonNull CameraDevice.StateCallback... stateCallbackArr) {
        return createComboCallback((List<CameraDevice.StateCallback>) Arrays.asList(stateCallbackArr));
    }
}
