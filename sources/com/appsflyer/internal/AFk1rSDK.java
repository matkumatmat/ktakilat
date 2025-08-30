package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

public final class AFk1rSDK {
    public final WeakReference<Context> AFAdRevenueData;
    public String getMonetizationNetwork;

    public AFk1rSDK(@NonNull Context context) {
        this.AFAdRevenueData = new WeakReference<>(context);
    }
}
