package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class TimedValue<T> {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        ((TimedValue) obj).getClass();
        if (!Intrinsics.a((Object) null, (Object) null)) {
            return false;
        }
        Duration.Companion companion = Duration.d;
        return true;
    }

    public final int hashCode() {
        Duration.Companion companion = Duration.d;
        return (int) 0;
    }

    public final String toString() {
        return "TimedValue(value=null, duration=" + Duration.h(0) + ')';
    }
}
