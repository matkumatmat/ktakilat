package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;

public interface SurfaceProcessingQuirk extends Quirk {
    boolean workaroundBySurfaceProcessing();
}
