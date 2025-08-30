package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioTrack;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.ViewCompat;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AFc1eSDK implements AFc1dSDK {
    private static final int getMediationNetwork = ((int) TimeUnit.SECONDS.toMillis(30));
    public final AFc1iSDK AFAdRevenueData = new AFc1iSDK();
    private AFe1zSDK AFInAppEventParameterName;
    private AFf1gSDK AFInAppEventType;
    private AFd1uSDK AFKeystoreWrapper;
    private AFc1vSDK AFLogger;
    private AFh1uSDK AFPurchaseDetails;
    private AFa1oSDK afDebugLog;
    private AFa1gSDK afErrorLog;
    private String afErrorLogForExcManagerOnly = null;
    private AFa1aSDK afInfoLog;
    private AFe1uSDK afLogForce;
    @Nullable
    private AFi1fSDK afRDLog;
    private AFf1dSDK afVerboseLog;
    private AFg1bSDK afWarnLog;
    private AFc1pSDK areAllFieldsValid;
    private PurchaseHandler component1;
    private AFc1jSDK component2;
    private AFf1oSDK component3;
    private AFd1lSDK component4;
    private AFg1qSDK copy;
    private AFh1vSDK copydefault;
    private AFj1fSDK d;
    private AFb1bSDK e;
    private AFd1pSDK equals;
    private AFg1vSDK force;
    private ExecutorService getCurrencyIso4217Code;
    private AFc1kSDK getLevel;
    private ScheduledExecutorService getMonetizationNetwork;
    private ExecutorService getRevenue;
    private AFj1lSDK hashCode;
    private AFg1uSDK i;
    private AFj1sSDK registerClient;
    private AFe1lSDK toString;
    private AFi1lSDK unregisterClient;
    private AFi1kSDK v;
    private AFg1xSDK values;
    private AFi1tSDK w;

    public static class AFa1ySDK implements ThreadFactory {
        private static final AtomicInteger getCurrencyIso4217Code = new AtomicInteger();
        private final AtomicInteger getMonetizationNetwork = new AtomicInteger();

        public AFa1ySDK() {
            getCurrencyIso4217Code.incrementAndGet();
        }

        public final Thread newThread(Runnable runnable) {
            int i = getCurrencyIso4217Code.get();
            int incrementAndGet = this.getMonetizationNetwork.incrementAndGet();
            StringBuilder sb = new StringBuilder("queue-");
            sb.append(i);
            sb.append("-");
            sb.append(incrementAndGet);
            return new Thread(runnable, sb.toString());
        }
    }

    @NonNull
    private synchronized ExecutorService AFLoggerLogLevel() {
        try {
            if (this.getCurrencyIso4217Code == null) {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "");
                this.getCurrencyIso4217Code = newSingleThreadExecutor;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.getCurrencyIso4217Code;
    }

    /* access modifiers changed from: private */
    @NonNull
    /* renamed from: AFPurchaseDetails */
    public synchronized AFd1uSDK afRDLog() {
        try {
            if (this.AFKeystoreWrapper == null) {
                this.AFKeystoreWrapper = new AFd1uSDK(this);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.AFKeystoreWrapper;
    }

    @NonNull
    private synchronized AFd1lSDK afLogForce() {
        try {
            if (this.component4 == null) {
                this.component4 = new AFd1lSDK(new AFd1jSDK(getMediationNetwork), getMonetizationNetwork());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.component4;
    }

    @NonNull
    private synchronized AFj1fSDK getLevel() {
        try {
            if (this.d == null) {
                this.d = new AFj1fSDK(getRevenue());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SharedPreferences m_() {
        Context context = this.AFAdRevenueData.getMonetizationNetwork;
        if (context != null) {
            return AFa1tSDK.c_(context);
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    @NonNull
    private String valueOf() {
        if (this.afErrorLogForExcManagerOnly == null) {
            this.afErrorLogForExcManagerOnly = new AFa1vSDK().getMonetizationNetwork();
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @NonNull
    private synchronized AFg1xSDK values() {
        try {
            if (this.values == null) {
                this.values = new AFg1xSDK(AFInAppEventType(), getRevenue());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.values;
    }

    @NonNull
    public final synchronized ScheduledExecutorService AFAdRevenueData() {
        try {
            if (this.getMonetizationNetwork == null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
                Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "");
                this.getMonetizationNetwork = newScheduledThreadPool;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.getMonetizationNetwork;
    }

    @NonNull
    public final synchronized AFc1vSDK AFInAppEventParameterName() {
        try {
            if (this.AFLogger == null) {
                this.AFLogger = new AFc1tSDK(AFInAppEventType(), component2());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.AFLogger;
    }

    @NonNull
    public final synchronized AFc1iSDK AFInAppEventType() {
        return this.AFAdRevenueData;
    }

    @NonNull
    public final synchronized AFe1zSDK AFKeystoreWrapper() {
        try {
            if (this.AFInAppEventParameterName == null) {
                this.AFInAppEventParameterName = new AFe1zSDK(getRevenue(), component2());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.AFInAppEventParameterName;
    }

    @NonNull
    public final synchronized AFj1sSDK AFLogger() {
        try {
            if (this.registerClient == null) {
                this.registerClient = new AFj1sSDK(this);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.registerClient;
    }

    @NonNull
    public final AFb1bSDK afDebugLog() {
        if (this.e == null) {
            ExecutorService AFLoggerLogLevel = AFLoggerLogLevel();
            ScheduledExecutorService AFAdRevenueData2 = AFAdRevenueData();
            AFa1oSDK d2 = d();
            if (this.v == null) {
                this.v = new AFi1oSDK();
            }
            this.e = new AFb1aSDK(AFLoggerLogLevel, AFAdRevenueData2, d2, this.v);
        }
        return this.e;
    }

    @NonNull
    public final AFf1dSDK afErrorLog() {
        if (this.afVerboseLog == null) {
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            if (context != null) {
                AFf1bSDK aFf1bSDK = new AFf1bSDK(context, AppsFlyerProperties.getInstance());
                if (this.getLevel == null) {
                    this.getLevel = new AFc1kSDK();
                }
                this.afVerboseLog = new AFf1fSDK(aFf1bSDK, this.getLevel, AppsFlyerProperties.getInstance());
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.afVerboseLog;
    }

    @Nullable
    public final AFh1uSDK afErrorLogForExcManagerOnly() {
        if (AFh1sSDK.getCurrencyIso4217Code() && this.AFPurchaseDetails == null) {
            this.AFPurchaseDetails = new AFh1pSDK(getRevenue(), AFLogger());
        }
        return this.AFPurchaseDetails;
    }

    @NonNull
    public final AFc1kSDK afInfoLog() {
        if (this.getLevel == null) {
            this.getLevel = new AFc1kSDK();
        }
        return this.getLevel;
    }

    @NonNull
    public final AFa1gSDK afVerboseLog() {
        if (this.afErrorLog == null) {
            this.afErrorLog = new AFa1lSDK(component2());
        }
        return this.afErrorLog;
    }

    @NonNull
    public final AFb1hSDK afWarnLog() {
        if (this.getLevel == null) {
            this.getLevel = new AFc1kSDK();
        }
        return new AFb1cSDK(this.getLevel, AFInAppEventType(), registerClient());
    }

    @NonNull
    public final synchronized AFh1vSDK areAllFieldsValid() {
        try {
            if (this.copydefault == null) {
                this.copydefault = new AFh1vSDK(component2());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.copydefault;
    }

    @NonNull
    public final synchronized AFf1oSDK component1() {
        try {
            if (this.component3 == null) {
                AFf1lSDK aFf1lSDK = new AFf1lSDK(component2());
                this.component3 = new AFf1oSDK(new AFf1pSDK(), getRevenue(), registerClient(), aFf1lSDK, new AFd1oSDK(afLogForce(), getRevenue(), AppsFlyerProperties.getInstance(), AFKeystoreWrapper(), getLevel()), new AFf1iSDK(getRevenue(), aFf1lSDK), copydefault());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.component3;
    }

    @NonNull
    public final AFc1qSDK component2() {
        if (this.component2 == null) {
            this.component2 = new AFc1jSDK(new AFc1hSDK(new e(this, 1)));
        }
        return this.component2;
    }

    @NonNull
    public final AFg1qSDK component3() {
        if (this.copy == null) {
            String valueOf = valueOf();
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            if (context != null) {
                if (this.unregisterClient == null) {
                    this.unregisterClient = new AFi1mSDK();
                }
                AFi1lSDK aFi1lSDK = this.unregisterClient;
                if (this.i == null) {
                    this.i = new AFg1sSDK();
                }
                AFg1uSDK aFg1uSDK = this.i;
                if (this.hashCode == null) {
                    Context context2 = this.AFAdRevenueData.getMonetizationNetwork;
                    if (context2 != null) {
                        this.hashCode = new AFj1nSDK(context2, AFLoggerLogLevel());
                    } else {
                        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                    }
                }
                AFj1lSDK aFj1lSDK = this.hashCode;
                if (this.force == null) {
                    this.force = new AFg1tSDK();
                }
                AFg1vSDK aFg1vSDK = this.force;
                AFh1vSDK areAllFieldsValid2 = areAllFieldsValid();
                AFc1qSDK component22 = component2();
                AFc1pSDK revenue = getRevenue();
                if (this.w == null) {
                    Context context3 = this.AFAdRevenueData.getMonetizationNetwork;
                    if (context3 != null) {
                        this.w = new AFi1tSDK(context3);
                    } else {
                        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                    }
                }
                AFi1tSDK aFi1tSDK = this.w;
                AFf1gSDK registerClient2 = registerClient();
                AFc1iSDK AFInAppEventType2 = AFInAppEventType();
                AFg1xSDK values2 = values();
                if (this.getLevel == null) {
                    this.getLevel = new AFc1kSDK();
                }
                this.copy = new AFg1oSDK(valueOf, context, aFi1lSDK, aFg1uSDK, aFj1lSDK, aFg1vSDK, areAllFieldsValid2, component22, revenue, aFi1tSDK, registerClient2, AFInAppEventType2, values2, this.getLevel);
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.copy;
    }

    @NonNull
    public final synchronized PurchaseHandler component4() {
        try {
            if (this.component1 == null) {
                this.component1 = new PurchaseHandler(this);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.component1;
    }

    @NonNull
    public final synchronized AFd1pSDK copy() {
        try {
            if (this.equals == null) {
                this.equals = new AFd1kSDK(this);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.equals;
    }

    @NonNull
    public final synchronized AFe1lSDK copydefault() {
        try {
            if (this.toString == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() {
                    /* access modifiers changed from: private */
                    /* renamed from: getMediationNetwork */
                    public boolean offer(Runnable runnable) {
                        if (isEmpty()) {
                            return super.offer(runnable);
                        }
                        return false;
                    }
                }, new AFa1ySDK());
                threadPoolExecutor.setRejectedExecutionHandler(new h2(1));
                this.toString = new AFe1lSDK(threadPoolExecutor);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.toString;
    }

    @NonNull
    public final synchronized AFa1oSDK d() {
        try {
            if (this.afDebugLog == null) {
                this.afDebugLog = new AFa1oSDK(this);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.afDebugLog;
    }

    @NonNull
    public final synchronized AFa1aSDK e() {
        try {
            if (this.afInfoLog == null) {
                this.afInfoLog = new AFa1bSDK(AFInAppEventType());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.afInfoLog;
    }

    @NonNull
    public final AFj1lSDK equals() {
        if (this.hashCode == null) {
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            if (context != null) {
                this.hashCode = new AFj1nSDK(context, AFLoggerLogLevel());
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.hashCode;
    }

    @WorkerThread
    @Nullable
    public final AFi1fSDK force() {
        String str;
        try {
            if (this.afRDLog == null) {
                AFc1pSDK revenue = getRevenue();
                AFc1iSDK AFInAppEventType2 = AFInAppEventType();
                Object[] objArr = new Object[3];
                objArr[2] = registerClient();
                objArr[1] = AFInAppEventType2;
                objArr[0] = revenue;
                Map map = AFi1jSDK.e;
                Object obj = map.get(-9506129);
                if (obj == null) {
                    obj = ((Class) AFi1jSDK.AFAdRevenueData(ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0 ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0 ? 0 : -1)) - 1), 37 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getDeclaredConstructor(new Class[]{AFc1pSDK.class, AFc1iSDK.class, AFf1gSDK.class});
                    map.put(-9506129, obj);
                }
                this.afRDLog = (AFi1fSDK) ((Constructor) obj).newInstance(objArr);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.PLAY_INTEGRITY_API;
            if (th2.getMessage() != null) {
                str = th2.getMessage();
            } else {
                str = "";
            }
            aFLogger.e(aFg1cSDK, str, th2, false, false);
        }
        return this.afRDLog;
    }

    @NonNull
    public final AFd1oSDK getCurrencyIso4217Code() {
        return new AFd1oSDK(afLogForce(), getRevenue(), AppsFlyerProperties.getInstance(), AFKeystoreWrapper(), getLevel());
    }

    @NonNull
    public final AFe1uSDK getMediationNetwork() {
        if (this.afLogForce == null) {
            this.afLogForce = new AFe1uSDK(component2(), AFInAppEventType(), getRevenue(), getMonetizationNetwork(), component3(), registerClient(), copydefault());
        }
        return this.afLogForce;
    }

    @NonNull
    public final synchronized ExecutorService getMonetizationNetwork() {
        try {
            if (this.getRevenue == null) {
                this.getRevenue = new AFc1oSDK(0, 5, 60, TimeUnit.SECONDS, new SynchronousQueue(), (Queue) null, 32, (DefaultConstructorMarker) null);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.getRevenue;
    }

    @NonNull
    public final synchronized AFc1pSDK getRevenue() {
        try {
            if (this.areAllFieldsValid == null) {
                AFc1iSDK AFInAppEventType2 = AFInAppEventType();
                AFc1qSDK component22 = component2();
                if (this.getLevel == null) {
                    this.getLevel = new AFc1kSDK();
                }
                this.areAllFieldsValid = new AFc1pSDK(AFInAppEventType2, component22, this.getLevel, getMonetizationNetwork());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.areAllFieldsValid;
    }

    @NonNull
    public final AFi1tSDK i() {
        if (this.w == null) {
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            if (context != null) {
                this.w = new AFi1tSDK(context);
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.w;
    }

    @NonNull
    public final synchronized AFf1gSDK registerClient() {
        try {
            if (this.AFInAppEventType == null) {
                this.AFInAppEventType = new AFf1gSDK(AFInAppEventType(), new AFf1eSDK());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.AFInAppEventType;
    }

    @NonNull
    public final AFi1lSDK unregisterClient() {
        if (this.unregisterClient == null) {
            this.unregisterClient = new AFi1mSDK();
        }
        return this.unregisterClient;
    }

    @NonNull
    public final AFg1bSDK v() {
        if (this.afWarnLog == null) {
            this.afWarnLog = new AFg1aSDK(this);
        }
        return this.afWarnLog;
    }

    @NonNull
    public final AFi1kSDK w() {
        if (this.v == null) {
            this.v = new AFi1oSDK();
        }
        return this.v;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void getMediationNetwork(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e2) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e2);
            Thread.currentThread().interrupt();
        }
    }
}
