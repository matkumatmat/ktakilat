package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public final class ExtendedCameraConfigProviderStore {
    @GuardedBy("LOCK")
    private static final Map<Object, CameraConfigProvider> CAMERA_CONFIG_PROVIDERS = new HashMap();
    private static final Object LOCK = new Object();

    private ExtendedCameraConfigProviderStore() {
    }

    public static void addConfig(@NonNull Object obj, @NonNull CameraConfigProvider cameraConfigProvider) {
        synchronized (LOCK) {
            CAMERA_CONFIG_PROVIDERS.put(obj, cameraConfigProvider);
        }
    }

    public static void clear() {
        synchronized (LOCK) {
            CAMERA_CONFIG_PROVIDERS.clear();
        }
    }

    @NonNull
    public static CameraConfigProvider getConfigProvider(@NonNull Object obj) {
        CameraConfigProvider cameraConfigProvider;
        synchronized (LOCK) {
            cameraConfigProvider = CAMERA_CONFIG_PROVIDERS.get(obj);
        }
        if (cameraConfigProvider == null) {
            return CameraConfigProvider.EMPTY;
        }
        return cameraConfigProvider;
    }
}
