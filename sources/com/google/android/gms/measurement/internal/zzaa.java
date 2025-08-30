package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzff;
import java.util.Objects;

final class zzaa extends zzab {
    final /* synthetic */ zzad zza;
    private final zzff zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaa(zzad zzad, String str, int i, zzff zzff) {
        super(str, i);
        Objects.requireNonNull(zzad);
        this.zza = zzad;
        this.zzh = zzff;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return false;
    }

    public final boolean zzc() {
        return this.zzh.zzg();
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r9v13, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x035f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0360  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r17, java.lang.Long r18, com.google.android.gms.internal.measurement.zzhs r19, long r20, com.google.android.gms.measurement.internal.zzbc r22, boolean r23) {
        /*
            r16 = this;
            r0 = r16
            com.google.android.gms.internal.measurement.zzpq.zza()
            com.google.android.gms.measurement.internal.zzad r1 = r0.zza
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r3 = r2.zzc()
            java.lang.String r4 = r0.zzb
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzaF
            boolean r3 = r3.zzp(r4, r5)
            com.google.android.gms.internal.measurement.zzff r5 = r0.zzh
            boolean r6 = r5.zzm()
            if (r6 == 0) goto L_0x0022
            r6 = r22
            long r6 = r6.zze
            goto L_0x0024
        L_0x0022:
            r6 = r20
        L_0x0024:
            com.google.android.gms.measurement.internal.zzgt r8 = r2.zzaV()
            java.lang.String r8 = r8.zzn()
            r9 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r9)
            r9 = 0
            if (r8 == 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzgt r8 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzk()
            int r10 = r0.zzc
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            boolean r11 = r5.zza()
            if (r11 == 0) goto L_0x0051
            int r11 = r5.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x0052
        L_0x0051:
            r11 = r9
        L_0x0052:
            com.google.android.gms.measurement.internal.zzgm r12 = r2.zzl()
            java.lang.String r13 = r5.zzc()
            java.lang.String r12 = r12.zza(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, event"
            r8.zzd(r13, r10, r11, r12)
            com.google.android.gms.measurement.internal.zzgt r8 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzk()
            com.google.android.gms.measurement.internal.zzpf r1 = r1.zzg
            com.google.android.gms.measurement.internal.zzpj r1 = r1.zzp()
            java.lang.String r1 = r1.zzj(r5)
            java.lang.String r10 = "Filter definition"
            r8.zzb(r10, r1)
        L_0x007a:
            boolean r1 = r5.zza()
            r8 = 0
            if (r1 == 0) goto L_0x039f
            int r1 = r5.zzb()
            r10 = 256(0x100, float:3.59E-43)
            if (r1 <= r10) goto L_0x008b
            goto L_0x039f
        L_0x008b:
            boolean r1 = r5.zzi()
            boolean r4 = r5.zzj()
            boolean r10 = r5.zzm()
            r11 = 1
            if (r1 != 0) goto L_0x009e
            if (r4 != 0) goto L_0x009e
            if (r10 == 0) goto L_0x00a0
        L_0x009e:
            r1 = 1
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            if (r23 == 0) goto L_0x00c7
            if (r1 != 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzgt r1 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            int r2 = r0.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r3 = r5.zza()
            if (r3 == 0) goto L_0x00c1
            int r3 = r5.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
        L_0x00c1:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zzc(r3, r2, r9)
            return r11
        L_0x00c7:
            java.lang.String r4 = r19.zzd()
            boolean r10 = r5.zzg()
            if (r10 == 0) goto L_0x00e7
            com.google.android.gms.internal.measurement.zzfl r10 = r5.zzh()
            java.lang.Boolean r6 = com.google.android.gms.measurement.internal.zzab.zzg(r6, r10)
            if (r6 != 0) goto L_0x00dd
            goto L_0x034a
        L_0x00dd:
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00e7
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x034a
        L_0x00e7:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            java.util.List r7 = r5.zzd()
            java.util.Iterator r7 = r7.iterator()
        L_0x00f4:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0129
            java.lang.Object r10 = r7.next()
            com.google.android.gms.internal.measurement.zzfh r10 = (com.google.android.gms.internal.measurement.zzfh) r10
            java.lang.String r12 = r10.zzh()
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            java.lang.String r7 = "null or empty param name in filter. event"
            r6.zzb(r7, r4)
            goto L_0x034a
        L_0x0121:
            java.lang.String r10 = r10.zzh()
            r6.add(r10)
            goto L_0x00f4
        L_0x0129:
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            java.util.List r10 = r19.zza()
            java.util.Iterator r10 = r10.iterator()
        L_0x0136:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x01bd
            java.lang.Object r12 = r10.next()
            com.google.android.gms.internal.measurement.zzhw r12 = (com.google.android.gms.internal.measurement.zzhw) r12
            java.lang.String r13 = r12.zzb()
            boolean r13 = r6.contains(r13)
            if (r13 == 0) goto L_0x0136
            boolean r13 = r12.zze()
            if (r13 == 0) goto L_0x016a
            java.lang.String r13 = r12.zzb()
            boolean r14 = r12.zze()
            if (r14 == 0) goto L_0x0165
            long r14 = r12.zzf()
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            goto L_0x0166
        L_0x0165:
            r12 = r9
        L_0x0166:
            r7.put(r13, r12)
            goto L_0x0136
        L_0x016a:
            boolean r13 = r12.zzi()
            if (r13 == 0) goto L_0x0188
            java.lang.String r13 = r12.zzb()
            boolean r14 = r12.zzi()
            if (r14 == 0) goto L_0x0183
            double r14 = r12.zzj()
            java.lang.Double r12 = java.lang.Double.valueOf(r14)
            goto L_0x0184
        L_0x0183:
            r12 = r9
        L_0x0184:
            r7.put(r13, r12)
            goto L_0x0136
        L_0x0188:
            boolean r13 = r12.zzc()
            if (r13 == 0) goto L_0x019a
            java.lang.String r13 = r12.zzb()
            java.lang.String r12 = r12.zzd()
            r7.put(r13, r12)
            goto L_0x0136
        L_0x019a:
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r10 = r12.zzb()
            java.lang.String r7 = r7.zzb(r10)
            java.lang.String r10 = "Unknown value for param. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x01bd:
            java.util.List r6 = r5.zzd()
            java.util.Iterator r6 = r6.iterator()
        L_0x01c5:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0348
            java.lang.Object r10 = r6.next()
            com.google.android.gms.internal.measurement.zzfh r10 = (com.google.android.gms.internal.measurement.zzfh) r10
            boolean r12 = r10.zze()
            if (r12 == 0) goto L_0x01df
            boolean r12 = r10.zzf()
            if (r12 == 0) goto L_0x01df
            r12 = 1
            goto L_0x01e0
        L_0x01df:
            r12 = 0
        L_0x01e0:
            java.lang.String r13 = r10.zzh()
            boolean r14 = r13.isEmpty()
            if (r14 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            java.lang.String r7 = "Event has empty param name. event"
            r6.zzb(r7, r4)
            goto L_0x034a
        L_0x0201:
            java.lang.Object r14 = r7.get(r13)
            boolean r15 = r14 instanceof java.lang.Long
            if (r15 == 0) goto L_0x024a
            boolean r15 = r10.zzc()
            if (r15 != 0) goto L_0x022e
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for long param. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x022e:
            java.lang.Long r14 = (java.lang.Long) r14
            long r13 = r14.longValue()
            com.google.android.gms.internal.measurement.zzfl r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.zzab.zzg(r13, r10)
            if (r10 != 0) goto L_0x0240
            goto L_0x034a
        L_0x0240:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01c5
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x034a
        L_0x024a:
            boolean r15 = r14 instanceof java.lang.Double
            if (r15 == 0) goto L_0x028f
            boolean r15 = r10.zzc()
            if (r15 != 0) goto L_0x0273
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for double param. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x0273:
            java.lang.Double r14 = (java.lang.Double) r14
            double r13 = r14.doubleValue()
            com.google.android.gms.internal.measurement.zzfl r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.zzab.zzh(r13, r10)
            if (r10 != 0) goto L_0x0285
            goto L_0x034a
        L_0x0285:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01c5
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x034a
        L_0x028f:
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x0308
            boolean r15 = r10.zza()
            if (r15 == 0) goto L_0x02a8
            java.lang.String r14 = (java.lang.String) r14
            com.google.android.gms.internal.measurement.zzfr r10 = r10.zzb()
            com.google.android.gms.measurement.internal.zzgt r13 = r2.zzaV()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.zzab.zzf(r14, r10, r13)
            goto L_0x02be
        L_0x02a8:
            boolean r15 = r10.zzc()
            if (r15 == 0) goto L_0x02ea
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = com.google.android.gms.measurement.internal.zzpj.zzm(r14)
            if (r15 == 0) goto L_0x02cc
            com.google.android.gms.internal.measurement.zzfl r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.zzab.zzi(r14, r10)
        L_0x02be:
            if (r10 != 0) goto L_0x02c2
            goto L_0x034a
        L_0x02c2:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01c5
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x034a
        L_0x02cc:
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Invalid param value for number filter. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No filter for String param. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x0308:
            if (r14 != 0) goto L_0x032a
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r9 = "Missing param for filter. event, param"
            r6.zzc(r9, r4, r7)
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x034a
        L_0x032a:
            com.google.android.gms.measurement.internal.zzgt r6 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zze()
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgm r7 = r2.zzl()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Unknown param type. event, param"
            r6.zzc(r10, r4, r7)
            goto L_0x034a
        L_0x0348:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
        L_0x034a:
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()
            if (r9 != 0) goto L_0x0357
            java.lang.String r4 = "null"
            goto L_0x0358
        L_0x0357:
            r4 = r9
        L_0x0358:
            java.lang.String r6 = "Event filter result"
            r2.zzb(r6, r4)
            if (r9 != 0) goto L_0x0360
            return r8
        L_0x0360:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.zzd = r2
            boolean r4 = r9.booleanValue()
            if (r4 != 0) goto L_0x036b
            return r11
        L_0x036b:
            r0.zze = r2
            if (r1 == 0) goto L_0x039e
            boolean r1 = r19.zze()
            if (r1 == 0) goto L_0x039e
            long r1 = r19.zzf()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            boolean r2 = r5.zzj()
            if (r2 == 0) goto L_0x0391
            if (r3 == 0) goto L_0x038e
            boolean r2 = r5.zzg()
            if (r2 != 0) goto L_0x038c
            goto L_0x038e
        L_0x038c:
            r1 = r17
        L_0x038e:
            r0.zzg = r1
            goto L_0x039e
        L_0x0391:
            if (r3 == 0) goto L_0x039c
            boolean r2 = r5.zzg()
            if (r2 != 0) goto L_0x039a
            goto L_0x039c
        L_0x039a:
            r1 = r18
        L_0x039c:
            r0.zzf = r1
        L_0x039e:
            return r11
        L_0x039f:
            com.google.android.gms.measurement.internal.zzgt r1 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zze()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgt.zzl(r4)
            boolean r3 = r5.zza()
            if (r3 == 0) goto L_0x03b9
            int r3 = r5.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
        L_0x03b9:
            java.lang.String r3 = java.lang.String.valueOf(r9)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zzc(r4, r2, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzhs, long, com.google.android.gms.measurement.internal.zzbc, boolean):boolean");
    }
}
