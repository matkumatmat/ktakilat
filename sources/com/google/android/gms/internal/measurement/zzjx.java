package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import com.google.common.base.Preconditions;

final class zzjx implements zzju {
    @GuardedBy("GservicesLoader.class")
    private static zzjx zza;
    private final Context zzb;
    private final ContentObserver zzc;
    @GuardedBy("GservicesLoader.class")
    private boolean zzd;

    private zzjx() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    public static zzjx zza(Context context) {
        zzjx zzjx;
        zzjx zzjx2;
        synchronized (zzjx.class) {
            try {
                if (zza == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzjx2 = new zzjx(context);
                    } else {
                        zzjx2 = new zzjx();
                    }
                    zza = zzjx2;
                }
                zzjx zzjx3 = zza;
                if (!(zzjx3 == null || zzjx3.zzc == null || zzjx3.zzd)) {
                    context.getContentResolver().registerContentObserver(zzjg.zza, true, zza.zzc);
                    ((zzjx) Preconditions.checkNotNull(zza)).zzd = true;
                }
            } catch (SecurityException e) {
                Log.e("GservicesLoader", "Unable to register Gservices content observer", e);
            } catch (Throwable th) {
                throw th;
            }
            zzjx = (zzjx) Preconditions.checkNotNull(zza);
        }
        return zzjx;
    }

    public static synchronized void zzc() {
        Context context;
        synchronized (zzjx.class) {
            try {
                zzjx zzjx = zza;
                if (!(zzjx == null || (context = zzjx.zzb) == null || zzjx.zzc == null || !zzjx.zzd)) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: zzb */
    public final String zze(String str) {
        Context context = this.zzb;
        if (context != null && !zzjm.zzb(context)) {
            try {
                return (String) mh.a(new zzjw(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzjf.zza(((Context) Preconditions.checkNotNull(this.zzb)).getContentResolver(), str, (String) null);
    }

    private zzjx(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjv(this, (Handler) null);
    }
}
