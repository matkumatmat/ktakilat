package coil3.intercept;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", i = {0, 0}, l = {31}, m = "proceed", n = {"this", "interceptor"}, s = {"L$0", "L$1"})
final class RealInterceptorChain$proceed$1 extends ContinuationImpl {
    public RealInterceptorChain c;
    public Interceptor d;
    public /* synthetic */ Object e;
    public final /* synthetic */ RealInterceptorChain f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = realInterceptorChain;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.b(this);
    }
}
