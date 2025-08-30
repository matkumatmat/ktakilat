package com.appsflyer.internal;

import android.content.Context;
import android.hardware.SensorEvent;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AFb1lSDK.getCurrencyIso4217Code((AFb1lSDK) this.d, (AFh1qSDK) this.e);
                return;
            case 1:
                ((AFj1pSDK) this.d).G_((SensorEvent) this.e);
                return;
            case 2:
                AFj1uSDK.getMonetizationNetwork((AFj1uSDK) this.d, (Context) this.e);
                return;
            case 3:
                ((AFj1vSDK) this.d).getCurrencyIso4217Code((Context) this.e);
                return;
            default:
                AFj1zSDK.getMonetizationNetwork((AFj1zSDK) this.d, (Context) this.e);
                return;
        }
    }
}
