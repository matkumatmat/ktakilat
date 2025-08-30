package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    @NonNull
    public static CameraUnavailableException createFrom(@NonNull CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i = 1;
        if (reason != 1) {
            i = 2;
            if (reason != 2) {
                i = 3;
                if (reason != 3) {
                    i = 4;
                    if (reason != 4) {
                        i = 5;
                        if (reason != 5) {
                            if (reason != 10001) {
                                i = 0;
                            } else {
                                i = 6;
                            }
                        }
                    }
                }
            }
        }
        return new CameraUnavailableException(i, (Throwable) cameraAccessExceptionCompat);
    }
}
