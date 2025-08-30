package com.appsflyer.internal;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AFa1tSDK.getRevenue((AFc1dSDK) this.d);
                return;
            default:
                ((AFd1mSDK) this.d).getMonetizationNetwork();
                return;
        }
    }
}
