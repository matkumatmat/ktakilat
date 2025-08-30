package com.google.android.gms.internal.measurement;

public class zzmv {
    protected volatile zznl zza;
    private volatile zzlg zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return false;
        }
        zzmv zzmv = (zzmv) obj;
        zznl zznl = this.zza;
        zznl zznl2 = zzmv.zza;
        if (zznl == null && zznl2 == null) {
            return zzc().equals(zzmv.zzc());
        }
        if (zznl != null && zznl2 != null) {
            return zznl.equals(zznl2);
        }
        if (zznl != null) {
            zzmv.zzd(zznl.zzcE());
            return zznl.equals(zzmv.zza);
        }
        zzd(zznl2.zzcE());
        return this.zza.equals(zznl2);
    }

    public int hashCode() {
        return 1;
    }

    public final zznl zza(zznl zznl) {
        zznl zznl2 = this.zza;
        this.zzb = null;
        this.zza = zznl;
        return zznl2;
    }

    public final int zzb() {
        if (this.zzb != null) {
            return ((zzlf) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzcn();
        }
        return 0;
    }

    public final zzlg zzc() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    zzlg zzlg = this.zzb;
                    return zzlg;
                }
                if (this.zza == null) {
                    this.zzb = zzlg.zzb;
                } else {
                    this.zzb = this.zza.zzcb();
                }
                zzlg zzlg2 = this.zzb;
                return zzlg2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(zznl zznl) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zznl;
                        this.zzb = zzlg.zzb;
                    } catch (zzmq unused) {
                        this.zzc = true;
                        this.zza = zznl;
                        this.zzb = zzlg.zzb;
                    }
                }
            }
        }
    }
}
