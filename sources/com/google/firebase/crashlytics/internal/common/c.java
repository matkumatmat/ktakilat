package com.google.firebase.crashlytics.internal.common;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ CrashlyticsController c;
    public final /* synthetic */ String d;

    public /* synthetic */ c(CrashlyticsController crashlyticsController, String str) {
        this.c = crashlyticsController;
        this.d = str;
    }

    public final void run() {
        this.c.lambda$openSession$1(this.d);
    }
}
