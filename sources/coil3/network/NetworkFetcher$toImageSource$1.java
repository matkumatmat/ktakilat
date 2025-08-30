package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.Buffer;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0}, l = {244}, m = "toImageSource", n = {"this", "buffer"}, s = {"L$0", "L$1"})
final class NetworkFetcher$toImageSource$1 extends ContinuationImpl {
    public NetworkFetcher c;
    public Buffer d;
    public /* synthetic */ Object e;
    public final /* synthetic */ NetworkFetcher f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$toImageSource$1(NetworkFetcher networkFetcher, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return NetworkFetcher.b(this.f, (NetworkResponseBody) null, this);
    }
}
