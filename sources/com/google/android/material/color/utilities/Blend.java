package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i, int i2, double d) {
        Cam16 fromInt = Cam16.fromInt(i);
        Cam16 fromInt2 = Cam16.fromInt(i2);
        double jstar = fromInt.getJstar();
        double astar = fromInt.getAstar();
        double bstar = fromInt.getBstar();
        return Cam16.fromUcs(((fromInt2.getJstar() - jstar) * d) + jstar, ((fromInt2.getAstar() - astar) * d) + astar, ((fromInt2.getBstar() - bstar) * d) + bstar).toInt();
    }

    public static int harmonize(int i, int i2) {
        Hct fromInt = Hct.fromInt(i);
        Hct fromInt2 = Hct.fromInt(i2);
        double min = Math.min(MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()) * 0.5d, 15.0d);
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(fromInt.getHue(), fromInt2.getHue()) * min) + fromInt.getHue()), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    public static int hctHue(int i, int i2, double d) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i, i2, d)).getHue(), Cam16.fromInt(i).getChroma(), ColorUtils.lstarFromArgb(i)).toInt();
    }
}
