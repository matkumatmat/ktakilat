package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;

public final /* synthetic */ class c implements Function {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return EndpointPair.ordered(obj, this.d);
            case 1:
                return EndpointPair.ordered(this.d, obj);
            case 2:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.d, (DirectedGraphConnections.NodeConnection) obj);
            default:
                return EndpointPair.unordered(this.d, obj);
        }
    }
}
