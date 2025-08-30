package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzoo {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd = Memory.class;
    private static final boolean zze;
    private static final zzon zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012f  */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            sun.misc.Unsafe r5 = zzq()
            zzc = r5
            int r6 = com.google.android.gms.internal.measurement.zzku.zza
            java.lang.Class<libcore.io.Memory> r6 = libcore.io.Memory.class
            zzd = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r7 = zzr(r6)
            zze = r7
            java.lang.Class r8 = java.lang.Integer.TYPE
            boolean r8 = zzr(r8)
            r9 = 0
            if (r5 != 0) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            if (r7 == 0) goto L_0x002c
            com.google.android.gms.internal.measurement.zzom r9 = new com.google.android.gms.internal.measurement.zzom
            r9.<init>(r5)
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.zzol r9 = new com.google.android.gms.internal.measurement.zzol
            r9.<init>(r5)
        L_0x0033:
            zzf = r9
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
            java.lang.reflect.Field r6 = zzB()     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r6 = 1
            goto L_0x0065
        L_0x0060:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzoo.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x003f
        L_0x0065:
            zzg = r6
            com.google.android.gms.internal.measurement.zzon r6 = zzf
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
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzoo.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006b
        L_0x00dd:
            zzh = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzz(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0127
            com.google.android.gms.internal.measurement.zzon r1 = zzf
            if (r1 == 0) goto L_0x0127
            sun.misc.Unsafe r1 = r1.zza
            r1.objectFieldOffset(r0)
        L_0x0127:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0130
            r2 = 1
        L_0x0130:
            zzb = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzoo.<clinit>():void");
    }

    private zzoo() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzku.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzC = zzC(cls, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(cls, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = -4 & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(255 << i))));
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzd(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static void zze(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    public static long zzf(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static void zzg(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    public static boolean zzh(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static void zzi(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static float zzj(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    public static void zzk(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    public static double zzl(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static void zzm(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    public static Object zzn(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static void zzo(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static void zzp(byte[] bArr, long j, byte b) {
        zzf.zza(bArr, zza + j, b);
    }

    public static Unsafe zzq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzok());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzr(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzku.zza;
        try {
            Class cls3 = zzd;
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

    public static /* synthetic */ boolean zzu(Object obj, long j) {
        if (((byte) ((zzf.zza.getInt(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean zzv(Object obj, long j) {
        if (((byte) ((zzf.zza.getInt(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
