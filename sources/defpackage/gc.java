package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: gc  reason: default package */
public final /* synthetic */ class gc implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f345a;

    public /* synthetic */ gc(int i) {
        this.f345a = i;
    }

    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f345a) {
            case 0:
                return dynamicScheme.errorPalette;
            case 1:
                return MaterialDynamicColors.lambda$onErrorContainer$92(dynamicScheme);
            case 2:
                return dynamicScheme.neutralVariantPalette;
            case 3:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$145(dynamicScheme);
            case 4:
                return dynamicScheme.errorPalette;
            case 5:
                return MaterialDynamicColors.lambda$errorContainer$90(dynamicScheme);
            case 6:
                return MaterialDynamicColors.lambda$surfaceDim$22(dynamicScheme);
            case 7:
                return dynamicScheme.tertiaryPalette;
            case 8:
                return MaterialDynamicColors.lambda$tertiaryFixed$121(dynamicScheme);
            case 9:
                return dynamicScheme.primaryPalette;
            case 10:
                return MaterialDynamicColors.lambda$primary$59(dynamicScheme);
            case 11:
                return dynamicScheme.neutralPalette;
            case 12:
                return Double.valueOf(0.0d);
            case 13:
                return dynamicScheme.secondaryPalette;
            case 14:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$118(dynamicScheme);
            case 15:
                return MaterialDynamicColors.lambda$controlHighlight$140(dynamicScheme);
            case 16:
                return dynamicScheme.tertiaryPalette;
            case 17:
                return MaterialDynamicColors.lambda$tertiary$84(dynamicScheme);
            case 18:
                return dynamicScheme.neutralVariantPalette;
            case 19:
                return MaterialDynamicColors.lambda$controlNormal$133(dynamicScheme);
            case 20:
                return dynamicScheme.primaryPalette;
            case 21:
                return MaterialDynamicColors.lambda$controlActivated$131(dynamicScheme);
            case 22:
                return dynamicScheme.primaryPalette;
            case 23:
                return MaterialDynamicColors.lambda$surface$16(dynamicScheme);
            case 24:
                return Double.valueOf(dynamicScheme.primaryPalette.getKeyColor().getTone());
            case 25:
                return MaterialDynamicColors.lambda$controlHighlight$138(dynamicScheme);
            case 26:
                return dynamicScheme.tertiaryPalette;
            case 27:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$128(dynamicScheme);
            case 28:
                return dynamicScheme.secondaryPalette;
            default:
                return Double.valueOf(dynamicScheme.secondaryPalette.getKeyColor().getTone());
        }
    }
}
