package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfn;
import java.util.Objects;

final class zzac extends zzab {
    final /* synthetic */ zzad zza;
    private final zzfn zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzac(zzad zzad, String str, int i, zzfn zzfn) {
        super(str, i);
        Objects.requireNonNull(zzad);
        this.zza = zzad;
        this.zzh = zzfn;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return true;
    }

    public final boolean zzc() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v16, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r14, java.lang.Long r15, com.google.android.gms.internal.measurement.zziu r16, boolean r17) {
        /*
            r13 = this;
            r0 = r13
            com.google.android.gms.internal.measurement.zzpq.zza()
            com.google.android.gms.measurement.internal.zzad r1 = r0.zza
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r2 = r1.zzc()
            java.lang.String r3 = r0.zzb
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.zzaD
            boolean r2 = r2.zzp(r3, r4)
            com.google.android.gms.internal.measurement.zzfn r3 = r0.zzh
            boolean r4 = r3.zze()
            boolean r5 = r3.zzf()
            boolean r6 = r3.zzh()
            r7 = 0
            r8 = 1
            if (r4 != 0) goto L_0x002a
            if (r5 != 0) goto L_0x002a
            if (r6 == 0) goto L_0x002c
        L_0x002a:
            r4 = 1
            goto L_0x002d
        L_0x002c:
            r4 = 0
        L_0x002d:
            r5 = 0
            if (r17 == 0) goto L_0x0054
            if (r4 != 0) goto L_0x0054
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            int r2 = r0.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x004e
            int r3 = r3.zzb()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x004e:
            java.lang.String r3 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zzc(r3, r2, r5)
            return r8
        L_0x0054:
            com.google.android.gms.internal.measurement.zzfh r9 = r3.zzd()
            boolean r10 = r9.zzf()
            boolean r11 = r16.zzf()
            if (r11 == 0) goto L_0x0095
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x0083
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zze()
            com.google.android.gms.measurement.internal.zzgm r10 = r1.zzl()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No number filter for long property. property"
            r9.zzb(r11, r10)
            goto L_0x0161
        L_0x0083:
            long r11 = r16.zzg()
            com.google.android.gms.internal.measurement.zzfl r5 = r9.zzd()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zzg(r11, r5)
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zze(r5, r10)
            goto L_0x0161
        L_0x0095:
            boolean r11 = r16.zzj()
            if (r11 == 0) goto L_0x00ce
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x00bc
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zze()
            com.google.android.gms.measurement.internal.zzgm r10 = r1.zzl()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No number filter for double property. property"
            r9.zzb(r11, r10)
            goto L_0x0161
        L_0x00bc:
            double r11 = r16.zzk()
            com.google.android.gms.internal.measurement.zzfl r5 = r9.zzd()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zzh(r11, r5)
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zze(r5, r10)
            goto L_0x0161
        L_0x00ce:
            boolean r11 = r16.zzd()
            if (r11 == 0) goto L_0x0148
            boolean r11 = r9.zza()
            if (r11 != 0) goto L_0x0133
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zze()
            com.google.android.gms.measurement.internal.zzgm r10 = r1.zzl()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No string or number filter defined. property"
            r9.zzb(r11, r10)
            goto L_0x0161
        L_0x00fa:
            java.lang.String r11 = r16.zze()
            boolean r11 = com.google.android.gms.measurement.internal.zzpj.zzm(r11)
            if (r11 == 0) goto L_0x0115
            java.lang.String r5 = r16.zze()
            com.google.android.gms.internal.measurement.zzfl r9 = r9.zzd()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zzi(r5, r9)
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zze(r5, r10)
            goto L_0x0161
        L_0x0115:
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zze()
            com.google.android.gms.measurement.internal.zzgm r10 = r1.zzl()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = r16.zze()
            java.lang.String r12 = "Invalid user property value for Numeric number filter. property, value"
            r9.zzc(r12, r10, r11)
            goto L_0x0161
        L_0x0133:
            java.lang.String r5 = r16.zze()
            com.google.android.gms.internal.measurement.zzfr r9 = r9.zzb()
            com.google.android.gms.measurement.internal.zzgt r11 = r1.zzaV()
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zzf(r5, r9, r11)
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzab.zze(r5, r10)
            goto L_0x0161
        L_0x0148:
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zze()
            com.google.android.gms.measurement.internal.zzgm r10 = r1.zzl()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "User property has no value, property"
            r9.zzb(r11, r10)
        L_0x0161:
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            if (r5 != 0) goto L_0x016e
            java.lang.String r9 = "null"
            goto L_0x016f
        L_0x016e:
            r9 = r5
        L_0x016f:
            java.lang.String r10 = "Property filter result"
            r1.zzb(r10, r9)
            if (r5 != 0) goto L_0x0177
            return r7
        L_0x0177:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.zzd = r1
            if (r6 == 0) goto L_0x0185
            boolean r1 = r5.booleanValue()
            if (r1 == 0) goto L_0x0184
            goto L_0x0185
        L_0x0184:
            return r8
        L_0x0185:
            if (r17 == 0) goto L_0x018d
            boolean r1 = r3.zze()
            if (r1 == 0) goto L_0x018f
        L_0x018d:
            r0.zze = r5
        L_0x018f:
            boolean r1 = r5.booleanValue()
            if (r1 == 0) goto L_0x01ce
            if (r4 == 0) goto L_0x01ce
            boolean r1 = r16.zza()
            if (r1 == 0) goto L_0x01ce
            long r4 = r16.zzb()
            if (r14 == 0) goto L_0x01a7
            long r4 = r14.longValue()
        L_0x01a7:
            if (r2 == 0) goto L_0x01bb
            boolean r1 = r3.zze()
            if (r1 == 0) goto L_0x01bb
            boolean r1 = r3.zzf()
            if (r1 != 0) goto L_0x01bb
            if (r15 == 0) goto L_0x01bb
            long r4 = r15.longValue()
        L_0x01bb:
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x01c8
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r0.zzg = r1
            goto L_0x01ce
        L_0x01c8:
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r0.zzf = r1
        L_0x01ce:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zziu, boolean):boolean");
    }
}
