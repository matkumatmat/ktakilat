package androidx.camera.extensions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;

class CameraExtensionsControls {
    private CameraExtensionsControls() {
    }

    @Nullable
    public static CameraExtensionsControl from(@NonNull CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof RestrictedCameraControl, "The input camera control must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((RestrictedCameraControl) cameraControl).getSessionProcessor();
        if (sessionProcessor instanceof CameraExtensionsControl) {
            return (CameraExtensionsControl) sessionProcessor;
        }
        return null;
    }
}
