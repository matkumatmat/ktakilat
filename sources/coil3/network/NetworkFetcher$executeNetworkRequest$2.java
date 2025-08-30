package coil3.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "T", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$executeNetworkRequest$2", f = "NetworkFetcher.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
final class NetworkFetcher$executeNetworkRequest$2 extends SuspendLambda implements Function2<NetworkResponse, Continuation<Object>, Object> {
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ SuspendLambda e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$executeNetworkRequest$2(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.e = (SuspendLambda) function2;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    public final Continuation create(Object obj, Continuation continuation) {
        NetworkFetcher$executeNetworkRequest$2 networkFetcher$executeNetworkRequest$2 = new NetworkFetcher$executeNetworkRequest$2(this.e, continuation);
        networkFetcher$executeNetworkRequest$2.d = obj;
        return networkFetcher$executeNetworkRequest$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((NetworkFetcher$executeNetworkRequest$2) create((NetworkResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            ResultKt.b(obj);
            NetworkResponse networkResponse = (NetworkResponse) this.d;
            int i2 = networkResponse.f131a;
            if ((200 > i2 || i2 >= 300) && i2 != 304) {
                throw new HttpException(networkResponse);
            }
            this.c = 1;
            obj = this.e.invoke(networkResponse, this);
            if (obj == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
