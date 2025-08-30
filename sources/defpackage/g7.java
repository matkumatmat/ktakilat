package defpackage;

import java.util.function.BiConsumer;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiConsumer;

/* renamed from: g7  reason: default package */
public final /* synthetic */ class g7 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f653a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g7(Object obj, int i) {
        this.f653a = i;
        this.b = obj;
    }

    public final void accept(Object obj, Object obj2) {
        switch (this.f653a) {
            case 0:
                Failable.accept((FailableBiConsumer) this.b, obj, obj2);
                return;
            default:
                Functions.accept((Functions.FailableBiConsumer) this.b, obj, obj2);
                return;
        }
    }
}
