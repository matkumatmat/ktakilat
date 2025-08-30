package defpackage;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: q  reason: default package */
public final /* synthetic */ class q implements LifecycleEventObserver {
    public final /* synthetic */ ActivityResultRegistry c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ActivityResultCallback e;
    public final /* synthetic */ ActivityResultContract f;

    public /* synthetic */ q(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.c = activityResultRegistry;
        this.d = str;
        this.e = activityResultCallback;
        this.f = activityResultContract;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResultRegistry.register$lambda$1(this.c, this.d, this.e, this.f, lifecycleOwner, event);
    }
}
