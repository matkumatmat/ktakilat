package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport d;
    public final /* synthetic */ String e;

    public /* synthetic */ h(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i) {
        this.c = i;
        this.d = locationListenerTransport;
        this.e = str;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onProviderEnabled$4(this.e);
                return;
            default:
                this.d.lambda$onProviderDisabled$5(this.e);
                return;
        }
    }
}
