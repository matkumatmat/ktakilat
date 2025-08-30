package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {
    public static final Notification b = new Notification((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f656a;

    public Notification(Object obj) {
        this.f656a = obj;
    }

    public static Notification a(Throwable th) {
        ObjectHelper.b(th, "error is null");
        return new Notification(NotificationLite.error(th));
    }

    public final Throwable b() {
        Object obj = this.f656a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public final Object c() {
        Object obj = this.f656a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return obj;
    }

    public final boolean d() {
        Object obj = this.f656a;
        if (obj == null || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.a(this.f656a, ((Notification) obj).f656a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f656a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.f656a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + obj + "]";
    }
}
