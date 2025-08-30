package androidx.camera.core.impl.capability;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.impl.CameraInfoInternal;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PreviewCapabilitiesImpl implements PreviewCapabilities {
    private boolean mIsStabilizationSupported;

    public PreviewCapabilitiesImpl(@NonNull CameraInfoInternal cameraInfoInternal) {
        this.mIsStabilizationSupported = cameraInfoInternal.isPreviewStabilizationSupported();
    }

    @NonNull
    public static PreviewCapabilities from(@NonNull CameraInfo cameraInfo) {
        return new PreviewCapabilitiesImpl((CameraInfoInternal) cameraInfo);
    }

    public boolean isStabilizationSupported() {
        return this.mIsStabilizationSupported;
    }
}
