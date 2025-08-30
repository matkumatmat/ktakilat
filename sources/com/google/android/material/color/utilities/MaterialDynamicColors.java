package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialDynamicColors {
    private static final double CONTAINER_ACCENT_TONE_DELTA = 15.0d;

    public static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        double d4;
        Hct from = Hct.from(d, d2, d3);
        if (from.getChroma() >= d2) {
            return d3;
        }
        Hct hct = from;
        double chroma = from.getChroma();
        double d5 = d3;
        while (hct.getChroma() < d2) {
            if (z) {
                d4 = -1.0d;
            } else {
                d4 = 1.0d;
            }
            double d6 = d5 + d4;
            Hct from2 = Hct.from(d, d2, d6);
            if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d2) < 0.4d) {
                return d6;
            }
            if (Math.abs(from2.getChroma() - d2) < Math.abs(hct.getChroma() - d2)) {
                hct = from2;
            }
            chroma = Math.max(chroma, from2.getChroma());
            d5 = d6;
        }
        return d5;
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        if (variant == Variant.FIDELITY || variant == Variant.CONTENT) {
            return true;
        }
        return false;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        if (dynamicScheme.variant == Variant.MONOCHROME) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$background$11(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlActivated$131(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$136(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$137(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 0.2d;
        } else {
            d = 0.12d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$138(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlHighlight$140(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = 0.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$controlNormal$133(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$error$95(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaConstraint lambda$error$96(DynamicScheme dynamicScheme) {
        TonePolarity tonePolarity;
        DynamicColor errorContainer = errorContainer();
        if (dynamicScheme.isDark) {
            tonePolarity = TonePolarity.DARKER;
        } else {
            tonePolarity = TonePolarity.LIGHTER;
        }
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, errorContainer, tonePolarity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$errorContainer$90(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseOnSurface$36(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 95.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inverseOnSurface$37(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inversePrimary$62(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 40.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$inversePrimary$63(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$inverseSurface$18(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onBackground$13(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onBackground$14(DynamicScheme dynamicScheme) {
        return background();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onError$98(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onError$99(DynamicScheme dynamicScheme) {
        return error();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onErrorContainer$92(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onErrorContainer$93(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimary$65(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimary$66(DynamicScheme dynamicScheme) {
        return primary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onPrimaryContainer$56(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(((Double) primaryContainer().tone.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 0.0d;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryContainer$57(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixed$105(DynamicScheme dynamicScheme) {
        double d = 10.0d;
        if (!isMonochrome(dynamicScheme)) {
            return Double.valueOf(10.0d);
        }
        if (!dynamicScheme.isDark) {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixed$106(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onPrimaryFixedVariant$108(DynamicScheme dynamicScheme) {
        double d = 30.0d;
        if (!isMonochrome(dynamicScheme)) {
            return Double.valueOf(30.0d);
        }
        if (!dynamicScheme.isDark) {
            d = 70.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onPrimaryFixedVariant$109(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondary$76(DynamicScheme dynamicScheme) {
        double d = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 10.0d;
            }
            return Double.valueOf(d);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondary$77(DynamicScheme dynamicScheme) {
        return secondary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onSecondaryContainer$70(DynamicScheme dynamicScheme) {
        double d;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(((Double) secondaryContainer().tone.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryContainer$71(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixed$116(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSecondaryFixedVariant$118(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 25.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSecondaryFixedVariant$119(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurface$34(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onSurfaceVariant$41(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onSurfaceVariant$42(DynamicScheme dynamicScheme) {
        return surfaceVariant();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiary$87(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 10.0d;
            } else {
                d2 = 90.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 20.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiary$88(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double lambda$onTertiaryContainer$81(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 0.0d;
            } else {
                d2 = 100.0d;
            }
            return Double.valueOf(d2);
        } else if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(((Double) tertiaryContainer().tone.apply(dynamicScheme)).doubleValue(), 4.5d));
        } else {
            if (dynamicScheme.isDark) {
                d = 90.0d;
            } else {
                d = 10.0d;
            }
            return Double.valueOf(d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryContainer$82(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixed$125(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 90.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixed$126(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$onTertiaryFixedVariant$128(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 70.0d;
        } else {
            d = 30.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor lambda$onTertiaryFixedVariant$129(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outline$44(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 60.0d;
        } else {
            d = 50.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$outlineVariant$46(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primary$59(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 100.0d;
            } else {
                d2 = 0.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaConstraint lambda$primary$60(DynamicScheme dynamicScheme) {
        TonePolarity tonePolarity;
        DynamicColor primaryContainer = primaryContainer();
        if (dynamicScheme.isDark) {
            tonePolarity = TonePolarity.DARKER;
        } else {
            tonePolarity = TonePolarity.LIGHTER;
        }
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, primaryContainer, tonePolarity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryContainer$54(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 85.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixed$101(DynamicScheme dynamicScheme) {
        double d;
        if (!isMonochrome(dynamicScheme)) {
            return Double.valueOf(90.0d);
        }
        if (dynamicScheme.isDark) {
            d = 100.0d;
        } else {
            d = 10.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$primaryFixedDim$103(DynamicScheme dynamicScheme) {
        double d;
        if (!isMonochrome(dynamicScheme)) {
            return Double.valueOf(80.0d);
        }
        if (dynamicScheme.isDark) {
            d = 90.0d;
        } else {
            d = 20.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondary$73(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaConstraint lambda$secondary$74(DynamicScheme dynamicScheme) {
        TonePolarity tonePolarity;
        DynamicColor secondaryContainer = secondaryContainer();
        if (dynamicScheme.isDark) {
            tonePolarity = TonePolarity.DARKER;
        } else {
            tonePolarity = TonePolarity.LIGHTER;
        }
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, secondaryContainer, tonePolarity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryContainer$68(DynamicScheme dynamicScheme) {
        double d = 30.0d;
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d = 85.0d;
            }
            return Double.valueOf(d);
        }
        if (!dynamicScheme.isDark) {
            d = 90.0d;
        }
        double d2 = d;
        if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d2);
        }
        return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d2, !dynamicScheme.isDark)), dynamicScheme));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixed$111(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 80.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$secondaryFixedDim$113(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 70.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surface$16(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceBright$20(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 24.0d;
        } else {
            d = 98.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainer$28(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 12.0d;
        } else {
            d = 94.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHigh$30(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 17.0d;
        } else {
            d = 92.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerHighest$32(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 22.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLow$26(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 96.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceContainerLowest$24(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 4.0d;
        } else {
            d = 100.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceDim$22(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 6.0d;
        } else {
            d = 87.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceTint$52(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$surfaceVariant$39(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiary$84(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 90.0d;
            } else {
                d2 = 25.0d;
            }
            return Double.valueOf(d2);
        }
        if (dynamicScheme.isDark) {
            d = 80.0d;
        } else {
            d = 40.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaConstraint lambda$tertiary$85(DynamicScheme dynamicScheme) {
        TonePolarity tonePolarity;
        DynamicColor tertiaryContainer = tertiaryContainer();
        if (dynamicScheme.isDark) {
            tonePolarity = TonePolarity.DARKER;
        } else {
            tonePolarity = TonePolarity.LIGHTER;
        }
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, tertiaryContainer, tonePolarity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryContainer$79(DynamicScheme dynamicScheme) {
        double d;
        double d2;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d2 = 60.0d;
            } else {
                d2 = 49.0d;
            }
            return Double.valueOf(d2);
        } else if (!isFidelity(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d = 30.0d;
            } else {
                d = 90.0d;
            }
            return Double.valueOf(d);
        } else {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixed$121(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 40.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$tertiaryFixedDim$123(DynamicScheme dynamicScheme) {
        double d;
        if (isMonochrome(dynamicScheme)) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textHintInverse$151(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverse$143(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textPrimaryInverseDisableOnly$147(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverse$145(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return Double.valueOf(d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double lambda$textSecondaryAndTertiaryInverseDisabled$149(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 10.0d;
        } else {
            d = 90.0d;
        }
        return Double.valueOf(d);
    }

    public static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct inViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (!DynamicColor.tonePrefersLightForeground(hct.getTone()) || DynamicColor.toneAllowsLightForeground(inViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(inViewingConditions.getTone());
        }
        return DynamicColor.enableLightForeground(hct.getTone());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        double d;
        if (dynamicScheme.isDark) {
            d = 30.0d;
        } else {
            d = 80.0d;
        }
        return ViewingConditions.defaultWithBackgroundLstar(d);
    }

    @NonNull
    public DynamicColor background() {
        return DynamicColor.fromPalette(new hc(18), new hc(19));
    }

    @NonNull
    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette(new gc(20), new gc(21), (Function<DynamicScheme, DynamicColor>) null);
    }

    @NonNull
    public DynamicColor controlHighlight() {
        return new DynamicColor(new hc(9), new hc(10), new hc(11), new hc(12), (Function<DynamicScheme, DynamicColor>) null, new hc(14), new hc(15), (Function<DynamicScheme, ToneDeltaConstraint>) null);
    }

    @NonNull
    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette(new gc(18), new gc(19));
    }

    @NonNull
    public DynamicColor error() {
        return DynamicColor.fromPalette(new d6(19), new d6(20), new fc(this, 25), new fc(this, 7));
    }

    @NonNull
    public DynamicColor errorContainer() {
        return DynamicColor.fromPalette(new gc(4), new gc(5), new fc(this, 25));
    }

    @NonNull
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        if (dynamicScheme.isDark) {
            return surfaceBright();
        }
        return surfaceDim();
    }

    @NonNull
    public DynamicColor inverseOnSurface() {
        return DynamicColor.fromPalette(new d6(11), new d6(13), new fc(this, 1));
    }

    @NonNull
    public DynamicColor inversePrimary() {
        return DynamicColor.fromPalette(new ic(1), new ic(2), new fc(this, 17));
    }

    @NonNull
    public DynamicColor inverseSurface() {
        return DynamicColor.fromPalette(new d6(28), new d6(29));
    }

    @NonNull
    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette(new d6(12), new d6(18));
    }

    @NonNull
    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette(new ic(20), new ic(21));
    }

    @NonNull
    public DynamicColor onBackground() {
        return DynamicColor.fromPalette(new hc(22), new hc(23), new fc(this, 15));
    }

    @NonNull
    public DynamicColor onError() {
        return DynamicColor.fromPalette(new ic(10), new ic(11), new fc(this, 20));
    }

    @NonNull
    public DynamicColor onErrorContainer() {
        return DynamicColor.fromPalette(new gc(0), new gc(1), new fc(this, 9));
    }

    @NonNull
    public DynamicColor onPrimary() {
        return DynamicColor.fromPalette(new hc(29), new ic(0), new fc(this, 16));
    }

    @NonNull
    public DynamicColor onPrimaryContainer() {
        return DynamicColor.fromPalette(new ic(14), new fc(this, 21), new fc(this, 22), (Function<DynamicScheme, ToneDeltaConstraint>) null);
    }

    @NonNull
    public DynamicColor onPrimaryFixed() {
        return DynamicColor.fromPalette(new d6(16), new d6(17), new fc(this, 6));
    }

    @NonNull
    public DynamicColor onPrimaryFixedVariant() {
        return DynamicColor.fromPalette(new ic(6), new ic(7), new fc(this, 18));
    }

    @NonNull
    public DynamicColor onSecondary() {
        return DynamicColor.fromPalette(new jc(5), new jc(6), new fc(this, 23));
    }

    @NonNull
    public DynamicColor onSecondaryContainer() {
        return DynamicColor.fromPalette(new d6(15), new fc(this, 4), new fc(this, 5));
    }

    @NonNull
    public DynamicColor onSecondaryFixed() {
        return DynamicColor.fromPalette(new d6(9), new d6(10), new fc(this, 0));
    }

    @NonNull
    public DynamicColor onSecondaryFixedVariant() {
        return DynamicColor.fromPalette(new gc(13), new gc(14), new fc(this, 11));
    }

    @NonNull
    public DynamicColor onSurface() {
        return DynamicColor.fromPalette(new ic(19), new jc(0), new fc(this, 25));
    }

    @NonNull
    public DynamicColor onSurfaceVariant() {
        return DynamicColor.fromPalette(new d6(25), new d6(26), new fc(this, 8));
    }

    @NonNull
    public DynamicColor onTertiary() {
        return DynamicColor.fromPalette(new hc(24), new ic(3), new fc(this, 19));
    }

    @NonNull
    public DynamicColor onTertiaryContainer() {
        return DynamicColor.fromPalette(new d6(14), new fc(this, 2), new fc(this, 3));
    }

    @NonNull
    public DynamicColor onTertiaryFixed() {
        return DynamicColor.fromPalette(new hc(5), new hc(6), new fc(this, 14));
    }

    @NonNull
    public DynamicColor onTertiaryFixedVariant() {
        return DynamicColor.fromPalette(new gc(26), new gc(27), new fc(this, 13));
    }

    @NonNull
    public DynamicColor outline() {
        return DynamicColor.fromPalette(new d6(5), new d6(6), new fc(this, 25));
    }

    @NonNull
    public DynamicColor outlineVariant() {
        return DynamicColor.fromPalette(new hc(25), new hc(26), new fc(this, 25));
    }

    @NonNull
    public DynamicColor primary() {
        return DynamicColor.fromPalette(new gc(9), new gc(10), new fc(this, 25), new fc(this, 10));
    }

    @NonNull
    public DynamicColor primaryContainer() {
        return DynamicColor.fromPalette(new hc(16), new hc(17), new fc(this, 25));
    }

    @NonNull
    public DynamicColor primaryFixed() {
        return DynamicColor.fromPalette(new ic(28), new ic(29), new fc(this, 25));
    }

    @NonNull
    public DynamicColor primaryFixedDim() {
        return DynamicColor.fromPalette(new jc(1), new jc(2), new fc(this, 25));
    }

    @NonNull
    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new gc(22), new gc(24));
    }

    @NonNull
    public DynamicColor scrim() {
        return DynamicColor.fromPalette(new gc(11), new gc(12));
    }

    @NonNull
    public DynamicColor secondary() {
        return DynamicColor.fromPalette(new jc(7), new jc(8), new fc(this, 25), new fc(this, 24));
    }

    @NonNull
    public DynamicColor secondaryContainer() {
        return DynamicColor.fromPalette(new hc(2), new hc(4), new fc(this, 25));
    }

    @NonNull
    public DynamicColor secondaryFixed() {
        return DynamicColor.fromPalette(new ic(4), new ic(5), new fc(this, 25));
    }

    @NonNull
    public DynamicColor secondaryFixedDim() {
        return DynamicColor.fromPalette(new ic(15), new ic(16), new fc(this, 25));
    }

    @NonNull
    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new gc(28), new gc(29));
    }

    @NonNull
    public DynamicColor shadow() {
        return DynamicColor.fromPalette(new ic(24), new ic(25));
    }

    @NonNull
    public DynamicColor surface() {
        return DynamicColor.fromPalette(new d6(2), new gc(23));
    }

    @NonNull
    public DynamicColor surfaceBright() {
        return DynamicColor.fromPalette(new hc(27), new hc(28));
    }

    @NonNull
    public DynamicColor surfaceContainer() {
        return DynamicColor.fromPalette(new d6(23), new d6(24));
    }

    @NonNull
    public DynamicColor surfaceContainerHigh() {
        return DynamicColor.fromPalette(new hc(20), new hc(21));
    }

    @NonNull
    public DynamicColor surfaceContainerHighest() {
        return DynamicColor.fromPalette(new ic(26), new ic(27));
    }

    @NonNull
    public DynamicColor surfaceContainerLow() {
        return DynamicColor.fromPalette(new hc(0), new hc(1));
    }

    @NonNull
    public DynamicColor surfaceContainerLowest() {
        return DynamicColor.fromPalette(new d6(3), new d6(4));
    }

    @NonNull
    public DynamicColor surfaceDim() {
        return DynamicColor.fromPalette(new d6(27), new gc(6));
    }

    @NonNull
    public DynamicColor surfaceTint() {
        return DynamicColor.fromPalette(new d6(7), new d6(8));
    }

    @NonNull
    public DynamicColor surfaceVariant() {
        return DynamicColor.fromPalette(new ic(17), new ic(18));
    }

    @NonNull
    public DynamicColor tertiary() {
        return DynamicColor.fromPalette(new gc(16), new gc(17), new fc(this, 25), new fc(this, 12));
    }

    @NonNull
    public DynamicColor tertiaryContainer() {
        return DynamicColor.fromPalette(new jc(3), new jc(4), new fc(this, 25));
    }

    @NonNull
    public DynamicColor tertiaryFixed() {
        return DynamicColor.fromPalette(new gc(7), new gc(8), new fc(this, 25));
    }

    @NonNull
    public DynamicColor tertiaryFixedDim() {
        return DynamicColor.fromPalette(new ic(8), new ic(9), new fc(this, 25));
    }

    @NonNull
    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette(new hc(7), new hc(8));
    }

    @NonNull
    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette(new ic(22), new ic(23));
    }

    @NonNull
    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette(new d6(21), new d6(22));
    }

    @NonNull
    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette(new ic(12), new ic(13));
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette(new gc(2), new gc(3));
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette(new hc(3), new hc(13));
    }
}
