package com.appsflyer.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H%¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00128\u0005@\u0004X\f¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/AFi1pSDK;", "", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "", "getRevenue", "()Ljava/lang/String;", "Lcom/appsflyer/internal/AFi1rSDK;", "getMediationNetwork", "()Lcom/appsflyer/internal/AFi1rSDK;", "Landroid/net/NetworkInfo;", "", "v_", "(Landroid/net/NetworkInfo;)Z", "getMonetizationNetwork", "()Z", "Landroid/net/ConnectivityManager;", "Landroid/net/ConnectivityManager;", "Landroid/telephony/TelephonyManager;", "Landroid/telephony/TelephonyManager;", "getCurrencyIso4217Code", "AFa1uSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AFi1pSDK {
    @NotNull
    public static final AFa1uSDK AFa1uSDK = new AFa1uSDK((DefaultConstructorMarker) null);
    @Nullable
    ConnectivityManager getMonetizationNetwork;
    @Nullable
    private final TelephonyManager getRevenue;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFi1pSDK$AFa1uSDK;", "", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1uSDK {
        private AFa1uSDK() {
        }

        public /* synthetic */ AFa1uSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.telephony.TelephonyManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFi1pSDK(@org.jetbrains.annotations.NotNull android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            boolean r1 = r0 instanceof android.net.ConnectivityManager
            r2 = 0
            if (r1 == 0) goto L_0x0016
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r3.getMonetizationNetwork = r0
            java.lang.String r0 = "phone"
            java.lang.Object r4 = r4.getSystemService(r0)
            boolean r0 = r4 instanceof android.telephony.TelephonyManager
            if (r0 == 0) goto L_0x0026
            r2 = r4
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
        L_0x0026:
            r3.getRevenue = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFi1pSDK.<init>(android.content.Context):void");
    }

    public static boolean v_(@Nullable NetworkInfo networkInfo) {
        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    @NotNull
    public final AFi1rSDK getMediationNetwork() {
        String str;
        Throwable th;
        String str2;
        String str3 = null;
        try {
            TelephonyManager telephonyManager = this.getRevenue;
            if (telephonyManager != null) {
                str = telephonyManager.getSimOperatorName();
                try {
                    str3 = telephonyManager.getNetworkOperatorName();
                    if (str3 != null) {
                        if (str3.length() == 0) {
                        }
                    }
                    if (telephonyManager.getPhoneType() == 2) {
                        str3 = "CDMA";
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    str2 = null;
                    str3 = str;
                    th = th3;
                    AFLogger.afErrorLog("Exception while collecting network info. ", th);
                    str = str3;
                    str3 = str2;
                    return new AFi1rSDK(getRevenue(), str3, str, getMonetizationNetwork());
                }
            } else {
                str = null;
            }
        } catch (Throwable th4) {
            th = th4;
            str2 = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            str = str3;
            str3 = str2;
            return new AFi1rSDK(getRevenue(), str3, str, getMonetizationNetwork());
        }
        return new AFi1rSDK(getRevenue(), str3, str, getMonetizationNetwork());
    }

    public abstract boolean getMonetizationNetwork();

    @NotNull
    public abstract String getRevenue();
}
