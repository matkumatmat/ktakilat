package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzcr extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(zzcu zzcu) throws RemoteException;

    void getAppInstanceId(zzcu zzcu) throws RemoteException;

    void getCachedAppInstanceId(zzcu zzcu) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzcu zzcu) throws RemoteException;

    void getCurrentScreenClass(zzcu zzcu) throws RemoteException;

    void getCurrentScreenName(zzcu zzcu) throws RemoteException;

    void getGmpAppId(zzcu zzcu) throws RemoteException;

    void getMaxUserProperties(String str, zzcu zzcu) throws RemoteException;

    void getSessionId(zzcu zzcu) throws RemoteException;

    void getTestFlag(zzcu zzcu, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, zzcu zzcu) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzdd zzdd, long j) throws RemoteException;

    void isDataCollectionEnabled(zzcu zzcu) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcu, long j) throws RemoteException;

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException;

    void onActivityCreatedByScionActivityInfo(zzdf zzdf, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityDestroyedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityPausedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityResumedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcu zzcu, long j) throws RemoteException;

    void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdf, zzcu zzcu, long j) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStartedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStoppedByScionActivityInfo(zzdf zzdf, long j) throws RemoteException;

    void performAction(Bundle bundle, zzcu zzcu, long j) throws RemoteException;

    void registerOnMeasurementEventListener(zzda zzda) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void retrieveAndUploadBatches(zzcx zzcx) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException;

    void setCurrentScreenByScionActivityInfo(zzdf zzdf, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzda zzda) throws RemoteException;

    void setInstanceIdProvider(zzdc zzdc) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setSgtmDebugInfo(Intent intent) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzda zzda) throws RemoteException;
}
