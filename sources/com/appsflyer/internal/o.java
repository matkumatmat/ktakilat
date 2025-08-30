package com.appsflyer.internal;

public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AFj1sSDK d;
    public final /* synthetic */ Runnable e;

    public /* synthetic */ o(AFj1sSDK aFj1sSDK, Runnable runnable, int i) {
        this.c = i;
        this.d = aFj1sSDK;
        this.e = runnable;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.getCurrencyIso4217Code(this.e);
                return;
            case 1:
                this.d.getRevenue(this.e);
                return;
            case 2:
                this.d.component2(this.e);
                return;
            default:
                this.d.getMonetizationNetwork(this.e);
                return;
        }
    }
}
