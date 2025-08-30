package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public final class AFj1nSDK implements AFj1lSDK {
    private static final BitSet areAllFieldsValid;
    final Runnable AFAdRevenueData;
    private final SensorManager component1;
    private final Map<AFj1pSDK, Map<String, Object>> component2;
    private final Map<AFj1pSDK, AFj1pSDK> component3;
    private final ExecutorService component4;
    private boolean equals;
    boolean getCurrencyIso4217Code;
    final Object getMediationNetwork;
    final Runnable getMonetizationNetwork;
    final Handler getRevenue;
    private final Runnable hashCode;

    static {
        BitSet bitSet = new BitSet(6);
        areAllFieldsValid = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    @VisibleForTesting
    private AFj1nSDK(@NonNull SensorManager sensorManager, Handler handler, ExecutorService executorService) {
        this.getMediationNetwork = new Object();
        BitSet bitSet = areAllFieldsValid;
        this.component3 = new HashMap(bitSet.size());
        this.component2 = new ConcurrentHashMap(bitSet.size());
        this.AFAdRevenueData = new Runnable() {
            public final void run() {
                synchronized (AFj1nSDK.this.getMediationNetwork) {
                    AFj1nSDK.this.getMonetizationNetwork();
                    AFj1nSDK aFj1nSDK = AFj1nSDK.this;
                    aFj1nSDK.getRevenue.postDelayed(aFj1nSDK.getMonetizationNetwork, 150);
                    AFj1nSDK.this.getCurrencyIso4217Code = true;
                }
            }
        };
        this.getMonetizationNetwork = new n(this, 2);
        this.hashCode = new Runnable() {
            public final void run() {
                synchronized (AFj1nSDK.this.getMediationNetwork) {
                    try {
                        AFj1nSDK aFj1nSDK = AFj1nSDK.this;
                        if (aFj1nSDK.getCurrencyIso4217Code) {
                            aFj1nSDK.getRevenue.removeCallbacks(aFj1nSDK.AFAdRevenueData);
                            AFj1nSDK aFj1nSDK2 = AFj1nSDK.this;
                            aFj1nSDK2.getRevenue.removeCallbacks(aFj1nSDK2.getMonetizationNetwork);
                            AFj1nSDK.this.getMediationNetwork();
                            AFj1nSDK.this.getCurrencyIso4217Code = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.component1 = sensorManager;
        this.getRevenue = handler;
        this.component4 = executorService;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void areAllFieldsValid() {
        try {
            if (!this.component3.isEmpty()) {
                for (AFj1pSDK next : this.component3.values()) {
                    this.component1.unregisterListener(next);
                    next.getMonetizationNetwork(this.component2, true);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
        }
        this.equals = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void component1() {
        try {
            for (Sensor next : this.component1.getSensorList(-1)) {
                if (getMonetizationNetwork(next.getType())) {
                    AFj1pSDK aFj1pSDK = new AFj1pSDK(next, this.component4);
                    if (!this.component3.containsKey(aFj1pSDK)) {
                        this.component3.put(aFj1pSDK, aFj1pSDK);
                    }
                    this.component1.registerListener(this.component3.get(aFj1pSDK), next, 1, this.getRevenue);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
        }
        this.equals = true;
    }

    @VisibleForTesting
    @NonNull
    private List<Map<String, Object>> component2() {
        synchronized (this.getMediationNetwork) {
            try {
                for (AFj1pSDK monetizationNetwork : this.component3.values()) {
                    monetizationNetwork.getMonetizationNetwork(this.component2, true);
                }
                if (this.component2.isEmpty()) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                    return copyOnWriteArrayList;
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.component2.values());
                return copyOnWriteArrayList2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    @NonNull
    private List<Map<String, Object>> component3() {
        synchronized (this.getMediationNetwork) {
            try {
                if (!this.component3.isEmpty() && this.equals) {
                    for (AFj1pSDK monetizationNetwork : this.component3.values()) {
                        monetizationNetwork.getMonetizationNetwork(this.component2, false);
                    }
                }
                if (this.component2.isEmpty()) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                    return copyOnWriteArrayList;
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.component2.values());
                return copyOnWriteArrayList2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void component4() {
        synchronized (this.getMediationNetwork) {
            this.getRevenue.post(new n(this, 0));
        }
    }

    private static boolean getMonetizationNetwork(int i) {
        return i >= 0 && areAllFieldsValid.get(i);
    }

    @NonNull
    public final Map<String, Object> AFAdRevenueData() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> component32 = component3();
        if (!component32.isEmpty()) {
            concurrentHashMap.put("sensors", component32);
        } else {
            List<Map<String, Object>> component22 = component2();
            if (!component22.isEmpty()) {
                concurrentHashMap.put("sensors", component22);
            }
        }
        return concurrentHashMap;
    }

    public final void getCurrencyIso4217Code() {
        this.getRevenue.post(this.hashCode);
        this.getRevenue.post(this.AFAdRevenueData);
    }

    public final void getMediationNetwork() {
        this.getRevenue.post(new n(this, 0));
    }

    public final synchronized void getRevenue() {
        this.getRevenue.post(this.hashCode);
    }

    @VisibleForTesting
    public final void getMonetizationNetwork() {
        this.getRevenue.post(new n(this, 1));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFj1nSDK(@androidx.annotation.NonNull android.content.Context r3, java.util.concurrent.ExecutorService r4) {
        /*
            r2 = this;
            android.content.Context r3 = r3.getApplicationContext()
            java.lang.String r0 = "sensor"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r1 = "internal"
            r0.<init>(r1)
            r0.start()
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r0 = r0.getLooper()
            r1.<init>(r0)
            r2.<init>(r3, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1nSDK.<init>(android.content.Context, java.util.concurrent.ExecutorService):void");
    }
}
