package com.trustdecision.android.bugly;

import com.trustdecision.android.bugly.l1l11i111l.llli1l111ilii1i;
import java.lang.Thread;

public class l1l11i111l implements Thread.UncaughtExceptionHandler {
    Thread.UncaughtExceptionHandler liii1l1lll1;

    public l1l11i111l(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.liii1l1lll1 = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        new llli1l111ilii1i().liii1l1lll1(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.liii1l1lll1;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
