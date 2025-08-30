package com.appsflyer.internal;

import java.util.Queue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class i implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Queue f174a;

    public /* synthetic */ i(Queue queue) {
        this.f174a = queue;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AFc1oSDK.getCurrencyIso4217Code(this.f174a, runnable, threadPoolExecutor);
    }
}
