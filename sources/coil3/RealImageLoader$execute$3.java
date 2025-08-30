package coil3;

import coil3.request.ImageRequest;
import coil3.request.RequestDelegate;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.RealImageLoader", f = "RealImageLoader.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {116, 128, 132}, m = "execute", n = {"this", "requestDelegate", "request", "eventListener", "this", "requestDelegate", "request", "eventListener", "cachedPlaceholder", "this", "requestDelegate", "request", "eventListener"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
final class RealImageLoader$execute$3 extends ContinuationImpl {
    public RealImageLoader c;
    public RequestDelegate d;
    public ImageRequest e;
    public EventListener f;
    public Image g;
    public /* synthetic */ Object i;
    public final /* synthetic */ RealImageLoader j;
    public int k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$3(RealImageLoader realImageLoader, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.j = realImageLoader;
    }

    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= Integer.MIN_VALUE;
        int i2 = RealImageLoader.f;
        return this.j.b((ImageRequest) null, 0, this);
    }
}
