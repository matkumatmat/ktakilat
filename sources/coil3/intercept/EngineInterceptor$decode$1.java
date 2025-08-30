package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {192}, m = "decode", n = {"this", "fetchResult", "components", "request", "mappedData", "options", "eventListener", "decoder", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
final class EngineInterceptor$decode$1 extends ContinuationImpl {
    public EngineInterceptor c;
    public SourceFetchResult d;
    public ComponentRegistry e;
    public ImageRequest f;
    public Object g;
    public Options i;
    public EventListener j;
    public Decoder k;
    public int l;
    public /* synthetic */ Object m;
    public final /* synthetic */ EngineInterceptor n;
    public int o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$decode$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.n = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.m = obj;
        this.o |= Integer.MIN_VALUE;
        return EngineInterceptor.b(this.n, (SourceFetchResult) null, (ComponentRegistry) null, (ImageRequest) null, (Object) null, (Options) null, (EventListener) null, this);
    }
}
