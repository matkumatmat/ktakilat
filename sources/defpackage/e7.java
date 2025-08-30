package defpackage;

import java.util.function.BiFunction;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiFunction;

/* renamed from: e7  reason: default package */
public final /* synthetic */ class e7 implements BiFunction {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e7(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                return Failable.apply((FailableBiFunction) this.d, obj, obj2);
            default:
                return Functions.apply((Functions.FailableBiFunction) this.d, obj, obj2);
        }
    }
}
