package coil3.intercept;

import coil3.EventListener;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.Options;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptorKt", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "transform", n = {"result", "request", "options", "eventListener", "$this$foldIndices$iv", "i$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class EngineInterceptorKt$transform$1 extends ContinuationImpl {
    public EngineInterceptor.ExecuteResult c;
    public ImageRequest d;
    public Options e;
    public EventListener f;
    public List g;
    public int i;
    public int j;
    public /* synthetic */ Object k;
    public int l;

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.l |= Integer.MIN_VALUE;
        return EngineInterceptorKt.a((EngineInterceptor.ExecuteResult) null, (ImageRequest) null, (Options) null, (EventListener) null, this);
    }
}
