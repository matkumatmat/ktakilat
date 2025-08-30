package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ReportQueue c;
    public final /* synthetic */ CountDownLatch d;

    public /* synthetic */ a(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.c = reportQueue;
        this.d = countDownLatch;
    }

    public final void run() {
        this.c.lambda$flushScheduledReportsIfAble$0(this.d);
    }
}
