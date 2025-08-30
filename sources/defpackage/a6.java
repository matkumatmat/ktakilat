package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import java.util.function.Function;

/* renamed from: a6  reason: default package */
public final /* synthetic */ class a6 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f221a;
    public final /* synthetic */ DynamicScheme b;

    public /* synthetic */ a6(int i, DynamicScheme dynamicScheme) {
        this.f221a = i;
        this.b = dynamicScheme;
    }

    public final Object apply(Object obj) {
        switch (this.f221a) {
            case 0:
                return DynamicColor.lambda$toneMaxContrastDefault$17(this.b, (DynamicColor) obj);
            case 1:
                return DynamicColor.lambda$toneMinContrastDefault$14(this.b, (DynamicColor) obj);
            default:
                return Double.valueOf(((DynamicColor) obj).getTone(this.b));
        }
    }
}
