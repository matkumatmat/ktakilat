package defpackage;

import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;

/* renamed from: qf  reason: default package */
public abstract /* synthetic */ class qf {
    public static boolean a(SurfaceProcessingQuirk surfaceProcessingQuirk) {
        return true;
    }

    public static boolean b(Quirks quirks) {
        for (SurfaceProcessingQuirk workaroundBySurfaceProcessing : quirks.getAll(SurfaceProcessingQuirk.class)) {
            if (workaroundBySurfaceProcessing.workaroundBySurfaceProcessing()) {
                return true;
            }
        }
        return false;
    }
}
