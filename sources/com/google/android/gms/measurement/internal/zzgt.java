package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzgt extends zzje {
    private char zza = 0;
    private long zzb = -1;
    @GuardedBy("this")
    private String zzc;
    private final zzgr zzd = new zzgr(this, 6, false, false);
    private final zzgr zze = new zzgr(this, 6, true, false);
    private final zzgr zzf = new zzgr(this, 6, false, true);
    private final zzgr zzg = new zzgr(this, 5, false, false);
    private final zzgr zzh = new zzgr(this, 5, true, false);
    private final zzgr zzi = new zzgr(this, 5, false, true);
    private final zzgr zzj = new zzgr(this, 4, false, false);
    private final zzgr zzk = new zzgr(this, 3, false, false);
    private final zzgr zzl = new zzgr(this, 2, false, false);

    public zzgt(zzib zzib) {
        super(zzib);
    }

    public static Object zzl(String str) {
        if (str == null) {
            return null;
        }
        return new zzgs(str);
    }

    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String zzp = zzp(z, obj);
        String zzp2 = zzp(z, obj2);
        String zzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    public static String zzp(boolean z, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            int length = String.valueOf(round).length();
            if (charAt == '-') {
                str2 = "-";
            }
            int length2 = str2.length() + length;
            StringBuilder sb = new StringBuilder(str2.length() + length2 + 3 + String.valueOf(round2).length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                if (z) {
                    str = th.getClass().getName();
                } else {
                    str = th.toString();
                }
                StringBuilder sb2 = new StringBuilder(str);
                String zzq = zzq(zzib.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length3 = stackTrace.length;
                while (true) {
                    if (i >= length3) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzq(className).equals(zzq)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzgs) {
                return ((zzgs) obj).zza();
            } else {
                if (z) {
                    return "-";
                }
                return obj.toString();
            }
        }
    }

    @VisibleForTesting
    public static String zzq(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) != -1) {
            return str.substring(0, lastIndexOf);
        }
        return "";
    }

    public final boolean zza() {
        return false;
    }

    public final zzgr zzb() {
        return this.zzd;
    }

    public final zzgr zzc() {
        return this.zze;
    }

    public final zzgr zzd() {
        return this.zzf;
    }

    public final zzgr zze() {
        return this.zzg;
    }

    public final zzgr zzf() {
        return this.zzh;
    }

    public final zzgr zzh() {
        return this.zzi;
    }

    public final zzgr zzi() {
        return this.zzj;
    }

    public final zzgr zzj() {
        return this.zzk;
    }

    public final zzgr zzk() {
        return this.zzl;
    }

    public final void zzm(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        int i2;
        if (!z && Log.isLoggable(zzn(), i)) {
            Log.println(i, zzn(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzhy zzi2 = this.zzu.zzi();
            if (zzi2 == null) {
                Log.println(6, zzn(), "Scheduler not set. Not logging error/warn");
            } else if (!zzi2.zzv()) {
                Log.println(6, zzn(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i >= 9) {
                    i2 = 8;
                } else {
                    i2 = i;
                }
                zzi2.zzj(new zzgq(this, i2, str, obj, obj2, obj3));
            }
        }
    }

    @VisibleForTesting
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzn() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzu.zzc().zzb();
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final /* synthetic */ char zzr() {
        return this.zza;
    }

    public final /* synthetic */ void zzs(char c) {
        this.zza = c;
    }

    public final /* synthetic */ long zzt() {
        return this.zzb;
    }

    public final /* synthetic */ void zzu(long j) {
        this.zzb = 130000;
    }
}
