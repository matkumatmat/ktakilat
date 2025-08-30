package defpackage;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: f4  reason: default package */
public final /* synthetic */ class f4 implements Continuation, ObservableOnSubscribe {
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ f4(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
        this.f = obj4;
        this.g = obj5;
    }

    public void d(ObservableEmitter observableEmitter) {
        GoogleMapActivity googleMapActivity = (GoogleMapActivity) this.c;
        String trim = googleMapActivity.p.address.getText().toString().trim();
        LatLng latLng = new LatLng(0.0d, 0.0d);
        try {
            List<Address> fromLocationName = new Geocoder(googleMapActivity, Locale.getDefault()).getFromLocationName(trim, 1);
            if (fromLocationName.size() > 0) {
                Address address = fromLocationName.get(0);
                latLng = new LatLng(address.getLatitude(), address.getLongitude());
            }
        } catch (IOException e2) {
            e2.toString();
            ArrayList arrayList = LogActivity.k;
        }
        LatLng[] latLngArr = (LatLng[]) this.d;
        latLngArr[0] = latLng;
        String sb = ((StringBuilder) this.f).toString();
        Bundle bundle = (Bundle) this.e;
        bundle.putString("location-address", sb);
        bundle.putDouble("lat", latLngArr[0].latitude);
        bundle.putDouble("lng", latLngArr[0].longitude);
        Intent intent = (Intent) this.g;
        intent.putExtra("location-result", bundle);
        observableEmitter.onNext(intent);
        observableEmitter.onComplete();
    }

    public Object then(Task task) {
        Task task2 = (Task) this.d;
        Task task3 = (Task) this.e;
        return ((ConfigFetchHandler) this.c).lambda$fetchIfCacheExpiredAndNotThrottled$2(task2, task3, (Date) this.f, (Map) this.g, task);
    }
}
