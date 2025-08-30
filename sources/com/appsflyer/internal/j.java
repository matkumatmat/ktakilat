package com.appsflyer.internal;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AFd1uSDK d;

    public /* synthetic */ j(AFd1uSDK aFd1uSDK, int i) {
        this.c = i;
        this.d = aFd1uSDK;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AFd1uSDK.AFAdRevenueData(this.d);
                return;
            case 1:
                AFd1uSDK.getMediationNetwork(this.d);
                return;
            default:
                AFd1uSDK.getMonetizationNetwork(this.d);
                return;
        }
    }
}
