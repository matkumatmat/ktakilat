package com.tencent.mmkv;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.ktakilat.cbase.ui.BaseApplication;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumMap f640a;
    public static final EnumMap b;
    public static final MMKVLogLevel[] c;
    public static final HashSet d = new HashSet();
    public static String e = null;
    public static boolean f = true;
    public static final boolean g = false;
    private final long nativeHandle;

    /* renamed from: com.tencent.mmkv.MMKV$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f641a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.mmkv.MMKVLogLevel[] r0 = com.tencent.mmkv.MMKVLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f641a = r0
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelDebug     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f641a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelWarning     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f641a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f641a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelNone     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f641a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelInfo     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.AnonymousClass1.<clinit>():void");
        }
    }

    public interface LibLoader {
    }

    static {
        EnumMap enumMap = new EnumMap(MMKVRecoverStrategic.class);
        f640a = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        enumMap.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap enumMap2 = new EnumMap(MMKVLogLevel.class);
        b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put(mMKVLogLevel, 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put(mMKVLogLevel2, 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put(mMKVLogLevel3, 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put(mMKVLogLevel4, 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put(mMKVLogLevel5, 4);
        c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        new HashMap();
    }

    public MMKV(long j) {
        this.nativeHandle = j;
    }

    public static void a() {
        synchronized (d) {
            f = true;
        }
    }

    private native long actualSize(long j);

    private native String[] allKeys(long j, boolean z);

    public static void b(BaseApplication baseApplication) {
        String str = baseApplication.getFilesDir().getAbsolutePath() + "/mmkv";
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        int i = 2;
        if ((baseApplication.getApplicationInfo().flags & 2) == 0) {
            synchronized (d) {
                f = false;
            }
        } else {
            a();
        }
        String absolutePath = baseApplication.getCacheDir().getAbsolutePath();
        boolean z = g;
        System.loadLibrary("mmkv");
        int i2 = AnonymousClass1.f641a[mMKVLogLevel.ordinal()];
        if (i2 == 1) {
            i = 0;
        } else if (i2 != 2) {
            i = 3;
            if (i2 != 3) {
                i = 4;
                if (i2 != 4) {
                    i = 1;
                }
            }
        }
        jniInitialize(str, absolutePath, i, z);
        e = str;
    }

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mmkv.MMKV c(android.content.Context r7, java.lang.String r8, int r9, int r10, java.lang.String r11) {
        /*
            java.lang.String r0 = e
            if (r0 == 0) goto L_0x01da
            int r0 = android.os.Process.myPid()
            android.net.Uri r1 = com.tencent.mmkv.MMKVContentProvider.c
            int r1 = android.os.Process.myPid()
            r2 = 0
            java.lang.String r3 = "activity"
            java.lang.String r4 = ""
            if (r0 != r1) goto L_0x008f
            java.lang.String r0 = com.tencent.mmkv.MMKVProcessUtil.f642a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = com.tencent.mmkv.MMKVProcessUtil.f642a
        L_0x001f:
            r4 = r0
            goto L_0x00b1
        L_0x0022:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x002d
            java.lang.String r0 = android.app.Application.getProcessName()
            goto L_0x002e
        L_0x002d:
            r0 = r4
        L_0x002e:
            com.tencent.mmkv.MMKVProcessUtil.f642a = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = com.tencent.mmkv.MMKVProcessUtil.f642a
            goto L_0x001f
        L_0x0039:
            java.lang.String r0 = "android.app.ActivityThread"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "currentProcessName"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ all -> 0x0054 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.invoke(r2, r2)     // Catch:{ all -> 0x0054 }
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0058
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0054 }
            goto L_0x0059
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            r0 = r4
        L_0x0059:
            com.tencent.mmkv.MMKVProcessUtil.f642a = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = com.tencent.mmkv.MMKVProcessUtil.f642a
            goto L_0x001f
        L_0x0064:
            int r0 = android.os.Process.myPid()
            java.lang.Object r1 = r7.getSystemService(r3)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            if (r1 == 0) goto L_0x008c
            java.util.List r1 = r1.getRunningAppProcesses()
            if (r1 == 0) goto L_0x008c
            java.util.Iterator r1 = r1.iterator()
        L_0x007a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3
            int r5 = r3.pid
            if (r5 != r0) goto L_0x007a
            java.lang.String r4 = r3.processName
        L_0x008c:
            com.tencent.mmkv.MMKVProcessUtil.f642a = r4
            goto L_0x00b1
        L_0x008f:
            java.lang.Object r1 = r7.getSystemService(r3)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            if (r1 == 0) goto L_0x00b1
            java.util.List r1 = r1.getRunningAppProcesses()
            java.util.Iterator r1 = r1.iterator()
        L_0x009f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00b1
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3
            int r5 = r3.pid
            if (r5 != r0) goto L_0x009f
            java.lang.String r4 = r3.processName
        L_0x00b1:
            if (r4 == 0) goto L_0x01cd
            int r0 = r4.length()
            if (r0 == 0) goto L_0x01cd
            java.lang.String r0 = ":"
            boolean r0 = r4.contains(r0)
            r3 = 0
            if (r0 == 0) goto L_0x01a8
            android.net.Uri r0 = com.tencent.mmkv.MMKVContentProvider.c
            if (r0 == 0) goto L_0x00c8
            goto L_0x00fb
        L_0x00c8:
            if (r7 != 0) goto L_0x00cc
        L_0x00ca:
            r0 = r2
            goto L_0x00fb
        L_0x00cc:
            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00e7 }
            java.lang.Class<com.tencent.mmkv.MMKVContentProvider> r1 = com.tencent.mmkv.MMKVContentProvider.class
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x00e7 }
            r0.<init>(r7, r1)     // Catch:{ Exception -> 0x00e7 }
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch:{ Exception -> 0x00e7 }
            if (r1 == 0) goto L_0x00eb
            r5 = 0
            android.content.pm.ProviderInfo r0 = r1.getProviderInfo(r0, r5)     // Catch:{ Exception -> 0x00e7 }
            if (r0 == 0) goto L_0x00eb
            java.lang.String r0 = r0.authority     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00eb:
            r0 = r2
        L_0x00ec:
            if (r0 != 0) goto L_0x00ef
            goto L_0x00ca
        L_0x00ef:
            java.lang.String r1 = "content://"
            java.lang.String r0 = r1.concat(r0)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.tencent.mmkv.MMKVContentProvider.c = r0
        L_0x00fb:
            if (r0 == 0) goto L_0x019b
            com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelInfo
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "getting parcelable mmkv in process, Uri = "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            e(r1, r5)
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "KEY_SIZE"
            r5.putInt(r6, r9)
            java.lang.String r6 = "KEY_MODE"
            r5.putInt(r6, r10)
            if (r11 == 0) goto L_0x0126
            java.lang.String r6 = "KEY_CRYPT"
            r5.putString(r6, r11)
        L_0x0126:
            android.content.ContentResolver r7 = r7.getContentResolver()
            java.lang.String r6 = "mmkvFromAshmemID"
            android.os.Bundle r7 = r7.call(r0, r6, r8, r5)
            if (r7 == 0) goto L_0x01a8
            java.lang.Class<com.tencent.mmkv.ParcelableMMKV> r0 = com.tencent.mmkv.ParcelableMMKV.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r7.setClassLoader(r0)
            java.lang.String r0 = "KEY"
            android.os.Parcelable r7 = r7.getParcelable(r0)
            com.tencent.mmkv.ParcelableMMKV r7 = (com.tencent.mmkv.ParcelableMMKV) r7
            if (r7 == 0) goto L_0x01a8
            int r0 = r7.d
            if (r0 < 0) goto L_0x016d
            int r5 = r7.e
            if (r5 < 0) goto L_0x016d
            java.lang.String r2 = r7.f
            java.lang.String r7 = r7.c
            long r5 = getMMKVWithAshmemFD(r7, r0, r5, r2)
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x015f
            com.tencent.mmkv.MMKV r2 = new com.tencent.mmkv.MMKV
            r2.<init>(r5)
            goto L_0x016d
        L_0x015f:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r9 = "Fail to create an ashmem MMKV instance ["
            java.lang.String r10 = "] in JNI"
            java.lang.String r7 = defpackage.ba.o(r9, r7, r10)
            r8.<init>(r7)
            throw r8
        L_0x016d:
            if (r2 == 0) goto L_0x01a8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r2.mmapID()
            r7.append(r8)
            java.lang.String r8 = " fd = "
            r7.append(r8)
            int r8 = r2.ashmemFD()
            r7.append(r8)
            java.lang.String r8 = ", meta fd = "
            r7.append(r8)
            int r8 = r2.ashmemMetaFD()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            e(r1, r7)
            return r2
        L_0x019b:
            com.tencent.mmkv.MMKVLogLevel r7 = com.tencent.mmkv.MMKVLogLevel.LevelError
            java.lang.String r8 = "MMKVContentProvider has invalid authority"
            e(r7, r8)
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r8)
            throw r7
        L_0x01a8:
            com.tencent.mmkv.MMKVLogLevel r7 = com.tencent.mmkv.MMKVLogLevel.LevelInfo
            java.lang.String r0 = "getting mmkv in main process"
            e(r7, r0)
            r7 = r10 | 8
            long r9 = getMMKVWithIDAndSize(r8, r9, r7, r11)
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x01bf
            com.tencent.mmkv.MMKV r7 = new com.tencent.mmkv.MMKV
            r7.<init>(r9)
            return r7
        L_0x01bf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r9 = "Fail to create an Ashmem MMKV instance ["
            java.lang.String r10 = "]"
            java.lang.String r8 = defpackage.ba.o(r9, r8, r10)
            r7.<init>(r8)
            throw r7
        L_0x01cd:
            com.tencent.mmkv.MMKVLogLevel r7 = com.tencent.mmkv.MMKVLogLevel.LevelError
            java.lang.String r8 = "process name detect fail, try again later"
            e(r7, r8)
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r8)
            throw r7
        L_0x01da:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "You should Call MMKV.initialize() first."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.c(android.content.Context, java.lang.String, int, int, java.lang.String):com.tencent.mmkv.MMKV");
    }

    private static native boolean checkProcessMode(long j);

    private native boolean containsKey(long j, String str);

    private native long count(long j, boolean z);

    private static native long createNB(int i);

    public static MMKV d(int i, String str) {
        String str2;
        if (e != null) {
            long mMKVWithID = getMMKVWithID(str, i, (String) null, (String) null, 0);
            if (mMKVWithID == 0) {
                throw new RuntimeException(ba.o("Fail to create an MMKV instance [", str, "] in JNI"));
            } else if (!f) {
                return new MMKV(mMKVWithID);
            } else {
                HashSet hashSet = d;
                synchronized (hashSet) {
                    try {
                        if (!hashSet.contains(Long.valueOf(mMKVWithID))) {
                            if (!checkProcessMode(mMKVWithID)) {
                                if (i == 1) {
                                    str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                                } else {
                                    str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                                }
                                throw new IllegalArgumentException(str2);
                            }
                            hashSet.add(Long.valueOf(mMKVWithID));
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                return new MMKV(mMKVWithID);
            }
        } else {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
    }

    private native boolean decodeBool(long j, String str, boolean z);

    @Nullable
    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d2);

    private native float decodeFloat(long j, String str, float f2);

    private native int decodeInt(long j, String str, int i);

    private native long decodeLong(long j, String str, long j2);

    @Nullable
    private native String decodeString(long j, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j, String str);

    private static native void destroyNB(long j, int i);

    public static void e(MMKVLogLevel mMKVLogLevel, String str) {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = (Integer) b.get(mMKVLogLevel);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        mmkvLogImp(i, stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBool_2(long j, String str, boolean z, int i);

    private native boolean encodeBytes(long j, String str, @Nullable byte[] bArr);

    private native boolean encodeBytes_2(long j, String str, @Nullable byte[] bArr, int i);

    private native boolean encodeDouble(long j, String str, double d2);

    private native boolean encodeDouble_2(long j, String str, double d2, int i);

    private native boolean encodeFloat(long j, String str, float f2);

    private native boolean encodeFloat_2(long j, String str, float f2, int i);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeInt_2(long j, String str, int i, int i2);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeLong_2(long j, String str, long j2, int i);

    private native boolean encodeSet(long j, String str, @Nullable String[] strArr);

    private native boolean encodeSet_2(long j, String str, @Nullable String[] strArr, int i);

    private native boolean encodeString(long j, String str, @Nullable String str2);

    private native boolean encodeString_2(long j, String str, @Nullable String str2, int i);

    private static native long getDefaultMMKV(int i, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i2, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i, @Nullable String str2, @Nullable String str3, long j);

    private static native long getMMKVWithIDAndSize(String str, int i, int i2, @Nullable String str2);

    private native boolean isCompareBeforeSetEnabled();

    private native boolean isEncryptionEnabled();

    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, String str2, int i, boolean z);

    private static void mmkvLogImp(int i, String str, int i2, String str2, String str3) {
        int i3 = AnonymousClass1.f641a[c[i].ordinal()];
        if (i3 == 2) {
            Log.w("MMKV", str3);
        } else if (i3 == 3) {
            Log.e("MMKV", str3);
        }
    }

    private native void nativeEnableCompareBeforeSet();

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        e(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f640a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        e(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f640a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static native boolean removeStorage(String str, @Nullable String str2);

    private native void removeValueForKey(long j, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j);

    private native int valueSize(long j, String str, boolean z);

    public static native String version();

    private native int writeValueToNB(long j, String str, long j2, int i);

    public final void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    public final SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    public final boolean commit() {
        sync(true);
        return true;
    }

    public final boolean contains(String str) {
        return containsKey(this.nativeHandle, str);
    }

    @Nullable
    public native String cryptKey();

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public final SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i);

    public final Map getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public final boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public final float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    public final int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public final long getLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public final String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public final Set getStringSet(String str, Set set) {
        Class<HashSet> cls = HashSet.class;
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set newInstance = cls.newInstance();
            newInstance.addAll(Arrays.asList(decodeStringSet));
            return newInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public native void lock();

    public native String mmapID();

    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public final SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    public final SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    public final SharedPreferences.Editor putLong(String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    public final SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        String[] strArr;
        long j = this.nativeHandle;
        if (set == null) {
            strArr = null;
        } else {
            strArr = (String[]) set.toArray(new String[0]);
        }
        encodeSet(j, str, strArr);
        return this;
    }

    public native boolean reKey(@Nullable String str);

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public final SharedPreferences.Editor remove(String str) {
        removeValueForKey(this.nativeHandle, str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }
}
