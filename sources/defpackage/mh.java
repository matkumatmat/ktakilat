package defpackage;

import android.os.Binder;
import com.google.android.gms.internal.measurement.zzjt;

/* renamed from: mh  reason: default package */
public abstract /* synthetic */ class mh {
    public static Object a(zzjt zzjt) {
        long clearCallingIdentity;
        try {
            return zzjt.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object zza = zzjt.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
