package defpackage;

import coil3.decode.Decoder;
import coil3.util.UtilsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* renamed from: v3  reason: default package */
public final /* synthetic */ class v3 implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Decoder.Factory d;

    public /* synthetic */ v3(Decoder.Factory factory, int i) {
        this.c = i;
        this.d = factory;
    }

    public final Object invoke() {
        Decoder.Factory factory = this.d;
        switch (this.c) {
            case 0:
                return CollectionsKt.s(factory);
            case 1:
                return CollectionsKt.s(factory);
            default:
                Function1 function1 = UtilsKt.f161a;
                return CollectionsKt.s(factory);
        }
    }
}
