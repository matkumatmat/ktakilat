package defpackage;

import java.util.function.Supplier;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableSupplier;

/* renamed from: d7  reason: default package */
public final /* synthetic */ class d7 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f646a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d7(Object obj, int i) {
        this.f646a = i;
        this.b = obj;
    }

    public final Object get() {
        switch (this.f646a) {
            case 0:
                return Failable.get((FailableSupplier) this.b);
            default:
                return Functions.get((Functions.FailableSupplier) this.b);
        }
    }
}
