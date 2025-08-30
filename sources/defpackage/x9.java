package defpackage;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.cbase.utils.location.IOnLocationCallback;
import com.ktakilat.loan.R;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;

/* renamed from: x9  reason: default package */
public final /* synthetic */ class x9 implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMyLocationButtonClickListener, IOnLocationCallback, GoogleMap.OnCameraChangeListener, GoogleMap.OnCameraMoveListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleMapActivity f845a;

    public /* synthetic */ x9(GoogleMapActivity googleMapActivity) {
        this.f845a = googleMapActivity;
    }

    public void a(double d, double d2) {
        GoogleMapActivity googleMapActivity = this.f845a;
        googleMapActivity.j = d;
        googleMapActivity.k = d2;
        if (!(d == 0.0d || d2 == 0.0d)) {
            googleMapActivity.runOnUiThread(new x0(googleMapActivity, 25));
        }
        googleMapActivity.o.c();
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        this.f845a.l = cameraPosition;
    }

    public void onCameraIdle() {
        GoogleMapActivity googleMapActivity = this.f845a;
        CameraPosition cameraPosition = googleMapActivity.l;
        if (cameraPosition != null) {
            LatLng latLng = cameraPosition.target;
            try {
                GoogleMapActivity.AddressAsyncTask addressAsyncTask = new GoogleMapActivity.AddressAsyncTask();
                googleMapActivity.m = addressAsyncTask;
                addressAsyncTask.execute(new String[]{String.valueOf(latLng.latitude), String.valueOf(latLng.longitude)});
            } catch (Exception unused) {
                googleMapActivity.p.address.setText("");
            }
        } else {
            googleMapActivity.p.address.setText("");
        }
    }

    public void onCameraMove() {
        GoogleMapActivity googleMapActivity = this.f845a;
        googleMapActivity.p.address.setText(googleMapActivity.getString(R.string.searching));
    }

    public boolean onMyLocationButtonClick() {
        GoogleMapActivity googleMapActivity = this.f845a;
        googleMapActivity.i.clear();
        googleMapActivity.i.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(googleMapActivity.j, googleMapActivity.k), 16.0f));
        return false;
    }
}
