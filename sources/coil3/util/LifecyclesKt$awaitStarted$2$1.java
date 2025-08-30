package coil3.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil3/util/LifecyclesKt$awaitStarted$2$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecyclesKt$awaitStarted$2$1 implements DefaultLifecycleObserver {
    public final /* synthetic */ CancellableContinuationImpl c;

    public LifecyclesKt$awaitStarted$2$1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.c = cancellableContinuationImpl;
    }

    public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        b5.a(this, lifecycleOwner);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        b5.b(this, lifecycleOwner);
    }

    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        b5.c(this, lifecycleOwner);
    }

    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        b5.d(this, lifecycleOwner);
    }

    public final void onStart(LifecycleOwner lifecycleOwner) {
        Result.Companion companion = Result.Companion;
        this.c.resumeWith(Result.m16constructorimpl(Unit.f696a));
    }

    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        b5.f(this, lifecycleOwner);
    }
}
