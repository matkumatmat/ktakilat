package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzcp extends zzbl implements zzcr {
    public zzcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(23, zza);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zzc(9, zza);
    }

    public final void clearMeasurementEnabled(long j) throws RemoteException {
        throw null;
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(24, zza);
    }

    public final void generateEventId(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(22, zza);
    }

    public final void getAppInstanceId(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(20, zza);
    }

    public final void getCachedAppInstanceId(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(19, zza);
    }

    public final void getConditionalUserProperties(String str, String str2, zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzd(zza, zzcu);
        zzc(10, zza);
    }

    public final void getCurrentScreenClass(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(17, zza);
    }

    public final void getCurrentScreenName(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(16, zza);
    }

    public final void getGmpAppId(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(21, zza);
    }

    public final void getMaxUserProperties(String str, zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbn.zzd(zza, zzcu);
        zzc(6, zza);
    }

    public final void getSessionId(zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zzc(46, zza);
    }

    public final void getTestFlag(zzcu zzcu, int i) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcu);
        zza.writeInt(i);
        zzc(38, zza);
    }

    public final void getUserProperties(String str, String str2, boolean z, zzcu zzcu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zzbn.zzd(zza, zzcu);
        zzc(5, zza);
    }

    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzdd zzdd, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, iObjectWrapper);
        zzbn.zzc(zza, zzdd);
        zza.writeLong(j);
        zzc(1, zza);
    }

    public final void isDataCollectionEnabled(zzcu zzcu) throws RemoteException {
        throw null;
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zzc(2, zza);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcu, long j) throws RemoteException {
        throw null;
    }

    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbn.zzd(zza, iObjectWrapper);
        zzbn.zzd(zza, iObjectWrapper2);
        zzbn.zzd(zza, iObjectWrapper3);
        zzc(33, zza);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityCreatedByScionActivityInfo(zzdf zzdf, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(53, zza);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityDestroyedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeLong(j);
        zzc(54, zza);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityPausedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeLong(j);
        zzc(55, zza);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityResumedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeLong(j);
        zzc(56, zza);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcu zzcu, long j) throws RemoteException {
        throw null;
    }

    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdf, zzcu zzcu, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zzbn.zzd(zza, zzcu);
        zza.writeLong(j);
        zzc(57, zza);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityStartedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeLong(j);
        zzc(51, zza);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    public final void onActivityStoppedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeLong(j);
        zzc(52, zza);
    }

    public final void performAction(Bundle bundle, zzcu zzcu, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzbn.zzd(zza, zzcu);
        zza.writeLong(j);
        zzc(32, zza);
    }

    public final void registerOnMeasurementEventListener(zzda zzda) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzda);
        zzc(35, zza);
    }

    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(12, zza);
    }

    public final void retrieveAndUploadBatches(zzcx zzcx) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzcx);
        zzc(58, zza);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(8, zza);
    }

    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zza.writeLong(j);
        zzc(45, zza);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        throw null;
    }

    public final void setCurrentScreenByScionActivityInfo(zzdf zzdf, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, zzdf);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(50, zza);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(39, zza);
    }

    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzc(42, zza);
    }

    public final void setEventInterceptor(zzda zzda) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzda);
        zzc(34, zza);
    }

    public final void setInstanceIdProvider(zzdc zzdc) throws RemoteException {
        throw null;
    }

    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        int i = zzbn.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(11, zza);
    }

    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(14, zza);
    }

    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, intent);
        zzc(48, zza);
    }

    public final void setUserId(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(7, zza);
    }

    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzd(zza, iObjectWrapper);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(4, zza);
    }

    public final void unregisterOnMeasurementEventListener(zzda zzda) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzd(zza, zzda);
        zzc(36, zza);
    }
}
