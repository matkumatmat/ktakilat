package coil3.request;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/request/BaseRequestDelegate;", "Lcoil3/request/RequestDelegate;", "job", "Lkotlinx/coroutines/Job;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class BaseRequestDelegate implements RequestDelegate {
    public final Job c;

    public /* synthetic */ BaseRequestDelegate(Job job) {
        this.c = job;
    }

    public final Object a(Continuation continuation) {
        return Unit.f696a;
    }

    public final /* synthetic */ void b() {
    }

    public final /* synthetic */ void complete() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestDelegate)) {
            return false;
        }
        if (!Intrinsics.a(this.c, ((BaseRequestDelegate) obj).c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final /* synthetic */ void start() {
    }

    public final String toString() {
        return "BaseRequestDelegate(job=" + this.c + ')';
    }
}
