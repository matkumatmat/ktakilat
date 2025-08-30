package coil3.network.okhttp.internal;

import coil3.network.NetworkRequest;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.CallFactoryNetworkClient", f = "utils.kt", i = {0, 1}, l = {24, 24, 25}, m = "executeRequest-impl", n = {"block", "block"}, s = {"L$0", "L$0"})
final class CallFactoryNetworkClient$executeRequest$1<T> extends ContinuationImpl {
    public Object c;
    public Call.Factory d;
    public /* synthetic */ Object e;
    public int f;

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        return CallFactoryNetworkClient.b((OkHttpClient) null, (NetworkRequest) null, (Function2) null, this);
    }
}
