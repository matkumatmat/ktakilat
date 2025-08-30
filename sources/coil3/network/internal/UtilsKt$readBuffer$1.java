package coil3.network.internal;

import coil3.network.NetworkResponseBody;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.Buffer;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.internal.UtilsKt", f = "utils.kt", i = {0}, l = {31}, m = "readBuffer", n = {"buffer"}, s = {"L$1"})
final class UtilsKt$readBuffer$1 extends ContinuationImpl {
    public NetworkResponseBody c;
    public Buffer d;
    public /* synthetic */ Object e;
    public int f;

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        return UtilsKt.a((NetworkResponseBody) null, this);
    }
}
