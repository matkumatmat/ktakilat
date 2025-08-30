package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: c6  reason: default package */
public final /* synthetic */ class c6 implements BiFunction {
    public final /* synthetic */ Function c;
    public final /* synthetic */ DynamicScheme d;
    public final /* synthetic */ Function e;

    public /* synthetic */ c6(Function function, DynamicScheme dynamicScheme, Function function2) {
        this.c = function;
        this.d = dynamicScheme;
        this.e = function2;
    }

    public final Object apply(Object obj, Object obj2) {
        return DynamicColor.lambda$toneMinContrastDefault$15(this.c, this.d, this.e, (Double) obj, (Double) obj2);
    }
}
