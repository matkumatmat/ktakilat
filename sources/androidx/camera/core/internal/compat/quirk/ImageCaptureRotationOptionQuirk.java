package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;
import com.facebook.share.internal.MessengerShareContentUtility;

public final class ImageCaptureRotationOptionQuirk implements Quirk {
    private static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Cuttlefish") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || Build.PRODUCT.equals("google_sdk") || Build.HARDWARE.contains("ranchu"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean isEmulatorAndApi21() {
        if (!isEmulator() || Build.VERSION.SDK_INT != 21) {
            return false;
        }
        return true;
    }

    private static boolean isHonor9X() {
        if (!"HONOR".equalsIgnoreCase(Build.BRAND) || !"STK-LX1".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    private static boolean isHuaweiMate20Lite() {
        if (!"HUAWEI".equalsIgnoreCase(Build.BRAND) || !"SNE-LX1".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isHuaweiMate20Lite() || isHonor9X() || isEmulatorAndApi21()) {
            return true;
        }
        return false;
    }

    public boolean isSupported(@NonNull Config.Option<?> option) {
        if (option != CaptureConfig.OPTION_ROTATION) {
            return true;
        }
        return false;
    }
}
