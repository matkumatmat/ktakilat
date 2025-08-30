package defpackage;

import com.google.common.base.Function;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.Network;
import com.google.common.graph.ValueGraph;

/* renamed from: ra  reason: default package */
public final /* synthetic */ class ra implements Function {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ ra(int i, Object obj, Object obj2) {
        this.c = i;
        this.e = obj;
        this.d = obj2;
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return ((Network) this.e).incidentNodes(obj).adjacentNode(this.d);
            default:
                return ImmutableValueGraph.lambda$connectionsOf$0((ValueGraph) this.e, this.d, obj);
        }
    }
}
