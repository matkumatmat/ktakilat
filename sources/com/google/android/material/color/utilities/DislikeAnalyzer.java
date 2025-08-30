package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct hct) {
        if (isDisliked(hct)) {
            return Hct.from(hct.getHue(), hct.getChroma(), 70.0d);
        }
        return hct;
    }

    public static boolean isDisliked(Hct hct) {
        boolean z;
        boolean z2;
        boolean z3;
        if (((double) Math.round(hct.getHue())) < 90.0d || ((double) Math.round(hct.getHue())) > 111.0d) {
            z = false;
        } else {
            z = true;
        }
        if (((double) Math.round(hct.getChroma())) > 16.0d) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((double) Math.round(hct.getTone())) < 65.0d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }
}
