package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map;

public final class zzjk {
    public static final zzjk zza = new zzjk((Boolean) null, (Boolean) null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjk(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzb = enumMap;
        enumMap.put(zzjj.AD_STORAGE, zzh((Boolean) null));
        enumMap.put(zzjj.ANALYTICS_STORAGE, zzh((Boolean) null));
        this.zzc = i;
    }

    public static zzjk zza(zzjh zzjh, zzjh zzjh2, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put(zzjj.AD_STORAGE, zzjh);
        enumMap.put(zzjj.ANALYTICS_STORAGE, zzjh2);
        return new zzjk(enumMap, -10);
    }

    public static String zzd(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjk zze(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzjk((Boolean) null, (Boolean) null, i);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjj : zzji.STORAGE.zzb()) {
            enumMap.put(zzjj, zzg(bundle.getString(zzjj.zze)));
        }
        return new zzjk(enumMap, i);
    }

    public static zzjk zzf(String str, int i) {
        String str2;
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zza2 = zzji.STORAGE.zza();
        for (int i2 = 0; i2 < zza2.length; i2++) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            zzjj zzjj = zza2[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put(zzjj, zzj(str2.charAt(i3)));
            } else {
                enumMap.put(zzjj, zzjh.UNINITIALIZED);
            }
        }
        return new zzjk(enumMap, i);
    }

    public static zzjh zzg(String str) {
        if (str == null) {
            return zzjh.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzjh.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjh.DENIED;
        }
        return zzjh.UNINITIALIZED;
    }

    public static zzjh zzh(Boolean bool) {
        if (bool == null) {
            return zzjh.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjh.GRANTED;
        }
        return zzjh.DENIED;
    }

    public static String zzi(zzjh zzjh) {
        int ordinal = zzjh.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    public static zzjh zzj(char c) {
        if (c == '+') {
            return zzjh.POLICY;
        }
        if (c == '0') {
            return zzjh.DENIED;
        }
        if (c != '1') {
            return zzjh.UNINITIALIZED;
        }
        return zzjh.GRANTED;
    }

    public static char zzm(zzjh zzjh) {
        if (zzjh == null) {
            return '-';
        }
        int ordinal = zzjh.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal == 2) {
            return '0';
        }
        if (ordinal != 3) {
            return '-';
        }
        return '1';
    }

    public static boolean zzu(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjk)) {
            return false;
        }
        zzjk zzjk = (zzjk) obj;
        for (zzjj zzjj : zzji.STORAGE.zzb()) {
            if (this.zzb.get(zzjj) != zzjk.zzb.get(zzjj)) {
                return false;
            }
        }
        if (this.zzc == zzjk.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzc * 17;
        for (zzjh hashCode : this.zzb.values()) {
            i = (i * 31) + hashCode.hashCode();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzd(this.zzc));
        for (zzjj zzjj : zzji.STORAGE.zzb()) {
            sb.append(",");
            sb.append(zzjj.zze);
            sb.append("=");
            zzjh zzjh = (zzjh) this.zzb.get(zzjj);
            if (zzjh == null) {
                zzjh = zzjh.UNINITIALIZED;
            }
            sb.append(zzjh);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        for (zzjh zzjh : this.zzb.values()) {
            if (zzjh != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zzk() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjj : zzji.STORAGE.zza()) {
            zzjh zzjh = (zzjh) this.zzb.get(zzjj);
            char c = '-';
            if (!(zzjh == null || (ordinal = zzjh.ordinal()) == 0)) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzl() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjj : zzji.STORAGE.zza()) {
            sb.append(zzm((zzjh) this.zzb.get(zzjj)));
        }
        return sb.toString();
    }

    public final Bundle zzn() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String zzi = zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        return bundle;
    }

    public final boolean zzo(zzjj zzjj) {
        if (((zzjh) this.zzb.get(zzjj)) == zzjh.DENIED) {
            return false;
        }
        return true;
    }

    public final zzjh zzp() {
        zzjh zzjh = (zzjh) this.zzb.get(zzjj.AD_STORAGE);
        if (zzjh == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjh;
    }

    public final zzjh zzq() {
        zzjh zzjh = (zzjh) this.zzb.get(zzjj.ANALYTICS_STORAGE);
        if (zzjh == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjh;
    }

    public final boolean zzr(zzjk zzjk) {
        EnumMap enumMap = this.zzb;
        for (zzjj zzjj : (zzjj[]) enumMap.keySet().toArray(new zzjj[0])) {
            zzjh zzjh = (zzjh) enumMap.get(zzjj);
            zzjh zzjh2 = (zzjh) zzjk.zzb.get(zzjj);
            zzjh zzjh3 = zzjh.DENIED;
            if (zzjh == zzjh3 && zzjh2 != zzjh3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzjk zzs(com.google.android.gms.measurement.internal.zzjk r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjj> r1 = com.google.android.gms.measurement.internal.zzjj.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzji r1 = com.google.android.gms.measurement.internal.zzji.STORAGE
            com.google.android.gms.measurement.internal.zzjj[] r1 = r1.zzb()
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x004a
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjh r5 = (com.google.android.gms.measurement.internal.zzjh) r5
            java.util.EnumMap r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzjh r6 = (com.google.android.gms.measurement.internal.zzjh) r6
            if (r5 != 0) goto L_0x0026
            goto L_0x0033
        L_0x0026:
            if (r6 == 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            if (r5 != r7) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            if (r6 == r7) goto L_0x0042
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.POLICY
            if (r5 != r7) goto L_0x0035
        L_0x0033:
            r5 = r6
            goto L_0x0042
        L_0x0035:
            if (r6 == r7) goto L_0x0042
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r5 == r7) goto L_0x0041
            if (r6 != r7) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            com.google.android.gms.measurement.internal.zzjh r5 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            goto L_0x0042
        L_0x0041:
            r5 = r7
        L_0x0042:
            if (r5 == 0) goto L_0x0047
            r0.put(r4, r5)
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004a:
            com.google.android.gms.measurement.internal.zzjk r9 = new com.google.android.gms.measurement.internal.zzjk
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjk.zzs(com.google.android.gms.measurement.internal.zzjk):com.google.android.gms.measurement.internal.zzjk");
    }

    public final zzjk zzt(zzjk zzjk) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjj : zzji.STORAGE.zzb()) {
            zzjh zzjh = (zzjh) this.zzb.get(zzjj);
            if (zzjh == zzjh.UNINITIALIZED) {
                zzjh = (zzjh) zzjk.zzb.get(zzjj);
            }
            if (zzjh != null) {
                enumMap.put(zzjj, zzjh);
            }
        }
        return new zzjk(enumMap, this.zzc);
    }

    private zzjk(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }
}
