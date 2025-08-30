package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import java.util.List;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Consumer) this.d).accept((Location) this.e);
                return;
            case 1:
                ((LocationManagerCompat.LocationListenerTransport) this.d).lambda$onLocationChanged$1((List) this.e);
                return;
            default:
                ((LocationManagerCompat.LocationListenerTransport) this.d).lambda$onLocationChanged$0((Location) this.e);
                return;
        }
    }
}
