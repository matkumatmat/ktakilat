package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import com.baidu.idl.face.platform.utils.BitmapUtils;

public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        throw new IllegalStateException(ba.k(i, "Invalid sensor rotation: "));
    }

    public static int getRelativeImageRotation(int i, int i2, boolean z) {
        int i3;
        if (z) {
            i3 = ((i2 - i) + BitmapUtils.ROTATE360) % BitmapUtils.ROTATE360;
        } else {
            i3 = (i2 + i) % BitmapUtils.ROTATE360;
        }
        if (Logger.isVerboseEnabled(TAG)) {
            StringBuilder r = e.r(i, "getRelativeImageRotation: destRotationDegrees=", i2, ", sourceRotationDegrees=", ", isOppositeFacing=");
            r.append(z);
            r.append(", result=");
            r.append(i3);
            Logger.d(TAG, r.toString());
        }
        return i3;
    }

    public static int surfaceRotationToDegrees(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return BitmapUtils.ROTATE180;
        }
        if (i == 3) {
            return BitmapUtils.ROTATE270;
        }
        throw new IllegalArgumentException(ba.k(i, "Unsupported surface rotation: "));
    }
}
