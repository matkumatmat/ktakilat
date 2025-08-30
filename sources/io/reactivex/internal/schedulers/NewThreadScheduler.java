package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

public final class NewThreadScheduler extends Scheduler {
    public static final RxThreadFactory e = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    public final RxThreadFactory d = e;

    public final Scheduler.Worker a() {
        return new NewThreadWorker(this.d);
    }
}
