package com.google.firebase.analytics;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzfb;

public class GoogleAnalyticsServerPreviewActivity extends Activity {
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzfb.zza(this, (Bundle) null).zze(getIntent());
        finish();
    }
}
