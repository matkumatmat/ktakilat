package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.facebook.places.model.PlaceFields;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/lifecycle/LifecycleDispatcher;", "", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "context", "Landroid/content/Context;", "DispatcherActivityCallback", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LifecycleDispatcher {
    @NotNull
    public static final LifecycleDispatcher INSTANCE = new LifecycleDispatcher();
    @NotNull
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Landroidx/lifecycle/LifecycleDispatcher$DispatcherActivityCallback;", "Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @VisibleForTesting
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }

    private LifecycleDispatcher() {
    }

    @JvmStatic
    public static final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        if (!initialized.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }
}
