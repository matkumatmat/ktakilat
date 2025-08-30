package com.appsflyer.internal;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AFb1lSDK d;

    public /* synthetic */ g(AFb1lSDK aFb1lSDK, int i) {
        this.c = i;
        this.d = aFb1lSDK;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AFb1lSDK.getRevenue(this.d);
                return;
            default:
                AFb1lSDK.AFAdRevenueData(this.d);
                return;
        }
    }
}
