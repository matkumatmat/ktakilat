package defpackage;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInternal;

/* renamed from: o2  reason: default package */
public abstract /* synthetic */ class o2 {
    public static CameraControl a(CameraInternal cameraInternal) {
        return cameraInternal.getCameraControlInternal();
    }

    public static CameraInfo b(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal();
    }

    public static CameraConfig c(CameraInternal cameraInternal) {
        return CameraConfigs.defaultConfig();
    }

    public static boolean d(CameraInternal cameraInternal) {
        return true;
    }

    public static boolean e(CameraInternal cameraInternal) {
        if (cameraInternal.getCameraInfo().getLensFacing() == 0) {
            return true;
        }
        return false;
    }

    public static void f(CameraInternal cameraInternal, boolean z) {
    }

    public static void g(CameraInternal cameraInternal, CameraConfig cameraConfig) {
    }

    public static void h(CameraInternal cameraInternal, boolean z) {
    }
}
