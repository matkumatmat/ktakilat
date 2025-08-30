package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

final class zzc {
    private final Map zza = Collections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */
    public int zzb = 0;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle zzc;

    @Nullable
    public final LifecycleCallback zzc(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.zza.get(str));
    }

    public final void zzd(String str, LifecycleCallback lifecycleCallback) {
        if (!this.zza.containsKey(str)) {
            this.zza.put(str, lifecycleCallback);
            if (this.zzb > 0) {
                new zzh(Looper.getMainLooper()).post(new zzb(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ba.o("LifecycleCallback with tag ", str, " already added to this fragment."));
    }

    public final void zze(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        for (LifecycleCallback dump : this.zza.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void zzf(int i, int i2, @Nullable Intent intent) {
        for (LifecycleCallback onActivityResult : this.zza.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void zzg(@Nullable Bundle bundle) {
        Bundle bundle2;
        this.zzb = 1;
        this.zzc = bundle;
        for (Map.Entry entry : this.zza.entrySet()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
    }

    public final void zzh() {
        this.zzb = 5;
        for (LifecycleCallback onDestroy : this.zza.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void zzi() {
        this.zzb = 3;
        for (LifecycleCallback onResume : this.zza.values()) {
            onResume.onResume();
        }
    }

    public final void zzj(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry entry : this.zza.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void zzk() {
        this.zzb = 2;
        for (LifecycleCallback onStart : this.zza.values()) {
            onStart.onStart();
        }
    }

    public final void zzl() {
        this.zzb = 4;
        for (LifecycleCallback onStop : this.zza.values()) {
            onStop.onStop();
        }
    }

    public final boolean zzm() {
        return this.zzb > 0;
    }

    public final boolean zzn() {
        return this.zzb >= 2;
    }
}
