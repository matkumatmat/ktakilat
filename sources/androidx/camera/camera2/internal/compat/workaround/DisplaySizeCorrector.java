package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;

public class DisplaySizeCorrector {
    @Nullable
    private final SmallDisplaySizeQuirk mSmallDisplaySizeQuirk = ((SmallDisplaySizeQuirk) DeviceQuirks.get(SmallDisplaySizeQuirk.class));

    @Nullable
    public Size getDisplaySize() {
        SmallDisplaySizeQuirk smallDisplaySizeQuirk = this.mSmallDisplaySizeQuirk;
        if (smallDisplaySizeQuirk != null) {
            return smallDisplaySizeQuirk.getDisplaySize();
        }
        return null;
    }
}
