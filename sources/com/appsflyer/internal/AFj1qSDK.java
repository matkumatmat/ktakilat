package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public abstract class AFj1qSDK extends Observable {
    public final Map<String, Object> AFAdRevenueData = new HashMap();
    public final String areAllFieldsValid;
    long component1;
    public final String component2;
    public AFa1ySDK component4 = AFa1ySDK.NOT_STARTED;
    final Runnable getRevenue;

    public enum AFa1ySDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public AFj1qSDK(String str, String str2, Runnable runnable) {
        this.getRevenue = runnable;
        this.component2 = str2;
        this.areAllFieldsValid = str;
    }

    public final void getMediationNetwork() {
        this.AFAdRevenueData.put("source", this.component2);
        this.AFAdRevenueData.put("type", this.areAllFieldsValid);
        getMonetizationNetwork();
        this.component4 = AFa1ySDK.FINISHED;
        setChanged();
        notifyObservers();
    }

    public void getMonetizationNetwork() {
        this.AFAdRevenueData.put("latency", Long.valueOf(System.currentTimeMillis() - this.component1));
    }

    public abstract void getRevenue(Context context);
}
