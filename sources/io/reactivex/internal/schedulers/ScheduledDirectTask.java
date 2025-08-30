package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    public Runnable getWrappedRunnable() {
        return this.c;
    }

    public Void call() throws Exception {
        FutureTask futureTask = AbstractDirectTask.e;
        this.d = Thread.currentThread();
        try {
            this.c.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.d = null;
        }
    }
}
