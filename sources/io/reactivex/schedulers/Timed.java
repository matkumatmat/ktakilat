package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f689a;
    public final long b;
    public final TimeUnit c;

    public Timed(Object obj, long j, TimeUnit timeUnit) {
        this.f689a = obj;
        this.b = j;
        ObjectHelper.b(timeUnit, "unit is null");
        this.c = timeUnit;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.a(this.f689a, timed.f689a) || this.b != timed.b || !ObjectHelper.a(this.c, timed.c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        Object obj = this.f689a;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        long j = this.b;
        return this.c.hashCode() + (((i * 31) + ((int) (j ^ (j >>> 31)))) * 31);
    }

    public final String toString() {
        return "Timed[time=" + this.b + ", unit=" + this.c + ", value=" + this.f689a + "]";
    }
}
