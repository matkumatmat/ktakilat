package defpackage;

import androidx.camera.core.Camera;
import androidx.camera.core.UseCase;

/* renamed from: r1  reason: default package */
public abstract /* synthetic */ class r1 {
    public static boolean a(Camera camera, boolean z, UseCase... useCaseArr) {
        return true;
    }

    public static boolean b(Camera camera, UseCase... useCaseArr) {
        return camera.isUseCasesCombinationSupported(true, useCaseArr);
    }

    public static boolean c(Camera camera, UseCase... useCaseArr) {
        return camera.isUseCasesCombinationSupported(false, useCaseArr);
    }
}
