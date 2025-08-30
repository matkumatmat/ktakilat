package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.zzht;
import java.util.Objects;

final class zzdr extends zzeq {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdr(zzfb zzfb, Context context, Bundle bundle) {
        super(zzfb, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzfb);
        this.zzc = zzfb;
    }

    public final void zza() {
        boolean z;
        boolean z2;
        try {
            Context context = this.zza;
            Preconditions.checkNotNull(context);
            String zza2 = zzht.zza(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(zza2)) {
                zza2 = zzht.zza(context);
            }
            Boolean zzc2 = zzht.zzc("google_analytics_force_disable_updates", resources, zza2);
            zzfb zzfb = this.zzc;
            if (zzc2 == null || !zzc2.booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            zzfb.zzR(zzfb.zzc(context, z));
            if (zzfb.zzQ() == null) {
                Log.w(zzfb.zzO(), "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
            int max = Math.max(localVersion, remoteVersion);
            if (Boolean.TRUE.equals(zzc2) || remoteVersion < localVersion) {
                z2 = true;
            } else {
                z2 = false;
            }
            ((zzcr) Preconditions.checkNotNull(zzfb.zzQ())).initialize(ObjectWrapper.wrap(context), new zzdd(130000, (long) max, z2, this.zzb, zzht.zza(context)), this.zzh);
        } catch (Exception e) {
            this.zzc.zzN(e, true, false);
        }
    }
}
