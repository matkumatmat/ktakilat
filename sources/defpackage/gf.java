package defpackage;

import java.util.List;
import java.util.function.BinaryOperator;

/* renamed from: gf  reason: default package */
public final /* synthetic */ class gf implements BinaryOperator {
    public final /* synthetic */ int c;

    public /* synthetic */ gf(int i) {
        this.c = i;
    }

    public final Object apply(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        switch (this.c) {
            case 0:
                return list.addAll(list2);
            default:
                return list.addAll(list2);
        }
    }
}
