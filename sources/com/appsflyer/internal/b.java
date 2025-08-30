package com.appsflyer.internal;

import com.appsflyer.internal.AFd1vSDK;

public final /* synthetic */ class b implements AFd1vSDK.AFa1ySDK, AFf1mSDK {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFa1tSDK f172a;

    public /* synthetic */ b(AFa1tSDK aFa1tSDK) {
        this.f172a = aFa1tSDK;
    }

    public void onConfigurationChanged(boolean z) {
        this.f172a.getMonetizationNetwork(z);
    }

    public void onRemoteConfigUpdateFinished(AFf1nSDK aFf1nSDK) {
        this.f172a.getCurrencyIso4217Code(aFf1nSDK);
    }
}
