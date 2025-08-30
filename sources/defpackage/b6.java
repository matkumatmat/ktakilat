package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: b6  reason: default package */
public final /* synthetic */ class b6 implements BiFunction {
    public final /* synthetic */ Function c;
    public final /* synthetic */ DynamicScheme d;

    public /* synthetic */ b6(Function function, DynamicScheme dynamicScheme) {
        this.c = function;
        this.d = dynamicScheme;
    }

    public final Object apply(Object obj, Object obj2) {
        return DynamicColor.lambda$toneMaxContrastDefault$18(this.c, this.d, (Double) obj, (Double) obj2);
    }
}
