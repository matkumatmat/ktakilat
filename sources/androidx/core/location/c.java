package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener c;

    public /* synthetic */ c(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.c = cancellableLocationListener;
    }

    public final void run() {
        this.c.lambda$startTimeout$0();
    }
}
