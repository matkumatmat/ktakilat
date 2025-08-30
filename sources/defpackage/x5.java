package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.TonalPalette;
import java.util.function.Function;

/* renamed from: x5  reason: default package */
public final /* synthetic */ class x5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f366a;
    public final /* synthetic */ Function b;

    public /* synthetic */ x5(int i, Function function) {
        this.f366a = i;
        this.b = function;
    }

    public final Object apply(Object obj) {
        switch (this.f366a) {
            case 0:
                return Double.valueOf(((TonalPalette) this.b.apply((DynamicScheme) obj)).getHue());
            default:
                return Double.valueOf(((TonalPalette) this.b.apply((DynamicScheme) obj)).getChroma());
        }
    }
}
