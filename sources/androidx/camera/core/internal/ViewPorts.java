package androidx.camera.core.internal;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class ViewPorts {
    private ViewPorts() {
    }

    @NonNull
    public static Map<UseCase, Rect> calculateViewPortRects(@NonNull Rect rect, boolean z, @NonNull Rational rational, @IntRange(from = 0, to = 359) int i, int i2, int i3, @NonNull Map<UseCase, StreamSpec> map) {
        boolean z2;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap hashMap = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry next : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, (float) ((StreamSpec) next.getValue()).getResolution().getWidth(), (float) ((StreamSpec) next.getValue()).getResolution().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            hashMap.put((UseCase) next.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF scaledRect = getScaledRect(rectF2, ImageUtil.getRotatedAspectRatio(i, rational), i2, z, i3, i);
        HashMap hashMap2 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry : hashMap.entrySet()) {
            ((Matrix) entry.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, scaledRect);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            hashMap2.put((UseCase) entry.getKey(), rect2);
        }
        return hashMap2;
    }

    private static RectF correctStartOrEnd(boolean z, @IntRange(from = 0, to = 359) int i, RectF rectF, RectF rectF2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = false;
        if (i != 0 || z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (i != 90 || !z) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z2 || z3) {
            return rectF2;
        }
        if (i != 0 || !z) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i != 270 || z) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z4 || z5) {
            return flipHorizontally(rectF2, rectF.centerX());
        }
        if (i != 90 || z) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (i != 180 || !z) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z6 || z7) {
            return flipVertically(rectF2, rectF.centerY());
        }
        if (i != 180 || z) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (i == 270 && z) {
            z9 = true;
        }
        if (z8 || z9) {
            return flipHorizontally(flipVertically(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z + " rotation " + i);
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        return new RectF(flipX(rectF.right, f), rectF.top, flipX(rectF.left, f), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f) {
        return new RectF(rectF.left, flipY(rectF.bottom, f), rectF.right, flipY(rectF.top, f));
    }

    private static float flipX(float f, float f2) {
        return (f2 + f2) - f;
    }

    private static float flipY(float f, float f2) {
        return (f2 + f2) - f;
    }

    @SuppressLint({"SwitchIntDef"})
    @NonNull
    public static RectF getScaledRect(@NonNull RectF rectF, @NonNull Rational rational, int i, boolean z, int i2, @IntRange(from = 0, to = 359) int i3) {
        if (i == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) rational.getNumerator(), (float) rational.getDenominator());
        if (i == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else if (i == 2) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        } else {
            throw new IllegalStateException(ba.k(i, "Unexpected scale type: "));
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return correctStartOrEnd(shouldMirrorStartAndEnd(z, i2), i3, rectF, rectF3);
    }

    private static boolean shouldMirrorStartAndEnd(boolean z, int i) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        return z ^ z2;
    }
}
