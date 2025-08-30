package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import com.facebook.appevents.AppEventsConstants;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcludedSupportedSizesQuirk implements Quirk {
    private static final String TAG = "ExcludedSupportedSizesQuirk";
    private static final int UNKNOWN_IMAGE_FORMAT = -1;

    @NonNull
    private List<Size> getHuaweiP20LiteExcludedSizes(@NonNull String str, int i, @Nullable Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && (i == 34 || i == 35 || cls != null)) {
            arrayList.add(new Size(720, 720));
            arrayList.add(new Size(LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getOnePlus6ExcludedSizes(@NonNull String str, int i) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && i == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, 3000));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getOnePlus6TExcludedSizes(@NonNull String str, int i) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && i == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(4000, 3000));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getRedmiNote9ProExcludedSizes(@NonNull String str, int i) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && i == 256) {
            arrayList.add(new Size(9280, 6944));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getSamsungJ7Api27AboveExcludedSizes(@NonNull String str, int i, @Nullable Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            if (i == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i == 35) {
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && (i == 34 || i == 35 || cls != null)) {
            arrayList.add(new Size(2576, 1932));
            arrayList.add(new Size(2560, 1440));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    @NonNull
    private List<Size> getSamsungJ7PrimeApi27AboveExcludedSizes(@NonNull String str, int i, @Nullable Class<?> cls) {
        String str2 = str;
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        if (str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            if (i2 == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i2 == 35) {
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && (i2 == 34 || i2 == 35 || cls != null)) {
            arrayList.add(new Size(3264, 2448));
            arrayList.add(new Size(3264, 1836));
            arrayList.add(new Size(2448, 2448));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    private static boolean isHuaweiP20Lite() {
        if (!"HUAWEI".equalsIgnoreCase(Build.BRAND) || !"HWANE".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean isOnePlus6() {
        if (!"OnePlus".equalsIgnoreCase(Build.BRAND) || !"OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean isOnePlus6T() {
        if (!"OnePlus".equalsIgnoreCase(Build.BRAND) || !"OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean isRedmiNote9Pro() {
        if (!"REDMI".equalsIgnoreCase(Build.BRAND) || !"joyeuse".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ7Api27Above() {
        if (!"SAMSUNG".equalsIgnoreCase(Build.BRAND) || !"J7XELTE".equalsIgnoreCase(Build.DEVICE) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        if (!"SAMSUNG".equalsIgnoreCase(Build.BRAND) || !"ON7XELTE".equalsIgnoreCase(Build.DEVICE) || Build.VERSION.SDK_INT < 27) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        if (isOnePlus6() || isOnePlus6T() || isHuaweiP20Lite() || isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above() || isRedmiNote9Pro()) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<Size> getExcludedSizes(@NonNull String str, int i) {
        if (isOnePlus6()) {
            return getOnePlus6ExcludedSizes(str, i);
        }
        if (isOnePlus6T()) {
            return getOnePlus6TExcludedSizes(str, i);
        }
        if (isHuaweiP20Lite()) {
            return getHuaweiP20LiteExcludedSizes(str, i, (Class<?>) null);
        }
        if (isSamsungJ7PrimeApi27Above()) {
            return getSamsungJ7PrimeApi27AboveExcludedSizes(str, i, (Class<?>) null);
        }
        if (isSamsungJ7Api27Above()) {
            return getSamsungJ7Api27AboveExcludedSizes(str, i, (Class<?>) null);
        }
        if (isRedmiNote9Pro()) {
            return getRedmiNote9ProExcludedSizes(str, i);
        }
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }

    @NonNull
    public List<Size> getExcludedSizes(@NonNull String str, @NonNull Class<?> cls) {
        if (isHuaweiP20Lite()) {
            return getHuaweiP20LiteExcludedSizes(str, -1, cls);
        }
        if (isSamsungJ7PrimeApi27Above()) {
            return getSamsungJ7PrimeApi27AboveExcludedSizes(str, -1, cls);
        }
        if (isSamsungJ7Api27Above()) {
            return getSamsungJ7Api27AboveExcludedSizes(str, -1, cls);
        }
        Logger.w(TAG, "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }
}
