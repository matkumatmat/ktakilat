package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class zzv extends LifecycleCallback {
    private final List zza = new ArrayList();

    private zzv(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static zzv zza(Activity activity) {
        zzv zzv;
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        synchronized (fragment) {
            try {
                zzv = (zzv) fragment.getCallbackOrNull("TaskOnStopCallback", zzv.class);
                if (zzv == null) {
                    zzv = new zzv(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzv;
    }

    @MainThread
    public final void onStop() {
        synchronized (this.zza) {
            try {
                for (WeakReference weakReference : this.zza) {
                    zzq zzq = (zzq) weakReference.get();
                    if (zzq != null) {
                        zzq.zzc();
                    }
                }
                this.zza.clear();
            } finally {
            }
        }
    }

    public final void zzb(zzq zzq) {
        synchronized (this.zza) {
            this.zza.add(new WeakReference(zzq));
        }
    }
}
