package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/network/NetworkClient;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NetworkClient {
    Object a(NetworkRequest networkRequest, Function2 function2, Continuation continuation);
}
