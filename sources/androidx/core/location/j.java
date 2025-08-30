package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Bundle f;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i, Bundle bundle) {
        this.c = locationListenerTransport;
        this.d = str;
        this.e = i;
        this.f = bundle;
    }

    public final void run() {
        this.c.lambda$onStatusChanged$3(this.d, this.e, this.f);
    }
}
