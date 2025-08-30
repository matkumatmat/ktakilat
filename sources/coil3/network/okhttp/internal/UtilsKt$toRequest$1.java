package coil3.network.okhttp.internal;

import coil3.network.NetworkRequest;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Request;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", i = {0, 0}, l = {32}, m = "toRequest", n = {"$this$toRequest", "request"}, s = {"L$0", "L$1"})
final class UtilsKt$toRequest$1 extends ContinuationImpl {
    public NetworkRequest c;
    public Request.Builder d;
    public Request.Builder e;
    public String f;
    public /* synthetic */ Object g;
    public int i;

    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return UtilsKt.b((NetworkRequest) null, this);
    }
}
