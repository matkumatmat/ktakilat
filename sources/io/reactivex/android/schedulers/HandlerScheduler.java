package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    public final Handler d;

    public static final class HandlerWorker extends Scheduler.Worker {
        public final Handler c;
        public volatile boolean d;

        public HandlerWorker(Handler handler) {
            this.c = handler;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.d) {
                return EmptyDisposable.INSTANCE;
            } else {
                Handler handler = this.c;
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(handler, runnable);
                Message obtain = Message.obtain(handler, scheduledRunnable);
                obtain.obj = this;
                this.c.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.d) {
                    return scheduledRunnable;
                }
                this.c.removeCallbacks(scheduledRunnable);
                return EmptyDisposable.INSTANCE;
            }
        }

        public final void dispose() {
            this.d = true;
            this.c.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.d;
        }
    }

    public static final class ScheduledRunnable implements Runnable, Disposable {
        public final Handler c;
        public final Runnable d;
        public volatile boolean e;

        public ScheduledRunnable(Handler handler, Runnable runnable) {
            this.c = handler;
            this.d = runnable;
        }

        public final void dispose() {
            this.e = true;
            this.c.removeCallbacks(this);
        }

        public final boolean isDisposed() {
            return this.e;
        }

        public final void run() {
            try {
                this.d.run();
            } catch (Throwable th) {
                RxJavaPlugins.b(th);
            }
        }
    }

    public HandlerScheduler(Handler handler) {
        this.d = handler;
    }

    public final Scheduler.Worker a() {
        return new HandlerWorker(this.d);
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            Handler handler = this.d;
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(handler, runnable);
            handler.postDelayed(scheduledRunnable, timeUnit.toMillis(j));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
