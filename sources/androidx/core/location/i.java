package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport c;
    public final /* synthetic */ int d;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i) {
        this.c = locationListenerTransport;
        this.d = i;
    }

    public final void run() {
        this.c.lambda$onFlushComplete$2(this.d);
    }
}
