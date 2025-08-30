package defpackage;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.core.util.Preconditions;

/* renamed from: ma  reason: default package */
public abstract /* synthetic */ class ma {
    public static DynamicRange a(ImageInputConfig imageInputConfig) {
        return (DynamicRange) Preconditions.checkNotNull((DynamicRange) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED));
    }

    public static int b(ImageInputConfig imageInputConfig) {
        return ((Integer) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    public static boolean c(ImageInputConfig imageInputConfig) {
        return imageInputConfig.containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
    }
}
