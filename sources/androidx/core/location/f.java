package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Executor d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    public /* synthetic */ f(Object obj, Executor executor, int i, int i2) {
        this.c = i2;
        this.f = obj;
        this.d = executor;
        this.e = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f).lambda$onStatusChanged$1(this.d, this.e);
                return;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f).lambda$onGpsStatusChanged$2(this.d, this.e);
                return;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f).lambda$onFirstFix$2(this.d, this.e);
                return;
        }
    }
}
