package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.RealImageLoader;
import coil3.target.ImageViewTarget;
import coil3.util.LifecyclesKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/request/ViewTargetRequestDelegate;", "Lcoil3/request/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewTargetRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    public final RealImageLoader c;
    public final ImageRequest d;
    public final ImageViewTarget e;
    public final Lifecycle f;
    public final Job g;

    public ViewTargetRequestDelegate(RealImageLoader realImageLoader, ImageRequest imageRequest, ImageViewTarget imageViewTarget, Lifecycle lifecycle, Job job) {
        this.c = realImageLoader;
        this.d = imageRequest;
        this.e = imageViewTarget;
        this.f = lifecycle;
        this.g = job;
    }

    public final Object a(Continuation continuation) {
        Lifecycle lifecycle = this.f;
        if (lifecycle == null) {
            return Unit.f696a;
        }
        Object a2 = LifecyclesKt.a(lifecycle, (ContinuationImpl) continuation);
        if (a2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return a2;
        }
        return Unit.f696a;
    }

    public final void b() {
        ImageViewTarget imageViewTarget = this.e;
        if (!imageViewTarget.d.isAttachedToWindow()) {
            ViewTargetRequestManager a2 = ViewTargetRequestManagerKt.a(imageViewTarget.d);
            ViewTargetRequestDelegate viewTargetRequestDelegate = a2.e;
            if (viewTargetRequestDelegate != null) {
                viewTargetRequestDelegate.c();
            }
            a2.e = this;
            throw new CancellationException("'ViewTarget.view' must be attached to a window.");
        }
    }

    public final void c() {
        this.g.c((CancellationException) null);
        ImageViewTarget imageViewTarget = this.e;
        boolean z = imageViewTarget instanceof LifecycleObserver;
        Lifecycle lifecycle = this.f;
        if (z && lifecycle != null) {
            lifecycle.removeObserver(imageViewTarget);
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
    }

    public final /* synthetic */ void complete() {
    }

    public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        b5.a(this, lifecycleOwner);
    }

    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        ViewTargetRequestManager a2 = ViewTargetRequestManagerKt.a(this.e.d);
        synchronized (a2) {
            Job job = a2.d;
            if (job != null) {
                ((JobSupport) job).c((CancellationException) null);
            }
            GlobalScope globalScope = GlobalScope.c;
            DefaultScheduler defaultScheduler = Dispatchers.f767a;
            a2.d = BuildersKt.b(globalScope, MainDispatcherLoader.f801a.t(), (CoroutineStart) null, new ViewTargetRequestManager$dispose$1(a2, (Continuation) null), 2);
            a2.c = null;
        }
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
        Lifecycle lifecycle = this.f;
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
        ImageViewTarget imageViewTarget = this.e;
        if ((imageViewTarget instanceof LifecycleObserver) && lifecycle != null) {
            lifecycle.removeObserver(imageViewTarget);
            lifecycle.addObserver(imageViewTarget);
        }
        ViewTargetRequestManager a2 = ViewTargetRequestManagerKt.a(imageViewTarget.d);
        ViewTargetRequestDelegate viewTargetRequestDelegate = a2.e;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.c();
        }
        a2.e = this;
    }
}
