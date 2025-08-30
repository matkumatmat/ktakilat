package coil3.network;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/ConnectivityCheckerApi21;", "Lcoil3/network/ConnectivityChecker;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"MissingPermission"})
final class ConnectivityCheckerApi21 implements ConnectivityChecker {
    public final ConnectivityManager b;

    public ConnectivityCheckerApi21(ConnectivityManager connectivityManager) {
        this.b = connectivityManager;
    }

    public final boolean a() {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }
}
