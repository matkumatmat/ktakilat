package rx.android.schedulers;

import android.os.Handler;
import rx.Scheduler;

@Deprecated
public final class HandlerScheduler extends LooperScheduler {
    private HandlerScheduler(Handler handler) {
        super(handler);
    }

    @Deprecated
    public static HandlerScheduler from(Handler handler) {
        if (handler != null) {
            return new HandlerScheduler(handler);
        }
        throw new NullPointerException("handler == null");
    }

    public /* bridge */ /* synthetic */ Scheduler.Worker createWorker() {
        return super.createWorker();
    }
}
