package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfx, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgc, zzfl zzfl, zzgz zzgz, zzem zzem, zzfs zzfs) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgc;
        this.zzk = zzfl;
        this.zzl = zzgz;
        this.zzm = zzem;
        this.zzg = zzfx;
        this.zzo = zzfs;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, (long) (zzl(i2) & 1048575), i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzo(i) & 1048575), obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzo(i2) & 1048575), obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        if (zzE(obj, i) == zzE(obj2, i)) {
            return true;
        }
        return false;
    }

    private final boolean zzE(Object obj, int i) {
        int zzl2 = zzl(i);
        long j = (long) (zzl2 & 1048575);
        if (j == 1048575) {
            int zzo2 = zzo(i);
            long j2 = (long) (zzo2 & 1048575);
            switch (zzn(zzo2)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzhj.zzd(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzhj.zzd(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzhj.zzd(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzhj.zzt(obj, j2);
                case 8:
                    Object zzf2 = zzhj.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzef)) {
                        throw new IllegalArgumentException();
                    } else if (!zzef.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzhj.zzf(obj, j2) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzef.zzb.equals(zzhj.zzf(obj, j2))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzhj.zzd(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzhj.zzc(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzhj.zzd(obj, j2) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzhj.zzf(obj, j2) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzhj.zzc(obj, j) & (1 << (zzl2 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzE(obj, i);
        }
        if ((i3 & i4) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgi) {
        return zzgi.zzi(zzhj.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        if (zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i) {
            return true;
        }
        return false;
    }

    public static zzha zzc(Object obj) {
        zzev zzev = (zzev) obj;
        zzha zzha = zzev.zzc;
        if (zzha != zzha.zza()) {
            return zzha;
        }
        zzha zzd2 = zzha.zzd();
        zzev.zzc = zzd2;
        return zzd2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x026e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.auth.zzga zzj(java.lang.Class r31, com.google.android.gms.internal.auth.zzfu r32, com.google.android.gms.internal.auth.zzgc r33, com.google.android.gms.internal.auth.zzfl r34, com.google.android.gms.internal.auth.zzgz r35, com.google.android.gms.internal.auth.zzem r36, com.google.android.gms.internal.auth.zzfs r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.auth.zzgh
            if (r1 == 0) goto L_0x03eb
            com.google.android.gms.internal.auth.zzgh r0 = (com.google.android.gms.internal.auth.zzgh) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = zza
            r17 = r7
            r7 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            goto L_0x0166
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0166:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.auth.zzfx r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r22 = r18
            r23 = r19
            r20 = 0
            r21 = 0
        L_0x0186:
            if (r4 >= r2) goto L_0x03c6
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01ae
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0196:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0196
        L_0x01a8:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b0
        L_0x01ae:
            r3 = r24
        L_0x01b0:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01be:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01be
        L_0x01d0:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d8
        L_0x01d6:
            r8 = r24
        L_0x01d8:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e2
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e2:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = 51
            if (r6 < r5) goto L_0x0287
            int r5 = r8 + 1
            char r8 = r1.charAt(r8)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0213
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x01f9:
            int r30 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r2) goto L_0x020e
            r2 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r29
            r8 = r8 | r2
            int r29 = r29 + 13
            r5 = r30
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f9
        L_0x020e:
            int r2 = r5 << r29
            r8 = r8 | r2
            r5 = r30
        L_0x0213:
            int r2 = r6 + -51
            r29 = r5
            r5 = 9
            if (r2 == r5) goto L_0x023c
            r5 = 17
            if (r2 != r5) goto L_0x0220
            goto L_0x023c
        L_0x0220:
            r5 = 12
            if (r2 != r5) goto L_0x0248
            int r2 = r0.zzc()
            r5 = 1
            if (r2 == r5) goto L_0x022f
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0248
        L_0x022f:
            int r2 = r21 / 3
            int r2 = r2 + r2
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
        L_0x0239:
            r16 = r5
            goto L_0x0248
        L_0x023c:
            int r2 = r21 / 3
            int r2 = r2 + r2
            r5 = 1
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
            goto L_0x0239
        L_0x0248:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r5 = r2 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x0255
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
        L_0x0251:
            r5 = r13
            r30 = r14
            goto L_0x025e
        L_0x0255:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzv(r15, r2)
            r10[r8] = r2
            goto L_0x0251
        L_0x025e:
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x026e
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x0276
        L_0x026e:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzv(r15, r13)
            r10[r8] = r13
        L_0x0276:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r27 = r5
            r28 = r16
            r25 = r29
            r5 = r1
            r16 = r8
            r8 = 0
            goto L_0x0387
        L_0x0287:
            r26 = r2
            r5 = r13
            r30 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzv(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x029e
            r14 = 17
            if (r6 != r14) goto L_0x02a3
        L_0x029e:
            r27 = r5
            r5 = 1
            goto L_0x030c
        L_0x02a3:
            r14 = 27
            if (r6 == r14) goto L_0x02ab
            r14 = 49
            if (r6 != r14) goto L_0x02af
        L_0x02ab:
            r27 = r5
            r5 = 1
            goto L_0x0301
        L_0x02af:
            r14 = 12
            if (r6 == r14) goto L_0x02e7
            r14 = 30
            if (r6 == r14) goto L_0x02e7
            r14 = 44
            if (r6 != r14) goto L_0x02bc
            goto L_0x02e7
        L_0x02bc:
            r14 = 50
            if (r6 != r14) goto L_0x02e4
            int r14 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            int r27 = r16 + 2
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02e0
            int r22 = r22 + 1
            int r2 = r16 + 3
            r16 = r10[r27]
            r12[r22] = r16
            r27 = r5
            r22 = r14
        L_0x02de:
            r5 = 1
            goto L_0x0316
        L_0x02e0:
            r22 = r14
            r2 = r27
        L_0x02e4:
            r27 = r5
            goto L_0x02de
        L_0x02e7:
            int r14 = r0.zzc()
            r27 = r5
            r5 = 1
            if (r14 == r5) goto L_0x02f4
            r14 = r3 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0316
        L_0x02f4:
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r16 = r16 + 2
            r2 = r10[r2]
            r12[r14] = r2
        L_0x02fe:
            r2 = r16
            goto L_0x0316
        L_0x0301:
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r16 = r16 + 2
            r2 = r10[r2]
            r12[r14] = r2
            goto L_0x02fe
        L_0x030c:
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            java.lang.Class r16 = r13.getType()
            r12[r14] = r16
        L_0x0316:
            long r13 = r9.objectFieldOffset(r13)
            int r14 = (int) r13
            r13 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r13 == 0) goto L_0x0372
            r13 = 17
            if (r6 > r13) goto L_0x0372
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r5) goto L_0x034b
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0335:
            int r25 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0347
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r16
            r8 = r8 | r13
            int r16 = r16 + 13
            r13 = r25
            goto L_0x0335
        L_0x0347:
            int r13 = r13 << r16
            r8 = r8 | r13
            goto L_0x034d
        L_0x034b:
            r25 = r13
        L_0x034d:
            int r13 = r7 + r7
            int r16 = r8 / 32
            int r16 = r16 + r13
            r13 = r10[r16]
            boolean r5 = r13 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x035f
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
        L_0x035b:
            r5 = r1
            r28 = r2
            goto L_0x0368
        L_0x035f:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzv(r15, r13)
            r10[r16] = r13
            goto L_0x035b
        L_0x0368:
            long r1 = r9.objectFieldOffset(r13)
            int r2 = (int) r1
            int r8 = r8 % 32
            r16 = r2
            goto L_0x0378
        L_0x0372:
            r5 = r1
            r28 = r2
            r25 = r8
            r8 = 0
        L_0x0378:
            r1 = 18
            if (r6 < r1) goto L_0x0386
            r1 = 49
            if (r6 > r1) goto L_0x0386
            int r1 = r23 + 1
            r17[r23] = r14
            r23 = r1
        L_0x0386:
            r2 = r14
        L_0x0387:
            int r1 = r21 + 1
            r11[r21] = r4
            int r4 = r21 + 2
            r13 = r3 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0394
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0395
        L_0x0394:
            r13 = 0
        L_0x0395:
            r14 = r3 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x039c
            r14 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039d
        L_0x039c:
            r14 = 0
        L_0x039d:
            r3 = r3 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x03a4
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03a5
        L_0x03a4:
            r3 = 0
        L_0x03a5:
            int r6 = r6 << 20
            r13 = r13 | r14
            r3 = r3 | r13
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r1] = r2
            int r21 = r21 + 3
            int r1 = r8 << 20
            r1 = r1 | r16
            r11[r4] = r1
            r1 = r5
            r4 = r25
            r2 = r26
            r13 = r27
            r16 = r28
            r14 = r30
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0186
        L_0x03c6:
            r27 = r13
            r30 = r14
            com.google.android.gms.internal.auth.zzga r1 = new com.google.android.gms.internal.auth.zzga
            com.google.android.gms.internal.auth.zzfx r14 = r0.zza()
            int r15 = r0.zzc()
            r16 = 0
            r9 = r1
            r10 = r11
            r11 = r12
            r12 = r27
            r13 = r30
            r20 = r33
            r21 = r34
            r22 = r35
            r23 = r36
            r24 = r37
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x03eb:
            com.google.android.gms.internal.auth.zzgw r0 = (com.google.android.gms.internal.auth.zzgw) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzj(java.lang.Class, com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzgc, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz, com.google.android.gms.internal.auth.zzem, com.google.android.gms.internal.auth.zzfs):com.google.android.gms.internal.auth.zzga");
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgi = (zzgi) this.zzd[i3];
        if (zzgi != null) {
            return zzgi;
        }
        zzgi zzb2 = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzr = zzr(i);
        int zzo2 = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, (long) zzo2);
        if (zzH(object)) {
            return object;
        }
        Object zzd2 = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd2, object);
        }
        return zzd2;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, (long) (zzo(i2) & 1048575));
        if (zzH(object)) {
            return object;
        }
        Object zzd2 = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd2, object);
        }
        return zzd2;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder u = e.u("Field ", str, " for ", name, " not found. Known fields are ");
            u.append(arrays);
            throw new RuntimeException(u.toString());
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzo2 = (long) (zzo(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzo2);
            if (object != null) {
                zzgi zzr = zzr(i);
                if (!zzE(obj, i)) {
                    if (!zzH(object)) {
                        unsafe.putObject(obj, zzo2, object);
                    } else {
                        Object zzd2 = zzr.zzd();
                        zzr.zzf(zzd2, object);
                        unsafe.putObject(obj, zzo2, zzd2);
                    }
                    zzz(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzo2);
                if (!zzH(object2)) {
                    Object zzd3 = zzr.zzd();
                    zzr.zzf(zzd3, object2);
                    unsafe.putObject(obj, zzo2, zzd3);
                    object2 = zzd3;
                }
                zzr.zzf(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzo2 = (long) (zzo(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzo2);
            if (object != null) {
                zzgi zzr = zzr(i);
                if (!zzI(obj, i2, i)) {
                    if (!zzH(object)) {
                        unsafe.putObject(obj, zzo2, object);
                    } else {
                        Object zzd2 = zzr.zzd();
                        zzr.zzf(zzd2, object);
                        unsafe.putObject(obj, zzo2, zzd2);
                    }
                    zzA(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzo2);
                if (!zzH(object2)) {
                    Object zzd3 = zzr.zzd();
                    zzr.zzf(zzd3, object2);
                    unsafe.putObject(obj, zzo2, zzd3);
                    object2 = zzd3;
                }
                zzr.zzf(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzz(Object obj, int i) {
        int zzl2 = zzl(i);
        long j = (long) (1048575 & zzl2);
        if (j != 1048575) {
            zzhj.zzn(obj, j, (1 << (zzl2 >>> 20)) | zzhj.zzc(obj, j));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r2 = r2 + ((int) (r3 ^ (r3 >>> 32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017d, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x022f, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0233
            int r3 = r9.zzo(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzn(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0221;
                case 1: goto L_0x0215;
                case 2: goto L_0x020b;
                case 3: goto L_0x0201;
                case 4: goto L_0x01f9;
                case 5: goto L_0x01ef;
                case 6: goto L_0x01e7;
                case 7: goto L_0x01db;
                case 8: goto L_0x01cd;
                case 9: goto L_0x01c2;
                case 10: goto L_0x01b6;
                case 11: goto L_0x01ae;
                case 12: goto L_0x01a6;
                case 13: goto L_0x019e;
                case 14: goto L_0x0194;
                case 15: goto L_0x018c;
                case 16: goto L_0x0182;
                case 17: goto L_0x0173;
                case 18: goto L_0x0167;
                case 19: goto L_0x0167;
                case 20: goto L_0x0167;
                case 21: goto L_0x0167;
                case 22: goto L_0x0167;
                case 23: goto L_0x0167;
                case 24: goto L_0x0167;
                case 25: goto L_0x0167;
                case 26: goto L_0x0167;
                case 27: goto L_0x0167;
                case 28: goto L_0x0167;
                case 29: goto L_0x0167;
                case 30: goto L_0x0167;
                case 31: goto L_0x0167;
                case 32: goto L_0x0167;
                case 33: goto L_0x0167;
                case 34: goto L_0x0167;
                case 35: goto L_0x0167;
                case 36: goto L_0x0167;
                case 37: goto L_0x0167;
                case 38: goto L_0x0167;
                case 39: goto L_0x0167;
                case 40: goto L_0x0167;
                case 41: goto L_0x0167;
                case 42: goto L_0x0167;
                case 43: goto L_0x0167;
                case 44: goto L_0x0167;
                case 45: goto L_0x0167;
                case 46: goto L_0x0167;
                case 47: goto L_0x0167;
                case 48: goto L_0x0167;
                case 49: goto L_0x0167;
                case 50: goto L_0x015b;
                case 51: goto L_0x0141;
                case 52: goto L_0x0129;
                case 53: goto L_0x0119;
                case 54: goto L_0x0109;
                case 55: goto L_0x00fb;
                case 56: goto L_0x00eb;
                case 57: goto L_0x00dd;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008f;
                case 62: goto L_0x0082;
                case 63: goto L_0x0075;
                case 64: goto L_0x0068;
                case 65: goto L_0x0059;
                case 66: goto L_0x004a;
                case 67: goto L_0x0035;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x022f
        L_0x0021:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
        L_0x0031:
            int r3 = r3 + r2
            r2 = r3
            goto L_0x022f
        L_0x0035:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
        L_0x0043:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r4 = (int) r3
            int r2 = r2 + r4
            goto L_0x022f
        L_0x004a:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
        L_0x0056:
            int r2 = r2 + r3
            goto L_0x022f
        L_0x0059:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x0068:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0056
        L_0x0075:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0056
        L_0x0082:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0056
        L_0x008f:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x00a0:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x00b1:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x00c5:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzfa.zza(r3)
            goto L_0x0031
        L_0x00dd:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0056
        L_0x00eb:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x00fb:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0056
        L_0x0109:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x0119:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x0129:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0031
        L_0x0141:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x022f
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x015b:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x0167:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x0173:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            if (r3 == 0) goto L_0x017d
            int r7 = r3.hashCode()
        L_0x017d:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x022f
        L_0x0182:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x018c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x0194:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x019e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x01a6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x01ae:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x01b6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x01c2:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            if (r3 == 0) goto L_0x017d
            int r7 = r3.hashCode()
            goto L_0x017d
        L_0x01cd:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0031
        L_0x01db:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.zzhj.zzt(r10, r5)
            int r3 = com.google.android.gms.internal.auth.zzfa.zza(r3)
            goto L_0x0031
        L_0x01e7:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x01ef:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x01f9:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0056
        L_0x0201:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x020b:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x0215:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.zzhj.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0031
        L_0x0221:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.zzhj.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0043
        L_0x022f:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0233:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.zzgz r0 = r9.zzl
            java.lang.Object r10 = r0.zzb(r10)
            int r10 = r10.hashCode()
            int r10 = r10 + r2
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v123, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v65, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v110, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v131, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v100, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v126, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v144, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v135, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v125, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v127, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v131, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v141, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v143, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v157, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v155, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v160, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v157, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v158, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v159, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v65, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v160, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v161, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v162, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v164, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v165, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v166, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v169, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v100, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v172, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v173, resolved type: byte} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x082d  */
    /* JADX WARNING: Removed duplicated region for block: B:634:0x0853 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x026b  */
    public final int zzb(java.lang.Object r41, byte[] r42, int r43, int r44, int r45, com.google.android.gms.internal.auth.zzdt r46) throws java.io.IOException {
        /*
            r40 = this;
            r0 = r40
            r7 = r41
            r15 = r42
            r5 = r44
            r6 = r45
            r3 = r46
            r4 = 3
            r1 = 1
            zzw(r41)
            sun.misc.Unsafe r14 = zzb
            r13 = 0
            r12 = -1
            r8 = r43
            r9 = -1
            r10 = 0
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r17 = 0
            r18 = 0
        L_0x0020:
            r19 = 0
            if (r8 >= r5) goto L_0x0ecf
            int r2 = r8 + 1
            byte r8 = r15[r8]
            if (r8 >= 0) goto L_0x0030
            int r2 = com.google.android.gms.internal.auth.zzdu.zzi(r8, r15, r2, r3)
            int r8 = r3.zza
        L_0x0030:
            int r11 = r8 >>> 3
            if (r11 <= r9) goto L_0x0045
            int r10 = r10 / r4
            int r9 = r0.zze
            if (r11 < r9) goto L_0x0042
            int r9 = r0.zzf
            if (r11 > r9) goto L_0x0042
            int r9 = r0.zzm(r11, r10)
            goto L_0x0043
        L_0x0042:
            r9 = -1
        L_0x0043:
            r10 = r9
            goto L_0x0053
        L_0x0045:
            int r9 = r0.zze
            if (r11 < r9) goto L_0x0052
            int r9 = r0.zzf
            if (r11 > r9) goto L_0x0052
            int r9 = r0.zzm(r11, r13)
            goto L_0x0043
        L_0x0052:
            r10 = -1
        L_0x0053:
            if (r10 != r12) goto L_0x006f
            r10 = r5
            r9 = r6
            r0 = r11
            r43 = r14
            r1 = r15
            r24 = r16
            r16 = 3
            r21 = -1
            r23 = 0
            r25 = 0
            r11 = r8
            r8 = 1
            r38 = r3
            r3 = r2
            r2 = r7
            r7 = r38
            goto L_0x0e95
        L_0x006f:
            r9 = r8 & 7
            int[] r12 = r0.zzc
            int r18 = r10 + 1
            r13 = r12[r18]
            int r4 = zzn(r13)
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r13 & r18
            long r5 = (long) r1
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            r26 = 0
            java.lang.String r1 = ""
            r28 = r8
            r8 = 17
            if (r4 > r8) goto L_0x0454
            r20 = 2
            int r8 = r10 + 2
            r8 = r12[r8]
            int r12 = r8 >>> 20
            r25 = 1
            int r29 = r25 << r12
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r12
            r43 = r1
            r1 = r16
            r16 = r13
            if (r8 == r1) goto L_0x00be
            if (r1 == r12) goto L_0x00b0
            long r12 = (long) r1
            r1 = r17
            r14.putInt(r7, r12, r1)
            r12 = 1048575(0xfffff, float:1.469367E-39)
        L_0x00b0:
            if (r8 != r12) goto L_0x00b4
            r1 = 0
            goto L_0x00b9
        L_0x00b4:
            long r12 = (long) r8
            int r1 = r14.getInt(r7, r12)
        L_0x00b9:
            r30 = r1
            r17 = r8
            goto L_0x00c2
        L_0x00be:
            r30 = r17
            r17 = r1
        L_0x00c2:
            switch(r4) {
                case 0: goto L_0x0408;
                case 1: goto L_0x03eb;
                case 2: goto L_0x03c4;
                case 3: goto L_0x03c4;
                case 4: goto L_0x03ac;
                case 5: goto L_0x0389;
                case 6: goto L_0x0370;
                case 7: goto L_0x0351;
                case 8: goto L_0x0220;
                case 9: goto L_0x01f5;
                case 10: goto L_0x01c8;
                case 11: goto L_0x03ac;
                case 12: goto L_0x017e;
                case 13: goto L_0x0370;
                case 14: goto L_0x0389;
                case 15: goto L_0x0154;
                case 16: goto L_0x0112;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            r4 = 3
            if (r9 != r4) goto L_0x0101
            java.lang.Object r1 = r0.zzt(r7, r10)
            int r5 = r11 << 3
            r13 = r5 | 4
            com.google.android.gms.internal.auth.zzgi r9 = r0.zzr(r10)
            r5 = r28
            r8 = r1
            r6 = r10
            r10 = r42
            r12 = r11
            r11 = r2
            r2 = r12
            r21 = -1
            r12 = r44
            r22 = r14
            r14 = r46
            int r8 = com.google.android.gms.internal.auth.zzdu.zzl(r8, r9, r10, r11, r12, r13, r14)
            r0.zzB(r7, r6, r1)
            r1 = r30 | r29
            r9 = r2
            r18 = r5
            r10 = r6
            r16 = r17
            r14 = r22
            r12 = -1
            r13 = 0
            r5 = r44
            r6 = r45
        L_0x00fc:
            r17 = r1
            r1 = 1
            goto L_0x0020
        L_0x0101:
            r22 = r14
            r21 = -1
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 1
            r8 = 3
            r14 = 0
            r11 = r10
            r10 = r22
            goto L_0x043a
        L_0x0112:
            r22 = r14
            r13 = r28
            r4 = 3
            r21 = -1
            r14 = r11
            r11 = r10
            if (r9 != 0) goto L_0x014a
            int r8 = com.google.android.gms.internal.auth.zzdu.zzk(r15, r2, r3)
            long r1 = r3.zzb
            long r9 = com.google.android.gms.internal.auth.zzej.zzc(r1)
            r12 = 1
            r1 = r22
            r12 = 2
            r2 = r41
            r12 = r3
            r23 = r14
            r14 = 3
            r3 = r5
            r5 = r9
            r1.putLong(r2, r3, r5)
            r1 = r30 | r29
            r5 = r44
            r6 = r45
            r10 = r11
            r3 = r12
            r18 = r13
            r16 = r17
            r14 = r22
        L_0x0144:
            r9 = r23
            r4 = 3
            r12 = -1
            r13 = 0
            goto L_0x00fc
        L_0x014a:
            r12 = r3
            r23 = r14
        L_0x014d:
            r10 = r22
        L_0x014f:
            r1 = 1
            r8 = 3
            r14 = 0
            goto L_0x043a
        L_0x0154:
            r12 = r3
            r23 = r11
            r22 = r14
            r13 = r28
            r14 = 3
            r21 = -1
            r11 = r10
            if (r9 != 0) goto L_0x014d
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r15, r2, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.auth.zzej.zzb(r1)
            r10 = r22
            r10.putInt(r7, r5, r1)
        L_0x0170:
            r1 = r30 | r29
            r5 = r44
            r6 = r45
        L_0x0176:
            r14 = r10
            r10 = r11
            r3 = r12
            r18 = r13
            r16 = r17
            goto L_0x0144
        L_0x017e:
            r12 = r3
            r23 = r11
            r13 = r28
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 3
            if (r9 != 0) goto L_0x014f
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r15, r2, r12)
            int r1 = r12.zza
            com.google.android.gms.internal.auth.zzey r2 = r0.zzq(r11)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r16 & r3
            if (r3 == 0) goto L_0x01c4
            if (r2 == 0) goto L_0x01c4
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x01a3
            goto L_0x01c4
        L_0x01a3:
            com.google.android.gms.internal.auth.zzha r2 = zzc(r41)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r13, r1)
            r5 = r44
            r6 = r45
            r14 = r10
            r10 = r11
            r3 = r12
            r18 = r13
            r16 = r17
            r9 = r23
            r17 = r30
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            goto L_0x0020
        L_0x01c4:
            r10.putInt(r7, r5, r1)
            goto L_0x0170
        L_0x01c8:
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 2
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 3
            if (r9 != r1) goto L_0x014f
            int r8 = com.google.android.gms.internal.auth.zzdu.zza(r15, r2, r12)
            java.lang.Object r2 = r12.zzc
            r10.putObject(r7, r5, r2)
            r2 = r30 | r29
            r5 = r44
            r6 = r45
        L_0x01e4:
            r14 = r10
            r10 = r11
            r3 = r12
            r18 = r13
            r16 = r17
            r9 = r23
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            r17 = r2
            goto L_0x0020
        L_0x01f5:
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 2
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 3
            if (r9 != r1) goto L_0x014f
            java.lang.Object r8 = r0.zzt(r7, r11)
            com.google.android.gms.internal.auth.zzgi r3 = r0.zzr(r11)
            r1 = r8
            r4 = r2
            r2 = r3
            r3 = r42
            r5 = r44
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzB(r7, r11, r8)
            r2 = r30 | r29
        L_0x021c:
            r6 = r45
            r8 = r1
            goto L_0x01e4
        L_0x0220:
            r4 = r2
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 2
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 3
            if (r9 != r1) goto L_0x034b
            r1 = r16 & r18
            if (r1 == 0) goto L_0x0320
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r15, r4, r12)
            int r2 = r12.zza
            if (r2 < 0) goto L_0x031b
            if (r2 != 0) goto L_0x0244
            r3 = r43
            r12.zzc = r3
            r8 = 3
            r14 = 0
            goto L_0x033b
        L_0x0244:
            int r3 = com.google.android.gms.internal.auth.zzhn.zza
            int r3 = r15.length
            int r4 = r3 - r1
            r8 = r1 | r2
            int r4 = r4 - r2
            r4 = r4 | r8
            if (r4 < 0) goto L_0x02f7
            int r3 = r1 + r2
            char[] r2 = new char[r2]
            r4 = 0
        L_0x0254:
            if (r1 >= r3) goto L_0x0268
            byte r8 = r15[r1]
            boolean r9 = com.google.android.gms.internal.auth.zzhk.zzd(r8)
            if (r9 == 0) goto L_0x0268
            r9 = 1
            int r1 = r1 + r9
            int r16 = r4 + 1
            char r8 = (char) r8
            r2[r4] = r8
            r4 = r16
            goto L_0x0254
        L_0x0268:
            r9 = 1
        L_0x0269:
            if (r1 >= r3) goto L_0x02ec
            int r8 = r1 + 1
            byte r14 = r15[r1]
            boolean r16 = com.google.android.gms.internal.auth.zzhk.zzd(r14)
            if (r16 == 0) goto L_0x0292
            int r1 = r4 + 1
            char r14 = (char) r14
            r2[r4] = r14
            r4 = r1
            r1 = r8
        L_0x027c:
            if (r1 >= r3) goto L_0x028f
            byte r8 = r15[r1]
            boolean r14 = com.google.android.gms.internal.auth.zzhk.zzd(r8)
            if (r14 == 0) goto L_0x028f
            int r1 = r1 + r9
            int r14 = r4 + 1
            char r8 = (char) r8
            r2[r4] = r8
            r4 = r14
            r9 = 1
            goto L_0x027c
        L_0x028f:
            r9 = 1
            r14 = 3
            goto L_0x0269
        L_0x0292:
            r9 = -32
            if (r14 >= r9) goto L_0x02ab
            if (r8 >= r3) goto L_0x02a6
            r9 = 2
            int r1 = r1 + r9
            byte r8 = r15[r8]
            r16 = 1
            int r18 = r4 + 1
            com.google.android.gms.internal.auth.zzhk.zzc(r14, r8, r2, r4)
        L_0x02a3:
            r4 = r18
            goto L_0x028f
        L_0x02a6:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02ab:
            r9 = -16
            if (r14 >= r9) goto L_0x02c9
            int r9 = r3 + -1
            if (r8 >= r9) goto L_0x02c4
            r9 = 2
            int r16 = r1 + 2
            byte r8 = r15[r8]
            r9 = 3
            int r1 = r1 + r9
            byte r9 = r15[r16]
            r16 = 1
            int r18 = r4 + 1
            com.google.android.gms.internal.auth.zzhk.zzb(r14, r8, r9, r2, r4)
            goto L_0x02a3
        L_0x02c4:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02c9:
            int r9 = r3 + -2
            if (r8 >= r9) goto L_0x02e7
            r9 = 2
            int r16 = r1 + 2
            byte r32 = r15[r8]
            r8 = 3
            int r9 = r1 + 3
            byte r33 = r15[r16]
            int r1 = r1 + 4
            byte r34 = r15[r9]
            r31 = r14
            r35 = r2
            r36 = r4
            com.google.android.gms.internal.auth.zzhk.zza(r31, r32, r33, r34, r35, r36)
            r8 = 2
            int r4 = r4 + r8
            goto L_0x028f
        L_0x02e7:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02ec:
            java.lang.String r1 = new java.lang.String
            r14 = 0
            r1.<init>(r2, r14, r4)
            r12.zzc = r1
            r1 = r3
            r8 = 3
            goto L_0x033b
        L_0x02f7:
            r14 = 0
            java.lang.ArrayIndexOutOfBoundsException r4 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8 = 3
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r5[r14] = r3
            r3 = 1
            r5[r3] = r1
            r1 = 2
            r5[r1] = r2
            java.lang.String r1 = "buffer length=%d, index=%d, size=%d"
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r4.<init>(r1)
            throw r4
        L_0x031b:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x0320:
            r3 = r43
            r8 = 3
            r14 = 0
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r15, r4, r12)
            int r2 = r12.zza
            if (r2 < 0) goto L_0x0346
            if (r2 != 0) goto L_0x0331
            r12.zzc = r3
            goto L_0x033b
        L_0x0331:
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.android.gms.internal.auth.zzfa.zzb
            r3.<init>(r15, r1, r2, r4)
            r12.zzc = r3
            int r1 = r1 + r2
        L_0x033b:
            java.lang.Object r2 = r12.zzc
            r10.putObject(r7, r5, r2)
        L_0x0340:
            r2 = r30 | r29
            r5 = r44
            goto L_0x021c
        L_0x0346:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x034b:
            r8 = 3
            r14 = 0
        L_0x034d:
            r2 = r4
        L_0x034e:
            r1 = 1
            goto L_0x043a
        L_0x0351:
            r4 = r2
            r12 = r3
            r23 = r11
            r13 = r28
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != 0) goto L_0x034d
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r15, r4, r12)
            long r2 = r12.zzb
            int r4 = (r2 > r26 ? 1 : (r2 == r26 ? 0 : -1))
            if (r4 == 0) goto L_0x036b
            r2 = 1
            goto L_0x036c
        L_0x036b:
            r2 = 0
        L_0x036c:
            com.google.android.gms.internal.auth.zzhj.zzk(r7, r5, r2)
            goto L_0x0340
        L_0x0370:
            r4 = r2
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 5
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != r1) goto L_0x034d
            int r1 = com.google.android.gms.internal.auth.zzdu.zzb(r15, r4)
            r10.putInt(r7, r5, r1)
            int r1 = r4 + 4
            goto L_0x0340
        L_0x0389:
            r4 = r2
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 1
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != r1) goto L_0x03a9
            long r18 = com.google.android.gms.internal.auth.zzdu.zzn(r15, r4)
            r1 = r10
            r2 = r41
            r9 = r4
            r3 = r5
            r5 = r18
            r1.putLong(r2, r3, r5)
            int r1 = r9 + 8
            goto L_0x0340
        L_0x03a9:
            r2 = r4
            goto L_0x043a
        L_0x03ac:
            r12 = r3
            r23 = r11
            r13 = r28
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != 0) goto L_0x034e
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r15, r2, r12)
            int r2 = r12.zza
            r10.putInt(r7, r5, r2)
            goto L_0x0340
        L_0x03c4:
            r12 = r3
            r23 = r11
            r13 = r28
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != 0) goto L_0x034e
            int r9 = com.google.android.gms.internal.auth.zzdu.zzk(r15, r2, r12)
            long r3 = r12.zzb
            r1 = r10
            r2 = r41
            r18 = r3
            r3 = r5
            r5 = r18
            r1.putLong(r2, r3, r5)
            r1 = r30 | r29
            r5 = r44
            r6 = r45
            r8 = r9
            goto L_0x0176
        L_0x03eb:
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 5
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != r1) goto L_0x034e
            int r1 = com.google.android.gms.internal.auth.zzdu.zzb(r15, r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            com.google.android.gms.internal.auth.zzhj.zzm(r7, r5, r1)
            int r1 = r2 + 4
            goto L_0x0340
        L_0x0408:
            r12 = r3
            r23 = r11
            r13 = r28
            r1 = 1
            r8 = 3
            r21 = -1
            r11 = r10
            r10 = r14
            r14 = 0
            if (r9 != r1) goto L_0x043a
            long r3 = com.google.android.gms.internal.auth.zzdu.zzn(r15, r2)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            com.google.android.gms.internal.auth.zzhj.zzl(r7, r5, r3)
            int r2 = r2 + 8
            r3 = r30 | r29
            r5 = r44
            r6 = r45
            r8 = r2
            r14 = r10
            r10 = r11
            r18 = r13
            r16 = r17
            r9 = r23
            r4 = 3
            r13 = 0
            r17 = r3
            r3 = r12
            r12 = -1
            goto L_0x0020
        L_0x043a:
            r9 = r45
            r3 = r2
            r2 = r7
            r43 = r10
            r25 = r11
            r7 = r12
            r11 = r13
            r1 = r15
            r24 = r17
            r0 = r23
            r17 = r30
            r8 = 1
            r16 = 3
            r23 = 0
            r10 = r44
            goto L_0x0e95
        L_0x0454:
            r23 = r11
            r22 = r12
            r21 = -1
            r12 = r3
            r11 = r10
            r10 = r14
            r14 = 0
            r3 = r1
            r1 = r16
            r16 = r13
            r13 = r28
            r8 = 27
            r25 = 10
            if (r4 != r8) goto L_0x04dd
            r8 = 2
            if (r9 != r8) goto L_0x04bf
            java.lang.Object r3 = r10.getObject(r7, r5)
            com.google.android.gms.internal.auth.zzez r3 = (com.google.android.gms.internal.auth.zzez) r3
            boolean r4 = r3.zzc()
            if (r4 != 0) goto L_0x048e
            int r4 = r3.size()
            if (r4 != 0) goto L_0x0483
            r4 = 10
            goto L_0x0487
        L_0x0483:
            int r25 = r4 + r4
            r4 = r25
        L_0x0487:
            com.google.android.gms.internal.auth.zzez r3 = r3.zzd(r4)
            r10.putObject(r7, r5, r3)
        L_0x048e:
            com.google.android.gms.internal.auth.zzgi r4 = r0.zzr(r11)
            r5 = 2
            r6 = 3
            r8 = r4
            r9 = r13
            r4 = r10
            r10 = r42
            r15 = r11
            r11 = r2
            r5 = r12
            r2 = 2
            r12 = r44
            r2 = r13
            r13 = r3
            r3 = r23
            r23 = 0
            r14 = r46
            int r8 = com.google.android.gms.internal.auth.zzdu.zze(r8, r9, r10, r11, r12, r13, r14)
            r6 = r45
            r16 = r1
            r18 = r2
            r9 = r3
            r14 = r4
            r3 = r5
            r10 = r15
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            r15 = r42
            r5 = r44
            goto L_0x0020
        L_0x04bf:
            r3 = r23
            r14 = 2
            r23 = 0
            r8 = r44
            r24 = r1
            r15 = r2
            r43 = r10
            r10 = 3
            r1 = r42
            r2 = r0
            r0 = 2
            r38 = r13
            r13 = r3
            r3 = r12
            r12 = r38
            r39 = r11
            r11 = r7
            r7 = r39
            goto L_0x0b96
        L_0x04dd:
            r8 = r2
            r15 = r11
            r2 = r13
            r11 = r23
            r23 = 0
            r13 = r12
            r12 = r10
            r10 = 3
            r14 = 49
            if (r4 > r14) goto L_0x0b51
            r14 = r16
            r16 = r11
            long r10 = (long) r14
            sun.misc.Unsafe r14 = zzb
            java.lang.Object r18 = r14.getObject(r7, r5)
            r28 = r1
            r1 = r18
            com.google.android.gms.internal.auth.zzez r1 = (com.google.android.gms.internal.auth.zzez) r1
            boolean r18 = r1.zzc()
            if (r18 != 0) goto L_0x051c
            int r18 = r1.size()
            if (r18 != 0) goto L_0x050d
            r43 = r8
            r8 = 10
            goto L_0x0513
        L_0x050d:
            int r25 = r18 + r18
            r43 = r8
            r8 = r25
        L_0x0513:
            com.google.android.gms.internal.auth.zzez r1 = r1.zzd(r8)
            r14.putObject(r7, r5, r1)
        L_0x051a:
            r14 = r1
            goto L_0x051f
        L_0x051c:
            r43 = r8
            goto L_0x051a
        L_0x051f:
            switch(r4) {
                case 18: goto L_0x0aca;
                case 19: goto L_0x0a68;
                case 20: goto L_0x0a13;
                case 21: goto L_0x0a13;
                case 22: goto L_0x09d6;
                case 23: goto L_0x0981;
                case 24: goto L_0x092d;
                case 25: goto L_0x08c0;
                case 26: goto L_0x07f5;
                case 27: goto L_0x07b0;
                case 28: goto L_0x072c;
                case 29: goto L_0x09d6;
                case 30: goto L_0x0675;
                case 31: goto L_0x092d;
                case 32: goto L_0x0981;
                case 33: goto L_0x0618;
                case 34: goto L_0x05ae;
                case 35: goto L_0x0aca;
                case 36: goto L_0x0a68;
                case 37: goto L_0x0a13;
                case 38: goto L_0x0a13;
                case 39: goto L_0x09d6;
                case 40: goto L_0x0981;
                case 41: goto L_0x092d;
                case 42: goto L_0x08c0;
                case 43: goto L_0x09d6;
                case 44: goto L_0x0675;
                case 45: goto L_0x092d;
                case 46: goto L_0x0981;
                case 47: goto L_0x0618;
                case 48: goto L_0x05ae;
                default: goto L_0x0522;
            }
        L_0x0522:
            r8 = 3
            if (r9 != r8) goto L_0x0594
            com.google.android.gms.internal.auth.zzgi r9 = r0.zzr(r15)
            r1 = r2 & -8
            r10 = r1 | 4
            r24 = r28
            r1 = r9
            r6 = r43
            r11 = r2
            r2 = r42
            r3 = r6
            r4 = r44
            r5 = r10
            r25 = r15
            r15 = r6
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r13.zzc
            r14.add(r2)
            r6 = r44
        L_0x0549:
            if (r1 >= r6) goto L_0x057e
            r5 = r42
            r4 = r25
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r1, r13)
            int r2 = r13.zza
            if (r11 != r2) goto L_0x0578
            r1 = r9
            r2 = r42
            r43 = r12
            r12 = r4
            r4 = r44
            r8 = r5
            r5 = r10
            r22 = r10
            r10 = r6
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r13.zzc
            r14.add(r2)
            r6 = r10
            r25 = r12
            r10 = r22
            r8 = 3
            r12 = r43
            goto L_0x0549
        L_0x0578:
            r8 = r5
            r10 = r6
            r43 = r12
            r12 = r4
            goto L_0x0585
        L_0x057e:
            r8 = r42
            r10 = r6
            r43 = r12
            r12 = r25
        L_0x0585:
            r2 = r0
            r3 = r1
            r1 = r8
            r8 = r10
            r25 = r12
            r7 = r13
            r13 = r16
            r0 = 2
        L_0x058f:
            r10 = 3
            r12 = r11
        L_0x0591:
            r11 = 1
            goto L_0x0b2b
        L_0x0594:
            r24 = r28
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            r1 = r42
            r8 = r44
            r25 = r12
            r7 = r13
            r13 = r16
            r10 = 3
            r11 = 1
            r12 = r2
            r2 = r0
            r0 = 2
            goto L_0x0b2a
        L_0x05ae:
            r8 = r42
            r10 = r44
            r11 = r2
            r24 = r28
            r1 = 2
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            if (r9 != r1) goto L_0x05e1
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r15, r13)
            int r2 = r13.zza
            int r2 = r2 + r1
        L_0x05c9:
            if (r1 >= r2) goto L_0x05d9
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r8, r1, r13)
            long r3 = r13.zzb
            long r3 = com.google.android.gms.internal.auth.zzej.zzc(r3)
            r14.zze(r3)
            goto L_0x05c9
        L_0x05d9:
            if (r1 != r2) goto L_0x05dc
            goto L_0x0585
        L_0x05dc:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x05e1:
            if (r9 != 0) goto L_0x060a
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r8, r15, r13)
            long r2 = r13.zzb
            long r2 = com.google.android.gms.internal.auth.zzej.zzc(r2)
            r14.zze(r2)
        L_0x05f2:
            if (r1 >= r10) goto L_0x0585
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r1, r13)
            int r3 = r13.zza
            if (r11 != r3) goto L_0x0585
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r8, r2, r13)
            long r2 = r13.zzb
            long r2 = com.google.android.gms.internal.auth.zzej.zzc(r2)
            r14.zze(r2)
            goto L_0x05f2
        L_0x060a:
            r2 = r0
        L_0x060b:
            r1 = r8
            r8 = r10
            r25 = r12
            r7 = r13
            r13 = r16
            r0 = 2
            r10 = 3
            r12 = r11
        L_0x0615:
            r11 = 1
            goto L_0x0b2a
        L_0x0618:
            r8 = r42
            r10 = r44
            r11 = r2
            r24 = r28
            r1 = 2
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            if (r9 != r1) goto L_0x064c
            com.google.android.gms.internal.auth.zzew r14 = (com.google.android.gms.internal.auth.zzew) r14
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r15, r13)
            int r2 = r13.zza
            int r2 = r2 + r1
        L_0x0633:
            if (r1 >= r2) goto L_0x0643
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r1, r13)
            int r3 = r13.zza
            int r3 = com.google.android.gms.internal.auth.zzej.zzb(r3)
            r14.zze(r3)
            goto L_0x0633
        L_0x0643:
            if (r1 != r2) goto L_0x0647
            goto L_0x0585
        L_0x0647:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x064c:
            if (r9 != 0) goto L_0x060a
            com.google.android.gms.internal.auth.zzew r14 = (com.google.android.gms.internal.auth.zzew) r14
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r15, r13)
            int r2 = r13.zza
            int r2 = com.google.android.gms.internal.auth.zzej.zzb(r2)
            r14.zze(r2)
        L_0x065d:
            if (r1 >= r10) goto L_0x0585
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r1, r13)
            int r3 = r13.zza
            if (r11 != r3) goto L_0x0585
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r2, r13)
            int r2 = r13.zza
            int r2 = com.google.android.gms.internal.auth.zzej.zzb(r2)
            r14.zze(r2)
            goto L_0x065d
        L_0x0675:
            r8 = r42
            r10 = r44
            r11 = r2
            r24 = r28
            r1 = 2
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            if (r9 != r1) goto L_0x068c
            int r1 = com.google.android.gms.internal.auth.zzdu.zzf(r8, r15, r14, r13)
            goto L_0x069b
        L_0x068c:
            if (r9 != 0) goto L_0x0728
            r1 = r11
            r2 = r42
            r3 = r15
            r4 = r44
            r5 = r14
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzj(r1, r2, r3, r4, r5, r6)
        L_0x069b:
            com.google.android.gms.internal.auth.zzey r2 = r0.zzq(r12)
            com.google.android.gms.internal.auth.zzgz r3 = r0.zzl
            int r4 = com.google.android.gms.internal.auth.zzgk.zza
            if (r2 == 0) goto L_0x0717
            boolean r4 = r14 instanceof java.util.RandomAccess
            if (r4 == 0) goto L_0x06ef
            int r4 = r14.size()
            r9 = r19
            r5 = 0
            r6 = 0
        L_0x06b1:
            if (r5 >= r4) goto L_0x06e1
            java.lang.Object r22 = r14.get(r5)
            r25 = r1
            r1 = r22
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r0 = r1.intValue()
            boolean r22 = r2.zza()
            if (r22 == 0) goto L_0x06d2
            if (r5 == r6) goto L_0x06cc
            r14.set(r6, r1)
        L_0x06cc:
            r1 = 1
            int r6 = r6 + r1
            r1 = r16
        L_0x06d0:
            r0 = 1
            goto L_0x06d9
        L_0x06d2:
            r1 = r16
            java.lang.Object r9 = com.google.android.gms.internal.auth.zzgk.zzc(r7, r1, r0, r9, r3)
            goto L_0x06d0
        L_0x06d9:
            int r5 = r5 + r0
            r0 = r40
            r16 = r1
            r1 = r25
            goto L_0x06b1
        L_0x06e1:
            r25 = r1
            r1 = r16
            if (r6 == r4) goto L_0x071b
            java.util.List r0 = r14.subList(r6, r4)
            r0.clear()
            goto L_0x071b
        L_0x06ef:
            r25 = r1
            r1 = r16
            java.util.Iterator r0 = r14.iterator()
            r4 = r19
        L_0x06f9:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x071b
            java.lang.Object r5 = r0.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            boolean r6 = r2.zza()
            if (r6 != 0) goto L_0x06f9
            java.lang.Object r4 = com.google.android.gms.internal.auth.zzgk.zzc(r7, r1, r5, r4, r3)
            r0.remove()
            goto L_0x06f9
        L_0x0717:
            r25 = r1
            r1 = r16
        L_0x071b:
            r2 = r40
            r7 = r13
            r3 = r25
            r0 = 2
            r13 = r1
            r1 = r8
            r8 = r10
            r25 = r12
            goto L_0x058f
        L_0x0728:
            r2 = r40
            goto L_0x060b
        L_0x072c:
            r8 = r42
            r10 = r44
            r11 = r2
            r1 = r16
            r24 = r28
            r0 = 2
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            if (r9 != r0) goto L_0x07a4
            int r0 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r15, r13)
            int r2 = r13.zza
            if (r2 < 0) goto L_0x079f
            int r3 = r8.length
            int r3 = r3 - r0
            if (r2 > r3) goto L_0x079a
            if (r2 != 0) goto L_0x0754
            com.google.android.gms.internal.auth.zzef r2 = com.google.android.gms.internal.auth.zzef.zzb
            r14.add(r2)
            goto L_0x075c
        L_0x0754:
            com.google.android.gms.internal.auth.zzef r3 = com.google.android.gms.internal.auth.zzef.zzk(r8, r0, r2)
            r14.add(r3)
        L_0x075b:
            int r0 = r0 + r2
        L_0x075c:
            if (r0 >= r10) goto L_0x078c
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r0, r13)
            int r3 = r13.zza
            if (r11 != r3) goto L_0x078c
            int r0 = com.google.android.gms.internal.auth.zzdu.zzh(r8, r2, r13)
            int r2 = r13.zza
            if (r2 < 0) goto L_0x0787
            int r3 = r8.length
            int r3 = r3 - r0
            if (r2 > r3) goto L_0x0782
            if (r2 != 0) goto L_0x077a
            com.google.android.gms.internal.auth.zzef r2 = com.google.android.gms.internal.auth.zzef.zzb
            r14.add(r2)
            goto L_0x075c
        L_0x077a:
            com.google.android.gms.internal.auth.zzef r3 = com.google.android.gms.internal.auth.zzef.zzk(r8, r0, r2)
            r14.add(r3)
            goto L_0x075b
        L_0x0782:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x0787:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x078c:
            r2 = r40
            r3 = r0
            r25 = r12
            r7 = r13
            r0 = 2
            r13 = r1
            r1 = r8
            r8 = r10
            r12 = r11
        L_0x0797:
            r10 = 3
            goto L_0x0591
        L_0x079a:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x079f:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x07a4:
            r2 = r40
            r25 = r12
            r7 = r13
            r13 = r1
        L_0x07aa:
            r1 = r8
            r8 = r10
            r12 = r11
        L_0x07ad:
            r10 = 3
            goto L_0x0615
        L_0x07b0:
            r8 = r42
            r10 = r44
            r11 = r2
            r1 = r16
            r24 = r28
            r0 = 2
            r38 = r15
            r15 = r43
            r43 = r12
            r12 = r38
            if (r9 != r0) goto L_0x07ed
            r6 = r40
            com.google.android.gms.internal.auth.zzgi r2 = r6.zzr(r12)
            r5 = r8
            r3 = 3
            r8 = r2
            r9 = r11
            r4 = r10
            r2 = 3
            r10 = r42
            r3 = r1
            r1 = r11
            r11 = r15
            r0 = r12
            r12 = r44
            r7 = r13
            r13 = r14
            r25 = r0
            r0 = 2
            r14 = r46
            int r8 = com.google.android.gms.internal.auth.zzdu.zze(r8, r9, r10, r11, r12, r13, r14)
            r12 = r1
            r13 = r3
        L_0x07e5:
            r1 = r5
            r2 = r6
            r3 = r8
            r10 = 3
            r11 = 1
            r8 = r4
            goto L_0x0b2b
        L_0x07ed:
            r3 = r1
            r25 = r12
            r7 = r13
            r2 = r40
            r13 = r3
            goto L_0x07aa
        L_0x07f5:
            r5 = r42
            r4 = r44
            r6 = r0
            r1 = r2
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r0 = 2
            r2 = 3
            r15 = r43
            r43 = r12
            if (r9 != r0) goto L_0x08ba
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r8 & r10
            int r10 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1))
            if (r10 != 0) goto L_0x085a
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r15, r7)
            int r9 = r7.zza
            if (r9 < 0) goto L_0x0855
            if (r9 != 0) goto L_0x0820
            r14.add(r3)
            goto L_0x082b
        L_0x0820:
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.auth.zzfa.zzb
            r10.<init>(r5, r8, r9, r11)
            r14.add(r10)
        L_0x082a:
            int r8 = r8 + r9
        L_0x082b:
            if (r8 >= r4) goto L_0x0853
            int r9 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r8, r7)
            int r10 = r7.zza
            if (r1 != r10) goto L_0x0853
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r9, r7)
            int r9 = r7.zza
            if (r9 < 0) goto L_0x084e
            if (r9 != 0) goto L_0x0843
            r14.add(r3)
            goto L_0x082b
        L_0x0843:
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.auth.zzfa.zzb
            r10.<init>(r5, r8, r9, r11)
            r14.add(r10)
            goto L_0x082a
        L_0x084e:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x0853:
            r12 = r1
            goto L_0x07e5
        L_0x0855:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x085a:
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r15, r7)
            int r9 = r7.zza
            if (r9 < 0) goto L_0x08b5
            if (r9 != 0) goto L_0x0868
            r14.add(r3)
            goto L_0x087b
        L_0x0868:
            int r10 = r8 + r9
            boolean r11 = com.google.android.gms.internal.auth.zzhn.zzc(r5, r8, r10)
            if (r11 == 0) goto L_0x08b0
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.auth.zzfa.zzb
            r11.<init>(r5, r8, r9, r12)
            r14.add(r11)
        L_0x087a:
            r8 = r10
        L_0x087b:
            if (r8 >= r4) goto L_0x0853
            int r9 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r8, r7)
            int r10 = r7.zza
            if (r1 != r10) goto L_0x0853
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r9, r7)
            int r9 = r7.zza
            if (r9 < 0) goto L_0x08ab
            if (r9 != 0) goto L_0x0893
            r14.add(r3)
            goto L_0x087b
        L_0x0893:
            int r10 = r8 + r9
            boolean r11 = com.google.android.gms.internal.auth.zzhn.zzc(r5, r8, r10)
            if (r11 == 0) goto L_0x08a6
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.auth.zzfa.zzb
            r11.<init>(r5, r8, r9, r12)
            r14.add(r11)
            goto L_0x087a
        L_0x08a6:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r0
        L_0x08ab:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x08b0:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r0
        L_0x08b5:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r0
        L_0x08ba:
            r12 = r1
            r8 = r4
            r1 = r5
            r2 = r6
            goto L_0x07ad
        L_0x08c0:
            r5 = r42
            r4 = r44
            r6 = r0
            r1 = r2
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r0 = 2
            r2 = 3
            r15 = r43
            r43 = r12
            if (r9 != r0) goto L_0x08fe
            com.google.android.gms.internal.auth.zzdv r14 = (com.google.android.gms.internal.auth.zzdv) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r15, r7)
            int r8 = r7.zza
            int r8 = r8 + r3
        L_0x08de:
            if (r3 >= r8) goto L_0x08f1
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r5, r3, r7)
            long r9 = r7.zzb
            int r11 = (r9 > r26 ? 1 : (r9 == r26 ? 0 : -1))
            if (r11 == 0) goto L_0x08ec
            r9 = 1
            goto L_0x08ed
        L_0x08ec:
            r9 = 0
        L_0x08ed:
            r14.zze(r9)
            goto L_0x08de
        L_0x08f1:
            if (r3 != r8) goto L_0x08f9
        L_0x08f3:
            r12 = r1
            r8 = r4
            r1 = r5
            r2 = r6
            goto L_0x0797
        L_0x08f9:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x08fe:
            if (r9 != 0) goto L_0x08ba
            com.google.android.gms.internal.auth.zzdv r14 = (com.google.android.gms.internal.auth.zzdv) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r5, r15, r7)
            long r8 = r7.zzb
            int r10 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1))
            if (r10 == 0) goto L_0x090e
            r8 = 1
            goto L_0x090f
        L_0x090e:
            r8 = 0
        L_0x090f:
            r14.zze(r8)
        L_0x0912:
            if (r3 >= r4) goto L_0x08f3
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r3, r7)
            int r9 = r7.zza
            if (r1 != r9) goto L_0x08f3
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r5, r8, r7)
            long r8 = r7.zzb
            int r10 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1))
            if (r10 == 0) goto L_0x0928
            r8 = 1
            goto L_0x0929
        L_0x0928:
            r8 = 0
        L_0x0929:
            r14.zze(r8)
            goto L_0x0912
        L_0x092d:
            r5 = r42
            r4 = r44
            r6 = r0
            r1 = r2
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r0 = 2
            r2 = 3
            r15 = r43
            r43 = r12
            if (r9 != r0) goto L_0x095f
            com.google.android.gms.internal.auth.zzew r14 = (com.google.android.gms.internal.auth.zzew) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r15, r7)
            int r8 = r7.zza
            int r8 = r8 + r3
        L_0x094b:
            if (r3 >= r8) goto L_0x0957
            int r9 = com.google.android.gms.internal.auth.zzdu.zzb(r5, r3)
            r14.zze(r9)
            int r3 = r3 + 4
            goto L_0x094b
        L_0x0957:
            if (r3 != r8) goto L_0x095a
            goto L_0x08f3
        L_0x095a:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x095f:
            r3 = 5
            if (r9 != r3) goto L_0x08ba
            com.google.android.gms.internal.auth.zzew r14 = (com.google.android.gms.internal.auth.zzew) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r5, r15)
            r14.zze(r3)
            int r3 = r15 + 4
        L_0x096d:
            if (r3 >= r4) goto L_0x08f3
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r3, r7)
            int r9 = r7.zza
            if (r1 != r9) goto L_0x08f3
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r5, r8)
            r14.zze(r3)
            int r3 = r8 + 4
            goto L_0x096d
        L_0x0981:
            r5 = r42
            r4 = r44
            r6 = r0
            r1 = r2
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r0 = 2
            r2 = 3
            r15 = r43
            r43 = r12
            if (r9 != r0) goto L_0x09b4
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r15, r7)
            int r8 = r7.zza
            int r8 = r8 + r3
        L_0x099f:
            if (r3 >= r8) goto L_0x09ab
            long r9 = com.google.android.gms.internal.auth.zzdu.zzn(r5, r3)
            r14.zze(r9)
            int r3 = r3 + 8
            goto L_0x099f
        L_0x09ab:
            if (r3 != r8) goto L_0x09af
            goto L_0x08f3
        L_0x09af:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x09b4:
            r3 = 1
            if (r9 != r3) goto L_0x08ba
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            long r8 = com.google.android.gms.internal.auth.zzdu.zzn(r5, r15)
            r14.zze(r8)
            int r8 = r15 + 8
        L_0x09c2:
            if (r8 >= r4) goto L_0x0853
            int r9 = com.google.android.gms.internal.auth.zzdu.zzh(r5, r8, r7)
            int r10 = r7.zza
            if (r1 != r10) goto L_0x0853
            long r10 = com.google.android.gms.internal.auth.zzdu.zzn(r5, r9)
            r14.zze(r10)
            int r8 = r9 + 8
            goto L_0x09c2
        L_0x09d6:
            r5 = r42
            r4 = r44
            r6 = r0
            r1 = r2
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r0 = 2
            r2 = 3
            r3 = 1
            r15 = r43
            r43 = r12
            if (r9 != r0) goto L_0x09f2
            int r8 = com.google.android.gms.internal.auth.zzdu.zzf(r5, r15, r14, r7)
            goto L_0x0853
        L_0x09f2:
            if (r9 != 0) goto L_0x0a0b
            r12 = r1
            r11 = 1
            r10 = 3
            r2 = r42
            r3 = r15
            r8 = r4
            r4 = r44
            r9 = r5
            r5 = r14
            r14 = r6
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzj(r1, r2, r3, r4, r5, r6)
            r3 = r1
            r1 = r9
            r2 = r14
            goto L_0x0b2b
        L_0x0a0b:
            r12 = r1
            r8 = r4
            r10 = 3
            r11 = 1
            r1 = r5
            r2 = r6
            goto L_0x0b2a
        L_0x0a13:
            r1 = r42
            r8 = r44
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r10 = 3
            r11 = 1
            r15 = r43
            r43 = r12
            r12 = r2
            r2 = r0
            r0 = 2
            if (r9 != r0) goto L_0x0a47
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r3
        L_0x0a32:
            if (r3 >= r4) goto L_0x0a3e
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r3, r7)
            long r5 = r7.zzb
            r14.zze(r5)
            goto L_0x0a32
        L_0x0a3e:
            if (r3 != r4) goto L_0x0a42
            goto L_0x0b2b
        L_0x0a42:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x0a47:
            if (r9 != 0) goto L_0x0b2a
            com.google.android.gms.internal.auth.zzfm r14 = (com.google.android.gms.internal.auth.zzfm) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r15, r7)
            long r4 = r7.zzb
            r14.zze(r4)
        L_0x0a54:
            if (r3 >= r8) goto L_0x0b2b
            int r4 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r3, r7)
            int r5 = r7.zza
            if (r12 != r5) goto L_0x0b2b
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r4, r7)
            long r4 = r7.zzb
            r14.zze(r4)
            goto L_0x0a54
        L_0x0a68:
            r1 = r42
            r8 = r44
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r10 = 3
            r11 = 1
            r15 = r43
            r43 = r12
            r12 = r2
            r2 = r0
            r0 = 2
            if (r9 != r0) goto L_0x0aa0
            com.google.android.gms.internal.auth.zzer r14 = (com.google.android.gms.internal.auth.zzer) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r3
        L_0x0a87:
            if (r3 >= r4) goto L_0x0a97
            int r5 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r3)
            float r5 = java.lang.Float.intBitsToFloat(r5)
            r14.zze(r5)
            int r3 = r3 + 4
            goto L_0x0a87
        L_0x0a97:
            if (r3 != r4) goto L_0x0a9b
            goto L_0x0b2b
        L_0x0a9b:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x0aa0:
            r3 = 5
            if (r9 != r3) goto L_0x0b2a
            com.google.android.gms.internal.auth.zzer r14 = (com.google.android.gms.internal.auth.zzer) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r15)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            r14.zze(r3)
            int r3 = r15 + 4
        L_0x0ab2:
            if (r3 >= r8) goto L_0x0b2b
            int r4 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r3, r7)
            int r5 = r7.zza
            if (r12 != r5) goto L_0x0b2b
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r4)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            r14.zze(r3)
            int r3 = r4 + 4
            goto L_0x0ab2
        L_0x0aca:
            r1 = r42
            r8 = r44
            r7 = r13
            r25 = r15
            r13 = r16
            r24 = r28
            r10 = 3
            r11 = 1
            r15 = r43
            r43 = r12
            r12 = r2
            r2 = r0
            r0 = 2
            if (r9 != r0) goto L_0x0b01
            com.google.android.gms.internal.auth.zzek r14 = (com.google.android.gms.internal.auth.zzek) r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r7)
            int r4 = r7.zza
            int r4 = r4 + r3
        L_0x0ae9:
            if (r3 >= r4) goto L_0x0af9
            long r5 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r3)
            double r5 = java.lang.Double.longBitsToDouble(r5)
            r14.zze(r5)
            int r3 = r3 + 8
            goto L_0x0ae9
        L_0x0af9:
            if (r3 != r4) goto L_0x0afc
            goto L_0x0b2b
        L_0x0afc:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r0
        L_0x0b01:
            if (r9 != r11) goto L_0x0b2a
            com.google.android.gms.internal.auth.zzek r14 = (com.google.android.gms.internal.auth.zzek) r14
            long r3 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r15)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            r14.zze(r3)
            int r3 = r15 + 8
        L_0x0b12:
            if (r3 >= r8) goto L_0x0b2b
            int r4 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r3, r7)
            int r5 = r7.zza
            if (r12 != r5) goto L_0x0b2b
            long r5 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r4)
            double r5 = java.lang.Double.longBitsToDouble(r5)
            r14.zze(r5)
            int r3 = r4 + 8
            goto L_0x0b12
        L_0x0b2a:
            r3 = r15
        L_0x0b2b:
            if (r3 == r15) goto L_0x0b45
            r14 = r43
            r6 = r45
            r15 = r1
            r0 = r2
            r5 = r8
            r18 = r12
            r9 = r13
            r16 = r24
            r10 = r25
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            r8 = r3
            r3 = r7
            r7 = r41
            goto L_0x0020
        L_0x0b45:
            r2 = r41
            r9 = r45
            r10 = r8
            r11 = r12
            r0 = r13
            r8 = 1
            r16 = 3
            goto L_0x0e95
        L_0x0b51:
            r24 = r1
            r43 = r12
            r7 = r13
            r25 = r15
            r14 = r16
            r1 = r42
            r12 = r2
            r15 = r8
            r13 = r11
            r8 = r44
            r2 = r0
            r0 = 2
            r11 = 50
            if (r4 != r11) goto L_0x0ba5
            if (r9 != r0) goto L_0x0b91
            sun.misc.Unsafe r0 = zzb
            r7 = r25
            java.lang.Object r1 = r2.zzs(r7)
            r11 = r41
            java.lang.Object r3 = r0.getObject(r11, r5)
            r4 = r3
            com.google.android.gms.internal.auth.zzfr r4 = (com.google.android.gms.internal.auth.zzfr) r4
            boolean r4 = r4.zze()
            if (r4 != 0) goto L_0x0b8e
            com.google.android.gms.internal.auth.zzfr r4 = com.google.android.gms.internal.auth.zzfr.zza()
            com.google.android.gms.internal.auth.zzfr r4 = r4.zzb()
            com.google.android.gms.internal.auth.zzfs.zza(r4, r3)
            r0.putObject(r11, r5, r4)
        L_0x0b8e:
            com.google.android.gms.internal.auth.zzfq r1 = (com.google.android.gms.internal.auth.zzfq) r1
            throw r19
        L_0x0b91:
            r11 = r41
            r3 = r7
            r7 = r25
        L_0x0b96:
            r9 = r45
            r25 = r7
            r10 = r8
            r2 = r11
            r11 = r12
            r0 = r13
            r8 = 1
            r16 = 3
            r7 = r3
            r3 = r15
            goto L_0x0e95
        L_0x0ba5:
            r11 = r41
            r7 = r25
            int r16 = r7 + 2
            sun.misc.Unsafe r0 = zzb
            r16 = r22[r16]
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r16 & r10
            long r10 = (long) r8
            switch(r4) {
                case 51: goto L_0x0e4d;
                case 52: goto L_0x0e23;
                case 53: goto L_0x0dfe;
                case 54: goto L_0x0dfe;
                case 55: goto L_0x0dd9;
                case 56: goto L_0x0db3;
                case 57: goto L_0x0d8d;
                case 58: goto L_0x0d61;
                case 59: goto L_0x0d1e;
                case 60: goto L_0x0cee;
                case 61: goto L_0x0ccb;
                case 62: goto L_0x0dd9;
                case 63: goto L_0x0c7c;
                case 64: goto L_0x0d8d;
                case 65: goto L_0x0db3;
                case 66: goto L_0x0c47;
                case 67: goto L_0x0c0c;
                case 68: goto L_0x0bc7;
                default: goto L_0x0bb8;
            }
        L_0x0bb8:
            r2 = r41
            r10 = r44
            r20 = r7
            r11 = r12
            r0 = r13
            r8 = 1
            r16 = 3
        L_0x0bc3:
            r7 = r46
            goto L_0x0e76
        L_0x0bc7:
            r0 = 3
            if (r9 != r0) goto L_0x0c00
            r3 = r41
            java.lang.Object r4 = r2.zzu(r3, r13, r7)
            r5 = r12 & -8
            r5 = r5 | 4
            com.google.android.gms.internal.auth.zzgi r9 = r2.zzr(r7)
            r6 = r44
            r8 = r4
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 3
            r10 = r42
            r14 = 1
            r11 = r15
            r37 = r12
            r12 = r44
            r0 = r13
            r13 = r5
            r5 = 1
            r14 = r46
            int r8 = com.google.android.gms.internal.auth.zzdu.zzl(r8, r9, r10, r11, r12, r13, r14)
            r2.zzC(r3, r0, r7, r4)
            r2 = r3
            r10 = r6
            r20 = r7
            r3 = r8
            r11 = r37
            r8 = 1
            r7 = r46
            goto L_0x0e77
        L_0x0c00:
            r0 = r13
            r16 = 3
            r2 = r41
            r10 = r44
            r20 = r7
            r11 = r12
            r8 = 1
            goto L_0x0bc3
        L_0x0c0c:
            r3 = r41
            r4 = r0
            r37 = r12
            r0 = r13
            r8 = 1
            r16 = 3
            r12 = r10
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r44
            if (r9 != 0) goto L_0x0c40
            r14 = r46
            int r9 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r15, r14)
            r18 = r9
            long r8 = r14.zzb
            long r8 = com.google.android.gms.internal.auth.zzej.zzc(r8)
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r4.putObject(r3, r5, r8)
            r4.putInt(r3, r12, r0)
            r2 = r3
            r20 = r7
            r7 = r14
            r3 = r18
        L_0x0c3b:
            r11 = r37
        L_0x0c3d:
            r8 = 1
            goto L_0x0e77
        L_0x0c40:
            r2 = r3
            r20 = r7
            r11 = r37
            goto L_0x0bc3
        L_0x0c47:
            r3 = r41
            r14 = r46
            r4 = r0
            r37 = r12
            r0 = r13
            r16 = 3
            r12 = r10
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r44
            if (r9 != 0) goto L_0x0c73
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r14)
            int r9 = r14.zza
            int r9 = com.google.android.gms.internal.auth.zzej.zzb(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r4.putObject(r3, r5, r9)
            r4.putInt(r3, r12, r0)
            r2 = r3
            r20 = r7
            r3 = r8
            r7 = r14
            goto L_0x0c3b
        L_0x0c73:
            r2 = r3
            r20 = r7
            r7 = r14
            r11 = r37
        L_0x0c79:
            r8 = 1
            goto L_0x0e76
        L_0x0c7c:
            r3 = r41
            r14 = r46
            r4 = r0
            r37 = r12
            r0 = r13
            r16 = 3
            r12 = r10
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r44
            if (r9 != 0) goto L_0x0cc4
            int r8 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r14)
            int r9 = r14.zza
            com.google.android.gms.internal.auth.zzey r18 = r2.zzq(r7)
            if (r18 == 0) goto L_0x0ca0
            boolean r18 = r18.zza()
            if (r18 == 0) goto L_0x0ca3
        L_0x0ca0:
            r11 = r37
            goto L_0x0cb3
        L_0x0ca3:
            com.google.android.gms.internal.auth.zzha r4 = zzc(r41)
            long r5 = (long) r9
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r6 = r37
            r4.zzh(r6, r5)
            r11 = r6
            goto L_0x0cbd
        L_0x0cb3:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r4.putObject(r3, r5, r9)
            r4.putInt(r3, r12, r0)
        L_0x0cbd:
            r2 = r3
            r20 = r7
            r3 = r8
        L_0x0cc1:
            r7 = r14
            goto L_0x0c3d
        L_0x0cc4:
            r11 = r37
        L_0x0cc6:
            r2 = r3
            r20 = r7
            r7 = r14
            goto L_0x0c79
        L_0x0ccb:
            r3 = r41
            r14 = r46
            r4 = r0
            r0 = r13
            r8 = 2
            r16 = 3
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r8) goto L_0x0cc6
            int r9 = com.google.android.gms.internal.auth.zzdu.zza(r1, r15, r14)
            java.lang.Object r8 = r14.zzc
            r4.putObject(r3, r5, r8)
            r4.putInt(r3, r12, r0)
            r2 = r3
            r20 = r7
            r3 = r9
            goto L_0x0cc1
        L_0x0cee:
            r3 = r41
            r10 = r44
            r14 = r46
            r11 = r12
            r0 = r13
            r4 = 2
            r16 = 3
            if (r9 != r4) goto L_0x0d1c
            java.lang.Object r8 = r2.zzu(r3, r0, r7)
            com.google.android.gms.internal.auth.zzgi r4 = r2.zzr(r7)
            r9 = r1
            r1 = r8
            r12 = r2
            r2 = r4
            r13 = r3
            r3 = r42
            r4 = r15
            r5 = r44
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzm(r1, r2, r3, r4, r5, r6)
            r12.zzC(r13, r0, r7, r8)
            r3 = r1
            r20 = r7
            r1 = r9
            r2 = r13
            goto L_0x0cc1
        L_0x0d1c:
            r12 = r2
            goto L_0x0cc6
        L_0x0d1e:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r8 = 2
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r8) goto L_0x0c79
            int r9 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r7)
            int r8 = r7.zza
            if (r8 != 0) goto L_0x0d3e
            r4.putObject(r2, r5, r3)
            goto L_0x0d5b
        L_0x0d3e:
            r3 = r14 & r18
            if (r3 == 0) goto L_0x0d50
            int r3 = r9 + r8
            boolean r3 = com.google.android.gms.internal.auth.zzhn.zzc(r1, r9, r3)
            if (r3 == 0) goto L_0x0d4b
            goto L_0x0d50
        L_0x0d4b:
            com.google.android.gms.internal.auth.zzfb r0 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r0
        L_0x0d50:
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.auth.zzfa.zzb
            r3.<init>(r1, r9, r8, r14)
            r4.putObject(r2, r5, r3)
            int r9 = r9 + r8
        L_0x0d5b:
            r4.putInt(r2, r12, r0)
            r3 = r9
            goto L_0x0c3d
        L_0x0d61:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != 0) goto L_0x0c79
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r15, r7)
            long r8 = r7.zzb
            int r14 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1))
            if (r14 == 0) goto L_0x0d80
            r8 = 1
            goto L_0x0d81
        L_0x0d80:
            r8 = 0
        L_0x0d81:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r4.putObject(r2, r5, r8)
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0d8d:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r3 = 5
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r3) goto L_0x0c79
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r15)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.putObject(r2, r5, r3)
            int r3 = r15 + 4
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0db3:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r3 = 1
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r3) goto L_0x0c79
            long r8 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r15)
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r4.putObject(r2, r5, r3)
            int r3 = r15 + 8
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0dd9:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != 0) goto L_0x0c79
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r15, r7)
            int r8 = r7.zza
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r4.putObject(r2, r5, r8)
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0dfe:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != 0) goto L_0x0c79
            int r3 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r15, r7)
            long r8 = r7.zzb
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r4.putObject(r2, r5, r8)
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0e23:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r3 = 5
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r3) goto L_0x0c79
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r15)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r4.putObject(r2, r5, r3)
            int r3 = r15 + 4
            r4.putInt(r2, r12, r0)
            goto L_0x0c3d
        L_0x0e4d:
            r2 = r41
            r4 = r0
            r20 = r7
            r0 = r13
            r8 = 1
            r16 = 3
            r7 = r46
            r38 = r10
            r10 = r44
            r11 = r12
            r12 = r38
            if (r9 != r8) goto L_0x0e76
            long r25 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r15)
            double r25 = java.lang.Double.longBitsToDouble(r25)
            java.lang.Double r3 = java.lang.Double.valueOf(r25)
            r4.putObject(r2, r5, r3)
            int r3 = r15 + 8
            r4.putInt(r2, r12, r0)
            goto L_0x0e77
        L_0x0e76:
            r3 = r15
        L_0x0e77:
            if (r3 == r15) goto L_0x0e91
            r14 = r43
            r6 = r45
            r9 = r0
            r15 = r1
            r8 = r3
            r3 = r7
            r5 = r10
            r18 = r11
            r10 = r20
            r16 = r24
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            r0 = r40
            r7 = r2
            goto L_0x0020
        L_0x0e91:
            r9 = r45
            r25 = r20
        L_0x0e95:
            if (r11 != r9) goto L_0x0ea7
            if (r9 != 0) goto L_0x0e9a
            goto L_0x0ea7
        L_0x0e9a:
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r40
            r12 = r2
            r8 = r3
            r3 = r17
            r1 = r24
            r2 = 1
            goto L_0x0ee1
        L_0x0ea7:
            com.google.android.gms.internal.auth.zzha r5 = zzc(r41)
            r1 = r11
            r12 = r2
            r2 = r42
            r4 = r44
            r6 = r46
            int r1 = com.google.android.gms.internal.auth.zzdu.zzg(r1, r2, r3, r4, r5, r6)
            r15 = r42
            r14 = r43
            r8 = r1
            r3 = r7
            r6 = r9
            r5 = r10
            r18 = r11
            r7 = r12
            r16 = r24
            r10 = r25
            r1 = 1
            r4 = 3
            r12 = -1
            r13 = 0
            r9 = r0
            r0 = r40
            goto L_0x0020
        L_0x0ecf:
            r10 = r5
            r9 = r6
            r12 = r7
            r1 = r8
            r43 = r14
            r24 = r16
            r2 = 1
            r3 = r17
            r11 = r18
            r1 = r24
            r4 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0ee1:
            if (r1 == r4) goto L_0x0ee9
            long r4 = (long) r1
            r1 = r43
            r1.putInt(r12, r4, r3)
        L_0x0ee9:
            int r1 = r0.zzi
        L_0x0eeb:
            int r3 = r0.zzj
            if (r1 >= r3) goto L_0x0f18
            int[] r3 = r0.zzh
            r3 = r3[r1]
            int[] r4 = r0.zzc
            r4 = r4[r3]
            int r4 = r0.zzo(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r5
            long r6 = (long) r4
            java.lang.Object r4 = com.google.android.gms.internal.auth.zzhj.zzf(r12, r6)
            if (r4 != 0) goto L_0x0f07
            goto L_0x0f0d
        L_0x0f07:
            com.google.android.gms.internal.auth.zzey r6 = r0.zzq(r3)
            if (r6 != 0) goto L_0x0f0f
        L_0x0f0d:
            int r1 = r1 + r2
            goto L_0x0eeb
        L_0x0f0f:
            com.google.android.gms.internal.auth.zzfr r4 = (com.google.android.gms.internal.auth.zzfr) r4
            java.lang.Object r1 = r0.zzs(r3)
            com.google.android.gms.internal.auth.zzfq r1 = (com.google.android.gms.internal.auth.zzfq) r1
            throw r19
        L_0x0f18:
            if (r9 != 0) goto L_0x0f22
            if (r8 != r10) goto L_0x0f1d
            goto L_0x0f26
        L_0x0f1d:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzd()
            throw r1
        L_0x0f22:
            if (r8 > r10) goto L_0x0f27
            if (r11 != r9) goto L_0x0f27
        L_0x0f26:
            return r8
        L_0x0f27:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzd()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    public final void zze(Object obj) {
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzev = (zzev) obj;
                zzev.zzl(Integer.MAX_VALUE);
                zzev.zza = 0;
                zzev.zzj();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzo2 = zzo(i);
                int i2 = 1048575 & zzo2;
                int zzn2 = zzn(zzo2);
                long j = (long) i2;
                if (zzn2 != 9) {
                    if (zzn2 == 60 || zzn2 == 68) {
                        if (zzI(obj, this.zzc[i], i)) {
                            zzr(i).zze(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzn2) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzk.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzE(obj, i)) {
                    zzr(i).zze(zzb.getObject(obj, j));
                }
            }
            this.zzl.zze(obj);
        }
    }

    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzo2 = zzo(i);
            int i2 = this.zzc[i];
            long j = (long) (1048575 & zzo2);
            switch (zzn(zzo2)) {
                case 0:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 1:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 2:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 3:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 4:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 5:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 6:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 7:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 8:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 11:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 12:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 13:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 14:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 15:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 16:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 17:
                    zzx(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzI(obj2, i2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    }
                case 60:
                    zzy(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzI(obj2, i2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    }
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdt) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdt);
    }

    public final boolean zzh(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzo2 = zzo(i);
            long j = (long) (zzo2 & 1048575);
            switch (zzn(zzo2)) {
                case 0:
                    if (zzD(obj, obj2, i) && Double.doubleToLongBits(zzhj.zza(obj, j)) == Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzD(obj, obj2, i) && Float.floatToIntBits(zzhj.zzb(obj, j)) == Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzD(obj, obj2, i) && zzhj.zzt(obj, j) == zzhj.zzt(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 50:
                    z = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzl2 = (long) (zzl(i) & 1048575);
                    if (zzhj.zzc(obj, zzl2) == zzhj.zzc(obj2, zzl2) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzl.zzb(obj).equals(this.zzl.zzb(obj2))) {
            return false;
        }
        return true;
    }

    public final boolean zzi(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzi) {
            int i6 = this.zzh[i5];
            int i7 = this.zzc[i6];
            int zzo2 = zzo(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzo2) != 0 && !zzF(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzn2 = zzn(zzo2);
            if (zzn2 != 9 && zzn2 != 17) {
                if (zzn2 != 27) {
                    if (zzn2 == 60 || zzn2 == 68) {
                        if (zzI(obj2, i7, i6) && !zzG(obj2, zzo2, zzr(i6))) {
                            return false;
                        }
                    } else if (zzn2 != 49) {
                        if (zzn2 == 50 && !((zzfr) zzhj.zzf(obj2, (long) (zzo2 & 1048575))).isEmpty()) {
                            zzfq zzfq = (zzfq) zzs(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhj.zzf(obj2, (long) (zzo2 & 1048575));
                if (!list.isEmpty()) {
                    zzgi zzr = zzr(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzr.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzF(obj, i6, i2, i, i10) && !zzG(obj2, zzo2, zzr(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        return true;
    }
}
