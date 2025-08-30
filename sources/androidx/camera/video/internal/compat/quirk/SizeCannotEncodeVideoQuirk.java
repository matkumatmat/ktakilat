package androidx.camera.video.internal.compat.quirk;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SizeCannotEncodeVideoQuirk implements Quirk {
    @NonNull
    private static Set<Size> getProblematicSizes() {
        if (isMotoC()) {
            return new HashSet(Collections.singletonList(new Size(720, 1280)));
        }
        return Collections.emptySet();
    }

    private static boolean isMotoC() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto c".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }

    @NonNull
    public Rect adjustCropRectForProblematicEncodeSize(@NonNull Rect rect, int i, @Nullable VideoEncoderInfo videoEncoderInfo) {
        int i2;
        Size rotateSize = TransformUtils.rotateSize(TransformUtils.rectToSize(rect), i);
        if (!isProblematicEncodeSize(rotateSize)) {
            return rect;
        }
        if (videoEncoderInfo != null) {
            i2 = videoEncoderInfo.getHeightAlignment() / 2;
        } else {
            i2 = 8;
        }
        Rect rect2 = new Rect(rect);
        if (rect.width() == rotateSize.getHeight()) {
            rect2.left += i2;
            rect2.right -= i2;
        } else {
            rect2.top += i2;
            rect2.bottom -= i2;
        }
        return rect2;
    }

    public boolean isProblematicEncodeSize(@NonNull Size size) {
        return getProblematicSizes().contains(size);
    }
}
