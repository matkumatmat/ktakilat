package com.appsflyer;

import com.appsflyer.internal.AFg1gSDK;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AFg1gSDK[] d;

    public /* synthetic */ a(AFg1gSDK[] aFg1gSDKArr, int i) {
        this.c = i;
        this.d = aFg1gSDKArr;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AFLogger.getMediationNetwork(this.d);
                return;
            default:
                AFLogger.getCurrencyIso4217Code(this.d);
                return;
        }
    }
}
