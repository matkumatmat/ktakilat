package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import androidx.annotation.WorkerThread;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzib;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public final class zzgy extends zzor {
    public zzgy(zzpf zzpf) {
        super(zzpf);
    }

    public final boolean zzb() {
        zzay();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaY().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public final boolean zzbb() {
        return false;
    }

    @WorkerThread
    public final void zzc(String str, zzos zzos, zzib zzib, zzgv zzgv) {
        zzg();
        zzay();
        try {
            URL url = new URI(zzos.zza()).toURL();
            this.zzg.zzp();
            String str2 = str;
            this.zzu.zzaW().zzm(new zzgx(this, str2, url, zzib.zzcc(), zzos.zzb(), zzgv));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaV().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgt.zzl(str), zzos.zza());
        }
    }

    @WorkerThread
    public final void zzd(zzh zzh, Map map, zzgv zzgv) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzh);
        Preconditions.checkNotNull(zzgv);
        zzot zzf = this.zzg.zzf();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendQueryParameter = builder.scheme((String) zzfx.zze.zzb((Object) null)).encodedAuthority((String) zzfx.zzf.zzb((Object) null)).path("config/app/".concat(String.valueOf(zzh.zzf()))).appendQueryParameter("platform", FaceEnvironment.OS);
        zzf.zzu.zzc().zzi();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(130000)).appendQueryParameter("runtime_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String uri = builder.build().toString();
        try {
            this.zzu.zzaW().zzm(new zzgx(this, zzh.zzc(), new URI(uri).toURL(), (byte[]) null, map, zzgv));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaV().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgt.zzl(zzh.zzc()), uri);
        }
    }
}
