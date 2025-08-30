package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause0Impl;", "Lkotlinx/coroutines/selects/SelectClause0;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectClause0Impl implements SelectClause0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f816a;
    public final Function3 b;
    public final Function3 c = null;
    public final Function3 d;

    public SelectClause0Impl(Object obj, Function3 function3) {
        this.f816a = obj;
        this.b = function3;
        Function3 function32 = SelectKt.f820a;
        this.d = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.c;
    }

    public final Function3 a() {
        return this.b;
    }

    public final Object b() {
        return this.f816a;
    }

    public final Function3 c() {
        return this.c;
    }

    public final Function3 d() {
        return this.d;
    }
}
