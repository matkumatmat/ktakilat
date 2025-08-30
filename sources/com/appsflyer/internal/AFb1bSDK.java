package com.appsflyer.internal;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFb1bSDK;", "", "", "getCurrencyIso4217Code", "()Z", "Landroid/content/Context;", "p0", "Lcom/appsflyer/internal/AFb1bSDK$AFa1zSDK;", "p1", "", "AFAdRevenueData", "(Landroid/content/Context;Lcom/appsflyer/internal/AFb1bSDK$AFa1zSDK;)V", "()V", "AFa1vSDK", "AFa1zSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AFb1bSDK {
    @NotNull
    public static final AFa1vSDK AFa1vSDK = AFa1vSDK.AFAdRevenueData;

    public static final class AFa1vSDK {
        static final /* synthetic */ AFa1vSDK AFAdRevenueData = new AFa1vSDK();
        private static long getRevenue = 500;

        private AFa1vSDK() {
        }

        public static long getRevenue() {
            return getRevenue;
        }
    }

    public interface AFa1zSDK {
        void getCurrencyIso4217Code();

        void getRevenue(@NotNull AFh1qSDK aFh1qSDK);
    }

    void AFAdRevenueData();

    void AFAdRevenueData(@NotNull Context context, @NotNull AFa1zSDK aFa1zSDK);

    boolean getCurrencyIso4217Code();
}
