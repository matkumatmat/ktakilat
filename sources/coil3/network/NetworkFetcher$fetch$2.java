package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$2", f = "NetworkFetcher.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
final class NetworkFetcher$fetch$2 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ NetworkFetcher e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$2(NetworkFetcher networkFetcher, Continuation continuation) {
        super(2, continuation);
        this.e = networkFetcher;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        NetworkFetcher$fetch$2 networkFetcher$fetch$2 = new NetworkFetcher$fetch$2(this.e, continuation);
        networkFetcher$fetch$2.d = obj;
        return networkFetcher$fetch$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((NetworkFetcher$fetch$2) create((NetworkResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        NetworkResponse networkResponse;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.c;
        NetworkFetcher networkFetcher = this.e;
        if (i == 0) {
            ResultKt.b(obj);
            NetworkResponse networkResponse2 = (NetworkResponse) this.d;
            NetworkResponseBody networkResponseBody = networkResponse2.e;
            if (networkResponseBody != null) {
                this.d = networkResponse2;
                this.c = 1;
                Object b = NetworkFetcher.b(networkFetcher, networkResponseBody, this);
                if (b == coroutineSingletons) {
                    return coroutineSingletons;
                }
                networkResponse = networkResponse2;
                obj = b;
            } else {
                throw new IllegalStateException("body == null");
            }
        } else if (i == 1) {
            networkResponse = (NetworkResponse) this.d;
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return new SourceFetchResult((ImageSource) obj, NetworkFetcher.f(networkFetcher.f126a, networkResponse.d.a()), DataSource.NETWORK);
    }
}
