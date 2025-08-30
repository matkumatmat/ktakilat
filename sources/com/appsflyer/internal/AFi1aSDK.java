package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1qSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;

public class AFi1aSDK extends AFi1dSDK {
    public final Map<String, Object> getCurrencyIso4217Code = new HashMap();
    @NonNull
    final ExecutorService getMonetizationNetwork;

    public AFi1aSDK(@NonNull Runnable runnable, @NonNull ExecutorService executorService, @NonNull AFc1pSDK aFc1pSDK) {
        super("store", "google", aFc1pSDK, runnable);
        this.getMonetizationNetwork = executorService;
    }

    private boolean AFAdRevenueData(@NonNull Context context) {
        if (!getRevenue()) {
            return false;
        }
        try {
            if (AFj1iSDK.getMonetizationNetwork(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install referrer is allowed");
                return true;
            }
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly("InstallReferrerClient not found", e);
            AFLogger.INSTANCE.v(AFg1cSDK.REFERRER, "Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public final void getRevenue(final Context context) {
        if (AFAdRevenueData(context)) {
            this.component1 = System.currentTimeMillis();
            this.component4 = AFj1qSDK.AFa1ySDK.STARTED;
            addObserver(new Observer() {
                public final void update(Observable observable, Object obj) {
                    AFj1qSDK.this.getRevenue.run();
                }
            });
            try {
                final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Connecting to Install Referrer Library...");
                build.startConnection(new InstallReferrerStateListener() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void lambda$onInstallReferrerSetupFinished$0(InstallReferrerClient installReferrerClient, Context context, int i) {
                        AFi1aSDK.this.getRevenue(installReferrerClient, context, i);
                    }

                    public final void onInstallReferrerServiceDisconnected() {
                        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install Referrer service disconnected");
                    }

                    public final void onInstallReferrerSetupFinished(int i) {
                        AFi1aSDK.this.getMonetizationNetwork.execute(new m(this, build, context, i));
                    }
                });
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "referrerClient -> startConnection", th);
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final void getRevenue(InstallReferrerClient installReferrerClient, Context context, int i) {
        this.getCurrencyIso4217Code.put("code", String.valueOf(i));
        this.AFAdRevenueData.put("api_ver", Long.valueOf(AFj1iSDK.AFAdRevenueData(context, "com.android.vending")));
        this.AFAdRevenueData.put("api_ver_name", AFj1iSDK.getMediationNetwork(context, "com.android.vending"));
        if (i == -1) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer SERVICE_DISCONNECTED");
            this.AFAdRevenueData.put("response", "SERVICE_DISCONNECTED");
        } else if (i == 0) {
            this.AFAdRevenueData.put("response", "OK");
            try {
                AFLogger aFLogger = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK = AFg1cSDK.REFERRER;
                aFLogger.d(aFg1cSDK, "InstallReferrer connected");
                if (installReferrerClient.isReady()) {
                    ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null) {
                        this.getCurrencyIso4217Code.put("val", installReferrer2);
                        this.AFAdRevenueData.put("referrer", installReferrer2);
                    }
                    long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                    this.getCurrencyIso4217Code.put("clk", Long.toString(referrerClickTimestampSeconds));
                    this.AFAdRevenueData.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                    long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                    this.getCurrencyIso4217Code.put("install", Long.toString(installBeginTimestampSeconds));
                    this.AFAdRevenueData.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                    HashMap hashMap = new HashMap();
                    boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                    this.getCurrencyIso4217Code.put("instant", Boolean.valueOf(googlePlayInstantParam));
                    hashMap.put("instant", Boolean.valueOf(googlePlayInstantParam));
                    try {
                        hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                        hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                        hashMap.put("install_version", installReferrer.getInstallVersion());
                    } catch (NoSuchMethodError e) {
                        AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "some method not exist", e, false, false);
                    }
                    if (!hashMap.isEmpty()) {
                        this.AFAdRevenueData.put("google_custom", hashMap);
                    }
                    installReferrerClient.endConnection();
                } else {
                    aFLogger.w(aFg1cSDK, "ReferrerClient: InstallReferrer is not ready");
                    this.getCurrencyIso4217Code.put(NotificationCompat.CATEGORY_ERROR, "ReferrerClient: InstallReferrer is not ready");
                }
            } catch (NoSuchMethodError e2) {
                AFLogger.afErrorLogForExcManagerOnly("getGooglePlayInstantParam not exist", e2);
            } catch (Throwable th) {
                Throwable th2 = th;
                AFLogger aFLogger2 = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK2 = AFg1cSDK.REFERRER;
                StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                sb.append(th2.getMessage());
                aFLogger2.w(aFg1cSDK2, sb.toString());
                this.getCurrencyIso4217Code.put(NotificationCompat.CATEGORY_ERROR, th2.getMessage());
                aFLogger2.e(aFg1cSDK2, "Failed to get install referrer", th2, false, false);
            }
        } else if (i == 1) {
            this.AFAdRevenueData.put("response", "SERVICE_UNAVAILABLE");
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer not supported");
        } else if (i == 2) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer FEATURE_NOT_SUPPORTED");
            this.AFAdRevenueData.put("response", "FEATURE_NOT_SUPPORTED");
        } else if (i != 3) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "responseCode not found.");
        } else {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer DEVELOPER_ERROR");
            this.AFAdRevenueData.put("response", "DEVELOPER_ERROR");
        }
        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install Referrer collected locally");
        getMediationNetwork();
    }
}
