package org.greenrobot.eventbus;

class AsyncPoster implements Runnable, Poster {
    public final PendingPostQueue c = new Object();
    public final EventBus d;

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, org.greenrobot.eventbus.PendingPostQueue] */
    public AsyncPoster(EventBus eventBus) {
        this.d = eventBus;
    }

    public final void a(Subscription subscription, Object obj) {
        this.c.a(PendingPost.a(subscription, obj));
        this.d.j.execute(this);
    }

    public final void run() {
        PendingPost b = this.c.b();
        if (b != null) {
            this.d.c(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
