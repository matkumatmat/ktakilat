package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzhj {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc = Memory.class;
    private static final boolean zzd;
    private static final zzhi zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012b  */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            sun.misc.Unsafe r5 = zzg()
            zzb = r5
            int r6 = com.google.android.gms.internal.auth.zzds.zza
            java.lang.Class<libcore.io.Memory> r6 = libcore.io.Memory.class
            zzc = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r7 = zzs(r6)
            zzd = r7
            java.lang.Class r8 = java.lang.Integer.TYPE
            boolean r8 = zzs(r8)
            r9 = 0
            if (r5 != 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            if (r7 == 0) goto L_0x002c
            com.google.android.gms.internal.auth.zzhh r9 = new com.google.android.gms.internal.auth.zzhh
            r9.<init>(r5)
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0033
            com.google.android.gms.internal.auth.zzhg r9 = new com.google.android.gms.internal.auth.zzhg
            r9.<init>(r5)
        L_0x0033:
            zze = r9
            java.lang.String r5 = "getLong"
            java.lang.Class<java.lang.reflect.Field> r7 = java.lang.reflect.Field.class
            java.lang.String r8 = "objectFieldOffset"
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            if (r9 != 0) goto L_0x0041
        L_0x003f:
            r6 = 0
            goto L_0x0065
        L_0x0041:
            sun.misc.Unsafe r9 = r9.zza
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r3]     // Catch:{ all -> 0x0060 }
            r11[r2] = r7     // Catch:{ all -> 0x0060 }
            r9.getMethod(r8, r11)     // Catch:{ all -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ all -> 0x0060 }
            r11[r2] = r10     // Catch:{ all -> 0x0060 }
            r11[r3] = r6     // Catch:{ all -> 0x0060 }
            r9.getMethod(r5, r11)     // Catch:{ all -> 0x0060 }
            java.lang.reflect.Field r6 = zzy()     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r6 = 1
            goto L_0x0065
        L_0x0060:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhj.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x003f
        L_0x0065:
            zzf = r6
            com.google.android.gms.internal.auth.zzhi r6 = zze
            if (r6 != 0) goto L_0x006d
        L_0x006b:
            r0 = 0
            goto L_0x00dd
        L_0x006d:
            sun.misc.Unsafe r6 = r6.zza
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r9[r2] = r7     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r8, r9)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "arrayBaseOffset"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r8[r2] = r4     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r7, r8)     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "arrayIndexScale"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x00d8 }
            r8[r2] = r4     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r7, r8)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "getInt"
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r8 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r8[r2] = r10     // Catch:{ all -> 0x00d8 }
            r8[r3] = r7     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r4, r8)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "putInt"
            java.lang.Class[] r8 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r8[r2] = r10     // Catch:{ all -> 0x00d8 }
            r8[r3] = r7     // Catch:{ all -> 0x00d8 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00d8 }
            r8[r1] = r9     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r4, r8)     // Catch:{ all -> 0x00d8 }
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r4[r2] = r10     // Catch:{ all -> 0x00d8 }
            r4[r3] = r7     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r5, r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "putLong"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r5[r2] = r10     // Catch:{ all -> 0x00d8 }
            r5[r3] = r7     // Catch:{ all -> 0x00d8 }
            r5[r1] = r7     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r4, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "getObject"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d8 }
            r5[r2] = r10     // Catch:{ all -> 0x00d8 }
            r5[r3] = r7     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r4, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "putObject"
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00d8 }
            r0[r2] = r10     // Catch:{ all -> 0x00d8 }
            r0[r3] = r7     // Catch:{ all -> 0x00d8 }
            r0[r1] = r10     // Catch:{ all -> 0x00d8 }
            r6.getMethod(r4, r0)     // Catch:{ all -> 0x00d8 }
            r0 = 1
            goto L_0x00dd
        L_0x00d8:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhj.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006b
        L_0x00dd:
            zzg = r0
            java.lang.Class<byte[]> r0 = byte[].class
            zzw(r0)
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzw(r0)
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x0123
            com.google.android.gms.internal.auth.zzhi r1 = zze
            if (r1 == 0) goto L_0x0123
            sun.misc.Unsafe r1 = r1.zza
            r1.objectFieldOffset(r0)
        L_0x0123:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012c
            r2 = 1
        L_0x012c:
            zza = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhj.<clinit>():void");
    }

    private zzhj() {
    }

    public static double zza(Object obj, long j) {
        return zze.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zze.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zze.zza.getInt(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zze.zza.getLong(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zze.zza.getObject(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhf());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        zzhi zzhi = zze;
        long j2 = -4 & j;
        int i = zzhi.zza.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zzhi.zza.putInt(obj, j2, ((z ? 1 : 0) << i2) | ((~(255 << i2)) & i));
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        zzhi zzhi = zze;
        long j2 = -4 & j;
        int i = zzhi.zza.getInt(obj, j2);
        int i2 = (((int) j) & 3) << 3;
        zzhi.zza.putInt(obj, j2, ((z ? 1 : 0) << i2) | ((~(255 << i2)) & i));
    }

    public static void zzk(Object obj, long j, boolean z) {
        zze.zzc(obj, j, z);
    }

    public static void zzl(Object obj, long j, double d) {
        zze.zzd(obj, j, d);
    }

    public static void zzm(Object obj, long j, float f) {
        zze.zze(obj, j, f);
    }

    public static void zzn(Object obj, long j, int i) {
        zze.zza.putInt(obj, j, i);
    }

    public static void zzo(Object obj, long j, long j2) {
        zze.zza.putLong(obj, j, j2);
    }

    public static void zzp(Object obj, long j, Object obj2) {
        zze.zza.putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j) {
        if (((byte) ((zze.zza.getInt(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j) {
        if (((byte) ((zze.zza.getInt(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean zzs(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzds.zza;
        try {
            Class cls3 = zzc;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j) {
        return zze.zzf(obj, j);
    }

    public static boolean zzu() {
        return zzg;
    }

    public static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzds.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzz = zzz(cls, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(cls, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
