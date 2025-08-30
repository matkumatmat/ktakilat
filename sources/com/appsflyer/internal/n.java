package com.appsflyer.internal;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AFj1nSDK d;

    public /* synthetic */ n(AFj1nSDK aFj1nSDK, int i) {
        this.c = i;
        this.d = aFj1nSDK;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.areAllFieldsValid();
                return;
            case 1:
                this.d.component1();
                return;
            default:
                this.d.component4();
                return;
        }
    }
}
