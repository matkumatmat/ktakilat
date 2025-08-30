package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import com.appsflyer.AFLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(31)
@SourceDebugExtension({"SMAP\nNetworkDataCollectorApi31.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkDataCollectorApi31.kt\ncom/appsflyer/internal/network/NetworkDataCollectorApi31\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n1#2:74\n*E\n"})
public final class AFi1sSDK extends AFi1pSDK {
    /* access modifiers changed from: private */
    @NotNull
    public String AFAdRevenueData = "unknown";
    /* access modifiers changed from: private */
    @Nullable
    public Network getRevenue;

    public static final class AFa1vSDK extends ConnectivityManager.NetworkCallback {
        private /* synthetic */ AFi1sSDK getRevenue;

        public AFa1vSDK(AFi1sSDK aFi1sSDK) {
            this.getRevenue = aFi1sSDK;
        }

        public final void onAvailable(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "");
            this.getRevenue.getRevenue = network;
        }

        public final void onLost(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "");
            this.getRevenue.getRevenue = network;
            this.getRevenue.AFAdRevenueData = "NetworkLost";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFi1sSDK(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        AFa1vSDK aFa1vSDK = new AFa1vSDK(this);
        try {
            ConnectivityManager connectivityManager = this.getMonetizationNetwork;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), aFa1vSDK);
            }
        } catch (Throwable th) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DEVICE_DATA, "Error at attempt to register network callback with ConnectivityManager", th, true, false, false, false, 96, (Object) null);
        }
    }

    private static boolean y_(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null || !networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(15)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String getRevenue() {
        NetworkCapabilities networkCapabilities;
        Network network = this.getRevenue;
        if (network != null) {
            ConnectivityManager connectivityManager = this.getMonetizationNetwork;
            if (connectivityManager != null) {
                networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            } else {
                networkCapabilities = null;
            }
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(1)) {
                    return "WIFI";
                }
                if (networkCapabilities.hasTransport(0)) {
                    return "MOBILE";
                }
            }
        }
        return "unknown";
    }

    public final boolean getMonetizationNetwork() {
        Network network = this.getRevenue;
        if (network == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = null;
        if (Intrinsics.a(this.AFAdRevenueData, "NetworkLost")) {
            network = null;
        }
        if (network == null) {
            return false;
        }
        ConnectivityManager connectivityManager = this.getMonetizationNetwork;
        if (connectivityManager != null) {
            networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        }
        if (networkCapabilities != null) {
            return y_(networkCapabilities);
        }
        return false;
    }
}
