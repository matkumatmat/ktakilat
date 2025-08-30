package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzhj {
    final zzib zza;

    public zzhj(zzpf zzpf) {
        this.zza = zzpf.zzaf();
    }

    @VisibleForTesting
    public final boolean zza() {
        try {
            zzib zzib = this.zza;
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzib.zzaY());
            if (packageManager == null) {
                zzib.zzaV().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zza.zzaV().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
