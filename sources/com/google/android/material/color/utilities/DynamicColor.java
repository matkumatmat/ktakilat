package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final Function<DynamicScheme, Double> chroma;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final Function<DynamicScheme, Double> hue;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaConstraint> toneDeltaConstraint;
    public final Function<DynamicScheme, Double> toneMaxContrast;
    public final Function<DynamicScheme, Double> toneMinContrast;

    /* renamed from: com.google.android.material.color.utilities.DynamicColor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$TonePolarity;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.android.material.color.utilities.TonePolarity[] r0 = com.google.android.material.color.utilities.TonePolarity.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity = r0
                com.google.android.material.color.utilities.TonePolarity r1 = com.google.android.material.color.utilities.TonePolarity.DARKER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$android$material$color$utilities$TonePolarity     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.material.color.utilities.TonePolarity r1 = com.google.android.material.color.utilities.TonePolarity.LIGHTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$android$material$color$utilities$TonePolarity     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.material.color.utilities.TonePolarity r1 = com.google.android.material.color.utilities.TonePolarity.NO_PREFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.AnonymousClass1.<clinit>():void");
        }
    }

    public DynamicColor(Function<DynamicScheme, Double> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, Double> function3, Function<DynamicScheme, Double> function4, Function<DynamicScheme, DynamicColor> function5, Function<DynamicScheme, Double> function6, Function<DynamicScheme, Double> function7, Function<DynamicScheme, ToneDeltaConstraint> function8) {
        this.hue = function;
        this.chroma = function2;
        this.tone = function3;
        this.opacity = function4;
        this.background = function5;
        this.toneMinContrast = function6;
        this.toneMaxContrast = function7;
        this.toneDeltaConstraint = function8;
    }

    public static double calculateDynamicTone(DynamicScheme dynamicScheme, Function<DynamicScheme, Double> function, Function<DynamicColor, Double> function2, BiFunction<Double, Double, Double> biFunction, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, ToneDeltaConstraint> function4, Function<Double, Double> function5, Function<Double, Double> function6) {
        DynamicColor dynamicColor;
        double d;
        double d2;
        DynamicScheme dynamicScheme2 = dynamicScheme;
        Function<DynamicScheme, DynamicColor> function7 = function3;
        Function<Double, Double> function8 = function5;
        Function<Double, Double> function9 = function6;
        double doubleValue = ((Double) function.apply(dynamicScheme2)).doubleValue();
        if (function7 == null) {
            dynamicColor = null;
        } else {
            dynamicColor = (DynamicColor) function7.apply(dynamicScheme2);
        }
        if (dynamicColor == null) {
            return doubleValue;
        }
        double ratioOfTones = Contrast.ratioOfTones(doubleValue, ((Double) dynamicColor.tone.apply(dynamicScheme2)).doubleValue());
        Double d3 = (Double) function2.apply(dynamicColor);
        double doubleValue2 = d3.doubleValue();
        double doubleValue3 = ((Double) biFunction.apply(Double.valueOf(ratioOfTones), d3)).doubleValue();
        double ratioOfTones2 = Contrast.ratioOfTones(doubleValue2, doubleValue3);
        double d4 = 1.0d;
        if (!(function8 == null || function8.apply(Double.valueOf(ratioOfTones)) == null)) {
            d4 = ((Double) function8.apply(Double.valueOf(ratioOfTones))).doubleValue();
        }
        if (function9 == null || function9.apply(Double.valueOf(ratioOfTones)) == null) {
            d = 21.0d;
        } else {
            d = ((Double) function9.apply(Double.valueOf(ratioOfTones))).doubleValue();
        }
        double clampDouble = MathUtils.clampDouble(d4, d, ratioOfTones2);
        if (clampDouble != ratioOfTones2) {
            doubleValue3 = contrastingTone(doubleValue2, clampDouble);
        }
        Function<DynamicScheme, DynamicColor> function10 = dynamicColor.background;
        if (function10 == null || function10.apply(dynamicScheme2) == null) {
            d2 = enableLightForeground(doubleValue3);
        } else {
            d2 = doubleValue3;
        }
        return ensureToneDelta(d2, doubleValue, dynamicScheme, function4, function2);
    }

    public static double contrastingTone(double d, double d2) {
        boolean z;
        double lighterUnsafe = Contrast.lighterUnsafe(d, d2);
        double darkerUnsafe = Contrast.darkerUnsafe(d, d2);
        double ratioOfTones = Contrast.ratioOfTones(lighterUnsafe, d);
        double ratioOfTones2 = Contrast.ratioOfTones(darkerUnsafe, d);
        if (tonePrefersLightForeground(d)) {
            if (Math.abs(ratioOfTones - ratioOfTones2) >= 0.1d || ratioOfTones >= d2 || ratioOfTones2 >= d2) {
                z = false;
            } else {
                z = true;
            }
            if (ratioOfTones >= d2 || ratioOfTones >= ratioOfTones2 || z) {
                return lighterUnsafe;
            }
            return darkerUnsafe;
        } else if (ratioOfTones2 >= d2 || ratioOfTones2 >= ratioOfTones) {
            return darkerUnsafe;
        } else {
            return lighterUnsafe;
        }
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    public static double ensureToneDelta(double d, double d2, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function, Function<DynamicColor, Double> function2) {
        ToneDeltaConstraint toneDeltaConstraint2;
        if (function == null) {
            toneDeltaConstraint2 = null;
        } else {
            toneDeltaConstraint2 = (ToneDeltaConstraint) function.apply(dynamicScheme);
        }
        if (toneDeltaConstraint2 == null) {
            return d;
        }
        double d3 = toneDeltaConstraint2.delta;
        double doubleValue = ((Double) function2.apply(toneDeltaConstraint2.keepAway)).doubleValue();
        double abs = Math.abs(d - doubleValue);
        if (abs >= d3) {
            return d;
        }
        int i = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$TonePolarity[toneDeltaConstraint2.keepAwayPolarity.ordinal()];
        boolean z = true;
        if (i == 1) {
            return MathUtils.clampDouble(0.0d, 100.0d, doubleValue + d3);
        }
        if (i == 2) {
            return MathUtils.clampDouble(0.0d, 100.0d, doubleValue - d3);
        }
        if (i != 3) {
            return d;
        }
        if (d2 <= ((Double) toneDeltaConstraint2.keepAway.tone.apply(dynamicScheme)).doubleValue()) {
            z = false;
        }
        double abs2 = Math.abs(abs - d3);
        if (!z ? d >= abs2 : d + abs2 > 100.0d) {
            return d - abs2;
        }
        return d + abs2;
    }

    public static DynamicColor fromArgb(int i) {
        return fromPalette(new z5(TonalPalette.fromInt(i), 0), new z5(Hct.fromInt(i), 1));
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return fromPalette(function, function2, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, ToneDeltaConstraint>) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$getTone$11(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return dynamicColor;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$17(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return (Double) dynamicColor.toneMaxContrast.apply(dynamicScheme);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$18(Function function, DynamicScheme dynamicScheme, Double d, Double d2) {
        if (function == null || function.apply(dynamicScheme) == null || ((DynamicColor) function.apply(dynamicScheme)).background == null || ((DynamicColor) function.apply(dynamicScheme)).background.apply(dynamicScheme) == null) {
            return Double.valueOf(contrastingTone(d2.doubleValue(), Math.max(7.0d, d.doubleValue())));
        }
        return Double.valueOf(contrastingTone(d2.doubleValue(), 7.0d));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$14(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return (Double) dynamicColor.toneMinContrast.apply(dynamicScheme);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$15(Function function, DynamicScheme dynamicScheme, Function function2, Double d, Double d2) {
        double doubleValue = ((Double) function.apply(dynamicScheme)).doubleValue();
        if (d.doubleValue() >= 7.0d) {
            doubleValue = contrastingTone(d2.doubleValue(), 4.5d);
        } else if (d.doubleValue() >= 3.0d) {
            doubleValue = contrastingTone(d2.doubleValue(), 3.0d);
        } else if (!(function2 == null || function2.apply(dynamicScheme) == null || ((DynamicColor) function2.apply(dynamicScheme)).background == null || ((DynamicColor) function2.apply(dynamicScheme)).background.apply(dynamicScheme) == null)) {
            doubleValue = contrastingTone(d2.doubleValue(), d.doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$16(Double d) {
        return d;
    }

    public static boolean toneAllowsLightForeground(double d) {
        if (Math.round(d) <= 49) {
            return true;
        }
        return false;
    }

    public static double toneMaxContrastDefault(Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new a6(0, dynamicScheme), new b6(function2, dynamicScheme), function2, function3, (Function<Double, Double>) null, (Function<Double, Double>) null);
    }

    public static double toneMinContrastDefault(Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new a6(1, dynamicScheme), new c6(function, dynamicScheme, function2), function2, function3, (Function<Double, Double>) null, new d6(0));
    }

    public static boolean tonePrefersLightForeground(double d) {
        if (Math.round(d) < 60) {
            return true;
        }
        return false;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(((Double) function.apply(dynamicScheme)).doubleValue() * 255.0d)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct from = Hct.from(((Double) this.hue.apply(dynamicScheme)).doubleValue(), ((Double) this.chroma.apply(dynamicScheme)).doubleValue(), getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, from);
        return from;
    }

    public double getTone(DynamicScheme dynamicScheme) {
        boolean z;
        DynamicColor dynamicColor;
        double d;
        Function<DynamicScheme, Double> function;
        DynamicScheme dynamicScheme2 = dynamicScheme;
        double doubleValue = ((Double) this.tone.apply(dynamicScheme2)).doubleValue();
        double d2 = dynamicScheme2.contrastLevel;
        boolean z2 = false;
        if (d2 < 0.0d) {
            z = true;
        } else {
            z = false;
        }
        if (d2 != 0.0d) {
            double doubleValue2 = ((Double) this.tone.apply(dynamicScheme2)).doubleValue();
            if (z) {
                function = this.toneMinContrast;
            } else {
                function = this.toneMaxContrast;
            }
            doubleValue = doubleValue2 + (Math.abs(dynamicScheme2.contrastLevel) * (((Double) function.apply(dynamicScheme2)).doubleValue() - doubleValue2));
        }
        Function<DynamicScheme, DynamicColor> function2 = this.background;
        if (function2 == null) {
            dynamicColor = null;
        } else {
            dynamicColor = (DynamicColor) function2.apply(dynamicScheme2);
        }
        double d3 = 1.0d;
        if (dynamicColor != null) {
            Function<DynamicScheme, DynamicColor> function3 = dynamicColor.background;
            if (!(function3 == null || function3.apply(dynamicScheme2) == null)) {
                z2 = true;
            }
            double ratioOfTones = Contrast.ratioOfTones(((Double) this.tone.apply(dynamicScheme2)).doubleValue(), ((Double) dynamicColor.tone.apply(dynamicScheme2)).doubleValue());
            if (z) {
                double ratioOfTones2 = Contrast.ratioOfTones(((Double) this.toneMinContrast.apply(dynamicScheme2)).doubleValue(), ((Double) dynamicColor.toneMinContrast.apply(dynamicScheme2)).doubleValue());
                if (z2) {
                    d3 = ratioOfTones2;
                }
                d = ratioOfTones;
            } else {
                double ratioOfTones3 = Contrast.ratioOfTones(((Double) this.toneMaxContrast.apply(dynamicScheme2)).doubleValue(), ((Double) dynamicColor.toneMaxContrast.apply(dynamicScheme2)).doubleValue());
                if (z2) {
                    d3 = Math.min(ratioOfTones3, ratioOfTones);
                }
                if (z2) {
                    d = Math.max(ratioOfTones3, ratioOfTones);
                }
            }
            return calculateDynamicTone(dynamicScheme, this.tone, new a6(2, dynamicScheme2), new e6(doubleValue), new z5(dynamicColor, 2), this.toneDeltaConstraint, new v5(d3, 1), new v5(d, 0));
        }
        d = 21.0d;
        return calculateDynamicTone(dynamicScheme, this.tone, new a6(2, dynamicScheme2), new e6(doubleValue), new z5(dynamicColor, 2), this.toneDeltaConstraint, new v5(d3, 1), new v5(d, 0));
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, DynamicColor> function3) {
        return fromPalette(function, function2, function3, (Function<DynamicScheme, ToneDeltaConstraint>) null);
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, ToneDeltaConstraint> function4) {
        return new DynamicColor(new x5(0, function), new x5(1, function), function2, (Function<DynamicScheme, Double>) null, function3, new y5(0, function2, function3, function4), new y5(1, function2, function3, function4), function4);
    }

    public static DynamicColor fromArgb(int i, Function<DynamicScheme, Double> function) {
        return fromPalette(new w5(i, 2), function);
    }

    public static DynamicColor fromArgb(int i, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2) {
        return fromPalette(new w5(i, 1), function, function2);
    }

    public static DynamicColor fromArgb(int i, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return fromPalette(new w5(i, 0), function, function2, function3);
    }
}
