package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {158}, m = "fetch", n = {"this", "components", "request", "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
final class EngineInterceptor$fetch$1 extends ContinuationImpl {
    public EngineInterceptor c;
    public ComponentRegistry d;
    public ImageRequest e;
    public Object f;
    public Options g;
    public EventListener i;
    public Fetcher j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ EngineInterceptor m;
    public int n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$fetch$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.d((ComponentRegistry) null, (ImageRequest) null, (Object) null, (Options) null, (EventListener) null, this);
    }
}
