package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j, long j2, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long nanos;
        long j3 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos2 = timeUnit2.toNanos(j2);
        if (nowNanoSupplier != null) {
            nanos = nowNanoSupplier.nowNanos();
        } else {
            nanos = TimeUnit.MILLISECONDS.toNanos(worker.now());
        }
        long j4 = nanos;
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        SequentialSubscription sequentialSubscription3 = sequentialSubscription2;
        AnonymousClass1 r15 = r3;
        AnonymousClass1 r3 = new Action0(j4, timeUnit2.toNanos(j3) + j4, action0, sequentialSubscription2, nowNanoSupplier, worker, nanos2) {
            long count;
            long lastNowNanos;
            long startInNanos;
            final /* synthetic */ Action0 val$action;
            final /* synthetic */ long val$firstNowNanos;
            final /* synthetic */ long val$firstStartInNanos;
            final /* synthetic */ SequentialSubscription val$mas;
            final /* synthetic */ NowNanoSupplier val$nowNanoSupplier;
            final /* synthetic */ long val$periodInNanos;
            final /* synthetic */ Scheduler.Worker val$worker;

            {
                this.val$firstNowNanos = r1;
                this.val$firstStartInNanos = r3;
                this.val$action = r5;
                this.val$mas = r6;
                this.val$nowNanoSupplier = r7;
                this.val$worker = r8;
                this.val$periodInNanos = r9;
                this.lastNowNanos = r1;
                this.startInNanos = r3;
            }

            public void call() {
                long j;
                long j2;
                this.val$action.call();
                if (!this.val$mas.isUnsubscribed()) {
                    NowNanoSupplier nowNanoSupplier = this.val$nowNanoSupplier;
                    if (nowNanoSupplier != null) {
                        j = nowNanoSupplier.nowNanos();
                    } else {
                        j = TimeUnit.MILLISECONDS.toNanos(this.val$worker.now());
                    }
                    long j3 = SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS;
                    long j4 = this.lastNowNanos;
                    if (j + j3 >= j4) {
                        long j5 = this.val$periodInNanos;
                        if (j < j4 + j5 + j3) {
                            long j6 = this.startInNanos;
                            long j7 = this.count + 1;
                            this.count = j7;
                            j2 = (j7 * j5) + j6;
                            this.lastNowNanos = j;
                            this.val$mas.replace(this.val$worker.schedule(this, j2 - j, TimeUnit.NANOSECONDS));
                        }
                    }
                    long j8 = this.val$periodInNanos;
                    j2 = j + j8;
                    long j9 = this.count + 1;
                    this.count = j9;
                    this.startInNanos = j2 - (j8 * j9);
                    this.lastNowNanos = j;
                    this.val$mas.replace(this.val$worker.schedule(this, j2 - j, TimeUnit.NANOSECONDS));
                }
            }
        };
        sequentialSubscription.replace(worker.schedule(r15, j3, timeUnit2));
        return sequentialSubscription3;
    }
}
