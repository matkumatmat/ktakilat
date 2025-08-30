package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f679a;
    public static final int b;
    public static final AtomicReference c = new AtomicReference();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    public static final class PurgeProperties {

        /* renamed from: a  reason: collision with root package name */
        public boolean f680a;
        public int b;
    }

    public static final class ScheduledTask implements Runnable {
        public final void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, io.reactivex.internal.schedulers.SchedulerPoolFactory$PurgeProperties] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, java.lang.Runnable] */
    static {
        Properties properties = System.getProperties();
        ? obj = new Object();
        if (properties.containsKey("rx2.purge-enabled")) {
            obj.f680a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
        } else {
            obj.f680a = true;
        }
        if (!obj.f680a || !properties.containsKey("rx2.purge-period-seconds")) {
            obj.b = 1;
        } else {
            try {
                obj.b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                obj.b = 1;
            }
        }
        boolean z = obj.f680a;
        f679a = z;
        b = obj.b;
        if (z) {
            while (true) {
                AtomicReference atomicReference = c;
                Object obj2 = (ScheduledExecutorService) atomicReference.get();
                if (obj2 == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    while (!atomicReference.compareAndSet(obj2, newScheduledThreadPool)) {
                        if (atomicReference.get() != obj2) {
                            newScheduledThreadPool.shutdownNow();
                        }
                    }
                    ? obj3 = new Object();
                    long j = (long) b;
                    newScheduledThreadPool.scheduleAtFixedRate(obj3, j, j, TimeUnit.SECONDS);
                    return;
                }
                return;
            }
        }
    }
}
