package defpackage;

import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.core.impl.Quirks;

/* renamed from: u2  reason: default package */
public abstract /* synthetic */ class u2 {
    public static boolean a(CaptureIntentPreviewQuirk captureIntentPreviewQuirk) {
        return true;
    }

    public static boolean b(Quirks quirks) {
        for (CaptureIntentPreviewQuirk workaroundByCaptureIntentPreview : quirks.getAll(CaptureIntentPreviewQuirk.class)) {
            if (workaroundByCaptureIntentPreview.workaroundByCaptureIntentPreview()) {
                return true;
            }
        }
        return false;
    }
}
