package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport d;
    public final /* synthetic */ Executor e;

    public /* synthetic */ g(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i) {
        this.c = i;
        this.d = gpsStatusTransport;
        this.e = executor;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onGpsStatusChanged$0(this.e);
                return;
            default:
                this.d.lambda$onGpsStatusChanged$1(this.e);
                return;
        }
    }
}
