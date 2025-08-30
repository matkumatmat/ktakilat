package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class HandlerPoster extends Handler implements Poster {
    public final PendingPostQueue c = new Object();
    public final int d = 10;
    public final EventBus e;
    public boolean f;

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Object, org.greenrobot.eventbus.PendingPostQueue] */
    public HandlerPoster(EventBus eventBus, Looper looper) {
        super(looper);
        this.e = eventBus;
    }

    public final void a(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.c.a(a2);
                if (!this.f) {
                    this.f = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost b = this.c.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.c.b();
                        if (b == null) {
                            this.f = false;
                            return;
                        }
                    }
                }
                this.e.c(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.d));
            if (sendMessage(obtainMessage())) {
                this.f = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f = false;
            throw th;
        }
    }
}
