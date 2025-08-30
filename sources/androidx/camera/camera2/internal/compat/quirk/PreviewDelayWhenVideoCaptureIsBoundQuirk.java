package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;

public class PreviewDelayWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, SurfaceProcessingQuirk {
    public static boolean load() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public final /* synthetic */ boolean workaroundByCaptureIntentPreview() {
        return u2.a(this);
    }

    public final /* synthetic */ boolean workaroundBySurfaceProcessing() {
        return qf.a(this);
    }
}
