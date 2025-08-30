package androidx.camera.extensions.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ExtensionsUtils {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Set<String> getPhysicalCameraIds(@NonNull CameraCharacteristics cameraCharacteristics) {
            try {
                return cameraCharacteristics.getPhysicalCameraIds();
            } catch (Exception unused) {
                return Collections.emptySet();
            }
        }
    }

    private ExtensionsUtils() {
    }

    @NonNull
    public static Map<String, CameraCharacteristics> getCameraCharacteristicsMap(@NonNull CameraInfoInternal cameraInfoInternal) {
        Set<String> physicalCameraIds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String cameraId = cameraInfoInternal.getCameraId();
        CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) cameraInfoInternal.getCameraCharacteristics();
        linkedHashMap.put(cameraId, cameraCharacteristics);
        if (Build.VERSION.SDK_INT < 28 || (physicalCameraIds = Api28Impl.getPhysicalCameraIds(cameraCharacteristics)) == null) {
            return linkedHashMap;
        }
        for (String next : physicalCameraIds) {
            if (!Objects.equals(next, cameraId)) {
                linkedHashMap.put(next, (CameraCharacteristics) cameraInfoInternal.getPhysicalCameraCharacteristics(next));
            }
        }
        return linkedHashMap;
    }
}
