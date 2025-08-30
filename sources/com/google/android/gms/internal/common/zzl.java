package com.google.android.gms.internal.common;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

public final class zzl {
    @Nullable
    public static Object zza(Class cls, String str, zzj... zzjArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return zzc(cls, "isIsolated", (Object) null, false, zzjArr);
    }

    @Nullable
    public static Object zzb(String str, String str2, ClassLoader classLoader, zzj... zzjArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return zzc(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", (Object) null, false, zzjArr);
    }

    @Nullable
    private static Object zzc(Class cls, String str, @Nullable Object obj, boolean z, zzj... zzjArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int length = zzjArr.length;
        Class[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i = 0; i < zzjArr.length; i++) {
            zzj zzj = zzjArr[i];
            zzj.getClass();
            clsArr[i] = zzj.zzc();
            objArr[i] = zzjArr[i].zzd();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke((Object) null, objArr);
    }
}
