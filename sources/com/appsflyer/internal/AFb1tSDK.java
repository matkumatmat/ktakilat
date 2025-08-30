package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AFb1tSDK<T> {
    public final FutureTask<T> AFAdRevenueData = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (AFb1tSDK.this.getMediationNetwork()) {
                return AFb1tSDK.this.getCurrencyIso4217Code();
            }
            return null;
        }
    });
    public final Context getCurrencyIso4217Code;
    public final String getMediationNetwork;
    private final String[] getMonetizationNetwork;
    public final Executor getRevenue;

    public AFb1tSDK(Context context, Executor executor, String str, String... strArr) {
        this.getCurrencyIso4217Code = context;
        this.getMediationNetwork = str;
        this.getMonetizationNetwork = strArr;
        this.getRevenue = executor;
    }

    public abstract T getCurrencyIso4217Code();

    public final boolean getMediationNetwork() {
        try {
            ProviderInfo resolveContentProvider = this.getCurrencyIso4217Code.getPackageManager().resolveContentProvider(this.getMediationNetwork, 128);
            if (resolveContentProvider == null || !Arrays.asList(this.getMonetizationNetwork).contains(AFj1iSDK.N_(this.getCurrencyIso4217Code.getPackageManager(), resolveContentProvider.packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog(e.getMessage(), e, false, true);
            return false;
        }
    }

    @Nullable
    public T getMonetizationNetwork() {
        try {
            return this.AFAdRevenueData.get(500, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            AFLogger.afErrorLog(e.getMessage(), e, false, false);
            return null;
        } catch (InterruptedException | ExecutionException e2) {
            AFLogger.afErrorLog(e2.getMessage(), e2, false, true);
            return null;
        }
    }
}
