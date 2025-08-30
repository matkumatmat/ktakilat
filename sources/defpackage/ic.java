package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: ic  reason: default package */
public final /* synthetic */ class ic implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f347a;

    public /* synthetic */ ic(int i) {
        this.f347a = i;
    }

    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f347a) {
            case 0:
                return MaterialDynamicColors.lambda$onPrimary$65(dynamicScheme);
            case 1:
                return dynamicScheme.primaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$inversePrimary$62(dynamicScheme);
            case 3:
                return MaterialDynamicColors.lambda$onTertiary$87(dynamicScheme);
            case 4:
                return dynamicScheme.secondaryPalette;
            case 5:
                return MaterialDynamicColors.lambda$secondaryFixed$111(dynamicScheme);
            case 6:
                return dynamicScheme.primaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$108(dynamicScheme);
            case 8:
                return dynamicScheme.tertiaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$123(dynamicScheme);
            case 10:
                return dynamicScheme.errorPalette;
            case 11:
                return MaterialDynamicColors.lambda$onError$98(dynamicScheme);
            case 12:
                return dynamicScheme.neutralPalette;
            case 13:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$147(dynamicScheme);
            case 14:
                return dynamicScheme.primaryPalette;
            case 15:
                return dynamicScheme.secondaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$secondaryFixedDim$113(dynamicScheme);
            case 17:
                return dynamicScheme.neutralVariantPalette;
            case 18:
                return MaterialDynamicColors.lambda$surfaceVariant$39(dynamicScheme);
            case 19:
                return dynamicScheme.neutralPalette;
            case 20:
                return dynamicScheme.neutralVariantPalette;
            case 21:
                return Double.valueOf(dynamicScheme.neutralVariantPalette.getKeyColor().getTone());
            case 22:
                return dynamicScheme.neutralPalette;
            case 23:
                return MaterialDynamicColors.lambda$textHintInverse$151(dynamicScheme);
            case 24:
                return dynamicScheme.neutralPalette;
            case 25:
                return Double.valueOf(0.0d);
            case 26:
                return dynamicScheme.neutralPalette;
            case 27:
                return MaterialDynamicColors.lambda$surfaceContainerHighest$32(dynamicScheme);
            case 28:
                return dynamicScheme.primaryPalette;
            default:
                return MaterialDynamicColors.lambda$primaryFixed$101(dynamicScheme);
        }
    }
}
