package com.appsflyer.internal;

import android.net.TrafficStats;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AFe1sSDK<Result> implements Comparable<AFe1sSDK<?>>, Callable<AFe1rSDK> {
    private static final AtomicInteger component4 = new AtomicInteger();
    @NonNull
    public final Set<AFe1mSDK> AFAdRevenueData = new HashSet();
    @Nullable
    private Throwable areAllFieldsValid;
    private final String component1;
    private final int component2;
    private long component3;
    @NonNull
    public final Set<AFe1mSDK> getCurrencyIso4217Code;
    @Nullable
    public AFe1rSDK getMediationNetwork;
    @NonNull
    public final AFe1mSDK getMonetizationNetwork;
    public volatile int getRevenue;
    private boolean hashCode;

    public AFe1sSDK(@NonNull AFe1mSDK aFe1mSDK, @NonNull AFe1mSDK[] aFe1mSDKArr, @Nullable String str) {
        HashSet hashSet = new HashSet();
        this.getCurrencyIso4217Code = hashSet;
        int incrementAndGet = component4.incrementAndGet();
        this.component2 = incrementAndGet;
        this.hashCode = false;
        this.getRevenue = 0;
        this.getMonetizationNetwork = aFe1mSDK;
        Collections.addAll(hashSet, aFe1mSDKArr);
        if (str != null) {
            this.component1 = str;
        } else {
            this.component1 = String.valueOf(incrementAndGet);
        }
    }

    @CallSuper
    @WorkerThread
    public void AFAdRevenueData() {
        this.hashCode = true;
    }

    public final boolean areAllFieldsValid() {
        return this.hashCode;
    }

    /* renamed from: component2 */
    public final AFe1rSDK call() throws Exception {
        TrafficStats.setThreadStatsTag(82339054);
        this.getMediationNetwork = null;
        this.areAllFieldsValid = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.getRevenue++;
        try {
            AFe1rSDK currencyIso4217Code = getCurrencyIso4217Code();
            this.getMediationNetwork = currencyIso4217Code;
            this.component3 = System.currentTimeMillis() - currentTimeMillis;
            getRevenue();
            return currencyIso4217Code;
        } catch (Throwable th) {
            this.component3 = System.currentTimeMillis() - currentTimeMillis;
            getRevenue();
            throw th;
        }
    }

    @Nullable
    public final Throwable component4() {
        return this.areAllFieldsValid;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFe1sSDK aFe1sSDK = (AFe1sSDK) obj;
        if (this.getMonetizationNetwork != aFe1sSDK.getMonetizationNetwork) {
            return false;
        }
        return this.component1.equals(aFe1sSDK.component1);
    }

    @WorkerThread
    @NonNull
    public abstract AFe1rSDK getCurrencyIso4217Code() throws Exception;

    @WorkerThread
    public void getCurrencyIso4217Code(Throwable th) {
    }

    @WorkerThread
    public abstract boolean getMediationNetwork();

    public abstract long getMonetizationNetwork();

    @WorkerThread
    public void getRevenue() {
    }

    public final int hashCode() {
        return this.component1.hashCode() + (this.getMonetizationNetwork.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMonetizationNetwork);
        sb.append("-");
        sb.append(this.component1);
        String obj = sb.toString();
        if (String.valueOf(this.component2).equals(this.component1)) {
            return obj;
        }
        StringBuilder s = e.s(obj, "-");
        s.append(this.component2);
        return s.toString();
    }

    /* renamed from: getCurrencyIso4217Code */
    public final int compareTo(AFe1sSDK<?> aFe1sSDK) {
        int i = this.getMonetizationNetwork.w - aFe1sSDK.getMonetizationNetwork.w;
        if (i != 0) {
            return i;
        }
        if (this.component1.equals(aFe1sSDK.component1)) {
            return 0;
        }
        return this.component2 - aFe1sSDK.component2;
    }
}
