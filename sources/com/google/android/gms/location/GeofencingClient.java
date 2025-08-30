package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public class GeofencingClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    public static class zza implements BaseImplementation.ResultHolder<Status> {
        private final TaskCompletionSource<Void> zza;

        public zza(TaskCompletionSource<Void> taskCompletionSource) {
            this.zza = taskCompletionSource;
        }

        public final void setFailedResult(Status status) {
            this.zza.setException(new ApiException(status));
        }

        public final /* synthetic */ void setResult(Object obj) {
            TaskUtil.setResultOrApiException((Status) obj, null, this.zza);
        }
    }

    public GeofencingClient(@NonNull Context context) {
        super(context, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public Task<Void> addGeofences(GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new zzah(geofencingRequest, pendingIntent)).build());
    }

    public Task<Void> removeGeofences(PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new zzaj(pendingIntent)).build());
    }

    public GeofencingClient(@NonNull Activity activity) {
        super(activity, LocationServices.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> removeGeofences(List<String> list) {
        return doWrite(TaskApiCall.builder().run(new zzai(list)).build());
    }
}
