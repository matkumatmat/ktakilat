package coil3.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/NetworkResponse;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkResponse {

    /* renamed from: a  reason: collision with root package name */
    public final int f131a;
    public final long b;
    public final long c;
    public final NetworkHeaders d;
    public final NetworkResponseBody e;
    public final Object f;

    public NetworkResponse(int i, long j, long j2, NetworkHeaders networkHeaders, NetworkResponseBody networkResponseBody, Object obj) {
        this.f131a = i;
        this.b = j;
        this.c = j2;
        this.d = networkHeaders;
        this.e = networkResponseBody;
        this.f = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r8 = (coil3.network.NetworkResponse) r8;
        r1 = r8.f131a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof coil3.network.NetworkResponse
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            coil3.network.NetworkResponse r8 = (coil3.network.NetworkResponse) r8
            int r1 = r8.f131a
            int r3 = r7.f131a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            long r3 = r7.b
            long r5 = r8.b
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x001c
            return r2
        L_0x001c:
            long r3 = r7.c
            long r5 = r8.c
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0025
            return r2
        L_0x0025:
            coil3.network.NetworkHeaders r1 = r7.d
            coil3.network.NetworkHeaders r3 = r8.d
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r3)
            if (r1 != 0) goto L_0x0030
            return r2
        L_0x0030:
            coil3.network.NetworkResponseBody r1 = r7.e
            coil3.network.NetworkResponseBody r3 = r8.e
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r3)
            if (r1 != 0) goto L_0x003b
            return r2
        L_0x003b:
            java.lang.Object r1 = r7.f
            java.lang.Object r8 = r8.f
            boolean r8 = kotlin.jvm.internal.Intrinsics.a(r1, r8)
            if (r8 != 0) goto L_0x0046
            return r2
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkResponse.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        long j = this.b;
        long j2 = this.c;
        int hashCode = (this.d.f128a.hashCode() + (((((this.f131a * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31;
        int i2 = 0;
        NetworkResponseBody networkResponseBody = this.e;
        if (networkResponseBody == null) {
            i = 0;
        } else {
            i = networkResponseBody.hashCode();
        }
        int i3 = (hashCode + i) * 31;
        Object obj = this.f;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "NetworkResponse(code=" + this.f131a + ", requestMillis=" + this.b + ", responseMillis=" + this.c + ", headers=" + this.d + ", body=" + this.e + ", delegate=" + this.f + ')';
    }
}
