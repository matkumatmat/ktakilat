package defpackage;

import com.google.common.base.Function;
import com.google.common.escape.Escaper;
import com.google.common.graph.Network;

/* renamed from: qa  reason: default package */
public final /* synthetic */ class qa implements Function {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ qa(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return ((Network) this.d).incidentNodes(obj).source();
            case 1:
                return ((Network) this.d).incidentNodes(obj).target();
            default:
                return ((Escaper) this.d).escape((String) obj);
        }
    }
}
