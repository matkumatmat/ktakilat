package org.greenrobot.eventbus;

import java.util.ArrayList;

final class PendingPost {
    public static final ArrayList d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Object f833a;
    public Subscription b;
    public PendingPost c;

    /* JADX WARNING: type inference failed for: r0v1, types: [org.greenrobot.eventbus.PendingPost, java.lang.Object] */
    public static PendingPost a(Subscription subscription, Object obj) {
        ArrayList arrayList = d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size > 0) {
                    PendingPost pendingPost = (PendingPost) arrayList.remove(size - 1);
                    pendingPost.f833a = obj;
                    pendingPost.b = subscription;
                    pendingPost.c = null;
                    return pendingPost;
                }
                ? obj2 = new Object();
                obj2.f833a = obj;
                obj2.b = subscription;
                return obj2;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
