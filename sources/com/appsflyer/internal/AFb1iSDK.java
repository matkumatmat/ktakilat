package com.appsflyer.internal;

import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\r"}, d2 = {"Lcom/appsflyer/internal/AFb1iSDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFc1qSDK;", "p0", "", "getRevenue", "(Lcom/appsflyer/internal/AFc1qSDK;)Ljava/lang/String;", "p1", "", "getCurrencyIso4217Code", "(Ljava/lang/String;Lcom/appsflyer/internal/AFc1qSDK;)V", "Ljava/lang/String;", "getMediationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFb1iSDK {
    @NotNull
    public static final AFb1iSDK INSTANCE = new AFb1iSDK();
    @Nullable
    private static String getCurrencyIso4217Code;

    private AFb1iSDK() {
    }

    @JvmStatic
    public static final synchronized void getCurrencyIso4217Code(@NotNull String str, @NotNull AFc1qSDK aFc1qSDK) {
        synchronized (AFb1iSDK.class) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(aFc1qSDK, "");
            getCurrencyIso4217Code = str;
            aFc1qSDK.getCurrencyIso4217Code("CUSTOM_INSTALL_ID_APPLIED", true);
            aFc1qSDK.getMediationNetwork("AF_INSTALLATION", str);
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized String getRevenue(@NotNull AFc1qSDK aFc1qSDK) {
        String str;
        synchronized (AFb1iSDK.class) {
            try {
                Intrinsics.checkNotNullParameter(aFc1qSDK, "");
                if (getCurrencyIso4217Code == null) {
                    String AFAdRevenueData = aFc1qSDK.AFAdRevenueData("AF_INSTALLATION", (String) null);
                    if (AFAdRevenueData == null) {
                        AFAdRevenueData = System.currentTimeMillis() + "-" + Math.abs(new SecureRandom().nextLong());
                        aFc1qSDK.getMediationNetwork("AF_INSTALLATION", AFAdRevenueData);
                    }
                    getCurrencyIso4217Code = AFAdRevenueData;
                }
                str = getCurrencyIso4217Code;
                Intrinsics.c(str);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return str;
    }
}
