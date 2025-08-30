package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzae;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.internal.location.zzn;

public class LocationServices {
    public static final Api<Api.ApiOptions.NoOptions> API;
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi = new zzn();
    @Deprecated
    public static final GeofencingApi GeofencingApi = new zzae();
    @Deprecated
    public static final SettingsApi SettingsApi = new zzbh();
    private static final Api.ClientKey<zzay> zza;
    private static final Api.AbstractClientBuilder<zzay, Api.ApiOptions.NoOptions> zzb;

    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzay> {
        public zza(GoogleApiClient googleApiClient) {
            super((Api<?>) LocationServices.API, googleApiClient);
        }

        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((Result) obj);
        }
    }

    static {
        Api.ClientKey<zzay> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzax zzax = new zzax();
        zzb = zzax;
        API = new Api<>("LocationServices.API", zzax, clientKey);
    }

    private LocationServices() {
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        return new FusedLocationProviderClient(activity);
    }

    public static GeofencingClient getGeofencingClient(@NonNull Activity activity) {
        return new GeofencingClient(activity);
    }

    public static SettingsClient getSettingsClient(@NonNull Activity activity) {
        return new SettingsClient(activity);
    }

    public static zzay zza(GoogleApiClient googleApiClient) {
        boolean z;
        boolean z2 = false;
        if (googleApiClient != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "GoogleApiClient parameter is required.");
        zzay zzay = (zzay) googleApiClient.getClient(zza);
        if (zzay != null) {
            z2 = true;
        }
        Preconditions.checkState(z2, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzay;
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        return new FusedLocationProviderClient(context);
    }

    public static GeofencingClient getGeofencingClient(@NonNull Context context) {
        return new GeofencingClient(context);
    }

    public static SettingsClient getSettingsClient(@NonNull Context context) {
        return new SettingsClient(context);
    }
}
