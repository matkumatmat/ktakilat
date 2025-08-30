package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final GenericScheduledExecutorService INSTANCE = new GenericScheduledExecutorService();
    private static final ScheduledExecutorService[] NONE = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService SHUTDOWN;
    private static int roundRobin;
    private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference<>(NONE);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        SHUTDOWN = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    private GenericScheduledExecutorService() {
        start();
    }

    public static ScheduledExecutorService getInstance() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = INSTANCE.executor.get();
        if (scheduledExecutorServiceArr == NONE) {
            return SHUTDOWN;
        }
        int i = roundRobin + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        roundRobin = i;
        return scheduledExecutorServiceArr[i];
    }

    public void shutdown() {
        while (true) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = this.executor.get();
            ScheduledExecutorService[] scheduledExecutorServiceArr2 = NONE;
            if (scheduledExecutorServiceArr != scheduledExecutorServiceArr2) {
                AtomicReference<ScheduledExecutorService[]> atomicReference = this.executor;
                while (true) {
                    if (atomicReference.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2)) {
                        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                            NewThreadWorker.deregisterExecutor(scheduledExecutorService);
                            scheduledExecutorService.shutdownNow();
                        }
                        return;
                    } else if (atomicReference.get() != scheduledExecutorServiceArr) {
                    }
                }
            } else {
                return;
            }
        }
    }

    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < availableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = GenericScheduledExecutorServiceFactory.create();
        }
        AtomicReference<ScheduledExecutorService[]> atomicReference = this.executor;
        ScheduledExecutorService[] scheduledExecutorServiceArr2 = NONE;
        while (!atomicReference.compareAndSet(scheduledExecutorServiceArr2, scheduledExecutorServiceArr)) {
            if (atomicReference.get() != scheduledExecutorServiceArr2) {
                while (i < availableProcessors) {
                    scheduledExecutorServiceArr[i].shutdownNow();
                    i++;
                }
                return;
            }
        }
        while (i < availableProcessors) {
            ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
            if (!NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor) scheduledExecutorService);
            }
            i++;
        }
    }
}
