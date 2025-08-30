package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> BUILD_MODELS = Arrays.asList(new String[]{"itel w6004"});
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        List<String> list = BUILD_MODELS_FRONT_CAMERA;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!list.contains(str.toLowerCase(locale)) || ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            z = false;
        } else {
            z = true;
        }
        boolean contains = BUILD_MODELS.contains(str.toLowerCase(locale));
        if (z || contains) {
            return true;
        }
        return false;
    }
}
