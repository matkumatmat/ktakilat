package defpackage;

import com.google.android.material.color.utilities.TonalPalette;
import java.util.function.Function;

/* renamed from: w5  reason: default package */
public final /* synthetic */ class w5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f364a;
    public final /* synthetic */ int b;

    public /* synthetic */ w5(int i, int i2) {
        this.f364a = i2;
        this.b = i;
    }

    public final Object apply(Object obj) {
        switch (this.f364a) {
            case 0:
                return TonalPalette.fromInt(this.b);
            case 1:
                return TonalPalette.fromInt(this.b);
            default:
                return TonalPalette.fromInt(this.b);
        }
    }
}
