package coil3.network.okhttp.internal;

import coil3.network.NetworkRequestBody;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.Buffer;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", i = {0}, l = {39}, m = "readByteString", n = {"buffer"}, s = {"L$0"})
final class UtilsKt$readByteString$1 extends ContinuationImpl {
    public Buffer c;
    public /* synthetic */ Object d;
    public int e;

    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return UtilsKt.c((NetworkRequestBody) null, this);
    }
}
