package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Supplier;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ViewConfigurationCompat {
    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        @DoNotInline
        public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static int getScaledMaximumFlingVelocity(@NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i, i2, i3);
        }

        @DoNotInline
        public static int getScaledMinimumFlingVelocity(@NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i, i2, i3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", (Class[]) null);
            } catch (Exception unused) {
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static int getCompatFlingVelocityThreshold(Resources resources, int i, Supplier<Integer> supplier, int i2) {
        int dimensionPixelSize;
        if (i == -1) {
            return supplier.get().intValue();
        }
        if (i == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i)) < 0) {
            return i2;
        }
        return dimensionPixelSize;
    }

    private static float getLegacyScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = sGetScaledScrollFactorMethod) != null) {
            try {
                return (float) ((Integer) method.invoke(viewConfiguration, (Object[]) null)).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private static int getPlatformResId(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, FaceEnvironment.OS);
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return getPlatformResId(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources resources, int i, int i2) {
        if (i == 4194304 && i2 == 26) {
            return getPlatformResId(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(@NonNull ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getScaledHoverSlop(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, i, i2, i3);
        }
        if (!isInputDeviceInfoValid(i, i2, i3)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int preApi34MaximumFlingVelocityResId = getPreApi34MaximumFlingVelocityResId(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return getCompatFlingVelocityThreshold(resources, preApi34MaximumFlingVelocityResId, new fh(viewConfiguration, 0), Integer.MIN_VALUE);
    }

    public static int getScaledMinimumFlingVelocity(@NonNull Context context, @NonNull ViewConfiguration viewConfiguration, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, i, i2, i3);
        }
        if (!isInputDeviceInfoValid(i, i2, i3)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int preApi34MinimumFlingVelocityResId = getPreApi34MinimumFlingVelocityResId(resources, i3, i2);
        Objects.requireNonNull(viewConfiguration);
        return getCompatFlingVelocityThreshold(resources, preApi34MinimumFlingVelocityResId, new fh(viewConfiguration, 1), Integer.MAX_VALUE);
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int i, int i2, int i3) {
        InputDevice device = InputDevice.getDevice(i);
        if (device == null || device.getMotionRange(i2, i3) == null) {
            return false;
        }
        return true;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(viewConfiguration);
        }
        Resources resources = context.getResources();
        int platformResId = getPlatformResId(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if (platformResId == 0 || !resources.getBoolean(platformResId)) {
            return false;
        }
        return true;
    }
}
