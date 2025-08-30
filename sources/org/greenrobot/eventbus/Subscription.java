package org.greenrobot.eventbus;

import com.ktakilat.cbase.ui.BaseActivity;

final class Subscription {

    /* renamed from: a  reason: collision with root package name */
    public final BaseActivity f839a;
    public final SubscriberMethod b;
    public volatile boolean c = true;

    public Subscription(BaseActivity baseActivity, SubscriberMethod subscriberMethod) {
        this.f839a = baseActivity;
        this.b = subscriberMethod;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r4 = (org.greenrobot.eventbus.Subscription) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof org.greenrobot.eventbus.Subscription
            r1 = 0
            if (r0 == 0) goto L_0x0018
            org.greenrobot.eventbus.Subscription r4 = (org.greenrobot.eventbus.Subscription) r4
            com.ktakilat.cbase.ui.BaseActivity r0 = r4.f839a
            com.ktakilat.cbase.ui.BaseActivity r2 = r3.f839a
            if (r2 != r0) goto L_0x0018
            org.greenrobot.eventbus.SubscriberMethod r0 = r3.b
            org.greenrobot.eventbus.SubscriberMethod r4 = r4.b
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0018
            r1 = 1
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.Subscription.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.b.f.hashCode() + this.f839a.hashCode();
    }
}
