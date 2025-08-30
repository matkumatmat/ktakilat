package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannel;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause1Impl;", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectClause1Impl<Q> implements SelectClause1<Q> {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedChannel f817a;
    public final FunctionReferenceImpl b;
    public final FunctionReferenceImpl c;
    public final l1 d;

    public SelectClause1Impl(BufferedChannel bufferedChannel, Function3 function3, Function3 function32, l1 l1Var) {
        this.f817a = bufferedChannel;
        this.b = (FunctionReferenceImpl) function3;
        this.c = (FunctionReferenceImpl) function32;
        this.d = l1Var;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.jvm.internal.FunctionReferenceImpl, kotlin.jvm.functions.Function3] */
    public final Function3 a() {
        return this.b;
    }

    public final Object b() {
        return this.f817a;
    }

    public final Function3 c() {
        return this.d;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.jvm.internal.FunctionReferenceImpl, kotlin.jvm.functions.Function3] */
    public final Function3 d() {
        return this.c;
    }
}
