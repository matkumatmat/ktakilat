package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    public final String c;
    public final int d;
    public final boolean e;

    public static final class RxCustomThread extends Thread implements NonBlockingThread {
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.c + '-' + incrementAndGet();
        if (this.e) {
            thread = new Thread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.d);
        thread.setDaemon(true);
        return thread;
    }

    public String toString() {
        return ba.r(new StringBuilder("RxThreadFactory["), this.c, "]");
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.c = str;
        this.d = i;
        this.e = z;
    }
}
