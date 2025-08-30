package org.greenrobot.eventbus;

final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    public PendingPost f834a;
    public PendingPost b;

    public final synchronized void a(PendingPost pendingPost) {
        try {
            PendingPost pendingPost2 = this.b;
            if (pendingPost2 != null) {
                pendingPost2.c = pendingPost;
                this.b = pendingPost;
            } else if (this.f834a == null) {
                this.b = pendingPost;
                this.f834a = pendingPost;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized PendingPost b() {
        PendingPost pendingPost;
        pendingPost = this.f834a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.c;
            this.f834a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    public final synchronized PendingPost c() {
        try {
            if (this.f834a == null) {
                wait((long) 1000);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return b();
    }
}
