package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcq {
    @VisibleForTesting
    zzib zza = null;
    @GuardedBy("listenerMap")
    private final Map zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcu zzcu, String str) {
        zzb();
        this.zza.zzk().zzal(zzcu, str);
    }

    public void beginAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        zzb();
        this.zza.zzw().zza(str, j);
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzj().zzab(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzn((Boolean) null);
    }

    public void endAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        zzb();
        this.zza.zzw().zzb(str, j);
    }

    public void generateEventId(zzcu zzcu) throws RemoteException {
        zzb();
        long zzd = this.zza.zzk().zzd();
        zzb();
        this.zza.zzk().zzam(zzcu, zzd);
    }

    public void getAppInstanceId(zzcu zzcu) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzi(this, zzcu));
    }

    public void getCachedAppInstanceId(zzcu zzcu) throws RemoteException {
        zzb();
        zzc(zzcu, this.zza.zzj().zzQ());
    }

    public void getConditionalUserProperties(String str, String str2, zzcu zzcu) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzm(this, zzcu, str, str2));
    }

    public void getCurrentScreenClass(zzcu zzcu) throws RemoteException {
        zzb();
        zzc(zzcu, this.zza.zzj().zzae());
    }

    public void getCurrentScreenName(zzcu zzcu) throws RemoteException {
        zzb();
        zzc(zzcu, this.zza.zzj().zzad());
    }

    public void getGmpAppId(zzcu zzcu) throws RemoteException {
        String str;
        zzb();
        zzli zzj = this.zza.zzj();
        try {
            str = zzls.zza(zzj.zzu.zzaY(), "google_app_id", zzj.zzu.zzq());
        } catch (IllegalStateException e) {
            zzj.zzu.zzaV().zzb().zzb("getGoogleAppId failed with exception", e);
            str = null;
        }
        zzc(zzcu, str);
    }

    public void getMaxUserProperties(String str, zzcu zzcu) throws RemoteException {
        zzb();
        this.zza.zzj().zzY(str);
        zzb();
        this.zza.zzk().zzan(zzcu, 25);
    }

    public void getSessionId(zzcu zzcu) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzj.zzu.zzaW().zzj(new zzkl(zzj, zzcu));
    }

    public void getTestFlag(zzcu zzcu, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzk().zzal(zzcu, this.zza.zzj().zzj());
        } else if (i == 1) {
            this.zza.zzk().zzam(zzcu, this.zza.zzj().zzk().longValue());
        } else if (i == 2) {
            zzpo zzk = this.zza.zzk();
            double doubleValue = this.zza.zzj().zzm().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcu.zzb(bundle);
            } catch (RemoteException e) {
                zzk.zzu.zzaV().zze().zzb("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzk().zzan(zzcu, this.zza.zzj().zzl().intValue());
        } else if (i == 4) {
            this.zza.zzk().zzap(zzcu, this.zza.zzj().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzcu zzcu) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzk(this, zzcu, str, str2, z));
    }

    public void initForTests(@NonNull Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzdd zzdd, long j) throws RemoteException {
        zzib zzib = this.zza;
        if (zzib == null) {
            this.zza = zzib.zzy((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdd, Long.valueOf(j));
        } else {
            e.C(zzib, "Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcu zzcu) throws RemoteException {
        zzb();
        this.zza.zzaW().zzj(new zzn(this, zzcu));
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzC(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcu, long j) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzaW().zzj(new zzj(this, zzcu, new zzbg(str2, new zzbe(bundle), "app", j), str));
    }

    public void logHealthData(int i, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzaV().zzm(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        onActivityCreatedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j);
    }

    public void onActivityCreatedByScionActivityInfo(zzdf zzdf, Bundle bundle, long j) {
        zzb();
        zzkx zzkx = this.zza.zzj().zza;
        if (zzkx != null) {
            this.zza.zzj().zzh();
            zzkx.zza(zzdf, bundle);
        }
    }

    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityDestroyedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    public void onActivityDestroyedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        zzb();
        zzkx zzkx = this.zza.zzj().zza;
        if (zzkx != null) {
            this.zza.zzj().zzh();
            zzkx.zzb(zzdf);
        }
    }

    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityPausedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    public void onActivityPausedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        zzb();
        zzkx zzkx = this.zza.zzj().zza;
        if (zzkx != null) {
            this.zza.zzj().zzh();
            zzkx.zzc(zzdf);
        }
    }

    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityResumedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    public void onActivityResumedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        zzb();
        zzkx zzkx = this.zza.zzj().zza;
        if (zzkx != null) {
            this.zza.zzj().zzh();
            zzkx.zzd(zzdf);
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcu zzcu, long j) throws RemoteException {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzcu, j);
    }

    public void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdf, zzcu zzcu, long j) throws RemoteException {
        zzb();
        zzkx zzkx = this.zza.zzj().zza;
        Bundle bundle = new Bundle();
        if (zzkx != null) {
            this.zza.zzj().zzh();
            zzkx.zze(zzdf, bundle);
        }
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzaV().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityStartedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    public void onActivityStartedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        onActivityStoppedByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    public void onActivityStoppedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    public void performAction(Bundle bundle, zzcu zzcu, long j) throws RemoteException {
        zzb();
        zzcu.zzb((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzda zzda) throws RemoteException {
        zzjp zzjp;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            try {
                zzjp = (zzjp) map.get(Integer.valueOf(zzda.zzf()));
                if (zzjp == null) {
                    zzjp = new zzq(this, zzda);
                    map.put(Integer.valueOf(zzda.zzf()), zzjp);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.zza.zzj().zzW(zzjp);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzT(j);
    }

    public void retrieveAndUploadBatches(zzcx zzcx) {
        zzb();
        this.zza.zzj().zzt(new zzo(this, zzcx));
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            e.w(this.zza, "Conditional user property must not be null");
        } else {
            this.zza.zzj().zzaa(bundle, j);
        }
    }

    public void setConsent(@NonNull Bundle bundle, long j) throws RemoteException {
    }

    public void setConsentThirdParty(@NonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzp(bundle, -20, j);
    }

    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j) throws RemoteException {
        zzb();
        setCurrentScreenByScionActivityInfo(zzdf.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j);
    }

    public void setCurrentScreenByScionActivityInfo(zzdf zzdf, String str, String str2, long j) throws RemoteException {
        zzb();
        this.zza.zzs().zzk(zzdf, str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzj.zzb();
        zzj.zzu.zzaW().zzj(new zzjx(zzj, z));
    }

    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzli zzj = this.zza.zzj();
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzj.zzu.zzaW().zzj(new zzle(zzj, bundle2));
    }

    public void setEventInterceptor(zzda zzda) throws RemoteException {
        zzb();
        zzp zzp = new zzp(this, zzda);
        if (this.zza.zzaW().zze()) {
            this.zza.zzj().zzV(zzp);
        } else {
            this.zza.zzaW().zzj(new zzl(this, zzp));
        }
    }

    public void setInstanceIdProvider(zzdc zzdc) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzn(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        zzj.zzu.zzaW().zzj(new zzjz(zzj, j));
    }

    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        Uri data = intent.getData();
        if (data == null) {
            zzj.zzu.zzaV().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            zzib zzib = zzj.zzu;
            zzib.zzaV().zzi().zza("[sgtm] Preview Mode was not enabled.");
            zzib.zzc().zzy((String) null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (!TextUtils.isEmpty(queryParameter2)) {
            zzib zzib2 = zzj.zzu;
            zzib2.zzaV().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zzib2.zzc().zzy(queryParameter2);
        }
    }

    public void setUserId(@NonNull String str, long j) throws RemoteException {
        zzb();
        zzli zzj = this.zza.zzj();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzj.zzu.zzaW().zzj(new zzlf(zzj, str));
            zzj.zzL((String) null, "_id", str, true, j);
            return;
        }
        e.C(zzj.zzu, "User ID must be non-empty or null");
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzj().zzL(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzda zzda) throws RemoteException {
        zzjp zzjp;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            zzjp = (zzjp) map.remove(Integer.valueOf(zzda.zzf()));
        }
        if (zzjp == null) {
            zzjp = new zzq(this, zzda);
        }
        this.zza.zzj().zzX(zzjp);
    }
}
