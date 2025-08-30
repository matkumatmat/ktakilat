package coil3.intercept;

import coil3.EventListener;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {115, 119, 137}, m = "execute", n = {"this", "request", "mappedData", "eventListener", "options", "components", "fetchResult", "this", "request", "eventListener", "options", "fetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class EngineInterceptor$execute$1 extends ContinuationImpl {
    public EngineInterceptor c;
    public ImageRequest d;
    public Object e;
    public Object f;
    public Ref.ObjectRef g;
    public Ref.ObjectRef i;
    public Ref.ObjectRef j;
    public Ref.ObjectRef k;
    public /* synthetic */ Object l;
    public final /* synthetic */ EngineInterceptor m;
    public int n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return EngineInterceptor.c(this.m, (ImageRequest) null, (Object) null, (Options) null, (EventListener) null, this);
    }
}
