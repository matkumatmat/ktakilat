package coil3.network;

import kotlin.Metadata;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NetworkClientKt {
    public static final NetworkResponseBody a(BufferedSource bufferedSource) {
        return new SourceResponseBody(bufferedSource);
    }
}
