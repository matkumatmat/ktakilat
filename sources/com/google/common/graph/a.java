package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph;

public final /* synthetic */ class a implements Function {
    public final /* synthetic */ int c;
    public final /* synthetic */ AbstractBaseGraph.AnonymousClass2 d;

    public /* synthetic */ a(AbstractBaseGraph.AnonymousClass2 r1, int i) {
        this.c = i;
        this.d = r1;
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return this.d.lambda$iterator$0(obj);
            case 1:
                return this.d.lambda$iterator$1(obj);
            default:
                return this.d.lambda$iterator$2(obj);
        }
    }
}
