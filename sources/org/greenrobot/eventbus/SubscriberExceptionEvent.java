package org.greenrobot.eventbus;

import com.ktakilat.cbase.ui.BaseActivity;

public final class SubscriberExceptionEvent {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f835a;
    public final Object b;
    public final BaseActivity c;

    public SubscriberExceptionEvent(Throwable th, Object obj, BaseActivity baseActivity) {
        this.f835a = th;
        this.b = obj;
        this.c = baseActivity;
    }
}
