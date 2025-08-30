package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.LifecyclesKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/request/LifecycleRequestDelegate;", "Lcoil3/request/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    public final Lifecycle c;
    public final Job d;

    public LifecycleRequestDelegate(Lifecycle lifecycle, Job job) {
        this.c = lifecycle;
        this.d = job;
    }

    public final Object a(Continuation continuation) {
        Object a2 = LifecyclesKt.a(this.c, (ContinuationImpl) continuation);
        if (a2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return a2;
        }
        return Unit.f696a;
    }

    public final /* synthetic */ void b() {
    }

    public final void complete() {
        this.c.removeObserver(this);
    }

    public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        b5.a(this, lifecycleOwner);
    }

    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        this.d.c((CancellationException) null);
    }

    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        b5.c(this, lifecycleOwner);
    }

    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        b5.d(this, lifecycleOwner);
    }

    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        b5.e(this, lifecycleOwner);
    }

    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        b5.f(this, lifecycleOwner);
    }

    public final void start() {
        this.c.addObserver(this);
    }
}
