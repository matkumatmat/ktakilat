package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmw implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzr zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zznk zzf;

    public zzmw(zznk zznk, AtomicReference atomicReference, String str, String str2, String str3, zzr zzr, boolean z) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzr;
        this.zze = z;
        Objects.requireNonNull(zznk);
        this.zzf = zznk;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                zznk zznk = this.zzf;
                zzga zzZ = zznk.zzZ();
                if (zzZ == null) {
                    zznk.zzu.zzaV().zzb().zzd("(legacy) Failed to get user properties; not connected to service", (Object) null, this.zzb, this.zzc);
                    atomicReference2.set(Collections.emptyList());
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    zzr zzr = this.zzd;
                    Preconditions.checkNotNull(zzr);
                    atomicReference2.set(zzZ.zzp(this.zzb, this.zzc, this.zze, zzr));
                } else {
                    atomicReference2.set(zzZ.zzq((String) null, this.zzb, this.zzc, this.zze));
                }
                zznk.zzV();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzu.zzaV().zzb().zzd("(legacy) Failed to get user properties; remote exception", (Object) null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
