package coil3.network;

import coil3.annotation.ExperimentalCoilApi;
import coil3.network.internal.DefaultCacheStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalCoilApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcoil3/network/CacheStrategy;", "", "ReadResult", "WriteResult", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultCacheStrategy f121a = new Object();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil3/network/CacheStrategy$Companion;", "", "Lcoil3/network/CacheStrategy;", "DEFAULT", "Lcoil3/network/CacheStrategy;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/CacheStrategy$ReadResult;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ReadResult {

        /* renamed from: a  reason: collision with root package name */
        public final NetworkResponse f122a;

        public ReadResult(NetworkResponse networkResponse) {
            this.f122a = networkResponse;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReadResult) {
                ReadResult readResult = (ReadResult) obj;
                readResult.getClass();
                if (!Intrinsics.a((Object) null, (Object) null) || !Intrinsics.a(this.f122a, readResult.f122a)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            NetworkResponse networkResponse = this.f122a;
            if (networkResponse != null) {
                return networkResponse.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "ReadResult(request=null, response=" + this.f122a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/network/CacheStrategy$WriteResult;", "", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WriteResult {

        /* renamed from: a  reason: collision with root package name */
        public final NetworkResponse f123a;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/network/CacheStrategy$WriteResult$Companion;", "", "Lcoil3/network/CacheStrategy$WriteResult;", "DISABLED", "Lcoil3/network/CacheStrategy$WriteResult;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
        }

        public WriteResult(NetworkResponse networkResponse) {
            this.f123a = networkResponse;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WriteResult) {
                if (Intrinsics.a(this.f123a, ((WriteResult) obj).f123a)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            NetworkResponse networkResponse = this.f123a;
            if (networkResponse != null) {
                return networkResponse.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "WriteResult(response=" + this.f123a + ')';
        }
    }

    ReadResult a(NetworkResponse networkResponse);

    WriteResult b(NetworkResponse networkResponse, NetworkResponse networkResponse2);
}
