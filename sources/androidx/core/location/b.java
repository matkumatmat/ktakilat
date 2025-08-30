package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ LocationManager c;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport d;

    public /* synthetic */ b(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.c = locationManager;
        this.d = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.c.addGpsStatusListener(this.d));
    }
}
