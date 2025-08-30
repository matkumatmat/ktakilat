package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Executor d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ e(Object obj, Executor executor, Object obj2, int i) {
        this.c = i;
        this.e = obj;
        this.d = executor;
        this.f = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.e).lambda$onGnssMeasurementsReceived$0(this.d, (GnssMeasurementsEvent) this.f);
                return;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.e).lambda$onGpsStatusChanged$3(this.d, (GnssStatusCompat) this.f);
                return;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.e).lambda$onSatelliteStatusChanged$3(this.d, (GnssStatus) this.f);
                return;
        }
    }
}
