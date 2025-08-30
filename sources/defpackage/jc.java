package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import org.apache.commons.lang3.reflect.MethodUtils;

/* renamed from: jc  reason: default package */
public final /* synthetic */ class jc implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f349a;

    public /* synthetic */ jc(int i) {
        this.f349a = i;
    }

    public final Object apply(Object obj) {
        switch (this.f349a) {
            case 0:
                return MaterialDynamicColors.lambda$onSurface$34((DynamicScheme) obj);
            case 1:
                return ((DynamicScheme) obj).primaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$primaryFixedDim$103((DynamicScheme) obj);
            case 3:
                return ((DynamicScheme) obj).tertiaryPalette;
            case 4:
                return MaterialDynamicColors.lambda$tertiaryContainer$79((DynamicScheme) obj);
            case 5:
                return ((DynamicScheme) obj).secondaryPalette;
            case 6:
                return MaterialDynamicColors.lambda$onSecondary$76((DynamicScheme) obj);
            case 7:
                return ((DynamicScheme) obj).secondaryPalette;
            case 8:
                return MaterialDynamicColors.lambda$secondary$73((DynamicScheme) obj);
            case 9:
                return String.valueOf((Class) obj);
            case 10:
                return ((Method) obj).toString();
            case 11:
                return ((Class) obj).getDeclaredMethods();
            case 12:
                return Arrays.stream((Method[]) obj);
            default:
                return MethodUtils.lambda$null$3((Integer) obj);
        }
    }
}
