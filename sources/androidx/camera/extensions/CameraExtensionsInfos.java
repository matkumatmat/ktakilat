package androidx.camera.extensions;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;

class CameraExtensionsInfos {
    private static final CameraExtensionsInfo NORMAL_MODE_CAMERA_EXTENSIONS_INFO = new CameraExtensionsInfo() {
        public final /* synthetic */ LiveData getCurrentExtensionMode() {
            return j2.a(this);
        }

        public final /* synthetic */ LiveData getExtensionStrength() {
            return j2.b(this);
        }

        public final /* synthetic */ boolean isCurrentExtensionModeAvailable() {
            return j2.c(this);
        }

        public final /* synthetic */ boolean isExtensionStrengthAvailable() {
            return j2.d(this);
        }
    };

    private CameraExtensionsInfos() {
    }

    @NonNull
    public static CameraExtensionsInfo from(@NonNull CameraInfo cameraInfo) {
        Preconditions.checkArgument(cameraInfo instanceof RestrictedCameraInfo, "The input camera info must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((RestrictedCameraInfo) cameraInfo).getSessionProcessor();
        if (sessionProcessor instanceof CameraExtensionsInfo) {
            return (CameraExtensionsInfo) sessionProcessor;
        }
        return NORMAL_MODE_CAMERA_EXTENSIONS_INFO;
    }
}
