package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import java.util.function.Function;

/* renamed from: y5  reason: default package */
public final /* synthetic */ class y5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f369a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ Function c;
    public final /* synthetic */ Function d;

    public /* synthetic */ y5(int i, Function function, Function function2, Function function3) {
        this.f369a = i;
        this.b = function;
        this.c = function2;
        this.d = function3;
    }

    public final Object apply(Object obj) {
        switch (this.f369a) {
            case 0:
                return Double.valueOf(DynamicColor.toneMinContrastDefault(this.b, this.c, (DynamicScheme) obj, this.d));
            default:
                return Double.valueOf(DynamicColor.toneMaxContrastDefault(this.b, this.c, (DynamicScheme) obj, this.d));
        }
    }
}
