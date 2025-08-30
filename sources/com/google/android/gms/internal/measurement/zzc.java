package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzc {
    @VisibleForTesting
    final zzf zza;
    @VisibleForTesting
    zzg zzb;
    @VisibleForTesting
    final zzab zzc = new zzab();
    private final zzz zzd = new zzz();

    public zzc() {
        zzf zzf = new zzf();
        this.zza = zzf;
        this.zzb = zzf.zzb.zzc();
        zzf.zzd.zza("internal.registerCallback", new zzb(this));
        zzf.zzd.zza("internal.eventLogger", new zza(this));
    }

    public final void zza(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zzb(zzaa zzaa) throws zzd {
        try {
            zzab zzab = this.zzc;
            zzab.zzb(zzaa);
            this.zza.zzc.zze("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.zzd.zzb(this.zzb.zzc(), zzab);
            if (zzc() || zzd()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzc() {
        zzab zzab = this.zzc;
        if (!zzab.zzc().equals(zzab.zza())) {
            return true;
        }
        return false;
    }

    public final boolean zzd() {
        if (!this.zzc.zzf().isEmpty()) {
            return true;
        }
        return false;
    }

    public final zzab zze() {
        return this.zzc;
    }

    public final void zzf(zzja zzja) throws zzd {
        zzai zzai;
        try {
            zzf zzf = this.zza;
            this.zzb = zzf.zzb.zzc();
            if (!(zzf.zza(this.zzb, (zzje[]) zzja.zza().toArray(new zzje[0])) instanceof zzag)) {
                for (zziy zziy : zzja.zzb().zza()) {
                    List zzb2 = zziy.zzb();
                    String zza2 = zziy.zza();
                    Iterator it = zzb2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            zzao zza3 = zzf.zza(this.zzb, (zzje) it.next());
                            if (zza3 instanceof zzal) {
                                zzg zzg = this.zzb;
                                if (!zzg.zzd(zza2)) {
                                    zzai = null;
                                } else {
                                    zzao zzh = zzg.zzh(zza2);
                                    if (zzh instanceof zzai) {
                                        zzai = (zzai) zzh;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zza2)));
                                    }
                                }
                                if (zzai != null) {
                                    zzai.zza(this.zzb, Collections.singletonList(zza3));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zza2)));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final /* synthetic */ zzai zzg() {
        return new zzv(this.zzd);
    }
}
