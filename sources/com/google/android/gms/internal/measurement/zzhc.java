package com.google.android.gms.internal.measurement;

public final class zzhc extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhc zzk;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzhc zzhc = new zzhc();
        zzk = zzhc;
        zzme.zzcp(zzhc.class, zzhc);
    }

    private zzhc() {
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzhc();
        } else {
            if (i2 == 4) {
                return new zzhb((byte[]) null);
            }
            if (i2 == 5) {
                return zzk;
            }
            throw null;
        }
    }
}
