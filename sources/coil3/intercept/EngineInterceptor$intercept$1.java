package coil3.intercept;

import coil3.intercept.Interceptor;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0}, l = {64}, m = "intercept", n = {"chain"}, s = {"L$0"})
final class EngineInterceptor$intercept$1 extends ContinuationImpl {
    public Interceptor.Chain c;
    public /* synthetic */ Object d;
    public final /* synthetic */ EngineInterceptor e;
    public int f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a((RealInterceptorChain) null, this);
    }
}
