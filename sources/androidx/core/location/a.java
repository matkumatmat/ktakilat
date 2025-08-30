package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f42a;

    public /* synthetic */ a(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f42a = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f42a.cancel();
    }
}
