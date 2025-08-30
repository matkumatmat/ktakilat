package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: fc  reason: default package */
public final /* synthetic */ class fc implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f344a;
    public final /* synthetic */ MaterialDynamicColors b;

    public /* synthetic */ fc(MaterialDynamicColors materialDynamicColors, int i) {
        this.f344a = i;
        this.b = materialDynamicColors;
    }

    public final Object apply(Object obj) {
        switch (this.f344a) {
            case 0:
                return this.b.lambda$onSecondaryFixed$116((DynamicScheme) obj);
            case 1:
                return this.b.lambda$inverseOnSurface$37((DynamicScheme) obj);
            case 2:
                return this.b.lambda$onTertiaryContainer$81((DynamicScheme) obj);
            case 3:
                return this.b.lambda$onTertiaryContainer$82((DynamicScheme) obj);
            case 4:
                return this.b.lambda$onSecondaryContainer$70((DynamicScheme) obj);
            case 5:
                return this.b.lambda$onSecondaryContainer$71((DynamicScheme) obj);
            case 6:
                return this.b.lambda$onPrimaryFixed$106((DynamicScheme) obj);
            case 7:
                return this.b.lambda$error$96((DynamicScheme) obj);
            case 8:
                return this.b.lambda$onSurfaceVariant$42((DynamicScheme) obj);
            case 9:
                return this.b.lambda$onErrorContainer$93((DynamicScheme) obj);
            case 10:
                return this.b.lambda$primary$60((DynamicScheme) obj);
            case 11:
                return this.b.lambda$onSecondaryFixedVariant$119((DynamicScheme) obj);
            case 12:
                return this.b.lambda$tertiary$85((DynamicScheme) obj);
            case 13:
                return this.b.lambda$onTertiaryFixedVariant$129((DynamicScheme) obj);
            case 14:
                return this.b.lambda$onTertiaryFixed$126((DynamicScheme) obj);
            case 15:
                return this.b.lambda$onBackground$14((DynamicScheme) obj);
            case 16:
                return this.b.lambda$onPrimary$66((DynamicScheme) obj);
            case 17:
                return this.b.lambda$inversePrimary$63((DynamicScheme) obj);
            case 18:
                return this.b.lambda$onPrimaryFixedVariant$109((DynamicScheme) obj);
            case 19:
                return this.b.lambda$onTertiary$88((DynamicScheme) obj);
            case 20:
                return this.b.lambda$onError$99((DynamicScheme) obj);
            case 21:
                return this.b.lambda$onPrimaryContainer$56((DynamicScheme) obj);
            case 22:
                return this.b.lambda$onPrimaryContainer$57((DynamicScheme) obj);
            case 23:
                return this.b.lambda$onSecondary$77((DynamicScheme) obj);
            case 24:
                return this.b.lambda$secondary$74((DynamicScheme) obj);
            default:
                return this.b.highestSurface((DynamicScheme) obj);
        }
    }
}
