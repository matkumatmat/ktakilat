package defpackage;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;

/* renamed from: z9  reason: default package */
public final /* synthetic */ class z9 implements OnMapReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleMapActivity f849a;

    public /* synthetic */ z9(GoogleMapActivity googleMapActivity) {
        this.f849a = googleMapActivity;
    }

    public final void onMapReady(GoogleMap googleMap) {
        GoogleMapActivity googleMapActivity = this.f849a;
        googleMapActivity.i = googleMap;
        googleMap.setBuildingsEnabled(false);
        googleMapActivity.z();
        googleMapActivity.i.setOnCameraChangeListener(new x9(googleMapActivity));
        googleMapActivity.i.setOnCameraMoveListener(new x9(googleMapActivity));
        googleMapActivity.i.setOnCameraIdleListener(new x9(googleMapActivity));
        googleMapActivity.i.setOnMyLocationButtonClickListener(new x9(googleMapActivity));
        if (!(googleMapActivity.j == 0.0d || googleMapActivity.k == 0.0d)) {
            googleMapActivity.i.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(googleMapActivity.j, googleMapActivity.k)));
        }
        try {
            GoogleMapActivity.AddressAsyncTask addressAsyncTask = new GoogleMapActivity.AddressAsyncTask();
            googleMapActivity.m = addressAsyncTask;
            addressAsyncTask.execute(new String[]{String.valueOf(googleMapActivity.j), String.valueOf(googleMapActivity.k)});
        } catch (Exception unused) {
            googleMapActivity.p.addressMore.setText("");
        }
    }
}
