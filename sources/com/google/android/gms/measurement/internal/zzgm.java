package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

public final class zzgm {
    protected static final AtomicReference zza = new AtomicReference();
    protected static final AtomicReference zzb = new AtomicReference();
    protected static final AtomicReference zzc = new AtomicReference();
    private final zzgl zzd;

    public zzgm(zzgl zzgl) {
        this.zzd = zzgl;
    }

    private static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z;
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        if (strArr.length == strArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzjl.zzc, zzjl.zza, zza);
    }

    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzjm.zzb, zzjm.zza, zzb);
    }

    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return ba.o("experiment_id(", str, ")");
        }
        return zzg(str, zzjn.zzb, zzjn.zza, zzc);
    }

    public final String zzd(zzbg zzbg) {
        String str;
        zzgl zzgl = this.zzd;
        if (!zzgl.zza()) {
            return zzbg.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzbg.zzc);
        sb.append(",name=");
        sb.append(zza(zzbg.zza));
        sb.append(",params=");
        zzbe zzbe = zzbg.zzb;
        if (zzbe == null) {
            str = null;
        } else if (!zzgl.zza()) {
            str = zzbe.toString();
        } else {
            str = zze(zzbe.zzf());
        }
        sb.append(str);
        return sb.toString();
    }

    public final String zze(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder v = ba.v("Bundle[{");
        for (String next : bundle.keySet()) {
            if (v.length() != 8) {
                v.append(", ");
            }
            v.append(zzb(next));
            v.append("=");
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                str = zzf(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = zzf((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = zzf(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            v.append(str);
        }
        v.append("}]");
        return v.toString();
    }

    public final String zzf(Object[] objArr) {
        String str;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder v = ba.v("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zze(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (v.length() != 1) {
                    v.append(", ");
                }
                v.append(str);
            }
        }
        v.append("]");
        return v.toString();
    }
}
