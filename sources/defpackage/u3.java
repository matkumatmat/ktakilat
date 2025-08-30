package defpackage;

import coil3.ComponentRegistry;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;

/* renamed from: u3  reason: default package */
public final /* synthetic */ class u3 implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ ComponentRegistry d;

    public /* synthetic */ u3(ComponentRegistry componentRegistry, int i) {
        this.c = i;
        this.d = componentRegistry;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                ComponentRegistry componentRegistry = this.d;
                List list = componentRegistry.d;
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    CollectionsKt.f(arrayList, (List) ((Function0) list.get(i)).invoke());
                }
                componentRegistry.d = EmptyList.INSTANCE;
                return arrayList;
            default:
                ComponentRegistry componentRegistry2 = this.d;
                List list2 = componentRegistry2.e;
                ArrayList arrayList2 = new ArrayList();
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    CollectionsKt.f(arrayList2, (List) ((Function0) list2.get(i2)).invoke());
                }
                componentRegistry2.e = EmptyList.INSTANCE;
                return arrayList2;
        }
    }
}
