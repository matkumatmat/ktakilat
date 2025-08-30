package coil3.network;

import coil3.disk.DiskCache;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {138, 153}, m = "writeToDiskCache", n = {"this", "snapshot", "networkResponse", "networkResponse", "modifiedNetworkResponse", "editor"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class NetworkFetcher$writeToDiskCache$1 extends ContinuationImpl {
    public Object c;
    public Object d;
    public Object e;
    public /* synthetic */ Object f;
    public final /* synthetic */ NetworkFetcher g;
    public int i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$writeToDiskCache$1(NetworkFetcher networkFetcher, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.i |= Integer.MIN_VALUE;
        return NetworkFetcher.c(this.g, (DiskCache.Snapshot) null, (NetworkResponse) null, (NetworkRequest) null, (NetworkResponse) null, this);
    }
}
