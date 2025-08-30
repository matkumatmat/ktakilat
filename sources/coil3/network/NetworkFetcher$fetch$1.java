package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 2}, l = {61, 74, 102}, m = "fetch", n = {"this", "snapshot", "cacheResponse", "this", "snapshot", "snapshot"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
final class NetworkFetcher$fetch$1 extends ContinuationImpl {
    public Object c;
    public Ref.ObjectRef d;
    public Ref.ObjectRef e;
    public /* synthetic */ Object f;
    public final /* synthetic */ NetworkFetcher g;
    public int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$1(NetworkFetcher networkFetcher, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.i |= Integer.MIN_VALUE;
        return this.g.a(this);
    }
}
