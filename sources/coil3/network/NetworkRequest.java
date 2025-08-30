package coil3.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/NetworkRequest;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkRequest {

    /* renamed from: a  reason: collision with root package name */
    public final String f130a;
    public final String b;
    public final NetworkHeaders c;
    public final NetworkRequestBody d;

    public NetworkRequest(String str, String str2, NetworkHeaders networkHeaders, NetworkRequestBody networkRequestBody) {
        this.f130a = str;
        this.b = str2;
        this.c = networkHeaders;
        this.d = networkRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) obj;
        return Intrinsics.a(this.f130a, networkRequest.f130a) && Intrinsics.a(this.b, networkRequest.b) && Intrinsics.a(this.c, networkRequest.c) && Intrinsics.a(this.d, networkRequest.d);
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.c.f128a.hashCode() + ba.d(this.f130a.hashCode() * 31, 31, this.b)) * 31;
        NetworkRequestBody networkRequestBody = this.d;
        if (networkRequestBody == null) {
            i = 0;
        } else {
            i = networkRequestBody.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "NetworkRequest(url=" + this.f130a + ", method=" + this.b + ", headers=" + this.c + ", body=" + this.d + ')';
    }
}
