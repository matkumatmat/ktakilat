package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.google.android.material.color.utilities.ToneDeltaConstraint;
import java.util.function.Function;

/* renamed from: hc  reason: default package */
public final /* synthetic */ class hc implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f346a;

    public /* synthetic */ hc(int i) {
        this.f346a = i;
    }

    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f346a) {
            case 0:
                return dynamicScheme.neutralPalette;
            case 1:
                return MaterialDynamicColors.lambda$surfaceContainerLow$26(dynamicScheme);
            case 2:
                return dynamicScheme.secondaryPalette;
            case 3:
                return dynamicScheme.neutralPalette;
            case 4:
                return MaterialDynamicColors.lambda$secondaryContainer$68(dynamicScheme);
            case 5:
                return dynamicScheme.tertiaryPalette;
            case 6:
                return MaterialDynamicColors.lambda$onTertiaryFixed$125(dynamicScheme);
            case 7:
                return dynamicScheme.tertiaryPalette;
            case 8:
                return Double.valueOf(dynamicScheme.tertiaryPalette.getKeyColor().getTone());
            case 9:
                return Double.valueOf(0.0d);
            case 10:
                return Double.valueOf(0.0d);
            case 11:
                return MaterialDynamicColors.lambda$controlHighlight$136(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$controlHighlight$137(dynamicScheme);
            case 13:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$149(dynamicScheme);
            case 14:
                return Double.valueOf(DynamicColor.toneMinContrastDefault(new gc(25), (Function<DynamicScheme, DynamicColor>) null, dynamicScheme, (Function<DynamicScheme, ToneDeltaConstraint>) null));
            case 15:
                return Double.valueOf(DynamicColor.toneMaxContrastDefault(new gc(15), (Function<DynamicScheme, DynamicColor>) null, dynamicScheme, (Function<DynamicScheme, ToneDeltaConstraint>) null));
            case 16:
                return dynamicScheme.primaryPalette;
            case 17:
                return MaterialDynamicColors.lambda$primaryContainer$54(dynamicScheme);
            case 18:
                return dynamicScheme.neutralPalette;
            case 19:
                return MaterialDynamicColors.lambda$background$11(dynamicScheme);
            case 20:
                return dynamicScheme.neutralPalette;
            case 21:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$30(dynamicScheme);
            case 22:
                return dynamicScheme.neutralPalette;
            case 23:
                return MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
            case 24:
                return dynamicScheme.tertiaryPalette;
            case 25:
                return dynamicScheme.neutralVariantPalette;
            case 26:
                return MaterialDynamicColors.lambda$outlineVariant$46(dynamicScheme);
            case 27:
                return dynamicScheme.neutralPalette;
            case 28:
                return MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
            default:
                return dynamicScheme.primaryPalette;
        }
    }
}
