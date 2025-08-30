package org.greenrobot.eventbus;

import java.util.logging.Level;

final class BackgroundPoster implements Runnable, Poster {
    public final PendingPostQueue c = new Object();
    public final EventBus d;
    public volatile boolean e;

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, org.greenrobot.eventbus.PendingPostQueue] */
    public BackgroundPoster(EventBus eventBus) {
        this.d = eventBus;
    }

    public final void a(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.c.a(a2);
                if (!this.e) {
                    this.e = true;
                    this.d.j.execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                PendingPost c2 = this.c.c();
                if (c2 == null) {
                    synchronized (this) {
                        c2 = this.c.b();
                        if (c2 == null) {
                            this.e = false;
                            this.e = false;
                            return;
                        }
                    }
                }
                this.d.c(c2);
            } catch (InterruptedException e2) {
                try {
                    Logger logger = this.d.p;
                    Level level = Level.WARNING;
                    logger.b(level, Thread.currentThread().getName() + " was interruppted", e2);
                    this.e = false;
                    return;
                } catch (Throwable th) {
                    this.e = false;
                    throw th;
                }
            }
        }
    }
}
