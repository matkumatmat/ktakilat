package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

public class MaxPreviewSize {
    @Nullable
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    @NonNull
    public Size getMaxPreviewResolution(@NonNull Size size) {
        Size verifiedResolution;
        ExtraCroppingQuirk extraCroppingQuirk = this.mExtraCroppingQuirk;
        if (extraCroppingQuirk == null || (verifiedResolution = extraCroppingQuirk.getVerifiedResolution(SurfaceConfig.ConfigType.PRIV)) == null) {
            return size;
        }
        if (verifiedResolution.getHeight() * verifiedResolution.getWidth() > size.getHeight() * size.getWidth()) {
            return verifiedResolution;
        }
        return size;
    }

    @VisibleForTesting
    public MaxPreviewSize(@Nullable ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }
}
