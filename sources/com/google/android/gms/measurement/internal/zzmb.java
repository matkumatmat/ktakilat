package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.List;
import java.util.Objects;

final class zzmb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcu zze;
    final /* synthetic */ zznk zzf;

    public zzmb(zznk zznk, String str, String str2, zzr zzr, boolean z, zzcu zzcu) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzr;
        this.zzd = z;
        this.zze = zzcu;
        Objects.requireNonNull(zznk);
        this.zzf = zznk;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            zznk zznk = this.zzf;
            zzga zzZ = zznk.zzZ();
            if (zzZ == null) {
                zzib zzib = zznk.zzu;
                zzib.zzaV().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                zzib.zzk().zzaq(this.zze, bundle2);
                return;
            }
            zzr zzr = this.zzc;
            Preconditions.checkNotNull(zzr);
            List<zzpk> zzp = zzZ.zzp(this.zza, this.zzb, this.zzd, zzr);
            bundle = new Bundle();
            if (zzp != null) {
                for (zzpk zzpk : zzp) {
                    String str = zzpk.zze;
                    if (str != null) {
                        bundle.putString(zzpk.zzb, str);
                    } else {
                        Long l = zzpk.zzd;
                        if (l != null) {
                            bundle.putLong(zzpk.zzb, l.longValue());
                        } else {
                            Double d = zzpk.zzg;
                            if (d != null) {
                                bundle.putDouble(zzpk.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                zznk.zzV();
                zzib zzib2 = zznk.zzu;
                zzib2.zzk().zzaq(this.zze, bundle);
            } catch (RemoteException e2) {
                e = e2;
                try {
                    this.zzf.zzu.zzaV().zzb().zzc("Failed to get user properties; remote exception", this.zza, e);
                    zznk zznk2 = this.zzf;
                    zznk2.zzu.zzk().zzaq(this.zze, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    zznk zznk3 = this.zzf;
                    zznk3.zzu.zzk().zzaq(this.zze, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
            this.zzf.zzu.zzaV().zzb().zzc("Failed to get user properties; remote exception", this.zza, e);
            zznk zznk22 = this.zzf;
            zznk22.zzu.zzk().zzaq(this.zze, bundle);
        } catch (Throwable th3) {
            th = th3;
            zznk zznk32 = this.zzf;
            zznk32.zzu.zzk().zzaq(this.zze, bundle2);
            throw th;
        }
    }
}
