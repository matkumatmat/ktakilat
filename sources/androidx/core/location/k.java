package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport d;
    public final /* synthetic */ Executor e;

    public /* synthetic */ k(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.c = i;
        this.d = preRGnssStatusTransport;
        this.e = executor;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onStopped$1(this.e);
                return;
            default:
                this.d.lambda$onStarted$0(this.e);
                return;
        }
    }
}
