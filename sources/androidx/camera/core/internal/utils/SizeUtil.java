package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class SizeUtil {
    public static final Size RESOLUTION_1080P = new Size(1920, 1080);
    public static final Size RESOLUTION_1440P = new Size(1920, 1440);
    public static final Size RESOLUTION_480P = new Size(720, FaceEnvironment.VALUE_CROP_WIDTH);
    public static final Size RESOLUTION_720P = new Size(1280, 720);
    public static final Size RESOLUTION_QVGA = new Size(320, 240);
    public static final Size RESOLUTION_VGA = new Size(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
    public static final Size RESOLUTION_ZERO = new Size(0, 0);

    private SizeUtil() {
    }

    @Nullable
    public static <T> T findNearestHigherFor(@NonNull Size size, @NonNull TreeMap<Size, T> treeMap) {
        Map.Entry<Size, T> ceilingEntry = treeMap.ceilingEntry(size);
        if (ceilingEntry != null) {
            return ceilingEntry.getValue();
        }
        Map.Entry<Size, T> floorEntry = treeMap.floorEntry(size);
        if (floorEntry != null) {
            return floorEntry.getValue();
        }
        return null;
    }

    public static int getArea(int i, int i2) {
        return i * i2;
    }

    @Nullable
    public static Size getMaxSize(@NonNull List<Size> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (Size) Collections.max(list, new CompareSizesByArea());
    }

    public static boolean isLongerInAnyEdge(@NonNull Size size, @NonNull Size size2) {
        if (size.getWidth() > size2.getWidth() || size.getHeight() > size2.getHeight()) {
            return true;
        }
        return false;
    }

    public static boolean isSmallerByArea(@NonNull Size size, @NonNull Size size2) {
        if (getArea(size) < getArea(size2)) {
            return true;
        }
        return false;
    }

    public static int getArea(@NonNull Size size) {
        return getArea(size.getWidth(), size.getHeight());
    }
}
