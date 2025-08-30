package defpackage;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

/* renamed from: c2  reason: default package */
public abstract /* synthetic */ class c2 {
    public static CaptureResult a(CameraCaptureResult cameraCaptureResult) {
        return null;
    }

    public static void b(CameraCaptureResult cameraCaptureResult, ExifData.Builder builder) {
        builder.setFlashState(cameraCaptureResult.getFlashState());
    }
}
