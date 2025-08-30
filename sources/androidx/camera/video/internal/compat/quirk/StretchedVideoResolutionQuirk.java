package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Quirk;
import com.baidu.idl.face.platform.FaceEnvironment;

public class StretchedVideoResolutionQuirk implements Quirk {
    private static boolean isMotoE5Play() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto e5 play".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    @Nullable
    public Size getAlternativeResolution(int i) {
        if (i == 4) {
            return new Size(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
        }
        if (i == 5) {
            return new Size(960, 720);
        }
        if (i != 6) {
            return null;
        }
        return new Size(1440, 1080);
    }
}
