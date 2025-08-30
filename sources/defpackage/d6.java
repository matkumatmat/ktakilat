package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.lang.reflect.Field;
import java.util.function.Function;

/* renamed from: d6  reason: default package */
public final /* synthetic */ class d6 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f342a;

    public /* synthetic */ d6(int i) {
        this.f342a = i;
    }

    public final Object apply(Object obj) {
        switch (this.f342a) {
            case 0:
                return DynamicColor.lambda$toneMinContrastDefault$16((Double) obj);
            case 1:
                return ((Field) obj).getName();
            case 2:
                return ((DynamicScheme) obj).neutralPalette;
            case 3:
                return ((DynamicScheme) obj).neutralPalette;
            case 4:
                return MaterialDynamicColors.lambda$surfaceContainerLowest$24((DynamicScheme) obj);
            case 5:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 6:
                return MaterialDynamicColors.lambda$outline$44((DynamicScheme) obj);
            case 7:
                return ((DynamicScheme) obj).primaryPalette;
            case 8:
                return MaterialDynamicColors.lambda$surfaceTint$52((DynamicScheme) obj);
            case 9:
                return ((DynamicScheme) obj).secondaryPalette;
            case 10:
                return Double.valueOf(10.0d);
            case 11:
                return ((DynamicScheme) obj).neutralPalette;
            case 12:
                return ((DynamicScheme) obj).neutralPalette;
            case 13:
                return MaterialDynamicColors.lambda$inverseOnSurface$36((DynamicScheme) obj);
            case 14:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 15:
                return ((DynamicScheme) obj).secondaryPalette;
            case 16:
                return ((DynamicScheme) obj).primaryPalette;
            case 17:
                return MaterialDynamicColors.lambda$onPrimaryFixed$105((DynamicScheme) obj);
            case 18:
                return Double.valueOf(((DynamicScheme) obj).neutralPalette.getKeyColor().getTone());
            case 19:
                return ((DynamicScheme) obj).errorPalette;
            case 20:
                return MaterialDynamicColors.lambda$error$95((DynamicScheme) obj);
            case 21:
                return ((DynamicScheme) obj).neutralPalette;
            case 22:
                return MaterialDynamicColors.lambda$textPrimaryInverse$143((DynamicScheme) obj);
            case 23:
                return ((DynamicScheme) obj).neutralPalette;
            case 24:
                return MaterialDynamicColors.lambda$surfaceContainer$28((DynamicScheme) obj);
            case 25:
                return ((DynamicScheme) obj).neutralVariantPalette;
            case 26:
                return MaterialDynamicColors.lambda$onSurfaceVariant$41((DynamicScheme) obj);
            case 27:
                return ((DynamicScheme) obj).neutralPalette;
            case 28:
                return ((DynamicScheme) obj).neutralPalette;
            default:
                return MaterialDynamicColors.lambda$inverseSurface$18((DynamicScheme) obj);
        }
    }
}
