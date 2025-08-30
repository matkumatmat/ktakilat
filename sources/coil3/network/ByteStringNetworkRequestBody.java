package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/network/ByteStringNetworkRequestBody;", "Lcoil3/network/NetworkRequestBody;", "bytes", "Lokio/ByteString;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class ByteStringNetworkRequestBody implements NetworkRequestBody {
    public final Unit a(Buffer buffer) {
        buffer.write((ByteString) null);
        return Unit.f696a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ByteStringNetworkRequestBody)) {
            return false;
        }
        ((ByteStringNetworkRequestBody) obj).getClass();
        if (!Intrinsics.a((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ByteStringNetworkRequestBody(bytes=null)";
    }
}
