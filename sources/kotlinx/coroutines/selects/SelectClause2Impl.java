package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause2Impl;", "P", "Q", "Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectClause2Impl<P, Q> implements SelectClause2<P, Q> {

    /* renamed from: a  reason: collision with root package name */
    public final Channel f818a;
    public final FunctionReferenceImpl b;
    public final Function3 c;
    public final Function3 d;

    public SelectClause2Impl(Channel channel, Function3 function3, Function3 function32) {
        this.f818a = channel;
        this.b = (FunctionReferenceImpl) function3;
        this.c = function32;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.jvm.internal.FunctionReferenceImpl, kotlin.jvm.functions.Function3] */
    public final Function3 a() {
        return this.b;
    }

    public final Function3 d() {
        return this.c;
    }
}
